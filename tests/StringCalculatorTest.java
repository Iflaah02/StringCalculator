import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test() {
		
		StringCalculator laske = new StringCalculator();
		laske.add("vmp");
		fail("Not yet implemented");
	}

	
	@Test
	public void test2() 
		{
		
		StringCalculator laske = new StringCalculator();
		System.out.println(laske.add("18,54,55"));
		fail("Not yet implemented");
		}
	
	@Test
	public void testForTooManyNumbers() 
		{
		
		StringCalculator laske = new StringCalculator();
		System.out.println(laske.add("19,54,55,77"));
		fail("Not yet implemented");
		}
	
	
	@Test
	public void testMethodcC () //tests if a character is valid. should fail with character a that is inserted into the string
		{
		StringCalculator laske = new StringCalculator();
		int result;
		String t="5a\\,n15k";
		for (int i=0; i<t.length(); i++)
			{
			result = laske.cC(t.charAt(i));
			if (result == 0) fail("Joo...ei..Not yet implemented");
			}
		}
	
	
	@Test
	public void testMethodcCwithSeeminglyValidInput () 
	//tests if a character is valid for all of the allowed types of characters allowed
		{
		StringCalculator laske = new StringCalculator();
		int result;
		String t="5\\,n15";
		for (int i=0; i<t.length(); i++)
			{
			result = laske.cC(t.charAt(i));
			if (result == 0) fail("Joo...ei..Not yet implemented");
			}
		}
}
