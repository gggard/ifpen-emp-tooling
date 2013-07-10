/**
 * 
 */
package fr.ifpen.emptooling.reverse.ui.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import fr.ifpen.emptooling.reverse.ui.ReverseToEcoreConstants;

/**
 * @author glefur
 *
 */
public class ReverseToEcoreWizard extends Wizard {

	private String baseURI = ReverseToEcoreConstants.DEFAULT_URI;
	private String baseNSPrefix = ReverseToEcoreConstants.DEFAULT_NSPREFIX;
	private IContainer targetContainer;
	
	/**
	 * @return the baseURI
	 */
	public String getBaseURI() {
		return baseURI;
	}

	/**
	 * @return the baseNSPrefix
	 */
	public String getBaseNSPrefix() {
		return baseNSPrefix;
	}

	/**
	 * @return the targetContainer
	 */
	public IContainer getTargetContainer() {
		return targetContainer;
	}

	/**
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		addPage(new BasicSettingsPage());
		addPage(new TargetPage());
	}
	
	/**
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		return true;
	}

	private class BasicSettingsPage extends WizardPage {

		public BasicSettingsPage() {
			super("basics");
			setTitle("Model settings");
			setDescription("Configure the reversed model");
		}

		public void createControl(Composite parent) {
			
			Composite control = new Composite(parent, SWT.NONE);
			control.setLayout(new GridLayout(2, false));
			Label uri = new Label(control, SWT.NONE);
			uri.setText("Base URI");
			Text uriText = new Text(control, SWT.BORDER);
			uriText.setText(ReverseToEcoreConstants.DEFAULT_URI);
			uriText.addModifyListener(new ModifyListener() {
				
				public void modifyText(ModifyEvent e) {
					baseURI = ((Text)e.widget).getText();
					getWizard().getContainer().updateButtons();
				}
			});
			uriText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			Label nsPrefix = new Label(control, SWT.NONE);
			nsPrefix.setText("Base Prefix");
			Text nsPrefixText = new Text(control, SWT.BORDER);
			nsPrefixText.setText(ReverseToEcoreConstants.DEFAULT_NSPREFIX);
			nsPrefixText.addModifyListener(new ModifyListener() {
				
				public void modifyText(ModifyEvent e) {
					baseNSPrefix = ((Text)e.widget).getText();
					getWizard().getContainer().updateButtons();
				}
			});
			nsPrefixText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			setControl(control);
		}

		/**
		 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
		 */
		@Override
		public boolean isPageComplete() {
			return baseURI != null && !baseURI.isEmpty() && baseNSPrefix != null && !baseNSPrefix.isEmpty();
		}

	}
	
	private class TargetPage extends WizardPage {

		public TargetPage() {
			super("target");
			setTitle("File settings");
			setDescription("Configure the target directory");
		}

		/**
		 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
		 */
		public void createControl(Composite parent) {
			Composite control = new Composite(parent, SWT.NONE);
			control.setLayout(new GridLayout(1, false));
			Label label = new Label(control, SWT.NONE);
			label.setText("Select the target folder for the reversed Ecore model:");
			final TreeViewer tree = new TreeViewer(control);
			tree.setContentProvider(new WorkbenchContentProvider());
			tree.setLabelProvider(new WorkbenchLabelProvider());
			tree.setInput(ResourcesPlugin.getWorkspace().getRoot());
			tree.addSelectionChangedListener(new ISelectionChangedListener() {
				
				public void selectionChanged(SelectionChangedEvent event) {
					StructuredSelection sSel = (StructuredSelection) tree.getSelection();
					if (!sSel.isEmpty() && sSel.getFirstElement() instanceof IContainer) {
						targetContainer = (IContainer) sSel.getFirstElement();
						getWizard().getContainer().updateButtons();
					}
				}
			});
			tree.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
			setControl(control);
		}

		/**
		 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
		 */
		@Override
		public boolean isPageComplete() {
			return targetContainer != null;
		}
		
		
	}
	
}
