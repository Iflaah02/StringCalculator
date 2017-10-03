import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//	
	@Test
	  public void testAddUnknownWith0() throws StringCalculatorException {
	    StringCalculator calc = new StringCalculator();

	    String test = "";

	    assertEquals(0, calc.addUnknown(test));
	  }
	
	@Test
	  public void testAddWithEmpty() throws StringCalculatorException {
	    StringCalculator calc = new StringCalculator();

	    String test = "";

	    assertEquals(0, calc.add(test));
	  }
	
	@Test
	  public void testAddWithOne() throws StringCalculatorException {
	    StringCalculator calc = new StringCalculator();

	    String test = "1";

	    assertEquals(1, calc.add(test));
	  }

}
