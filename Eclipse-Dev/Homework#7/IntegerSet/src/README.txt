Use the supplied .java file(s) as the basis of your solution to the assignment. Note that, for the purposes of this course, all classes are defined within the default package (in other words, they do not explicitly specify a package).

This assignment must be submitted as a .zip file containing only your solution's .java files named following the convention LastnameFirstInitialExercise#.zip where the '#' is the Exercise number.
For example, my submission for this assignment would be named DukeGExercise8.13.zip). There should be NO DIRECTORIES within the zip file.

Inclusion of the System.exit() method in your code negatively impacts the operation of the test suite and will result in a loss of credit. DO NOT use the System.exit() method in your solution.

In addition to the usual template code (IntegerSet.java) I have included a working command line test driver (IntegerSetTest.java) to aid in interactively manipulating IntegerSets and checking your work. Despite what the assignment prompt states in the text YOU ARE NOT REQUIRED TO WRITE YOUR OWN TEST DRIVER. Your assignment is to complete IntegerSet.java as per the assignment prompt. Your assignment submission should contain only IntegerSet.java. DO NOT submit IntegerSetTest.java.

As for the format of IntegerSet output…
An empty IntegerSet should be displayed as:
{ --- }
An integer set containing 5 and 10 should be displayed as:
{ 5 10 }

Still reading? You're in luck!
A unit test driver that bears a striking resemblance to the one I'll use to grade your assignment has also been made available. Please use that to check your assumptions and validate your work.


Questions:

1. Do I create only 1 boolean array set with a range from 0-100?

2. Why do we need a no-argument constructor to initialize the array to the "empty set"?

3. If an IntegerSet only has a single array of booleans how can we create a method that creates set that is union of two existing sets?

4. What is the expected output for the empty set?

5. What is the expected output if the set contains 0, 6 and 100.


Answers:

1. The class IntegerSet has a single 101 element array of type boolean: this is an instance variable. Multiple instances of IntegerSet can be created and, since the array is an instance variable, each will have its own independent array representing its own independent set.

For example:
IntegerSet is1 = new IntegerSet();
IntegerSet is2 = new IntegerSet();

is1 and is2 can then be manipulated.

Note that the elements in the array are not integers. Per the assignment prompt the array must be of type boolean. The assignment prompt states this as, "The set is represented by an array of booleans." Each element in the array can be either true or false (because they are of type boolean). Each element in the array corresponds to an integer that may be in the set. As a result the array must be just large enough for each of the 101 possible values (0-100) to be represented. If the element in the array corresponding to an integer is true then the integer is in the set; conversely, if it is false the integer is not in the set. If your IntegerSet's array is named set (just name it set... that's what the unit tests I provided assume), and if you have an IntegerSet named iSet, then if iSet.set[3] == true you know that 3 is in the set and if iSet.set[4] == false you know that 4 is not in the set.

2. You're right, this will be handled by default since instance variables receive default values unless explicitly set in the constructor. Every element of an array instance variable is initialized to the default value of its type which, in this case, is false.


3. Make a static method that populates and returns a new IntegerSet with the union of the two sets it is passed as arguments.

A call would look like:
IntegerSet unionResult = union(is1, is2);

And the method signature would look like:
public static IntegerSet union(IntegerSet setA, IntegerSet setB) {
Create a new IntegerSet resultSet.
Loop over each element in the result set's boolean array... if the current index you're on holds a value of true in the array of either of the IntegerSets that were passed as arguments, set that index to true in the resultSet.
Return the resultSet.
}

The intersection is almost identical (it really comes down to using "or" for union and "and" for intersection).


4. { --- }


5. { 0 6 100 }