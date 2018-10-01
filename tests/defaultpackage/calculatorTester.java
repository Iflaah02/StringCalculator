package defaultpackage;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Scanner;

public class calculatorTester {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	@Test
	public void insertString(){
		StringCalculator calc = new StringCalculator();
		String stringReturned = calc.addNumbers();
		System.out.println("String returned to test: "+stringReturned);
		if(stringReturned==null)
		{
			fail("No sum executed.");
		}
	}

}
