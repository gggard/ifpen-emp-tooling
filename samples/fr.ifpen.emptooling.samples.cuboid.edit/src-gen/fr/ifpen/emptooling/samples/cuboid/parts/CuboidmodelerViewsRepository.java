/**
 * Generated with Acceleo
 */
package fr.ifpen.emptooling.samples.cuboid.parts;

/**
 * 
 * 
 */
public class CuboidmodelerViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Scene view descriptor
	 * 
	 */
	public static class Scene {
		public static class Objects {
	
			
			public static String cubes = "cuboidmodeler::Scene::Objects::cubes";
			
	
		}
	
		public static class Transformations {
	
				public static class Translation {
			
					
					public static String translationX = "cuboidmodeler::Scene::Transformations::Translation::translationX";
					
					
					public static String translationY = "cuboidmodeler::Scene::Transformations::Translation::translationY";
					
					
					public static String translationZ = "cuboidmodeler::Scene::Transformations::Translation::translationZ";
					
			
				}
			
				public static class Rotation {
			
					
					public static String rotationX = "cuboidmodeler::Scene::Transformations::Rotation::rotationX";
					
					
					public static String rotationY = "cuboidmodeler::Scene::Transformations::Rotation::rotationY";
					
					
					public static String rotationZ = "cuboidmodeler::Scene::Transformations::Rotation::rotationZ";
					
			
				}
			
				public static class Flags {
			
					
					public static String rotate = "cuboidmodeler::Scene::Transformations::Flags::rotate";
					
					
					public static String showWires = "cuboidmodeler::Scene::Transformations::Flags::show Wires";
					
					
					public static String showFaces = "cuboidmodeler::Scene::Transformations::Flags::show Faces";
					
			
				}
			
	
		}
	
		public static class View {
	
			// Start of user code for newt ElementEditor key
			public static String newt = "cuboidmodeler::Scene::View::newt";
			// End of user code
			
	
		}
	
	}

	/**
	 * Cuboid view descriptor
	 * 
	 */
	public static class Cuboid {
	
	public static String name = "cuboidmodeler::Cuboid::name";
	
		public static class Position {
	
			
			public static String posX = "cuboidmodeler::Cuboid::Position::posX";
			
			
			public static String posY = "cuboidmodeler::Cuboid::Position::posY";
			
			
			public static String posZ = "cuboidmodeler::Cuboid::Position::posZ";
			
	
		}
	
		public static class Color {
	
			
			public static String red = "cuboidmodeler::Cuboid::Color::red";
			
			
			public static String green = "cuboidmodeler::Cuboid::Color::green";
			
			
			public static String blue = "cuboidmodeler::Cuboid::Color::blue";
			
			
			public static String opacity = "cuboidmodeler::Cuboid::Color::opacity";
			
	
		}
	
		public static class Attributes {
	
			
			public static String length = "cuboidmodeler::Cuboid::Attributes::length";
			
			
			public static String height = "cuboidmodeler::Cuboid::Attributes::height";
			
			
			public static String depth = "cuboidmodeler::Cuboid::Attributes::depth";
			
	
		}
	
	}

}
