import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test() {
		
	}
	
	@Test
	public void number_processing_test() throws StringCalculatorException{
		
		StringCalculator calculator = new StringCalculator();
		
		int[] result = calculator.processNumber("1/n2,3");
		int[] finalresult = new int[] {1,2,3};
		assertArrayEquals("number processing from string to array of int", finalresult, result);
	}
	
	@Test 
	public void sum_calculation_test() throws StringCalculatorException{
		StringCalculator calculator = new StringCalculator();
		int[] result = calculator.processNumber("1/n2,3");
		int total = calculator.calculateSum(result);
		
		assertEquals("Calculation", 6, total);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void check_amount_of_number() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("1,1,2,3,4,5,3,4,2,2,2,2,2,2,2,2,2,2,1/n2,3");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void check_string_for_minus_number_condition() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("-1/n2,3");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void check_string_for_special_condition() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("-1/n,");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void check_string_for_letter_condition() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("-1/n2,A");
	}
	
}
