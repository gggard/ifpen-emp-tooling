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
import org.eclipse.jdt.core.IPackageFragment;

/**
 * @author <a href="mailto:sebastien.schneider@ifpen.fr">Sebastien Schneider</a>
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ReverseSettings {

    public String rootPackageName;

    public String rootNsPrefix;

    public String rootNsURI;

    public Map<String, PackageSettings> packageParams = new HashMap<String, PackageSettings>();

    public static class PackageSettings {

        public String packageName, nsPrefix, nsURI;

        public EPackage createEcorePackage() {
            EPackage subPackage = EcoreFactory.eINSTANCE.createEPackage();
            subPackage.setName(packageName);
            subPackage.setNsPrefix(nsPrefix);
            subPackage.setNsURI(nsURI);
            configurePackage(subPackage);
            return subPackage;
        }

        protected void configurePackage(EPackage subPackage) {
        }
    }
    
    public static class DefaultPackageSetting extends PackageSettings {
    	
    	private String baseURI;
    	private String baseNSPrefix;
    	private IPackageFragment packageFragment;

        public DefaultPackageSetting(String baseURI, String baseNSPrefix, IPackageFragment packageFragment) {
			this.baseURI = baseURI;
			this.baseNSPrefix = baseNSPrefix;
			this.packageFragment = packageFragment;
		}

		public EPackage createEcorePackage() {
            EPackage subPackage = EcoreFactory.eINSTANCE.createEPackage();
            String name = packageFragment.getElementName();
			subPackage.setName(name);
            subPackage.setNsURI(baseURI + "/" + name);
            subPackage.setNsPrefix(baseNSPrefix + "-" + name);
            return subPackage;
        }
		
    
    }

}
