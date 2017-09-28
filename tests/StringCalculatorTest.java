import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	StringCalculator stringCalculator;
	@Before
	public void setUp() {
		stringCalculator = new StringCalculator();
	}
	
	//Unit tests for the first slice
	@Test
	public void test_setInput() {
		String defaultValue = stringCalculator.getInput();
		String input = "Hello 2 the world!";
		stringCalculator.setInput(input);
		assertNotEquals("The private property stringInput is set", defaultValue, stringCalculator.getInput());
	}
	@Test
	public void test_getInput() {
		String input = "Hello";
		stringCalculator.setInput(input);
		assertEquals("The value of stringInput is Hello", input, stringCalculator.getInput() );	
	}
	//Unit tests for the second slice
	@Test
	public void test_extractandStoreIntegers_09() {
		String input = "0,9";
		ArrayList<Integer> expectedArrayList = new ArrayList<Integer>();
		expectedArrayList.add(0);
		expectedArrayList.add(9);
		stringCalculator.extractandStoreIntegers(input);
		assertEquals("the lists are not the same", expectedArrayList, stringCalculator.getIntegersArrayList());
	}
	@Test
	public void test_extractandStoreIntegers_0123456789() {
		String input = "0,1,abc,2,3,eee,4,5,6,7,8,9,abc";
		ArrayList<Integer> expectedArrayList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			expectedArrayList.add(i);
		}
		stringCalculator.extractandStoreIntegers(input);
		assertEquals("the lists are not the same", expectedArrayList, stringCalculator.getIntegersArrayList());
	}
	//Unit tests for the third slice
	@Test
	public void test_add_0_1_9() {
		String input = "0abcd,19";
		int expectedSum = 0 + 1 + 9;
		int actualSum = stringCalculator.add(input);
		assertEquals("equals 10", expectedSum, actualSum);
		
	}
	@Test
	public void test_add_no_integer() {
		String input = "abc";
		assertEquals("the sum is 0 when there is no integer", 0, stringCalculator.add(input));
	}
	@Test
	public void test_add_empty_string() {
		String input ="";
		assertEquals("the sum is 0 when the input is empty", 0, stringCalculator.add(input));
	}
}
