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
package fr.ifpen.emptooling.filter.presentation.editor.viewer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ILazyTreeContentProvider;
import org.eclipse.jface.viewers.ILazyTreePathContentProvider;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;

import fr.ifpen.emptooling.filter.Filter;
import fr.ifpen.emptooling.filter.FilterFactory;
import fr.ifpen.emptooling.filter.FilterPackage;

/**
 * Specific check box viewer.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class IFPContainerCheckedTreeViewer extends ContainerCheckedTreeViewer {

	public static final String IFP_CHECKBOX_EDITOR_COMMAND = "IFP Checkbox editor command";
	private List<TreeItem> checkedItems;
	private Map<EObject, Filter> eObjectToFilters;
	private final EditingDomain editingDomain;
	private Filter rootFilter;
	private final Resource filteredResource;
	private ICheckStateProvider myCheckStateProvider;

	/**
	 * @param parent
	 *            Composite
	 * @param style
	 * @param editingDomain EditingDomain
	 * @param filteredResource 
	 * @param editor 
	 */
	public IFPContainerCheckedTreeViewer(Composite parent, int style, EditingDomain editingDomain, Resource filteredResource) {
		super(parent, style);
		this.editingDomain = editingDomain;
		this.filteredResource = filteredResource;
		checkedItems = new ArrayList<TreeItem>();
		eObjectToFilters = new HashMap<EObject, Filter>();
		initViewerListeners();
	}

	/**
	 * Replace TreeListener to call owned initializeItem and updateItem (cause private methods)
	 */
	private void initViewerListeners() {
		Object listener = getTreeListener();
		if (listener instanceof ListenerList && !((ListenerList) listener).isEmpty()) {
			removeTreeListener((ITreeViewerListener) ((ListenerList) listener).getListeners()[0]);
		}
		
		addTreeListener(new ITreeViewerListener() {
            public void treeCollapsed(TreeExpansionEvent event) {
            }

            public void treeExpanded(TreeExpansionEvent event) {
                Widget item = findItem(event.getElement());
                if (item instanceof TreeItem) {
                    initializeItem((TreeItem) item);
                }
            }
        });
		
	}

	/**
	 * @return the tree listeners list (non accessible field, to replace it)
	 */
	private Object getTreeListener() {
		Field declaredField;
		try {
			declaredField = getClass().getSuperclass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("treeListeners");
			declaredField.setAccessible(true);
			return declaredField.get(this);
		} catch (SecurityException e) {
		} catch (NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}

		return null;
	}

	/**
	 * Init map eObjectToFilters.
	 * 
	 * @param rootFilter Filter
	 */
	public void init(Filter rootFilter) {
		eObjectToFilters.clear();
		this.rootFilter = rootFilter;
		setGrayChecked(rootFilter.getTarget(), true);
		eObjectToFilters.put(rootFilter.getTarget(), rootFilter);
		CompoundCommand cc = new CompoundCommand(IFP_CHECKBOX_EDITOR_COMMAND);
		for (Iterator<EObject> iterator = rootFilter.eAllContents(); iterator
				.hasNext();) {
			EObject filter = iterator.next();
			if (filter instanceof Filter) {
				EObject element = ((Filter) filter).getTarget();
				if (!element.eIsProxy() && element.eResource() != null) {
					setChecked(element);
					eObjectToFilters.put(((Filter) filter).getTarget(),
						(Filter) filter);
				} else {
					RemoveCommand removeCommand = new RemoveCommand(editingDomain, filter.eContainer(), FilterPackage.eINSTANCE.getFilter_SubFilters(), filter);
					cc.append(removeCommand);
				}
				
			}

		}
		if (!cc.isEmpty()) {
			editingDomain.getCommandStack().execute(cc);
		}
	}

	/**
	 * Check tree item element.
	 * 
	 * @param element EObject
	 */
	private void setChecked(EObject element) {
		if (!getChecked(element)) {
			Assert.isNotNull(element);
		    Widget widget = internalExpand(element, false);
		    if (widget instanceof TreeItem) {
		        ((TreeItem) widget).setChecked(true);
		    }
		}
	}

	/** (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.ContainerCheckedTreeViewer#doCheckStateChanged(java.lang.Object)
	 */
	@Override
	public void doCheckStateChanged(Object element) {
		CompoundCommand command = getCheckStateChangedCommand(element);
		// execute updates commands
		if (command != null && !command.isEmpty()) {
			editingDomain.getCommandStack().execute(command);
		}
	}

	/**
	 * @param element
	 * @return
	 */
	public CompoundCommand getCheckStateChangedCommand(Object element) {
		if ((element != null && rootFilter != null && element.equals(rootFilter.getTarget()) && !getChecked(element)) || rootFilter == null) {
			return null;
		}
		checkedItems.clear();
		Widget item = findItem(element);
		TreeItem treeItem = null;
		if (item instanceof TreeItem) {
			treeItem = (TreeItem) item;
			treeItem.setGrayed(false);
			checkedItems.add(treeItem);
			updateChildrenItems(treeItem);
			updateParentItems(treeItem.getParentItem());
		}
		// update filter model
		return updateFilterModel(treeItem);
	}
	
	public CompoundCommand doCheckStateChanged2(Object element) {
		return getCheckStateChangedCommand(element);
	}

	/**
	 * Update filter model when check state changed.
	 * 
	 * @param treeItemRoot TreeItem
	 */
	public CompoundCommand updateFilterModel(TreeItem treeItemRoot) {
		CompoundCommand cc = new CompoundCommand(IFP_CHECKBOX_EDITOR_COMMAND);
		List<EObject> removedFilters = new ArrayList<EObject>();
		for (TreeItem treeItem : checkedItems) {
			Object data = treeItem.getData();
			if (data instanceof EObject && !data.equals(rootFilter.getTarget())) {
				EObject parent = ((EObject) data).eContainer();
				
				// if proxy -> reinit
				if (rootFilter != null && (rootFilter.eIsProxy() || rootFilter.eResource() == null)) {
					rootFilter = (Filter) filteredResource.getContents().get(0);
					init(rootFilter);
				}
				
				// if parent is not registered in the map
				if (parent != null && eObjectToFilters.get(parent) == null) {
					eObjectToFilters.put(parent,
							rootFilter);
				}
				
				// if proxy -> reinit
				if (parent ==null && rootFilter != null && (rootFilter.getTarget().eIsProxy() || rootFilter.getTarget().eResource() == null)) {
					init(rootFilter);
				}
				
				// put root filter if it does not exist
				if (parent == null
						&& rootFilter != null
						&& rootFilter.getTarget() != null
						&& rootFilter.getTarget().equals(data)) {
					eObjectToFilters.put((EObject) data,
							rootFilter);
				} else {
					Filter parentFilter = eObjectToFilters.get(parent);
					if (parentFilter == null && parent != null && parent.eResource() != null && getChecked(parent)) {
						break;
					}
					
					// filter already correct : no need to update
					Filter filter = eObjectToFilters.get(data);
					if (filter!= null && !(filter.eIsProxy() || filter.eResource() == null || filter.eContainer() == null)) {
						if (parentFilter.getSubFilters().contains(filter) && treeItem.getChecked()) {
							break;
						}
					}
					if (filter==null && !treeItem.getChecked()) {
						break;
					} 
					createUpdateCommands(treeItemRoot, cc, removedFilters,
							treeItem, parentFilter);
				}
			}
		}
		// remove unchecked filters in the map
		for (EObject filtered : removedFilters) {
			eObjectToFilters.remove(filtered);
		}
		
		return cc;
		
	}

	/**
	 * Create updates commands on filter model.
	 * 
	 * @param treeItemRoot TreeItem
	 * @param cc CompoundCommand
	 * @param removedFilters List<EObject>
	 * @param treeItem TreeItem
	 * @param parentFilter Filter
	 */
	public void createUpdateCommands(TreeItem treeItemRoot, CompoundCommand cc,
			List<EObject> removedFilters, TreeItem treeItem, Filter parentFilter) {
		if (treeItemRoot!=null && treeItemRoot.getChecked()) {
			if (parentFilter != null) {
				Filter subFilter = FilterFactory.eINSTANCE
						.createFilter();
				AddCommand addCommand = new AddCommand(editingDomain,
						parentFilter,
						FilterPackage.eINSTANCE.getFilter_SubFilters(),
						subFilter);
				SetCommand setCommand = new SetCommand(editingDomain,
						subFilter,
						FilterPackage.eINSTANCE.getFilter_Target(),
						(EObject) treeItem.getData());
//				parentFilter.getSubFilters().add(subFilter);
				subFilter.setTarget((EObject) treeItem.getData());
				cc.append(addCommand);
				cc.append(setCommand);
				eObjectToFilters.put((EObject) treeItem.getData(), subFilter);
			}
			
		} else {
			Filter value = eObjectToFilters.get((EObject) treeItem.getData());
			if (parentFilter != null && value != null) {
				RemoveCommand removeCommand = new RemoveCommand(editingDomain, parentFilter, FilterPackage.eINSTANCE.getFilter_SubFilters(), value);
				cc.append(removeCommand);
				removedFilters.add((EObject) treeItem.getData());
			}
		}
		
	}

	/**
	 * Updates the check state of all created children
	 */
	private void updateChildrenItems(TreeItem parent) {
		Item[] children = getChildren(parent);
		boolean state = parent.getChecked();
		for (int i = 0; i < children.length; i++) {
			TreeItem curr = (TreeItem) children[i];
			if (curr.getData() != null
					&& ((curr.getChecked() != state) || curr.getGrayed())) {
				if (state != curr.getChecked() && eObjectToFilters.get(curr.getData())!= null) {
					curr.setChecked(state);
					checkedItems.add(curr);
				}
				if (false != curr.getGrayed()) {
					curr.setGrayed(false);
				}
				updateChildrenItems(curr);
			}
		}
	}

	/**
	 * Updates the check / gray state of all parent items
	 */
	private void updateParentItems(TreeItem item) {
		if (item != null && !(item.getData().equals(rootFilter.getTarget()))) {
			Item[] children = getChildren(item);
			boolean containsChecked = false;
			boolean containsUnchecked = false;
			for (int i = 0; i < children.length; i++) {
				TreeItem curr = (TreeItem) children[i];
				containsChecked |= curr.getChecked();
				containsUnchecked |= (!curr.getChecked() || curr.getGrayed());
			}
			if (!(containsUnchecked && !containsChecked)) {
				if (containsChecked != item.getChecked()) {
					item.setChecked(containsChecked);
					checkedItems.add(0, item);
				}
				
				boolean grayed = containsChecked && containsUnchecked;
				if (grayed != item.getGrayed()) {
					item.setGrayed(grayed);
				}
				
			} else {
				if (containsChecked != item.getChecked()) {
					// check when item is checked and all children unchecked
					if (myCheckStateProvider.isChecked(item.getData()) && !item.getChecked()) {
						item.setChecked(true);
						checkedItems.add(0, item);
					}
					// uncheck when all chidren are unchecked and item is unchecked (ex undo for check all children
					if (myCheckStateProvider.isChecked(item.getData()) && eObjectToFilters.get(item.getData()).eContainer()== null && item.getChecked()) {
						item.setChecked(false);					
						checkedItems.add(0, item);
					}
				}
			}
			updateParentItems(item.getParentItem());
		}
	}

	/** (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.ContainerCheckedTreeViewer#setExpanded(org.eclipse.swt.widgets.Item, boolean)
	 */
	protected void setExpanded(Item item, boolean expand) {
		((TreeItem) item).setExpanded(expand);
		boolean contentProviderIsLazy = (getContentProvider() instanceof ILazyTreeContentProvider)
				|| (getContentProvider() instanceof ILazyTreePathContentProvider);
		if (contentProviderIsLazy) {
			// force repaints to happen
			getControl().update();
		}
		
        if (expand && item instanceof TreeItem) {
            initializeItem((TreeItem) item);
        }
    }
	
	/**
	 * Initialize item.
	 * @param itemTreeItem
	 */
	private void initializeItem(TreeItem item) {
        if (item.getChecked() && !item.getGrayed()) {
            updateChildrenItems(item);
        }
    }

	/**
	 * @return the eObjectToFilters
	 */
	public Map<EObject, Filter> getEObjectToFilters() {
		return eObjectToFilters;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.jface.viewers.AbstractTreeViewer#internalExpand(java.lang.Object, boolean)
	 */
	public Widget internalExpand(Object elementOrPath, boolean expand) {
		return super.internalExpand(elementOrPath, expand);
	}

	/**
	 * For check all children action
	 * 
	 * @param element
	 * @param state
	 * @return all checked commands
	 */
	public CompoundCommand setSubtreeChecked2(Object element, boolean state) {
		CompoundCommand cc = new CompoundCommand(IFP_CHECKBOX_EDITOR_COMMAND);
		 Widget widget = internalExpand(element, false);
	        if (widget instanceof TreeItem) {
	            TreeItem item = (TreeItem) widget;
	            if (!element.equals(rootFilter.getTarget()) && item.getChecked() != state) {
					item.setChecked(state);
					for (Command command : doCheckStateChanged2(element).getCommandList()) {
						cc.append(command);
					}
				}
	            setCheckedChildren(item, state, cc);
	        }
	        return cc;
		
	}
	
	/**
     * Sets the checked state for the children of the given item.
     *
     * @param item the item
     * @param state <code>true</code> if the item should be checked,
     *  and <code>false</code> if it should be unchecked
	 * @param cc CompoundCommand
     */
    private void setCheckedChildren(Item item, boolean state, CompoundCommand cc) {
        createChildren(item);
        Item[] items = getChildren(item);
        if (items != null) {
            for (int i = 0; i < items.length; i++) {
                Item it = items[i];
                if (it.getData() != null && (it instanceof TreeItem)) {
                    TreeItem treeItem = (TreeItem) it;
                    if (treeItem.getChecked() != state) {
                    	treeItem.setChecked(state);
                    	for (Command command : doCheckStateChanged2(treeItem.getData()).getCommandList()) {
    						cc.append(command);
    					} 
                    }
                    setCheckedChildren(treeItem, state, cc);
                }
            }
        }
    }

	/** (non-Javadoc)
	 * @see org.eclipse.jface.viewers.CheckboxTreeViewer#setCheckStateProvider(org.eclipse.jface.viewers.ICheckStateProvider)
	 */
	@Override
	public void setCheckStateProvider(ICheckStateProvider checkStateProvider) {
		super.setCheckStateProvider(checkStateProvider);
		myCheckStateProvider = checkStateProvider;
	}

}
 
