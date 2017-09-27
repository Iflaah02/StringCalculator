import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	
	@Test
	public void testSplit() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("1,2");
		int splitLength = calculator.splitLength;
		assertEquals(2,splitLength);
				
	}
	@Test
	public void testSplit1() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("1");
		int splitLength = calculator.splitLength;
		assertEquals(1,splitLength);
				
	}
	
	@Test
	public void testSplit0() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("");
		int splitLength = calculator.splitLength;
		assertEquals(1,splitLength);
				
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/*@Test (expected = StringCalculatorException.class)
	public void testLength() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("1,2,3"); d
				
	}*/
	
	@Test
	public void testSum() throws StringCalculatorException  {
		StringCalculator calculator = new StringCalculator();
		calculator.add("5,2,7");
		
		int sumOfNumbers = calculator.sumOfNumbers();
		assertEquals(14,sumOfNumbers);
	}
	
	@Test
	public void testnewLine() throws StringCalculatorException  {
		StringCalculator calculator = new StringCalculator();
		calculator.add("5,2");
		calculator.newLines();
		
		int withNewLine = calculator.lengthNumbers;
		assertEquals(2,withNewLine);
	}
	@Test
	public void testnewLine2() throws StringCalculatorException  {
		StringCalculator calculator = new StringCalculator();
		calculator.add("5\n3,2");
		calculator.newLines();
		
		int withNewLine = calculator.lengthNumbers;
		assertEquals(3,withNewLine);
	}
	@Test (expected = StringCalculatorException.class)
	public void testnewLineError() throws StringCalculatorException  {
		StringCalculator calculator = new StringCalculator();
		
		calculator.newLinesError("5,\n");
		
		
	}

}
