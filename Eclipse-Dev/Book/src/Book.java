// Fig. 8.10 - 8.11
public enum Book {

	// declare constants for enum type
	JHTP("Java head first", "2015"),
	CHTP("C head first", "2013"),
	IW3HTP("Internet & world wide web how to Program", "2012"),
	CPPHTP("C++ How to Program", "2014"),
	VBHTP("Visual Basic how to Program", "2014"),
	CSHARPHTP("Visual C# how to Program", "2014");
	
	// instance fields
	private final String title;
	private final String copyrightYear;
	
	// enum constructor
	private Book(String title, String copyrightYear) {
		this.title = title;
		this.copyrightYear = copyrightYear;
	}
	
	// accessor for title
	public String getTitle() {
		return title;
	}
	
	// accessor for copyrightYear
	public String getCopyrightYear() {
		return copyrightYear;
	}
}
