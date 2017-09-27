import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test_length_0() throws StringCalculatorException {
		//Arrange
		String numbersStr = "";
		StringCalculator calc = new StringCalculator();
				//Act
		int score = calc.add(numbersStr) ;
				// Assert
				assertEquals(0, score);	
	}

	
	@Test
	public void test_split() {
		//Arrange
		String numbersStr = "0,1,2";
		StringCalculator calc = new StringCalculator();
				//Act
		String[] score = calc.split(numbersStr);
				// Assert
				assertEquals("0", score[0]);
				assertEquals("1", score[1]);
				assertEquals("2", score[2]);
				
	}

	@Test
	public void test_calculate() {
		
		String[] s1 = {"2","4","3"};
		
		StringCalculator calc = new StringCalculator();
		int score = calc.calculate(3,s1);
		
		assertEquals(9,score);
				
	}
	
	@Test
	public void test_length() {
		
		StringCalculator calc = new StringCalculator();
		
		String[] s_empty = {""};
		String[] s_1 = {"4"};
		String[] s_2 = {"4","1"};
		String[] s_3 = {"4","2","7"};
		int score = calc.check_length(s_empty);
		assertEquals("not empty",0,score);
		
		score = calc.check_length(s_1);
		assertEquals(1,score);
		score = calc.check_length(s_2);
		assertEquals(2,score);
		score = calc.check_length(s_3);
		assertEquals(3,score);
				
	}
	
	@Test(expected = StringCalculatorException.class)
	public void test_check_int() throws StringCalculatorException {
		
		StringCalculator calc = new StringCalculator();
		
		String[] s_fail = {"1","s"};
		String[] s_ok = {"4"};

		boolean score = calc.check_int(s_fail);

		
		score = calc.check_int(s_ok);
		assertEquals(true,score);

				
	}
	
	@Test(expected = StringCalculatorException.class)
	public void test_positive() throws StringCalculatorException {
		
		StringCalculator calc = new StringCalculator();
		
		String[] s_fail = {"1","-1"};
		String[] s_ok = {"4"};

		boolean score = calc.check_if_positive(s_fail);
		
		score = calc.check_if_positive(s_ok);
		assertEquals(true,score);

				
	}

	@Test(expected = StringCalculatorException.class)
	public void test_all_together() throws StringCalculatorException {
		
		StringCalculator calc = new StringCalculator();
		
		int score = calc.add("2,3,4");
		
		assertEquals(9,score);
		
		score = calc.add("1,2,s");
		
		score=calc.add("1,1,1,100");
		assertEquals(3,score);
		
	}	
	
	
}
