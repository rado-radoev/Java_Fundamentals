/*
 * IntegerSet.java
 */

/**
 *
 * @author Radoslav Radoev
 */
public class IntegerSet {
    
    /** 
     * Creates a new instance of IntegerSet   
     */
	private boolean[] set = new boolean[101];
    
	// Default constructor
	public IntegerSet() {}
    
    /**
     *  IntegerSet accessor
	 * @return the set
	 */
	private boolean[] getSet() {
		return set;
	}

	/**
	 * IntegerSet mutator
	 * @param 	sets the boolean array set 
	 */
	private void setSet(boolean[] set) {
		this.set = set;
	}

	/**
     * Return a new IntegerSet containing the union of the two IntegerSet objects
     * passed as arguments
     */
    // TODO: implement the union method
	public IntegerSet union (IntegerSet a, IntegerSet b) {
		// create a new IntegerSet that will be hold the union of the two integer sets
		IntegerSet temp = new IntegerSet();	
		// iterate through array a.length. - both arrays should have the same size 101
		// if a[i] == b[i], if both are true then add one element to new array
		// if a[i] == true, add it to the array
		// if b[i] == true, add it to the array
		// if any of the elements is set to false, they are not in the set, so 
		// don't add them to the new boolean array;
		
		for (int i = 0; i < a.getSet().length; i++) {
			if (a.set[i] == b.set[i]) {
				temp.set[i] = true;
			}
			else if (a.set[i] == true) {
				temp.set[i] = true;
			}
			else if (b.set[i] == true) {
				temp.set[i] = true;
			}
		}
		
		return temp;
		// For example: let A = (1,2,3) and let B = (3,4,5). Now the UNION of A and B, written A union B = (1,2,3,4,5). There is no need to list the 3 twice.
	}
	
    
    /**
     * Return a new IntegerSet containing the intersection of the two IntegerSet objects
     * passed as arguments
     */
    // TODO: implement the intersection method
    
    /**
     * Inserts an element into the IntegerSet by setting the corresponding
     * value within the set array to true. Returns false if the value was out
     * of range and true otherwise.
     */
    // TODO: implement the insertElement method
    
    /**
     * Deletes an element from the IntegerSet by setting the corresponding
     * value within the set array to false. Returns false if the value was out
     * of range and true otherwise.
     */
    // TODO: implement the deleteElement method 
    
    /**
     * @Override the toString method in the Object class
     * Displays the integers contained by the IntegerSet separated by spaces. 
     * An empty set should be displayed as:
     * { --- }
     * An integer set containing 5 and 10 should be displayed as:
     * { 5 10 }
     */
    // TODO: implement the toString method   
    
    /**
     * Returns true iff the current IntegerSet contains the same integers as
     * the IntegerSet supplied as an argument
     */
	// TODO: implement the isEqualTo method         
}
