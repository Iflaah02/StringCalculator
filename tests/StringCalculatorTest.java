import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testCheckNumbersLength_happypath1() {
		StringCalculator stringCalculator = new StringCalculator();
		List<String> list = Arrays.asList("1", "2");
		assertTrue(stringCalculator.checkNumbersLength(new CheckNumbersLengthParameter(list)));
	}

	@Test
	public void testCheckNumbersLength_tooManyNumbers() {
		StringCalculator stringCalculator = new StringCalculator();
		List<String> list = Arrays.asList("1", "2", "3");
		assertFalse(stringCalculator.checkNumbersLength(new CheckNumbersLengthParameter(list)));
	}

	@Test
	public void testHandleNewlineComma_happypath() throws StringCalculatorException {
		StringCalculator stringCalculator = new StringCalculator();
		List<String> list = Arrays.asList("1", "2");
		assertEquals(list, stringCalculator.handleNewlineComma("1\n2"));
	}
	
	@Test
	public void testHandleNewlineComma_happypath2() throws StringCalculatorException {
		StringCalculator stringCalculator = new StringCalculator();
		List<String> list = Arrays.asList("1", "2");
		assertEquals(list, stringCalculator.handleNewlineComma("1,2"));
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testHandleNewlineComma_commaFollowByNewline() throws StringCalculatorException {
		StringCalculator stringCalculator = new StringCalculator();
		System.out.println(stringCalculator.handleNewlineComma("1,\n"));
	}

	@Test
	public void testAdd_happypath() throws StringCalculatorException {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(0, stringCalculator.add(""));
	}
	
	@Test
	public void testAdd_happypath2() throws StringCalculatorException {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(110, stringCalculator.add("10,100"));
	}

}
