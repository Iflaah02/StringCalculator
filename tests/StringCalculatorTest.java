import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testAddforViableInput1_2() throws StringCalculatorException {
		
		//Arrange
		StringCalculator Calc = new StringCalculator();
		
		//Assert
		assertEquals("1 + 2 = 3", 3, Calc.add("1,2"));
		
	}
	
	@Test
	public void testAdd_shouldOnlyTake012() throws StringCalculatorException {
		//Arrange
		StringCalculator Calc = new StringCalculator();
		
		//Assert
		assertEquals("1 + 2 + 3 = 0", 0, Calc.add("1,2,3"));
		assertEquals("2 = 2", 2, Calc.add("2"));
		assertEquals("empty input = 0", 0, Calc.add(""));
		
	}
	
	@Test
	public void testAdd_shouldAcceptNewlines() throws StringCalculatorException {
		//Arrange
		StringCalculator Calc = new StringCalculator();
		
		//Assert
		assertEquals("1 + 2 = 3", 3, Calc.add("1\n2"));
		
	}
	@Test
	public void testAdd_shouldNotAcceptConsecutiveLimiters() throws StringCalculatorException {
		//Arrange
		StringCalculator Calc = new StringCalculator();
		assertEquals("1,\\n = 0", 0, Calc.add("1,\n"));
		//Assert
		
	}
	@Test (expected = Exception.class)
	public void testAdd_shouldNotAcceptNegativeNumbers() throws StringCalculatorException {
		//Arrange
		StringCalculator Calc = new StringCalculator();
				
		//Assert
		assertEquals("Should throw exception on -1", 0, Calc.add("-1"));
	}
	

}
