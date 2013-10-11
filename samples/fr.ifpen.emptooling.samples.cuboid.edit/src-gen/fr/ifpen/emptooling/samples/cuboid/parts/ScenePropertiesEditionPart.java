/**
 * Generated with Acceleo
 */
package fr.ifpen.emptooling.samples.cuboid.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;

import fr.ifpen.emptooling.samples.cuboid.Scene;

// End of user code

/**
 * 
 * 
 */
public interface ScenePropertiesEditionPart {

    /**
     * Init the cubes
     * 
     * @param current the current value
     * @param containgFeature the feature where to navigate if necessary
     * @param feature the feature to manage
     */
    public void initCubes(ReferencesTableSettings settings);

    /**
     * Update the cubes
     * 
     * @param newValue the cubes to update
     */
    public void updateCubes();

    /**
     * Adds the given filter to the cubes edition editor.
     * 
     * @param filter a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     */
    public void addFilterToCubes(ViewerFilter filter);

    /**
     * Adds the given filter to the cubes edition editor.
     * 
     * @param filter a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     */
    public void addBusinessFilterToCubes(ViewerFilter filter);

    /**
     * @return true if the given element is contained inside the cubes table
     */
    public boolean isContainedInCubesTable(EObject element);

    /**
     * @return the translationX
     */
    public String getTranslationX();

    /**
     * Defines a new translationX
     * 
     * @param newValue the new translationX to set
     */
    public void setTranslationX(String newValue);

    /**
     * @return the translationY
     */
    public String getTranslationY();

    /**
     * Defines a new translationY
     * 
     * @param newValue the new translationY to set
     */
    public void setTranslationY(String newValue);

    /**
     * @return the translationZ
     */
    public String getTranslationZ();

    /**
     * Defines a new translationZ
     * 
     * @param newValue the new translationZ to set
     */
    public void setTranslationZ(String newValue);

    /**
     * @return the rotationX
     */
    public String getRotationX();

    /**
     * Defines a new rotationX
     * 
     * @param newValue the new rotationX to set
     */
    public void setRotationX(String newValue);

    /**
     * @return the rotationY
     */
    public String getRotationY();

    /**
     * Defines a new rotationY
     * 
     * @param newValue the new rotationY to set
     */
    public void setRotationY(String newValue);

    /**
     * @return the rotationZ
     */
    public String getRotationZ();

    /**
     * Defines a new rotationZ
     * 
     * @param newValue the new rotationZ to set
     */
    public void setRotationZ(String newValue);

    /**
     * @return the rotate
     */
    public Boolean getRotate();

    /**
     * Defines a new rotate
     * 
     * @param newValue the new rotate to set
     */
    public void setRotate(Boolean newValue);

    /**
     * @return the show Wires
     */
    public Boolean getShowWires();

    /**
     * Defines a new show Wires
     * 
     * @param newValue the new show Wires to set
     */
    public void setShowWires(Boolean newValue);

    /**
     * @return the show Faces
     */
    public Boolean getShowFaces();

    /**
     * Defines a new show Faces
     * 
     * @param newValue the new show Faces to set
     */
    public void setShowFaces(Boolean newValue);

    // Start of user code for newt specific getters and setters declaration
    public void initScene(Scene scene);

    // End of user code

    /**
     * Returns the internationalized title text.
     * 
     * @return the internationalized title text.
     */
    public String getTitle();

    // Start of user code for additional methods

    // End of user code

}
