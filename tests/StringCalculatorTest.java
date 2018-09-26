import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test() {
		StringCalculator calc = new StringCalculator();
		
		calc.add("5,2");
		int sum = calc.returnSum();
		assertEquals("Sum 5+2", 7, sum);
	}
	
	@Test
	public void test_2() {
		StringCalculator calc = new StringCalculator();
		
		calc.add("-1,1");
		int sum = calc.returnSum();
		assertEquals("Sum -1+1", 0, sum);
	}	
	
	@Test
	public void test_3() {
		StringCalculator calc = new StringCalculator();
		
		calc.add("-1\n1");
		int sum = calc.returnSum();
		assertEquals("Sum -1+1", 0, sum);
	}
	
	@Test
	public void test_3_numbers() {
		StringCalculator calc = new StringCalculator();
		
		calc.add("1,2,3");
		int sum2 = calc.returnSum();
		assertEquals("Sum 1+2+3", 6, sum2);		
	}

	@Test
	public void test_3_numbers_2() {
		StringCalculator calc = new StringCalculator();
		
		calc.add("-1,0,5");
		int sum2 = calc.returnSum();
		assertEquals("Sum -1+0+5", 4, sum2);		
	}	
	
	
	@Test
	public void test_3_numbers_delimiters() {
		StringCalculator calc = new StringCalculator();
		
		String testWord = calc.replacer("5\n5");
		
		assertEquals("5\n5", "5,5", testWord);
		
	}	
	
	@Test
	public void test_3_numbers_different_delimiters() {
		StringCalculator calc = new StringCalculator();
		
		calc.add("1\n2,3");
		int sum2 = calc.returnSum();
		assertEquals("Sum 1+2+3", 6, sum2);		
	}	
	
	@Test
	public void test_3_numbers_different_delimiters_2() {
		StringCalculator calc = new StringCalculator();
		
		calc.add("1\n2\n3");
		int sum2 = calc.returnSum();
		assertEquals("Sum 1+2+3", 6, sum2);		
	}	
	
	@Test
	public void String_to_int() {
		StringCalculator calc = new StringCalculator();
		
		int parsed = calc.stringParser("5");
		assertEquals("String 5 to int 5", 5, parsed);		
	}	

	@Test
	public void String_to_int_2() {
		StringCalculator calc = new StringCalculator();
		
		int parsed = calc.stringParser("0");
		assertEquals("String 0 to int 0", 0, parsed);		
	}	
	
	@Test
	public void String_to_int_3() {
		StringCalculator calc = new StringCalculator();
		
		int parsed = calc.stringParser("-1");
		assertEquals("String -1 to int -1", -1, parsed);		
	}	
	
}
