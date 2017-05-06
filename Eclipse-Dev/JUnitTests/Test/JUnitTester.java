import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)	// sorts test cases by name
public class JUnitTester {
	
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(JUnitTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
			
			// disables a test on Linux
			Assume.assumeFalse(System.getProperty("os.name").contains("Linux"));
		}
	}

	@Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
            JUnitTest tester = new JUnitTest(); // MyClass is tested

            // assert statements
            assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));
            assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
            assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
    }

}
