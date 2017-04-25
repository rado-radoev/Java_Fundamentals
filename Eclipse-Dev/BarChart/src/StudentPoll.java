
public class StudentPoll {

	public static void main(String[] args) {
		
		int[] responses = {1,2,5,4,3,2,1,3,3,1,4,3,3,3,2,3,3,2,14};	// array that will hold the student responses
		int[] frequency = new int[6];	// array that will count the frequency
		
		for (int answer = 0; answer < responses.length; answer++) {	 // Loop through responses array
			try {
				++frequency[responses[answer]];		// Each response is the index of the frequency array. Increment the value of the index in frequency array
			} catch (ArrayIndexOutOfBoundsException e) {	// if the value is too big (anything more than 5) Do not add it to the frequency array.
				System.out.println(e); // invokes to string method
				System.out.printf("\tresponses[%d] = %d%n%n", answer, responses[answer]);
			}
		}
		
		System.out.printf("%s%10s%n", "Rating", "Frequency");
		
		// output each array element's value
		for (int rating = 1; rating < frequency.length; rating++) {
			System.out.printf("%6d%10s%n", rating, frequency[rating]);
		}
	}

}
