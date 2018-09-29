import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testReturn_Sum_1_2() throws StringCalculatorException {
		//Arrange
		StringCalculator cal = new StringCalculator();
		//Act
		int sum = cal.add("1,2");
		assertEquals(3, sum);
		
	}
	
	@Test
	public void testReturn_Sum_0() throws StringCalculatorException {
		//Arrange
		StringCalculator cal = new StringCalculator();
		//Act
		int sum = cal.add("0");
		assertEquals(0, sum);		
	}
	
	@Test
	public void testReturn_Sum_1_2_3() throws StringCalculatorException {
		//Arrange
		StringCalculator cal = new StringCalculator();
		//Act
		int sum = cal.add("1,2,3");
		assertEquals(6, sum);
		
	}
	
	@Test
	public void testHandle_NewLine_1_2() throws StringCalculatorException{
		//Arrange
		StringCalculator cal = new StringCalculator();
		//Act
		String str = cal.handleNewLines("1\n2");
		assertEquals("1,2", str);
	}
	
	@Test
	public void testHandle_NewLine_1_2_3() throws StringCalculatorException{
		//Arrange
		StringCalculator cal = new StringCalculator();
		//Act
		String str = cal.handleNewLines("1,2\n3");
		assertEquals("1,2,3", str);
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testInvalidNegtive_Invalid1() throws StringCalculatorException{
		//Arrange
		StringCalculator cal = new StringCalculator();
		//Act
		int[] numbers = cal.invalidNegtive("1,2\n");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testInvalidNegtive_Negtive() throws StringCalculatorException{
		//Arrange
		StringCalculator cal = new StringCalculator();
		//Act
		int[] numbers = cal.invalidNegtive("-1");	
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testInvalidNegtive_Invalid() throws StringCalculatorException{
		//Arrange
		StringCalculator cal = new StringCalculator();
		//Act
		int[] numbers = cal.invalidNegtive("abc");
	}
	

	@Test(expected = StringCalculatorException.class)
	public void testInvalidNegtive_1_2_a() throws StringCalculatorException{
		//Arrange
		StringCalculator cal = new StringCalculator();
		//Act
		int[] sum = cal.invalidNegtive("1,2,a");
	}
	

	@Test(expected = StringCalculatorException.class)
	public void testInvalidNegtive_1_2_valid() throws StringCalculatorException{
		//Arrange
		StringCalculator cal = new StringCalculator();
		//Act
		int[] sum = cal.invalidNegtive("1,2,#");
	}
	

	@Test(expected = StringCalculatorException.class)
	public void testInvalidNegtive_1_invalid() throws StringCalculatorException{
		//Arrange
		StringCalculator cal = new StringCalculator();
		//Act
		int[] sum = cal.invalidNegtive("1,\n");
	}

}
