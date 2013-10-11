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
package fr.ifpen.emptooling.samples.newtview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * NEWTView: a basic RCP View to test the NEWTWidget composite implementation inside Eclipse
 * <p>
 * Created on 12 mars 2012
 * 
 * @author schneids
 */
public class NEWTView extends ViewPart {

    NEWTWidget newt = null;

    /*
     * Overridden method (non-Javadoc)
     * 
     * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
     */
    @Override
    public void createPartControl(Composite parent) {
        this.newt = new NEWTWidget(parent, SWT.NONE, null, null);
    }

    /*
     * Overridden method (non-Javadoc)
     * 
     * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
     */
    @Override
    public void setFocus() {
        if (newt != null) {
            newt.setFocus();
        }
    }

    @Override
    public void dispose() {
        // dispose of the JOGL resources
        if (newt != null) {
            newt.dispose();
        }
        super.dispose();
    }
}
