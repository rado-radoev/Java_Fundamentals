import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import junit.framework.TestCase;


public class ShapeHierarchy_test extends TestCase {
	// Canned test data
	double d1 = 3;
	double d2 = 4;
	double d3 = 5;
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	// BEGIN verification of inheritance hierarchy
	public void testShapeInheritance() {
		assertEquals("The Shape class should not specify a superclass (i.e.: it should implicitly extend Object)", Object.class, Shape.class.getSuperclass());
	}
	
	public void testTwoDimensionalShapeInheritance() {
		assertEquals("The TwoDimensionalShape class should extend Shape", Shape.class, TwoDimensionalShape.class.getSuperclass());
	}
	
	public void testThreeDimensionalShapeInheritance() {
		assertEquals("The ThreeDimensionalShape class should extend Shape", Shape.class, ThreeDimensionalShape.class.getSuperclass());
	}
	
	public void testCircleInheritance() {
		assertEquals("The Circle class should extend TwoDimensionalShape", TwoDimensionalShape.class, Circle.class.getSuperclass());
	}
	
	public void testSquareInheritance() {
		assertEquals("The Square class should extend TwoDimensionalShape", TwoDimensionalShape.class, Square.class.getSuperclass());
	}
	
	public void testTriangleInheritance() {
		assertEquals("The Triangle class should extend TwoDimensionalShape", TwoDimensionalShape.class, Triangle.class.getSuperclass());
	}
	
	public void testSphereInheritance() {
		assertEquals("The Sphere class should extend ThreeDimensionalShape", ThreeDimensionalShape.class, Sphere.class.getSuperclass());
	}
	
	public void testCubeInheritance() {
		assertEquals("The Cube class should extend ThreeDimensionalShape", ThreeDimensionalShape.class, Cube.class.getSuperclass());
	}
	
	public void testTetrahedronInheritance() {
		assertEquals("The Tetrahedron class should extend ThreeDimensionalShape", ThreeDimensionalShape.class, Tetrahedron.class.getSuperclass());
	}
	
	public void testShapeAbstract() {
		assertTrue("The Shape class should be declared as abstract: it does not contain sufficient data to warrant instanciation", Modifier.isAbstract(Shape.class.getModifiers()));
	}
	// END verification of inheritance hierarchy
	
	// BEGIN verification of area methods
	public void testCircleArea() {
		verifyArea(
				new Circle(d1),
				Math.PI * Math.pow(d1, 2)
		);
	}
	public void testSquareArea() {
		verifyArea(
				new Square(d1),
				Math.pow(d1, 2)
		);
	}
	public void testTriangleArea() {
		verifyArea(
				new Triangle(d1, d2),
				d1 * d2/2
		);
	}
	public void testSphereArea() {
		verifyArea(
				new Sphere(d1),
				4 * Math.PI * Math.pow(d1, 2)
		);
	}
	public void testCubeArea() {
		verifyArea(
				new Cube(d1),
				6 * Math.pow(d1, 2)
		);
	}
	public void testTetrahedronArea() {
		verifyArea(
				new Tetrahedron(d1, d2, d3),
				4 * ((d1 * d2)/2)
		);
	}
	private void verifyArea(Shape shape, double expectedArea) {
		assertTrue("ERROR: invoked verifyArea on a non TwoDimensionalShape/ThreeDimensionalShap object", shape instanceof TwoDimensionalShape || shape instanceof ThreeDimensionalShape);
		if (shape instanceof TwoDimensionalShape) {
			assertEquals(shape.getClass().getName() + ".getArea() returned an incorrect value", expectedArea, ((TwoDimensionalShape)shape).getArea(), expectedArea * 0.1);
		} else {
			assertEquals(shape.getClass().getName() + ".getArea() returned an incorrect value", expectedArea, ((ThreeDimensionalShape)shape).getArea(), expectedArea * 0.1);
		}
	}
	// END verification of area methods
	
	// BEGIN verification of volume methods
	public void testSphereVolume() {
		verifyVolume(
				new Sphere(d1),
				4/3.0 * Math.PI * Math.pow(d1, 3)
		);
	}
	public void testCubeVolume() {
		verifyVolume(
				new Cube(d1),
				Math.pow(d1, 3)
		);
	}
	public void testTetrahedronVolume() {
		verifyVolume(
				new Tetrahedron(d1, d2, d3),
				1/3.0 * ((d1 * d2)/2) * d3
		);
	}
	private void verifyVolume(ThreeDimensionalShape shape, double expectedVolume) {
		assertEquals(shape.getClass().getName() + ".getVolume() returned an incorrect value", expectedVolume, shape.getVolume(), expectedVolume * 0.1);
	}
	// END verification of volume methods
	
	/**
	 * Verify method declarations align with the inheritance hierarchy
	 */
	public void testTwoDimensionalShapeMethodDeclarations() {
		methodVerification(TwoDimensionalShape.class, true, "getArea");
		methodVerification(TwoDimensionalShape.class, false, "getVolume");
	}
	
	/**
	 * Verify method declarations align with the inheritance hierarchy
	 */
	public void testThreeDimensionalShapeMethodDeclarations() {
		methodVerification(ThreeDimensionalShape.class, true, "getArea", "getVolume");
	}
	
	/**
	 * Ensures the specified Method(s) is/are present/absent
	 */
	public void methodVerification(Class clazz, boolean verifyPresence, String ... targetMethodNames) {
		ArrayList<String> actualMethodNames = new ArrayList<String>();
		for (Method currentMethod : clazz.getDeclaredMethods()) {
			actualMethodNames.add(currentMethod.getName());
		}
		for (String currentMethodName : targetMethodNames) {
			if (verifyPresence) {
				assertTrue("Method (" + currentMethodName + ") incorrectly absent from " + clazz.getName(), actualMethodNames.contains(currentMethodName));
			} else {
				assertFalse("Method (" + currentMethodName + ") incorrectly implemented in " + clazz.getName(), actualMethodNames.contains(currentMethodName));
			}
		}
	}
	
}
