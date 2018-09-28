import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void TestOne() throws StringCalculatorException{
		StringCalculator SCal = new StringCalculator();
		assertEquals(3,SCal.add("1,2"));
	}
	
	@Test
	public void TestThree() throws StringCalculatorException{
		StringCalculator SCal = new StringCalculator();
		assertEquals(23,SCal.add("1,22"));
	}
	
	@Test
	public void TestFour() throws StringCalculatorException{
		StringCalculator SCal = new StringCalculator();
		assertEquals(24,SCal.add("1,22/n1"));
	}
	
	@Test (expected = StringCalculatorException.class)
	public void TestSeparators() throws StringCalculatorException{
		StringCalculator SCal = new StringCalculator();
		SCal.add("1,22,/n1");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void TessNegative() throws StringCalculatorException{
		StringCalculator SCal = new StringCalculator();
		SCal.add("1,-2,3,4");
	}


}
