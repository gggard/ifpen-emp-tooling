/**
 * <copyright>
 *
 * Copyright (c) 2012-2013 IFPEN and Obeo.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IFPEN - Initial API and implementation.
 *   Obeo - Settings Anonymization.
 *
 * </copyright>
 *
 */
package fr.ifpen.emptooling.reverse;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

/**
 * @author <a href="mailto:sebastien.schneider@ifpen.fr">Sebastien Schneider</a>
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class ReverseSettings {

	public String rootPackageName;
	public String rootNsPrefix;
	public String rootNsURI;
	
    public Map<String, PackageSettings> packageParams = new HashMap<String, PackageSettings>();
    
    
    public class PackageSettings {

        public String packageName, nsPrefix, nsURI;
    	
        public EPackage createEcorePackage(EcoreFactory factory) {
            EPackage subPackage = factory.createEPackage();
            subPackage.setName(packageName);
            subPackage.setNsPrefix(nsPrefix);
            subPackage.setNsURI(nsURI);
            configurePackage(subPackage);
            return subPackage;
        }

    }


	protected void configurePackage(EPackage subPackage) {	}

}
