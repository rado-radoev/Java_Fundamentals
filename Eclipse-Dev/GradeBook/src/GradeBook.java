
public class GradeBook {
	private String courseName; // name of the course that GradeBook represents
	private int[] grades;	// array of student grades
	
	// Constructor
	public GradeBook(String courseName, int[] grades) {
		this.courseName = courseName;
		this.grades = grades;
	}
	
	// set course name
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	// retreive course name
	public String getCourseName() {
		return courseName;
	}
	
	// perform various operations on the data
	public void processGrades() {
		// output graders array
		outputGrades();
		
		// calculate method getAverage to calculate the average grade
		System.out.printf("%nClass average is %.2f%n", getAverage());
		
		// call methods getMinimum and getMaximum
		System.out.printf("Lowest grade is %d%nHighest grade is %d%n%n", getMinimum(), getMaximum());
		
		// call outputBarChart to print grade distribution chart
		outputBarChart();
	}
	
	
	// find minimum grade
	public int getMinimum() {
		int lowGrade = grades[0];	// assume grade[0] is the smallest
		
		// loop through grades array
		for (int grade : grades) {
			if (grade < lowGrade) {
				lowGrade = grade;
			}
		}
		
		return lowGrade;
	}
	
	
	// find maximum grade
	public int getMaximum() {
		int highestGrade = grades[0];	// assume grade[0] is the highest
		
		for (int grade : grades) {
			if (grade > highestGrade) {
				highestGrade = grade;
			}
		}
		return highestGrade;
	}
	
	// get average grade
	public double getAverage() {
		int total = 0;
		
		for (int grade : grades) {
			total += grade;
		}
		
		return (double) total / grades.length;
	}
	
	// output barchart displaying grade distribution
	public void outputBarChart() {
		System.out.println("Grade distribution:");
		
		// store frequency of grades in each range of 10 grades
		int[] frequency = new int[11];
		
		// for each grade, increment the appropriate frequency
		for (int grade : grades) {
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
		
		// output each student's grade
		for (int student = 0; student < grades.length; student++) {
			System.out.printf("Student %2d: %3d%n", student + 1, grades[student]);
		}
	}
	
	
	
	
	
	
	
	
	
}