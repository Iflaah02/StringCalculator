import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void test_hasOneNumber()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		
		
		//Assert
		assertTrue(cal.hasOneNumber("355"));
	}
	
	@Test
	public void test_hasNotOneNumber()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		
		
		//Assert
		assertFalse(cal.hasOneNumber("3,5"));
	}

	@Test
	public void test_hasTwoNumbers()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		
		
		//Assert
		assertTrue(cal.hasTwoNumbers("10,20"));
	}

	@Test
	public void test_hasMoreThanTwoNumbers()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		
		
		//Assert
		assertFalse(cal.hasTwoNumbers("10,20,30"));
	}

	
	@Test
	public void test_hasValidInputs()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
				
		//Act
		
				
		//Assert
		assertTrue(cal.hasValidInputs("55,18"));
	}

	@Test
	public void test_isDigit()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		
		//Assert
		assertTrue(cal.isDigit('5'));
	}

	@Test
	public void test_isNotDigit()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		
		//Assert
		assertFalse(cal.isDigit(';'));
		assertFalse(cal.isDigit('@'));
	}
	
	@Test
	public void test_isInCorrectOrder()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		
		//Assert
		assertTrue(cal.isInCorrectOrder("360,420"));
	}
	
	@Test
	public void test_isNotInCorrectOrder()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		
		//Assert
		assertFalse(cal.isInCorrectOrder("134,"));
		assertFalse(cal.isInCorrectOrder(",15"));
	}
	
	@Test
	public void test_ParseString()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		String[] tokens = cal.parseString("1,2");
		
		//Assert
		assertEquals("should create 1 by splitting the input string by ,", "1", tokens[0]);
		assertEquals("should create 2 by splitting the input string by ,", "2", tokens[1]);
	}
	
	@Test
	public void test_convertStringToInteger()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		String[] tokens = cal.parseString("1,2");
		int[] nums = cal.convertStringToInteger(tokens);
		
		//Assert
		assertEquals("num1 should be integer 1", 1, nums[0]);
		assertEquals("num2 should be integer 2", 2, nums[1]);
	}
	
	@Test //(expected = StringCalculatorException.class)
	public void test_detectNumbers() throws StringCalculatorException
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		cal.detectNumbers("1,3");
		
		//Assert
		assertEquals(1,cal.num1);
		assertEquals(3,cal.num2);
	}
	
	@Test
	public void test_negativeNumbers() throws StringCalculatorException
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		int sum = cal.add("-5,6");
		
		//Assert
		assertEquals(1, sum);
	}
	
	@Test
	public void test_add() throws StringCalculatorException
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		int sum = cal.add("60,40");
		
		//Assert
		assertEquals(100, sum);
	}
	
}
