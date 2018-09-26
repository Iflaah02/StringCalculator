import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	
	@Test
	public void test_getCountNumStrs() {
		
		StringCalculator sc = new StringCalculator();
		String[] array = {"23", "2", "", "3"};
		int countNums = sc.getCountNumStrs(array);
		
		assertEquals(3, countNums);
	}
	
	@Test
	public void test_removeEmptyString() {
	
		StringCalculator sc = new StringCalculator();
		String[] array = {"23", "2", "", "3"};
		String[] returnedArray = sc.removeEmptyString(array);
		
		
		String[] expectedArray = {"23", "2", "3"};
		assertArrayEquals(returnedArray, expectedArray);
	}
	
	@Test
	public void test_converToNumArray() {
		
		StringCalculator sc = new StringCalculator();
		
		String[] returnedArray = sc.converToNumArray("1,255\n , ,3");
		
		String[] expectedArray = {"1", "255",  "3"};
		
		assertArrayEquals(returnedArray, expectedArray);
	}
	
	
	@Test 
	public void test_add() {
		
		StringCalculator sc = new StringCalculator();
		
		int sumOfString = sc.add("1,255\n , ,3");
		int expected = 259;
		assertEquals(expected, sumOfString);
		
	}
	
	@Test 
	public void test_addWithEmptyStr() {
		
		StringCalculator sc = new StringCalculator();
		
		int sumOfString = sc.add("1,255\n , , ,3, 41");
		int expected = 300;
		assertEquals(expected, sumOfString);
		
	}

}
