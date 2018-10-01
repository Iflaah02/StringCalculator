import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testEmptyString() throws StringCalculatorException {
		assertEquals(0, StringCalculator.Add(""));
	}

	@Test
	public void testOneNumber() throws StringCalculatorException {
		assertEquals(1, StringCalculator.Add("1"));
	}

	@Test
	public void testTwoNumbers() throws StringCalculatorException {
		assertEquals(3, StringCalculator.Add("1,2"));
	}	

	@Test
    public void testMultipleNumbers() throws StringCalculatorException {
    	assertEquals(10, StringCalculator.Add("1,2,7"));
    }
	
	@Test
    public void testMultipleNumberswithn() throws StringCalculatorException {
    	assertEquals(6, StringCalculator.Add("1\n2,3"));
    }

	@Test (expected = StringCalculatorException.class)
    public void testNegNumber() throws StringCalculatorException {
    	assertEquals(6, StringCalculator.Add("-1,2,3"));
    }
	
	@Test (expected = StringCalculatorException.class)
    public void testinvalidinput() throws StringCalculatorException {
    	assertEquals(6, StringCalculator.Add("1,ss,tt"));
    }
	
	@Test (expected = StringCalculatorException.class)
    public void testinvalidinput2() throws StringCalculatorException {
    	assertEquals(6, StringCalculator.Add("1,,\n"));
    }
}
