Use the supplied .java file(s) as the basis of your solution to the assignment. Note that, for the purposes of this course, all classes are defined within the default package (in other words, they do not explicitly specify a package).

This assignment must be submitted as a .zip file containing only your solution's .java files named following the convention LastnameFirstInitialExercise#.zip where the '#' is the Exercise number.
For example, my submission for this assignment would be named DukeGExercise10.13.zip). There should be NO DIRECTORIES within the zip file.

Inclusion of the System.exit() method in your code negatively impacts the operation of the test suite and will result in a loss of credit. DO NOT use the System.exit() method in your solution.

I have not provided the usual template code this time. I have included the test suite (ShapeHierarchy_test.java) and a working command line test driver (ShapeTest.java) to aid in checking your work. Despite what the assignment prompt states in the text YOU ARE NOT REQUIRED TO WRITE YOUR OWN TEST DRIVER (that part is being provided for you). Your assignment is to create and complete: Shape.java, TwoDimensionalShape.java, ThreeDimensionalShape.java, Circle.java, Square.java, Triangle.java, Sphere.java, Cube.java, and Tetrahedron.java as per the assignment prompt. Your assignment submission should contain only these classes. DO NOT submit ShapeHierarchy_test.java  or ShapeTest.java.

The format of the console output is relaxed for this assignment. As a guide, samples Circle.java and Tetrahedron.java implementations follow (yours should display the same data, but the formatting and the instance variables accessed may vary based on your implementation):
    // Circle toString
    public String toString() {
        return "radius: " + getDim1();
    }

    // Tetrahedron toString
    public String toString() {
        return "base width: " + getDim1() + ", base height: " + getDim2() + 
                ", height: " + getDim3();
    }

Happy coding!