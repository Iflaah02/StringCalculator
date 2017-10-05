import static org.junit.Assert.*;
import java.lang.Object.*;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.Scanner;



import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void inputs() throws StringCalculatorException {
		calculator cal = new calculator();
		
		String input = "add 2";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);

	    assertEquals("add 2", cal.getInput());
	}

}
