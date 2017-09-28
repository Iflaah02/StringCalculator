import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	int num1;
	
	
	
	

	@Test
	public void test() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();

		num1 = calculator.add("5");
		assertEquals(5, num1, 0);
		
		
	}
	@Test
	public void test_string_empty() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		num1 = calculator.add("");
		assertEquals(0,num1,0);
		
	}

}
