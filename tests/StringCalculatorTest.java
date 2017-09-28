import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test_emptystring() throws StringCalculatorException{
		
		//empty strings should return 0
		 StringCalculator outcome = new StringCalculator();

		 int  result= outcome.countnumbers("");

		 assertEquals("Should be an empty string",0, result); 
		
		//test 1 number
		//test 2 numbers¨
		//test3 numbers
		//test more than 3 numbers
		//test empty string
		//test negative numbers or letters
		//test newlines between numbers
		//test lines and commas back to back
		
	}
	@Test
	public void test_with_one_number() throws StringCalculatorException{
		
		//empty strings should return 0
		 StringCalculator outcome = new StringCalculator();

		 int  result= outcome.countnumbers("5");

		 assertEquals("Doesn't add up",5, result); 
	}
	@Test
	public void test_with_multiple_numbers() throws StringCalculatorException{
		
		
		 StringCalculator outcome = new StringCalculator();

		 int  result= outcome.countnumbers("1,2,3,4,5,6,7,8,9");

		 assertEquals("Doesn't add up",45, result); 
	}
	@Test (expected = StringCalculatorException.class)
	public void test_negativevalues() throws StringCalculatorException {
		
		
		 StringCalculator outcome = new StringCalculator();

		 outcome.countnumbers("1,3,-1");

		
	}
	@Test (expected = StringCalculatorException.class)
	public void test_invalid_inputs() throws StringCalculatorException {
		
		
		 StringCalculator outcome = new StringCalculator();

		 outcome.countnumbers("1,0,6,b");

		
	}
	@Test (expected = StringCalculatorException.class)
	public void test_comma_and_newline_backtoback_inputs() throws StringCalculatorException {
		
		
		 StringCalculator outcome = new StringCalculator();

		 outcome.countnumbers("\n,45");

		
	}

}
