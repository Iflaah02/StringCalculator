import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	
	//Tests for countTokens method
	@Test
	public void countTokensPerLine_0_Numbers() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.countTokensPerLine("");
		assertEquals(0, test);		
	}
	
	@Test
	public void countTokensPerLine_1_Number() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.countTokensPerLine("1");
		assertEquals(1, test);	
	}
	
	@Test
	public void countTokensPerLine_2_Numbers_Space() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.countTokensPerLine("1,2");
		assertEquals(2, test);	
	}
	
	
	@Test
	public void countTokensPerLine_4_Numbers_Space() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.countTokensPerLine("1,2,3,4");
		assertEquals(4, test);	
	}
	
	//Tests for countLines
	@Test
	public void countLines_2_Lines() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.countLines("1\n2");
		assertEquals(2, test);
	}
	
	@Test
	public void countLines_EmptyString() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.countLines("");
		assertEquals(1, test);
	}
	
	@Test
	public void countLines_1_Line() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.countLines("2");
		assertEquals(1, test);
	}
	
	//Tests for checkDigit method
	@Test
	public void checkDigit_1() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.checkDigit("1", 1);
		assertEquals(1, test);
	}
	
	@Test
	public void checkDigit_a() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.checkDigit("a", 1);
		assertEquals(0, test);
	}
	
	@Test
	public void checkDigit_1SPACE2() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.checkDigit("1,2", 2);
		assertEquals(1, test);
	}
	
	
	@Test
	public void checkDigit_1SPACEa() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.checkDigit("1,a", 2);
		assertEquals(0, test);
	}
	
	@Test
	public void checkDigit_aSPACE1() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.checkDigit("a,1", 2);
		assertEquals(0, test);
	}
	
	@Test
	public void checkDigit_aSPACEa() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.checkDigit("a,a", 2);
		assertEquals(0, test);
	}
	
	//Test for sumTwoNumbers method
	@Test
	public void sumTwoNumbers_1_2() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.sumTwoNumbers("1,2");
		assertEquals(3, test);
	}
	
	//Test for sumUnknownNumbers method
	@Test
	public void sumUnknownNumbers_1_2_3() {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.sumUnknownNumbers("1,2,3");
		assertEquals(6, test);
	}
	
	//Test for add method
	@Test
	public void add_1() throws StringCalculatorException {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.add("1");
		assertEquals(1, test);
	}
	
	@Test
	public void add_1_1() throws StringCalculatorException {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.add("1,1");
		assertEquals(2, test);
	}
	
	@Test
	public void add_2_2_2() throws StringCalculatorException {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.add("2,2,2");
		assertEquals(6, test);
	}
	
	@Test
	public void add_2_2_HEAD_2_2() throws StringCalculatorException {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.add("2,2\n2,2");
		assertEquals(8, test);
	}

	@Test
	public void add_2_2_4_HEAD_2_1() throws StringCalculatorException {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.add("2,2,4\n2,1");
		assertEquals(11, test);
	}
	
	@Test
	public void add_2_2_4_HEAD_2_1_HEAD_1() throws StringCalculatorException {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.add("2,2,4\n2,1\n1");
		assertEquals(12, test);
	}
	
	@Test
	public void add_1_HEAD_2_3() throws StringCalculatorException {
		StringCalculator sc1 = new StringCalculator();
		int test = sc1.add("1\n2,3");
		assertEquals(6, test);
	}
	
	@Test
	public void add_NEGATIVE_NUMBER() throws StringCalculatorException {
		try {
			StringCalculator sc1 = new StringCalculator();
			sc1.add("-1,2,3");
		}catch(StringCalculatorException e) {
			assert(e.PrintError() == 0);
		}
	}
	
	@Test
	public void add_Failure() throws StringCalculatorException {
		try {
			StringCalculator sc1 = new StringCalculator();
			sc1.add("1,\n");
		}catch(StringCalculatorException e) {
			assert(e.PrintError() == 0);
		}
	}
}
