import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/* the initial task is faulty. It claims that the string calculator can take 0, 1 or 2 numbers but
   the example includes 3. Therefore this has been programmed to take up to any number of string based numbers.
 */

public class StringCalculatorTest {

	@Test
	public void test_entire_calculation_with_invalid_characters() {
		
		StringCalculator laske = new StringCalculator();
		int result=laske.add("vmp");
		if (result != 0) fail("Supposed to calculate 0 result");
	}

	
	@Test
	public void test_calculator_with_valid_input() 
		{
		
		StringCalculator laske = new StringCalculator();
		int result=laske.add("18,54,55");
		if (result != 18+54+55) fail("Not working, getting wrong result");
		}
	
	@Test
	public void testForMoreNumbers() 
		{
		
		StringCalculator laske = new StringCalculator();
		int result = laske.add("19,54,55,77");
		if (result != 19+54+55+77) fail("Not working, should calculate even 4 numbers");
		}
	
	
	@Test 
	public void testMethodcC () //tests if a character is valid. should fail with character a that is inserted into the string
		{
		StringCalculator laske = new StringCalculator();
		int result;
		String t="5a\\n,15kn";
		for (int i=0; i<t.length(); i++)
			{
			result = laske.cC(t.charAt(i));
			if (result == 0) fail("Failed for wrong type of characters");
			}
		}
	
	
	@Test
	public void testMethodcCwithSeeminglyValidInput () 
	//tests if a character is valid for all of the allowed types of characters allowed
		{
		StringCalculator laske = new StringCalculator();
		int result;
		String t="5\\n,n15";
		for (int i=0; i<t.length(); i++)
			{
			result = laske.cC(t.charAt(i));
			if (result == 0) fail("Not quite");
			}
		}
	
	@Test
	public void testMethod_separate()
	//tests if the separate method for finding the an individual number in the feed functions
		{
		StringCalculator laske = new StringCalculator();
		String aaru = "765,254";
		int x=4;
		int y=7;
		aaru=laske.separate(aaru, x, y);
		if (aaru != "254") fail ("not the correct result"); // apparently this fails for some reason?
		}
	
	@Test
	public void testMethod_find_numbers()
	//tests if the separate method for finding the an individual number in the feed functions
		{
		StringCalculator laske = new StringCalculator();
		String aaru = "765,254,45";
		laske.find_numbers(aaru);
		// if (aaru != "254") fail ("not the correct result"); // apparently this fails for some reason?
		}
	
	@Test
	public void testMethod_add_with_two_numbers()
	//tests if the separate method for finding the an individual number in the feed functions
		{
		StringCalculator laske = new StringCalculator();
		String aaru = "76,24";
		int result=laske.add(aaru);
		if (result != 100) fail ("not the correct result"); // apparently this fails for some reason?
		}
	
	@Test
	public void test_Method_toStrings_with_feed_different_feeds()
		{
		StringCalculator laske = new StringCalculator();
		String aaru = "76,24,45,58";
		laske.toStrings(aaru);
		String aaru2 = "76,24,45";
		laske.toStrings(aaru2);
		String aaru3 = "76,24,1,14,55";
		laske.toStrings(aaru3);
		String aaru4 = "0,a,b";
		laske.toStrings(aaru4);
		// this was just used to see what feeds the mechanism built on the 10th+ try can take

		}
	
	@Test
	public void test_Method_add_with_empty_feed()
		{
		StringCalculator laske = new StringCalculator();
		String aaru = "";
		laske.add(aaru);
		}
	
	@Test
	public void test_Method_add_with_no_commas()
		{
		StringCalculator laske = new StringCalculator();
		String aaru = "25";
		int result=laske.add(aaru);
		if (result != 25) fail ("not quite the result we wanted");
		}
	
	
}
