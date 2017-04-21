import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Ignore;

import junit.framework.TestCase;


public class SmallestInt_test extends TestCase {
	
	public static String newline = System.getProperty("line.separator");
	
//	public void testFullPromptCompliance() {
//		// Capture the output
//		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(capturedOut));
//
//		// Stimulate the input
//		String data = "3\r\n" + newline + "1" + newline + "4" + newline + "9" + newline;
//		System.setIn(new ByteArrayInputStream(data.getBytes()));
//
//		String[] arr = {};
//		SmallestInt.main(arr);
//		System.err.println(capturedOut);
//
//		Scanner sc = new Scanner(capturedOut.toString());
//		try {
//			/* FIRST LINE
//			 */
//			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
//
//			/* Consume all output lines asserting that each contains the expected output
//			 */
//			String expectedLines[] = { // If the program produces output per guidance all of these will appear on a single line when the unit test output is captured...
//					"How many integers shall we compare? (Enter a positive integer):",
//					"Enter value 1:",
//					"Enter value 2:",
//					"Enter value 3:",
//					"The smallest number entered was:"
//			};
//			String currentLine = sc.nextLine();
//			for (int ii = 0; ii < expectedLines.length; ii++) {
////				String currentLine = sc.nextLine();
//				assertTrue("The program's output is non-conformant. Expected: " + expectedLines[ii] + " ... Encountered: " + currentLine, currentLine.toLowerCase().contains(expectedLines[ii].toLowerCase()));
//			}
//
//		} catch (Exception e) {
//			assertThrowableTestFailure(e);
//		}
//	}
	
	public void testThreeIncreasing() {
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "3" + newline + "1" + newline + "4" + newline + "9" + newline;
		int knownSmallest = 1;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		SmallestInt.main(arr);
		System.err.println(capturedOut);
		
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			String currentLine = nextLineContaining(sc, "smallest");
			if (currentLine == null) {
				fail("The program's output is non-conformant: \"smallest\" was not displayed");
			}
			
			Scanner digitScan = new Scanner(currentLine);
			digitScan.skip(".*smallest");

			// Skip to the earnings salary
			digitScan.skip("\\D+");
			if (!digitScan.hasNextInt()) {
				fail("The program's output is non-conformant: smallest int not displayed as specified");
			} else {
				assertEquals("The program's output is non-conformant: the smallest int is incorrect", knownSmallest, digitScan.nextInt());
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	
	public void testNegativeThree() {
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "-3" + newline + "3" + newline + "1" + newline + "4" + newline + "9" + newline;
		int knownSmallest = 1;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		SmallestInt.main(arr);
		System.err.println(capturedOut);
		
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			String currentLine = nextLineContaining(sc, "smallest");
			if (currentLine == null) {
				fail("The program's output is non-conformant: \"smallest\" was not displayed");
			}
			
			Scanner digitScan = new Scanner(currentLine);
			digitScan.skip(".*smallest");

			// Skip to the earnings salary
			digitScan.skip("\\D+");
			if (!digitScan.hasNextInt()) {
				fail("The program's output is non-conformant: smallest int not displayed as specified");
			} else {
				assertEquals("The program's output is non-conformant: the smallest int is incorrect", knownSmallest, digitScan.nextInt());
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	
	public void testZeroThree() {
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "0" + newline + "3" + newline + "1" + newline + "4" + newline + "9" + newline;
		int knownSmallest = 1;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		SmallestInt.main(arr);
		System.err.println(capturedOut);
		
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			String currentLine = nextLineContaining(sc, "smallest");
			if (currentLine == null) {
				fail("The program's output is non-conformant: \"smallest\" was not displayed");
			}
			
			Scanner digitScan = new Scanner(currentLine);
			digitScan.skip(".*smallest");

			// Skip to the earnings salary
			digitScan.skip("\\D+");
			if (!digitScan.hasNextInt()) {
				fail("The program's output is non-conformant: smallest int not displayed as specified");
			} else {
				assertEquals("The program's output is non-conformant: the smallest int is incorrect", knownSmallest, digitScan.nextInt());
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testOne() {
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "1" + newline + "42" + newline;
		int knownSmallest = 42;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		SmallestInt.main(arr);
		System.err.println(capturedOut);
		
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			String currentLine = nextLineContaining(sc, "smallest");
			if (currentLine == null) {
				fail("The program's output is non-conformant: \"smallest\" was not displayed");
			}
			
			Scanner digitScan = new Scanner(currentLine);
			digitScan.skip(".*smallest");

			// Skip to the earnings salary
			digitScan.skip("\\D+");
			if (!digitScan.hasNextInt()) {
				fail("The program's output is non-conformant: smallest int not displayed as specified");
			} else {
				assertEquals("The program's output is non-conformant: the smallest int is incorrect", knownSmallest, digitScan.nextInt());
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	
	public void testSmallestInMiddle() {
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "3" + newline + "25" + newline + "5" + newline + "10" + newline;
		int knownSmallest = 5;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		SmallestInt.main(arr);
		System.err.println(capturedOut);
		
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			String currentLine = nextLineContaining(sc, "smallest");
			if (currentLine == null) {
				fail("The program's output is non-conformant: \"smallest\" was not displayed");
			}
			
			Scanner digitScan = new Scanner(currentLine);
			digitScan.skip(".*smallest");

			// Skip to the earnings salary
			digitScan.skip("\\D+");
			if (!digitScan.hasNextInt()) {
				fail("The program's output is non-conformant: smallest int not displayed as specified");
			} else {
				assertEquals("The program's output is non-conformant: the smallest int is incorrect", knownSmallest, digitScan.nextInt());
			}
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	
	public void testSmallestLast() {
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
	
		// Stimulate the input
		String data = "4" + newline + "81" + newline + "27" + newline + "9" + newline + "3" + newline;
		int knownSmallest = 3;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		String[] arr = {};
		SmallestInt.main(arr);
		System.err.println(capturedOut);
		
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			String currentLine = nextLineContaining(sc, "smallest");
			if (currentLine == null) {
				fail("The program's output is non-conformant: \"smallest\" was not displayed");
			}
			
			Scanner digitScan = new Scanner(currentLine);
			digitScan.skip(".*smallest");

			// Skip to the earnings salary
			digitScan.skip("\\D+");
			if (!digitScan.hasNextInt()) {
				fail("The program's output is non-conformant: smallest int not displayed as specified");
			} else {
				assertEquals("The program's output is non-conformant: the smallest int is incorrect", knownSmallest, digitScan.nextInt());
			}
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
