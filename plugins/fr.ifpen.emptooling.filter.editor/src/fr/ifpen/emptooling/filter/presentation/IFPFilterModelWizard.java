/*******************************************************************************
 * Copyright (c) 2013 IFPen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IFPen - initial API and implementation
 *******************************************************************************/
package fr.ifpen.emptooling.filter.presentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;

import fr.ifpen.emptooling.filter.Filter;
import fr.ifpen.emptooling.filter.FilterFactory;

/**
 * Wizard for filter model creation : add 2 pages from default EMF Creation Wizard - one for the
 * model to filter selection - the other to choose the first model element to filter.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class IFPFilterModelWizard extends FilterModelWizard {

    /**
     * Page to choose the model to filter.
     */
    private ModelToFilterPage modelToFilterPage;

    /**
     * PAge to choose the first filtered element.
     */
    private FirstFilteredElementPage firstFilteredElementPage;

    /**
     * Default constructor.
     */
    public IFPFilterModelWizard() {
    }

    /**
     * (non-Javadoc)
     * 
     * @see fr.ifpen.emptooling.filter.presentation.FilterModelWizard#addPages()
     */
    @Override
    public void addPages() {
        super.addPages();

        // add page for model to filter selection
        modelToFilterPage = new ModelToFilterPage(selection);
        addPage(modelToFilterPage);

        // add page to choose the first model element to filter
        firstFilteredElementPage = new FirstFilteredElementPage();
        addPage(firstFilteredElementPage);
    }

    /**
     * Page change listener : to get URI model from modelToFilterPage to firstFilteredElementPage
     */
    public void addPageChangingListener() {
        IWizardContainer wizardContainer = getContainer();
        if (wizardContainer instanceof WizardDialog) {
            ((WizardDialog) wizardContainer).addPageChangingListener(new IPageChangingListener() {
                public void handlePageChanging(PageChangingEvent event) {
                    Object currentPage = event.getCurrentPage();
                    Object targetPage = event.getTargetPage();

                    if (currentPage == modelToFilterPage) {
                        if (targetPage == firstFilteredElementPage) {
                            firstFilteredElementPage.setUri(modelToFilterPage.getURI());
                        }
                    }
                }
            });
        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see fr.ifpen.emptooling.filter.presentation.FilterModelWizard#createInitialModel()
     */
    @Override
    protected EObject createInitialModel() {
        EObject root = createRootModel();
        if (root instanceof Filter) {
            initFilter(root);
        }
        return root;
    }

    protected EObject createRootModel() {
        return super.createInitialModel();
    }

    /**
     * Init Filter model. Create a sub filter for each sub content element.
     * 
     * @param root EObject
     */
    private void initFilter(EObject root) {
        EObject firstFilteredElement = getFirstSelectedElement();
        ((Filter) root).setTarget(firstFilteredElement);
        Filter parentFilter = ((Filter) root);
        for (EObject child : firstFilteredElement.eContents()) {
            initSubFilter(parentFilter, child);
        }
    }

    /**
     * @return
     */
    protected EObject getFirstSelectedElement() {
        return firstFilteredElementPage.getFirstFilteredElement();
    }

    /**
     * Init Filter model. Create a sub filter for each sub content element.
     * 
     * @param parentFilter Filter
     * @param child EObject
     */
    private void initSubFilter(Filter parentFilter, EObject child) {
        if (!isIgnoredReference(child.eContainmentFeature())) {
            Filter subFilter = FilterFactory.eINSTANCE.createFilter();
            subFilter.setTarget(child);
            parentFilter.getSubFilters().add(subFilter);
            initSubFilters(child, subFilter);
        }
    }

    /**
     * @param eContainmentFeature EReference
     * @return if the reference should be ignored.
     */
    protected boolean isIgnoredReference(EReference eContainmentFeature) {
        return eContainmentFeature != null && eContainmentFeature.isChangeable()
                && !eContainmentFeature.isDerived() && !eContainmentFeature.isTransient()
                && isIgnoredSpecificReference(eContainmentFeature);
    }

    /**
     * Method to complete if other references are to ignored.
     * 
     * @param eContainmentFeature EReference
     * @return if the reference should be ignored.
     */
    protected boolean isIgnoredSpecificReference(EReference eContainmentFeature) {
        /*
         * EGenericTypes are usually "mutually derived" references that are
         * handled through specific means in ecore (eGenericSuperTypes and
         * eSuperTypes, EGenericType and eType...). As these aren't even shown
         * to the user, we wish to avoid filter on them.
         */
        return eContainmentFeature.getEType() == EcorePackage.eINSTANCE.getEGenericType();
    }

    /**
     * Init Filter model. Create a sub filter for each sub content element.
     * 
     * @param root EObject
     * @param parentFilter Filter
     */
    private void initSubFilters(EObject root, Filter parentFilter) {
        for (EObject child : root.eContents()) {
            initSubFilter(parentFilter, child);
        }
    }

}
