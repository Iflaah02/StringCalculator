import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void test_isEmpty()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		boolean result = cal.isEmpty("");
		
		//Assert
		assertTrue(result);
	}

	@Test
	public void test_CheckIfIsNotEmpty()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		boolean result = cal.isEmpty("1");
		
		//Assert
		assertFalse(result);
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
	public void test_GetNumberFromString()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		String[] tokens = cal.parseString("1,2");
		int[] nums = cal.getNumbersFromString(tokens);
		
		//Assert
		assertEquals("num1 should be integer 1", 1, nums[0]);
		assertEquals("num2 should be integer 2", 2, nums[1]);
	}
	
	@Test
	public void test_GetNumbers()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		//cal.getNumbers();
		
		//Assert

	}
	
	@Test
	public void test_add()
	{
		//Arrange
		StringCalculator cal = new StringCalculator();
		
		//Act
		int sum = cal.add("3,6");
		
		//Assert
		assertEquals(9, sum);
	}
	
}
