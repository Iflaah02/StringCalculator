import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void split4InputsTo4() {
		// Test for round 1: splitInputs
		StringCalculator calc = new StringCalculator();
		String input = "1,2,3,4";
		String returns[] = calc.splitInputs(input);
		assertEquals(returns.length, 4);
	}
	
	@Test
	public void addNumbers2and2equals4() {
		// Test for round 2: addNumbers
		StringCalculator calc = new StringCalculator();
		String inputs[] = {"2", "2"};
		int sum = calc.addNumbers(inputs);
		assertEquals(sum, 4);
	}

	@Test
	public void addNumbers1and2and3and4equals10() {
		// Test for round 2: addNumbers
		StringCalculator calc = new StringCalculator();
		String inputs[] = {"1", "2", "3", "4"};
		int sum = calc.addNumbers(inputs);
		assertEquals(sum, 10);
	}
	
	@Test
	public void split1enter2enter3splitToThree() {
		// Test for round 3: splitInputs
		StringCalculator calc = new StringCalculator();
		String input = "1\n2\n3";
		String returns[] = calc.splitInputs(input);
		assertEquals(returns.length, 3);
	}
	
	@Test
	public void split1comma2enter3splitToThree() {
		// Test for round 3: splitInputs
		StringCalculator calc = new StringCalculator();
		String input = "1,2\n3";
		String returns[] = calc.splitInputs(input);
		assertEquals(returns.length, 3);
	}
	
	@Test
	public void splitToCorrectOutputs() {
		// Test for round 3: splitInputs
		StringCalculator calc = new StringCalculator();
		String input = "1\n2\n3,4,5\n6";
		String returns[] = calc.splitInputs(input);
		String shouldBe[] = {"1", "2", "3", "4", "5", "6"};
		for (int i=0; i < returns.length; i++) {
			assertEquals(returns[0], shouldBe[0]);
		}
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidCommaNewLine() throws StringCalculatorException {
		// Test for round 4: erroneous newline + comma combinations
		StringCalculator calc = new StringCalculator();
		String input = "1,\n2";
		calc.checkInput(input);
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidNewLineComma() throws StringCalculatorException {
		// Test for round 4: erroneous newline + comma combinations
		StringCalculator calc = new StringCalculator();
		String input = "1\n,2";
		calc.checkInput(input);
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidEndsWithNewLine() throws StringCalculatorException {
		// Test for round 4: erroneous newline + comma combinations
		StringCalculator calc = new StringCalculator();
		String input = "1\n";
		calc.checkInput(input);
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidEndsWithComma() throws StringCalculatorException {
		// Test for round 4: erroneous newline + comma combinations
		StringCalculator calc = new StringCalculator();
		String input = "1,";
		calc.checkInput(input);
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidNegativeNumber() throws StringCalculatorException {
		// Test for round 5: other erroneous inputs
		StringCalculator calc = new StringCalculator();
		String input = "-1";
		calc.checkNumber(input);
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidNotNumber() throws StringCalculatorException {
		// Test for round 5: other erroneous inputs
		StringCalculator calc = new StringCalculator();
		String input = "aaa";
		calc.checkNumber(input);
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidBlank() throws StringCalculatorException {
		// Test for round 5: other erroneous inputs
		StringCalculator calc = new StringCalculator();
		String input = "";
		calc.checkNumber(input);
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalid2NewLinesInMiddle() throws StringCalculatorException {
		// Test for round 4: erroneous newline + comma combinations
		StringCalculator calc = new StringCalculator();
		String input = "2\n\n2";
		calc.checkInput(input);
		fail("exception should have been thrown in the line above");
	}
	@Test(expected=StringCalculatorException.class)
	public void invalid2CommasInMiddle() throws StringCalculatorException {
		// Test for round 4: erroneous newline + comma combinations
		StringCalculator calc = new StringCalculator();
		String input = "2,,2";
		calc.checkInput(input);
		fail("exception should have been thrown in the line above");
	}
	
	//Round 6: tests for "add" method that combines the other sub-methods
	
	@Test(expected=StringCalculatorException.class)
	public void invalid2CommasInMiddleListToAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("1,1,2,,2");
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalid2NewLinesInMiddleListToAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("1,1,2\n\n2");
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidEndCommaListToAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("1,2,2,");
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidEndNewLineListToAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("1,2,3\n");
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidNonNumberListToAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("aaa,ggg,2,2");
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidNegativeNumberListToAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("1,5,-2,2,2");
		fail("exception should have been thrown in the line above");
	}
	
	@Test(expected=StringCalculatorException.class)
	public void invalidBlankToAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("");
		fail("exception should have been thrown in the line above");
	}
	
	@Test
	public void _3times3is9WithCommasToAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int ans = calc.add("3,3,3");
		assertEquals(ans, 9);
	}
	
	@Test
	public void _3times3is9WithNewLinesToAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int ans = calc.add("3\n3\n3");
		assertEquals(ans, 9);
	}
	
	@Test
	public void LongListWithMixedSeparatorsToAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int ans = calc.add("1,2\n3,4\n5\n6,7\n10");
		assertEquals(ans, 38);
	}
}
