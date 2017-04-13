import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import junit.framework.TestCase;


public class CommissionCalculator_test extends TestCase {
	
	public static String newline = System.getProperty("line.separator");
	
	public void testNoSales() {
		final double expectedEarnings = 200;
		
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "0" + newline;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		CommissionCalculator.main(arr);
		System.err.println(capturedOut);
		
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			/* Consume lines until we find the one with "Total earnings"
			 * Then, ensure the value is ~$200
			 */
			String currentLine;
			do {
				currentLine = sc.nextLine().toLowerCase();
			} while(!currentLine.contains("total earnings") && sc.hasNextLine());
			assertEquals("The program's output is non-conformant: \"Total earnings\" was not displayed", true, currentLine.contains("total earnings"));
			
			Scanner digitScan = new Scanner(currentLine);
			digitScan.skip(".*total earnings");

			// Skip to the earnings salary
			digitScan.skip("\\D+");
			if (!digitScan.hasNextDouble()) {
				fail("The program's output is non-conformant: total earnings not displayed as specified");
			} else {
				assertEquals("The program's output is non-conformant: the earnings value is incorrect", expectedEarnings, digitScan.nextDouble(), expectedEarnings * .01);
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testSomeSales() {
		final double expectedEarnings = 312.86;
		
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "1" + newline + "1" + newline + "2" + newline + "4" + newline + "3" + newline + "3" + newline + "3" + newline + "0" + newline;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		CommissionCalculator.main(arr);
		System.err.println(capturedOut);
		
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			/* Consume lines until we find the one with "Total earnings"
			 * Then, ensure the value is ~$200
			 */
			String currentLine;
			do {
				currentLine = sc.nextLine().toLowerCase();
			} while(!currentLine.contains("total earnings") && sc.hasNextLine());
			assertEquals("The program's output is non-conformant: \"Total earnings\" was not displayed", true, currentLine.contains("total earnings"));
			
			Scanner digitScan = new Scanner(currentLine);
			digitScan.skip(".*total earnings");

			// Skip to the earnings salary
			digitScan.skip("\\D+");
			if (!digitScan.hasNextDouble()) {
				fail("The program's output is non-conformant: total earnings not displayed as specified");
			} else {
				assertEquals("The program's output is non-conformant: the earnings value is incorrect", expectedEarnings, digitScan.nextDouble(), expectedEarnings * .01);
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testInvalidPlusNoSales() {
		final double expectedEarnings = 200;
		
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "42" + newline + "-42" + newline + "0" + newline;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		CommissionCalculator.main(arr);
		System.err.println(capturedOut);

		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			/* Consume lines until we find the one with "Total earnings"
			 * Then, ensure the value is ~$200
			 */
			String currentLine;
			do {
				currentLine = sc.nextLine().toLowerCase();
			} while(!currentLine.contains("total earnings") && sc.hasNextLine());
			assertEquals("The program's output is non-conformant: \"Total earnings\" was not displayed", true, currentLine.contains("total earnings"));
			
			Scanner digitScan = new Scanner(currentLine);
			digitScan.skip(".*total earnings");

			// Skip to the earnings salary
			digitScan.skip("\\D+");
			if (!digitScan.hasNextDouble()) {
				fail("The program's output is non-conformant: total earnings not displayed as specified");
			} else {
				assertEquals("The program's output is non-conformant: the earnings value is incorrect", expectedEarnings, digitScan.nextDouble(), expectedEarnings * .01);
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testInvalidPlusSomeSales() {
		final double expectedEarnings = 259.85;
		
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "3" + newline + "3" + newline + "1" + newline + "42" + newline + "3" + newline + "-42" + newline + "2" + newline + "0" + newline;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		CommissionCalculator.main(arr);
		System.err.println(capturedOut);

		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			/* Consume lines until we find the one with "Total earnings"
			 * Then, ensure the value is ~$200
			 */
			String currentLine;
			do {
				currentLine = sc.nextLine().toLowerCase();
			} while(!currentLine.contains("total earnings") && sc.hasNextLine());
			assertEquals("The program's output is non-conformant: \"Total earnings\" was not displayed", true, currentLine.contains("total earnings"));
			
			Scanner digitScan = new Scanner(currentLine);
			digitScan.skip(".*total earnings");

			// Skip to the earnings salary
			digitScan.skip("\\D+");
			if (!digitScan.hasNextDouble()) {
				fail("The program's output is non-conformant: total earnings not displayed as specified");
			} else {
				assertEquals("The program's output is non-conformant: the earnings value is incorrect", expectedEarnings, digitScan.nextDouble(), expectedEarnings * .01);
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testCurrentCompensationRunningTotal() {
		
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "100" + newline + "1" + newline + "2" + newline + "3" + newline + "4" + newline + "0" + newline;
		double expectedCompensationProgression[] = {200, 200, 221.51, 233.12, 242.03, 273.53};
		
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		CommissionCalculator.main(arr);
		System.err.println(capturedOut);

		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
		
			/* There should be two error messages (two instances of invalid input) in this test case.
			 * Verifying a different part of the error message each time.
			 */
			for (int ii = 0; ii < expectedCompensationProgression.length; ii++) {
				String currentLine = nextLineContaining(sc, "Current");
				Scanner digitScan = new Scanner(currentLine);
				// Skip to the earnings salary
				digitScan.skip("\\D+");
				if (!digitScan.hasNextDouble()) {
					fail("The program's output is non-conformant: current earnings not displayed as specified");
				} else {
					assertEquals("The program's output is non-conformant: the current earnings value is incorrect", expectedCompensationProgression[ii], digitScan.nextDouble(), expectedCompensationProgression[ii] * .01);
				}
				
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testMenuOutputEachTime() {
		
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "1" + newline + "2" + newline + "0" + newline;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		CommissionCalculator.main(arr);
		System.err.println(capturedOut);

		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			/* Look for the specified input, in order, amongst the lines of the captured output buffer
			 * The menu should be displayed 3 times for this input set
			 */
			for (int ii = 0; ii < 3; ii++) {
				assertNotNull("The program's output is non-conformant: the column heading \"Value\" is not present as expected", nextLineContaining(sc, "Value"));
				assertNotNull("The program's output is non-conformant: the column displaying the item price \"239.99\" is not present as expected", nextLineContaining(sc, "239.99"));
				assertNotNull("The program's output is non-conformant: the column displaying the item price \"129.75\" is not present as expected", nextLineContaining(sc, "129.75"));
				assertNotNull("The program's output is non-conformant: the column displaying the item price \"99.95\" is not present as expected", nextLineContaining(sc, "99.95"));
				assertNotNull("The program's output is non-conformant: the column displaying the item price \"350.89\" is not present as expected", nextLineContaining(sc, "350.89"));
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testErrorOutput() {
		
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "1" + newline + "-2" + newline + "1" + newline + "13" + newline + "0" + newline;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		CommissionCalculator.main(arr);
		System.err.println(capturedOut);

		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			/* There should be two error messages (two instances of invalid input) in this test case.
			 * Verifying a different part of the error message each time.
			 */
			assertNotNull("The program's output is non-conformant: the invalid input error message does not contain \"ERROR\" as expected", nextLineContaining(sc, "ERROR"));
			assertNotNull("The program's output is non-conformant: the invalid input error message does not contain \"Invalid input\" as expected", nextLineContaining(sc, "Invalid input"));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	/**
	 * @param sc the Scanner to read from
	 * @param str the string to identify within the candidate lines (Scanner's buffer). It is converted to lower case in support of a case-insensitive search.
	 * @return the next line from the scanner containing the specified parameter or null if none are present
	 */
	private String nextLineContaining(Scanner sc, String str) {
		str = str.toLowerCase();
		String currentLine;
		do {
			currentLine = sc.nextLine().toLowerCase();
		} while(!currentLine.contains(str) && sc.hasNextLine());
		if (!currentLine.contains(str)) {
			currentLine = null;
		}
		return currentLine;
	}
	
	/* method name retrieval code courtesy of: http://dev.kanngard.net/Permalinks/ID_20030114224837.html
	 */
	private void assertThrowableTestFailure(Throwable thrown) {
		StackTraceElement stackTraceElements[] =
            (new Throwable()).getStackTrace();
		fail(thrown.getClass().getName() + " encountered! Unable to successfully execute test: " + stackTraceElements[1].toString());
	}
}
