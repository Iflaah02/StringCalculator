import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

//is this extends XYZ the way to access its methods the right way?
//got a lot 'cannot be resolved to' errors with testCalc
public class StringCalculatorTest extends StringCalculator
{

	@Test
	public void testInputs() 
	{
		String testInputs = null;
		//input testCalc = new StringCalculator();
		
		testInputs = StringCalculator.input();
		if(testInputs instanceof String )
		{
			
		}	
		else
		fail("Not a string, should be");
	}

    @Test
    public void testSplit()
    {
     //check that the return value from splitString is an ArrayList?	
     ArrayList<Integer> testSplits = new ArrayList<Integer>();
     testSplits = StringCalculator.splitString("1,2,3");
     
     if(testSplits instanceof ArrayList<?>)
     {
    	 
     }
     else
     fail("Not an ArrayList, should be");
    }
    
    @Test
    public void testSum()
    {
     //check that it adds the numbers together properly?
     int testSum = 0;
     testSum = StringCalculator.add(StringCalculator.splitString("1,2,3"));

     assertEquals("Did not seem to add them together",6,testSum);
    }
}
