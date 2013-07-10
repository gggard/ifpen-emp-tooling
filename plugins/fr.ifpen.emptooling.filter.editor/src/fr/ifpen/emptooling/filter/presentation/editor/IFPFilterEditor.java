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
package fr.ifpen.emptooling.filter.presentation.editor;

import java.util.Arrays;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

import fr.ifpen.emptooling.filter.Filter;
import fr.ifpen.emptooling.filter.presentation.editor.handler.CheckAllChildrenAction;
import fr.ifpen.emptooling.filter.presentation.editor.helper.FilterEditorHelper;
import fr.ifpen.emptooling.filter.presentation.editor.property.IFPEditorPropertyDescriptor;
import fr.ifpen.emptooling.filter.presentation.editor.viewer.CheckBoxViewerPane;
import fr.ifpen.emptooling.filter.presentation.editor.viewer.FilteredResultViewerPane;
import fr.ifpen.emptooling.filter.presentation.editor.viewer.IFPContainerCheckedTreeViewer;

/**
 * Check box fiter editor.
 * 
 *@author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class IFPFilterEditor extends AbstractFilterEditor {

	/**
	 * Check box viewer to create filter model.
	 */
	private IFPContainerCheckedTreeViewer checkViewer;

	/**
	 * Tree viewer to show filtered model.
	 */
	private TreeViewer resultViewer;

	/**
	 * First filtered resource (resource targeted by the root filter).
	 */
	private Resource firstFilteredResource;

	/**
	 * Root target filter.
	 */
	private EObject rootTargetFilter;

	/**
	 * Root filter.
	 */
	private Filter rootFilter;

	/**
	 * Container of rootTargetFilter
	 */
	private Object rootTargetFilterContainer;

	private boolean needRefreshOnFocus;
	
	/**
	 * Constructor.
	 */
	public IFPFilterEditor() {
		super();
		needRefreshOnFocus = false;
	}

	/** (non-Javadoc)
	 * @see fr.ifpen.emptooling.filter.presentation.editor.AbstractFilterEditor#createModel()
	 */
	@Override
	public void createModel() {
		super.createModel();

		// load first filtered model
		initVariables();
		
	}

	/**
	 * Init variables
	 */
	public void initVariables() {
		if (!getFilterResource().getContents().isEmpty()) {
			EObject eObject = getFilterResource().getContents().get(0);
			if (eObject instanceof Filter && ((Filter) eObject).getTarget() != null) {
				rootFilter = ((Filter) eObject);
				rootTargetFilter = rootFilter.getTarget();
			} 
			
			if (rootTargetFilter.eContainer() != null) {
				rootTargetFilterContainer = rootTargetFilter.eContainer();
			} else if (rootTargetFilter.eResource() != null) {
				rootTargetFilterContainer = rootTargetFilter.eResource();
			} else {
				throw new RuntimeException("Could not initialize filter resource variables. The filter model may be corrupted.");
			}
			
			if (editingDomain.getResourceSet().getResources().size() < 2) {
				Resource resource = rootTargetFilter.eResource();
				firstFilteredResource = editingDomain.getResourceSet().getResource(resource.getURI(), true);
			} else {
				firstFilteredResource = editingDomain.getResourceSet().getResources().get(1);
			}
		}
	}

	/** (non-Javadoc)
	 * @see fr.ifpen.emptooling.filter.presentation.editor.AbstractFilterEditor#createPageViewers()
	 */
	@Override
	public void createPageViewers() {

		// Only creates the other pages if there is something that can be edited
		//
		if (!getEditingDomain().getResourceSet().getResources().isEmpty()) {
			// Create a page for the check box tree view.
			{
				createCheckBoxViewer();
			}

			// Create a page for the result tree view.
			{
				createResultViewer();
			}

			getSite().getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {
					setActivePage(0);
				}
			});
			
		}

	}
	
	/**
	 * Create second page with filtered model.
	 */
	private void createResultViewer() {
		ViewerPane viewerPane = new FilteredResultViewerPane(getSite().getPage(),	IFPFilterEditor.this);
		viewerPane.createControl(getContainer());

		resultViewer = (TreeViewer) viewerPane.getViewer();
		resultViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		resultViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		
		resultViewer.addFilter(new ViewerFilter() {

			/** (non-Javadoc)
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				if (element instanceof EGenericType) {
					return false;
				}
				return true;
			}
		});

		resultViewer.setAutoExpandLevel(3);
		viewerPane.setTitle(getFilterResource());

		int pageIndex = addPage(viewerPane.getControl());
		setPageText(pageIndex, getString("_UI_ResultPage_label"));
	}

	/**
	 * Create first page with check box viewer.
	 */
	private void createCheckBoxViewer() {
		ViewerPane viewerPane = new CheckBoxViewerPane(getSite().getPage(), IFPFilterEditor.this);
		viewerPane.createControl(getContainer());

		checkViewer = (IFPContainerCheckedTreeViewer) viewerPane.getViewer();
		checkViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory) {

			/** (non-Javadoc)
			 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
			 */
			@Override
			public Object[] getElements(Object object) {
				if (object.equals(rootTargetFilter.eContainer())) {
					return Arrays.asList(rootTargetFilter).toArray();
				}
				return super.getElements(object);
			}

		});
		checkViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		
		checkViewer.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				if (element.equals(getFilterResource())
						|| element instanceof EGenericType) {
					return false;
				}
				return true;
			}
		});

		checkViewer.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				Object element = event.getElement();
				// lock target on root filter
				if (element != null && element.equals(rootTargetFilter)) {
					checkViewer.setGrayChecked(element, true);
				}
				checkViewer.setSelection(new StructuredSelection(element));
			}
		});

		checkViewer.setCheckStateProvider(new fr.ifpen.emptooling.filter.presentation.editor.viewer.CheckStateProvider(this));
		
		checkViewer.setInput(rootTargetFilterContainer);
		
		// init check states
		checkViewer.init(rootFilter);
		checkViewer.refresh();
		
		checkViewer.setSelection(new StructuredSelection(firstFilteredResource), true);
		
		viewerPane.setTitle(firstFilteredResource);

		new AdapterFactoryTreeEditor(checkViewer.getTree(),
				adapterFactory);

//		createContextMenuFor(checkViewer);
		final ToolBarManager tbm = viewerPane.getToolBarManager();
        tbm.add(new CheckAllChildrenAction(this));
        tbm.update(true);
        
		int pageIndex = addPage(viewerPane.getControl());
		setPageText(pageIndex, getString("_UI_FilterPage_label"));
	}

	/** (non-Javadoc)
	 * @see fr.ifpen.emptooling.filter.presentation.editor.AbstractFilterEditor#initPropertySheetPage()
	 */
	@Override
	protected void initPropertySheetPage() {
		propertySheetPage
		.setPropertySourceProvider(new AdapterFactoryContentProvider(
				adapterFactory) {
			
			 /** (non-Javadoc)
			 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#createPropertySource(java.lang.Object, org.eclipse.emf.edit.provider.IItemPropertySource)
			 */
			protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource)
			  {
					return new PropertySource(object, itemPropertySource) {
						/** (non-Javadoc)
						 * @see org.eclipse.emf.edit.ui.provider.PropertySource#createPropertyDescriptor(org.eclipse.emf.edit.provider.IItemPropertyDescriptor)
						 */
						protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor)
						  {
						    return new IFPEditorPropertyDescriptor(object, itemPropertyDescriptor, true);
						  }
					};
			  }
		});
		
	}

	/**
	 * @return checkViewer
	 */
	public IFPContainerCheckedTreeViewer getCheckViewer() {
		return checkViewer;
	}

	/**
	 * @return resultViewer
	 */
	public TreeViewer getResultViewer() {
		return resultViewer;
	}

	/** (non-Javadoc)
	 * @see fr.ifpen.emptooling.filter.presentation.editor.AbstractFilterEditor#getCommandStack()
	 */
	@Override
	protected CommandStack getCommandStack() {
		return new BasicCommandStack() {

			/** (non-Javadoc)
			 * @see org.eclipse.emf.common.command.BasicCommandStack#undo()
			 */
			@Override
			public void undo() {
				super.undo();
				refresh();
				
			}

			/** (non-Javadoc)
			 * @see org.eclipse.emf.common.command.BasicCommandStack#redo()
			 */
			@Override
			public void redo() {
				super.redo();
				refresh();
			}
			
		};
	}

	/**
	 * Refresh all viewers.
	 */
	public void refresh() {
		Object[] expandedElements = checkViewer.getExpandedElements();
//		checkViewer.setInput(rootTargetFilterContainer);
		checkViewer.init(rootFilter);
		checkViewer.refresh();
		checkViewer.setExpandedElements(expandedElements);
		if (currentViewer.equals(resultViewer)) {
			resultViewer.setInput(FilterEditorHelper.createTemporaryFilteredModel(getFilterResource()));
		}
	}

	/** (non-Javadoc)
	 * @see fr.ifpen.emptooling.filter.presentation.editor.AbstractFilterEditor#postRemovedResource()
	 */
	@Override
	protected void postRemovedResource() {
		
	}

	/** (non-Javadoc)
	 * @see fr.ifpen.emptooling.filter.presentation.editor.AbstractFilterEditor#postChangedResources()
	 */
	@Override
	protected void postChangedResources() {
		if (changedResources.contains(firstFilteredResource) || changedResources.contains(getFilterResource())) {
			needRefreshOnFocus = true;
		}
	}

	@Override
	public void setFocus() {
		super.setFocus();
		
		if (needRefreshOnFocus) {
			needRefreshOnFocus = false;
			refresh();
		}
		
	}

	/**
	 * @return the needRefreshOnFocus
	 */
	public boolean isNeedRefreshOnFocus() {
		return needRefreshOnFocus;
	}

	/**
	 * @return the firstFilteredResource
	 */
	public Resource getFirstFilteredResource() {
		return firstFilteredResource;
	}

	/**
	 * @return the rootTargetFilter
	 */
	public EObject getRootTargetFilter() {
		return rootTargetFilter;
	}

	/**
	 * @return the rootFilter
	 */
	public Filter getRootFilter() {
		return rootFilter;
	}

	/**
	 * @return the rootTargetFilterContainer
	 */
	public Object getRootTargetFilterContainer() {
		return rootTargetFilterContainer;
	}
}
