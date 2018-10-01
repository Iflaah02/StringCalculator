import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	
	//Test countToken method
	//-------------------------------------------------------------------
	
	@Test
	public void countToken_0Number() {
		StringCalculator sc = new StringCalculator();
		assertEquals(0, sc.countTokens(""));
	}
	
	@Test
	public void countToken_1Number() {
		StringCalculator sc = new StringCalculator();
		assertEquals(1, sc.countTokens("2,"));
	}
	
	@Test
	public void countToken_2Number() {
		StringCalculator sc = new StringCalculator();
		assertEquals(2, sc.countTokens("2, 3"));
	}
	
	@Test
	public void countToken_3Number() {
		StringCalculator sc = new StringCalculator();
		assertEquals(3, sc.countTokens("2, 3, 4"));
	}
	
	//Test getToken method
	//-------------------------------------------------------------------
	
	@Test
	public void getToken_1Number() {
		StringCalculator sc = new StringCalculator();
		String st[] = new String[1];
		st = sc.getToken("2,");
		assertEquals("2", st[0]);
	}
	
	@Test
	public void getToken_2Number() {
		StringCalculator sc = new StringCalculator();
		String st[] = new String[2];
		st = sc.getToken("2,3");
		assertEquals("3", st[1]);
	}
	
	//Test getNumber method
	//-------------------------------------------------------------------

	@Test
	public void getNumber_1() throws StringCalculatorException {
		StringCalculator sc = new StringCalculator();
		assertEquals(1, sc.getNumber("1"));
	}
	
	//Test getNumber method
	//-------------------------------------------------------------------

	@Test
	public void sum_1_2() {
		StringCalculator sc = new StringCalculator();
		assertEquals(3, sc.sum(1, 2));
	}
	
	//Test add method
	//-------------------------------------------------------------------

	@Test
	public void add_None() throws StringCalculatorException {
		StringCalculator sc = new StringCalculator();
		assertEquals(0, sc.add(""));
	}
	
	@Test
	public void add_1() throws StringCalculatorException {
		StringCalculator sc = new StringCalculator();
		assertEquals(3, sc.add("3"));
	}
	
	@Test
	public void add_1_2() throws StringCalculatorException {
		StringCalculator sc = new StringCalculator();
		assertEquals(3, sc.add("1,2"));
	}
	
	//Test addMoreThanTwoNumbers method
	//-------------------------------------------------------------------
	
	@Test
	public void add_1_2_3_4() throws StringCalculatorException {
		StringCalculator sc = new StringCalculator();
		assertEquals(10, sc.addMoreThanTwoNumbers("1,2,3,4"));
	}
	
	@Test
	public void add_1_2_3_4_5_6_7_8() throws StringCalculatorException {
		StringCalculator sc = new StringCalculator();
		assertEquals(36, sc.addMoreThanTwoNumbers("1,2,3,4,5,6,7,8"));
	}
	
	//Test lineNum method
	//-------------------------------------------------------------------
		
	@Test
	public void countLine_1() {
		StringCalculator sc = new StringCalculator();
		assertEquals(1, sc.countLines("1,2,3,4"));
	}

	@Test
	public void countLine_2() {
		StringCalculator sc = new StringCalculator();
		assertEquals(2, sc.countLines("1,2\n3,4"));
	}
	
	@Test
	public void countLine_3() {
		StringCalculator sc = new StringCalculator();
		assertEquals(3, sc.countLines("1\n2\n3,4"));
	}
	
	//Test getLine method
	//-------------------------------------------------------------------
	
	@Test
	public void getLine_1() {
		StringCalculator sc = new StringCalculator();
		String[] line = sc.getLine("1,2\n3");
		assertEquals("1,2", line[0]);
	}
	
	@Test
	public void getLine_2() {
		StringCalculator sc = new StringCalculator();
		String[] line = sc.getLine("1,2\n3");
		assertEquals("3", line[1]);
	}
	
	@Test
	public void getLine_3() {
		StringCalculator sc = new StringCalculator();
		String[] line = sc.getLine("1,2\n3,4,5\n6,7,8");
		assertEquals("6,7,8", line[2]);
	}
	
	//Test addLine method
	//-------------------------------------------------------------------
	
	@Test
	public void addLine_2_lines() throws StringCalculatorException {
		StringCalculator sc = new StringCalculator();
		assertEquals(6, sc.addlines("1,2\n3"));
	}
	
	@Test
	public void addLine_3_lines() throws StringCalculatorException {
		StringCalculator sc = new StringCalculator();
		assertEquals(21, sc.addlines("1,2\n3,4\n5,6"));
	}
	
	//Test exceptions
	//-------------------------------------------------------------------
	
	@Test(expected = StringCalculatorException.class)
	public void add_exception_negative_input() throws StringCalculatorException {
		StringCalculator sc = new StringCalculator();
		sc.addlines("-1");
	}
	
}
