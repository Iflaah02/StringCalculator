import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void test_toIntArray() throws StringCalculatorException{
		String text = "1,2";
		StringCalculator calc = new StringCalculator();
		int numbers[] = calc.toIntArray(text);
		int testArray[] = {1, 2};
		assertArrayEquals(numbers, testArray);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_toIntArray_WithNegativeNumber() throws StringCalculatorException{
		String text = "-1,2";
		StringCalculator calc = new StringCalculator();
		int numbers[] = calc.toIntArray(text); //Throws an exception
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_toIntArray_TooManyNumbers() throws StringCalculatorException{
		String text = "1,2,3";
		StringCalculator calc = new StringCalculator();
		int numbers[] = calc.toIntArray(text); //Throws and exception
	}

	@Test
	public void test_parseString_WithSingleNumber() throws StringCalculatorException {
		String text = "1";
		StringCalculator calc = new StringCalculator();
		int num[] = calc.parseString(text);
		int testNum[] = {1};
		assertArrayEquals(testNum, num);
		text = "0";
		num = calc.parseString(text);
		int testNum2[] = {0};
		assertArrayEquals(testNum2, num);
		text = "12,";
		num = calc.parseString(text);
		int testNum3[] = {12};
		assertArrayEquals(testNum3, num);
	}
	
	@Test
	public void test_parseString_Empty() throws StringCalculatorException {
		String text = "";
		StringCalculator calc = new StringCalculator();
		int num[] = calc.parseString(text);
		int testNum[] = {0};
		assertArrayEquals(testNum, num);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_parseString_Alphabetical() throws StringCalculatorException{
		String text = "a";
		StringCalculator calc = new StringCalculator();
		int num[] = calc.parseString(text); //This throws an exception
	}
	
	@Test
	public void test_handleRowChange() throws StringCalculatorException{
		String text = "1\n3";
		StringCalculator calc = new StringCalculator();
		String tst[] = calc.handleRowChange(text);
		String[] result = new String[] {"1","3"};
		assertArrayEquals(tst, result);
		text = "1\n2,3";
		tst = calc.handleRowChange(text);
		String[] result2 = new String[] {"1","2,3"};
		assertArrayEquals(tst, result2);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_handleRowChange_exceptionComma() throws StringCalculatorException{
		String text = "1\n2,3,";
		StringCalculator calc = new StringCalculator();
		String tst[] = calc.handleRowChange(text); //This throws an exception
	}
	
	@Test
	public void test_add() throws StringCalculatorException{
		String text = "1,2\n3,4";
		StringCalculator calc = new StringCalculator();
		int result = calc.add(text);
		assertEquals(10, result);
		text = "22,456\n33,445\n1";
		result = calc.add(text);
		assertEquals(957, result);
	}
	
	@Test
	public void test_add_withSingleNumber() throws StringCalculatorException{
		String text = "22";
		StringCalculator calc = new StringCalculator();
		int result = calc.add(text);
		assertEquals(22, result);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_add_Exception_incorrectInputNegativeNumber() throws StringCalculatorException{
		String text = "2,3\n-1,3";
		StringCalculator calc = new StringCalculator();
		int result = calc.add(text); //Throws an exception
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_add_exception_incorrectInputWithLinebreak() throws StringCalculatorException{
		String text = "2,3,\n3,4";
		StringCalculator calc = new StringCalculator();
		int result = calc.add(text); //Throws an exception
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_add_exception_incorrectInputAlphabetical() throws StringCalculatorException{
		String text = "2,3\n34,56\n3,a";
		StringCalculator calc = new StringCalculator();
		int result = calc.add(text); //Throws an exception
	}
	
	

}
