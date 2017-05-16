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
   
	/**
	 * Default constructor
	 */
	public IntegerSet() {}
    
    /**
     *  IntegerSet accessor
	 * @return the set as a boolean array
	 */
	private boolean[] getSet() {
		return set;
	}

	/**
	 * IntegerSet mutator
	 * @param 	sets the boolean array set 
	 */
	private void setSet(boolean[] set) {
		// Throw an error message if a larger set is passed
		if (set.length > this.set.length) {
			throw new IndexOutOfBoundsException("Set should be in range 0 - 100");
		}
		
		this.set = set;
	}


	/**
	 * Outputs the union between two sets, passed as arguments
	 * @param a	First set to compare
	 * @param b	Second set to compare
	 * @return	Returns a new IntegerSet, containing the union of the two IntegerSet objects
	 */
	public static IntegerSet union (IntegerSet a, IntegerSet b) {
		// create a new IntegerSet that will be hold the union of the two integer sets
		IntegerSet resultSet = new IntegerSet();	
		
		for (int i = 0; i < resultSet.getSet().length; i++) {
			if (a.set[i] || b.set[i]) {		// if element in a OR element in b are true
				resultSet.set[i] = true;
			}	
		}
		return resultSet;
	}
	
	/**
	 * Outputs the intersection of two sets, passed as arguments
	 * @param a	First set to compare
	 * @param b	Second set to compare
	 * @return Returns a new IntegerSet containing the intersection of the two IntegerSet objects
	 */
    public static IntegerSet intersection(IntegerSet a, IntegerSet b) {
    	// create a new IntegerSet that will be hold the intersection of the two integer sets
    	IntegerSet resultSet = new IntegerSet();
    	
    	for (int i = 0; i < resultSet.getSet().length; i++) {
    		if (a.set[i] && b.set[i]) {		// if element in a AND element in b are true
    			resultSet.set[i] = true;
    		}
    	}
    	return resultSet;
    }
    
    /**
     * Inserts an element into the IntegerSet by setting the corresponding
     * value within the set array to true
     * @param index	The array index to set
     * @return Returns false if the value was out of range and true otherwise.
     */
    public boolean insertElement(int index) {   	
    	if (index < set.length || index >= 0) { // Check if index is in range
    		this.set[index] = true;	// set index to true;
    		return true; 			// exit, no need to go further
    	}
    	else {						// index is not in range
    		return false;			// nothing to set return false	
    	}
    }
    
    /**
     * Deletes an element from the IntegerSet by setting the corresponding
     * value within the set array to false. 
     * @param index	The array index to set
     * @return Returns false if the value was out of range and true otherwise.
     */
    public boolean deleteElement(int index) {   	
    	if (index < set.length || index >= 0) {
    		this.set[index] = false;	// delete index (set to false);
    		return true; 				// index is in range
    	}
    	else { 							
    		return false;				// specified index is either not in the set range
    	}
    }
    
    /**
     * Overrides the toString method in the Object class
     * Displays the integers contained by the IntegerSet separated by spaces. 
     */
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < this.set.length; i++) {
    		if (this.set[i]) {	// Loops through the array and if an element is set to true add to output string
    			sb.append(String.format("%d ", i));	
    		}
    	}
    	
    	if (sb.length() > 0) {
    		return String.format("{ %s} ", sb.toString()); // Display integers in the format of { 5 10 }
    	}
    	else {
    		return String.format("{ --- }");	// Display when empty set
    	}
    }
    
    /**
     * Checks if current set is equal to another set passed as argument
     * @param Set to check for equality
     * @return Returns true if the current IntegerSet contains the same integers as
     * the IntegerSet supplied as an argument
     */
	public boolean isEqualTo(IntegerSet b) {
		// Loop trough both sets and as soon as a difference if find return false
		// If no difference is found return true. Both sets are equal
		for (int i = 0; i < this.set.length; i++) {
			if (this.set[i] != b.set[i]) {
				return false;	// the two sets are not equal
			}
		}
		return true;	// the two sets are equal
	}
}












