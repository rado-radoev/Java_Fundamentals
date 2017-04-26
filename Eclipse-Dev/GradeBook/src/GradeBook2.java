
public class GradeBook2 {
	private String courseName; // name of the course that GradeBook represents
	private int[][] grades;	// array of student grades
	
	// Constructor
	private GradeBook2(GradeBookBuilder builder) {
		this.courseName = builder.courseName;
		this.grades = builder.grades;
	}
	
	// set course name
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	// Retrieve course name
	public String getCourseName() {
		return courseName;
	}
	
	// perform various operations on the data
	public void processGrades() {
		// output graders array
		outputGrades();
		
		// call methods getMinimum and getMaximum
		System.out.printf("%n%s %d%n%s %d%n%n", 
				"Lowest grade in the grade boos is", getMinimum(),
				"Highest grade in the grade book is", getMaximum());
		
		// call outputBarChart to print grade distribution chart
		outputBarChart();
	}
	
	
	// find minimum grade
	public int getMinimum() {
		// assume first element is the smallest
		int lowGrade = grades[0][0];
		
		// loop through rows of grades array
		for (int[] studentGrades : grades) {
			// loop through columns
			for (int grade : studentGrades) {
				if (grade < lowGrade) {
					lowGrade = grade;
				}
			}
		}
		return lowGrade;
	}
	
	
	// find maximum grade
	public int getMaximum() {
		int highestGrade = grades[0][0];	// assume grade[0] is the highest
		
		for (int row = 0; row < grades.length; row++)
			for (int column = 0; column < grades[row].length; column++)
				if (highestGrade < grades[row][column])
					highestGrade = grades[row][column];
					
		return highestGrade;
	}
	
	// get average grade
	public double getAverage(int[] studentGrades) {
		int total = 0;
		
		for (int grade : studentGrades)
			total += grade;
		
		return (double) total / grades.length;
	}
	
	// output barchart displaying grade distribution
	public void outputBarChart() {
		System.out.println("Overall grade distribution:");
		
		// store frequency of grades in each range of 10 grades
		int[] frequency = new int[11];
		
		// for each grade, increment the appropriate frequency
		for (int[] studentGrade : grades) {
			for (int grade : studentGrade) 
				++frequency[grade / 10];
		}
		
		// for each grade frequency, print bar in chart
		for (int count = 0; count < frequency.length; count++) {
			// output bar label
			if (count == 10) {
				System.out.printf("%5d: ", 100);
			}
			else {
				System.out.printf("%02d-%02d: ", count * 10, count * 10 + 9);
			}
			
			// print bar of asterisks
			for(int stars = 0; stars < frequency[count]; stars++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	
	// output the contents of the grades array
	public void outputGrades() {
		System.out.printf("The grades are %n%n");
		System.out.print("                ");   // align column heads
		
		// create a column heading for each of the tests
		for (int test = 0; test < grades[0].length; test++) 
			System.out.printf("Test %d ", test + 1);
		
		System.out.println("Average"); // Student average column heading
		
		// create rows/columns of text representing array grades
		for (int student = 0; student < grades.length; student++) {
		
			System.out.printf("Student %2d", student + 1);
			
			for(int test : grades[student])
				System.out.printf("%8d", test);
			
			double average = getAverage(grades[student]);
			System.out.printf("%9.2f%n", average);
		}

	}
	
	
	public static class GradeBookBuilder {
		private String courseName; // name of the course that GradeBook represents
		private int[][] grades;	// array of student grades
		
		public GradeBookBuilder() {
			
		}
		
		public GradeBookBuilder courseName(String courseName) {
			this.courseName = courseName;
			return this;
		}
		
		public GradeBookBuilder grades(int[][] grades) {
			this.grades = grades;
			return this;
		}
		
		public GradeBook2 build() {
			GradeBook2 gradeBook = new GradeBook2(this);
			return gradeBook;
		}
		
	}

}
