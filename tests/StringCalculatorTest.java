import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StringCalculatorTest {
	private StringCalculator calculator;

	@Before
	public void init() {
		calculator = new StringCalculator();
	}

	@Test
	public void testSumTwoNumbers() {
		// test1: let's test the sum of 2 numbers. (low-hanging fruit!)
		int result = calculator.sum(1, 2);
		assertEquals(3, result);
	}

	@Test
	public void testSumAnyQuantityOfNumbers() {
		// test1: let's test the sum of 4 numbers. (the next low-hanging fruit)
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);

		int result = calculator.sum(numbers);
		assertEquals(10, result);
	}

	// I really like to test bad cases first! So:
	// test 3: get numbers list for empty string
	@Test
	public void testGetNumbersWithEmptyString() throws StringCalculatorException {
		ArrayList<Integer> numberList = calculator.getNumbers("");
		assertNotNull(numberList);
		assertEquals(1, numberList.size());
		int number = numberList.get(0);
		assertEquals(0, number);
	}

	// test 4: bad structure of string. case 1: "1\n,5"
	@Test(expected = StringCalculatorException.class)
	public void testGetNumbersWithInvalidStringPattern() throws StringCalculatorException {
		ArrayList<Integer> numberList = calculator.getNumbers("1\n,5");
	}

	// test 5: negative number in the string
	@Test(expected = StringCalculatorException.class)
	public void testGetNumbersWithNegativeNumberInString() throws StringCalculatorException {
		ArrayList<Integer> numberList = calculator.getNumbers("1\n-150");
	}

	// test 6: letters or special characters instead or number
	@Test(expected = StringCalculatorException.class)
	public void testGetNumbersInvalidNumber() throws StringCalculatorException {
		ArrayList<Integer> numberList = calculator.getNumbers("3mh%#&");
	}

	// test 7: success!
	@Test
	public void testGetNumbersSuccess() throws StringCalculatorException {
		ArrayList<Integer> numberList = calculator.getNumbers("1,2\n3,4,5\n6");
	}

	// test 8: testing the final method!
	@Test
	public void testAdd() throws StringCalculatorException{
		int result = calculator.add("10,2\n3,4,5\n6");
		assertEquals(30, result);
	}
}
