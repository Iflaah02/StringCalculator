import static org.junit.Assert.*;

import org.junit.Test;

//import StringCalculator;

public class StringCalculatorTest {
	
	@Test
	public void isNumberTest_inValid() {
		StringCalculator calc = new StringCalculator();
		char c = ',';
		assertFalse(calc.isNumber(c));
	}
	
	@Test
	public void isNumberTest_Valid() {
		StringCalculator calc = new StringCalculator();
		char c = '9';
		assertTrue(calc.isNumber(c));
	}
	
	@Test
	public void explode_onlyCommasTest_commasAsSeparator() {
		StringCalculator calc = new StringCalculator();
		String str = "1,2,3";
		String[] arrayOfString = {"1","2","3"};
		
		assertArrayEquals(arrayOfString, calc.explode_onlyCommas(str));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void explode_onlyCommasTest_wrongSeparator() {
		StringCalculator calc = new StringCalculator();
		String str = "1,2)3";
		calc.explode_onlyCommas(str);
	}
	
	@Test
	public void explode_anySeparatorTest_DifferentSeparator() {
		StringCalculator calc = new StringCalculator();
		String str = "1/2,3n6";
		String[] arrayOfString = {"1","2","3","6"};
		
		assertArrayEquals(arrayOfString, calc.explode_anySeparator(str));
	}
	
	@Test
	public void explode_newLineOrCommasTest_empty() {
		StringCalculator calc = new StringCalculator();
		String str = "";
		String[] arrayOfString = {};
		
		assertArrayEquals(arrayOfString, calc.explode_newLineOrCommas(str));
	}
	
	@Test
	public void explode_newLineOrCommasTest_valid() {
		StringCalculator calc = new StringCalculator();
		String str = "5,8\n8";
		String[] arrayOfString = {"5","8","8"};
		
		assertArrayEquals(arrayOfString, calc.explode_newLineOrCommas(str));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void explode_newLineOrCommasTest_twoConsecutiveNonNumeric() {
		StringCalculator calc = new StringCalculator();
		String str = "5,6,N5";
		calc.explode_newLineOrCommas(str);
	}
	
	@Test
	public void explode_anySeparatorTest_numberHigherThan9() {
		StringCalculator calc = new StringCalculator();
		String str = "5,6,10,5,95";
		String[] arrayOfString = {"5","6","10","5","95"};
		
		assertArrayEquals(arrayOfString, calc.explode_anySeparator(str));
	}
	
	@Test
	public void convertStringArrayToIntArrayTest() {
		StringCalculator calc = new StringCalculator();
		String[] arrayOfString = {"1","2","3"};
		int[] arrayOfInt = {1,2,3};
		
		assertArrayEquals(arrayOfInt, calc.convertStringArrayToIntArray(arrayOfString));
	}
	
	@Test
	public void arrayAddTest() {
		StringCalculator calc = new StringCalculator();
		int[] arrayOfInt = {1,2,3};
		int res = 6;
		
		assertEquals(res, calc.arrayAdd(arrayOfInt));
	}

	@Test
	public void addTest_3numbers() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		String str = "1,5,9";
		int res = 15;
		
		assertEquals(res, calc.add(str));
	}
	
	@Test
	public void addTest_5numbers() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		String str = "1,5,9,0,11";
		int res = 26;
		
		assertEquals(res, calc.add(str));
	}
	
	@Test
	public void addTest_emptyString() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		String str = "";
		int res = 0;
		
		assertEquals(res, calc.add(str));
	}
	
	@Test (expected = StringCalculatorException.class)
	public void addTest_negativeNumber() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		String str = "5,6,7\n5,-3";
		calc.add(str);
	}
}
