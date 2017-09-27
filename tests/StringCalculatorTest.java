import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void Add_empty_numberStr_return_0() throws StringCalculatorException {
		// Arrange
		StringCalculator calc = new StringCalculator();
		// Act
		int result = calc.add("");
		// Assert
		assertEquals(result, 0);
	}

	// tests for parseString() method	
	@Test
	public void ParseString_string_1_results_1() throws StringCalculatorException {
		// expected result
		List<Integer> resultList = new ArrayList<>();
		resultList.add(1);
		// Arrange
		StringCalculator calc = new StringCalculator();
		// Act
		int result = calc.add("1");
		// Assert
		assertEquals(result, 1);
	}
	
	@Test
	public void ParseString_string_1_c_1_results_1_1() throws StringCalculatorException {
		// expected result
		List<Integer> resultList = new ArrayList<>();
		resultList.add(1);
		resultList.add(1);
		// Arrange
		StringCalculator calc = new StringCalculator();
		// Act
		List<Integer> result = calc.parseString("1,1");
		// Assert
		assertEquals(resultList, result);
	}
	@Test
	public void ParseString_string_1_nl_1_results_1_1() throws StringCalculatorException {
		// expected result
		List<Integer> resultList = new ArrayList<>();
		resultList.add(1);
		resultList.add(1);
		// Arrange
		StringCalculator calc = new StringCalculator();
		// Act
		List<Integer> result = calc.parseString("1\n1");
		// Assert
		assertEquals(resultList, result);
	}
	
	@Test
	public void Add_string_1_2_3_4_results_10() throws StringCalculatorException {
		// Arrange
		StringCalculator calc = new StringCalculator();
		// Act
		int result = calc.add("1,2,3,4");
		// Assert
		assertEquals(10, result);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void ParseString_string_1_c_c_1_results_exception() throws StringCalculatorException {
		// Arrange
				StringCalculator calc = new StringCalculator();
				// Act and cause exception
				calc.parseString("1,,1");
	}
	@Test (expected = StringCalculatorException.class)
	public void ParseString_string_1_comma_results_exception() throws StringCalculatorException {
		// Arrange
				StringCalculator calc = new StringCalculator();
				// Act and cause exception
				calc.parseString("1,\n");
	}
	@Test (expected = StringCalculatorException.class)
	public void ParseString_string_negative_1_results_exception() throws StringCalculatorException {
		// Arrange
				StringCalculator calc = new StringCalculator();
				// Act and cause exception
				calc.parseString("-1");
	}
}
