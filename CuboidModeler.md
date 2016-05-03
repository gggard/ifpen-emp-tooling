The purpose of this demonstration is to describe the [\_Custom Element Editor\_](http://wiki.eclipse.org/EEF/User_Guide/Custom_Element_Editor) EEF customization method based on an actual use case. This customization process permits to insert a specific widget implementation in addition to those [already existing](http://wiki.eclipse.org/EEF_User_Guide#Editors_available_in_the_runtime).

This sample project proposes a [Cuboid](http://en.wikipedia.org/wiki/Cuboid) (or rectangular parallelepiped) Modeler with a 3D graphical representation embedded in the generated editor.
For this, a very simple Ecore model has been built. It consists of three concepts: a Scene and a collection of SceneObject in the Scene. A special kind of Object will be the Cuboid.
A Cuboid is a SceneObject, this latest contains some general attributes for a graphic object like color, opacity and position.

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/CuboidEcore.png](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/CuboidEcore.png)

EEF editor is generated from this very simple Ecore model by using the built-in all-in-one EEF action _"Initialize EEF Editor"_ from the contextual menu on the Ecore model file.

Then, from this generated code, we apply the Custom Element Editor customization method as described on the [EEF wiki](http://wiki.eclipse.org/EEF/User_Guide/Custom_Element_Editor):
  1. In the `ScenePropertiesEditionComponent`, we modify the `initPart` method to initialize our custom 3D view widget content input. In our case the whole Scene is the input for the 3D viewer:
```
if (isAccessible(CuboidmodelerViewsRepository.Scene.View.newt)) {
   basePart.initScene(scene);
}
```
  1. In the `ScenePropertiesEditionPart`, we just add a single service that initializes the `PropertiesEditionPart` with the Scene object:
```
public void initScene(Scene scene);
```
  1. In the `ScenePropertiesEditionPartForm` and `ScenePropertiesEditionPartImpl`, we complete four user code areas:
    1. implementation of the `initScene` service from the `ScenePropertiesEditionPart` interface in this way:
```
@Override
public void initScene(Scene scene) {
   cubeModelerContext.setInput(scene);
}
```
    1. declaration of the 3D View widget in two fields:
```
protected NEWTWidget newt;
protected CuboidModelerGLEventListener cubeModelerContext;
```
    1. modification of the `createControls` method to call the 3D View widget creation:
```
if (key == CuboidmodelerViewsRepository.Scene.View.newt) {
   return createNewtWidget(widgetFactory, parent);
}
```
    1. implementation of the method that create the 3D View widget (here we use an utility code from the NewtView plugin to create the 3D view and we implement the custom behaviour for the CuboidModeler through two classes coming from the `src` directory)
```
protected Composite createNewtWidget(FormToolkit widgetFactory, Composite parent) {
   cubeModelerContext = new CuboidModelerGLEventListener(parent.getDisplay());
   newt = new NEWTWidget(parent, SWT.NONE, cubeModelerContext,
      new CuboidModelerInputEventListener(cubeModelerContext));
   newt.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
   widgetFactory.paintBordersFor(parent);
   GridData newtData = new GridData(SWT.FILL, SWT.FILL, true, true);
   newtData.horizontalSpan = 3;
   newt.setLayoutData(newtData);
   return parent;
}
```

Thanks to both generated EEF editor and described Custom Element Editor implementation, we obtain a fully functional GUI integrating a 3D visualisation widget which is bound to the underlying model.

![http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/CuboidModelerPic_s2.jpg](http://ifpen-emp-tooling.eclipselabs.org.codespot.com/git.wiki/CuboidModelerPic_s2.jpg)