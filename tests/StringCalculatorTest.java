import static org.junit.Assert.*;
import org.junit.Test;
public class StringCalculatorTest
{
	
	@Test
	public void test_addition()
	{
		StringCalculator test = new StringCalculator();
		try
		{
			int result = test.add("1,22");
			assertEquals(23, result);
		}
		catch(Exception  e)
		{
			fail("Exception during addition 1");
		}
	}
	

	@Test
	public void test_addition2()
	{
		StringCalculator test = new StringCalculator();
		try
		{
			int result = test.add("1,0");
			assertEquals(1, result);
		}
		catch(Exception  e)
		{
			fail("Exception during addition 2");
		}
	}

	@Test
	public void test_addition3()
	{
		StringCalculator test = new StringCalculator();
		try
		{
			int result = test.add("10");
			assertEquals(10, result);
		}
		catch(Exception  e)
		{
			fail("Exception during addition 3");
		}
	}

	@Test
	public void test_addition_of_three_numbers()
	{
		StringCalculator test = new StringCalculator();
		try
		{
			int result = test.add("2,0,1");
			assertEquals(3, result);
		}
		catch(Exception  e)
		{
			fail("Exception while calculating three numbers");
		}
	}

	@Test (expected = StringCalculatorException.class )
	public void test_not_number() throws  StringCalculatorException
	{
		StringCalculator test = new StringCalculator();
		test.isAValidNumber("abc");
	}
	
	@Test (expected = StringCalculatorException.class )
	public void test_not_number2() throws  StringCalculatorException
	{
		StringCalculator test = new StringCalculator();
		test.isAValidNumber(",,,");
	}



	@Test
	public void test_line_break2()
	{

		String newline = System.getProperty("line.separator");
		StringCalculator test = new StringCalculator();
		try
		{
			int result = test.add("1"+newline+"2,3");
//			System.out.println(result);
			assertEquals(6, result);
		}
		catch(Exception  e)
		{
			fail("Exception while calculating three numbers");
		}
	}



	


	@Test (expected = StringCalculatorException.class )
	public void test_line_break_at_start() throws  StringCalculatorException
	{
		String newline = System.getProperty("line.separator");
		StringCalculator test = new StringCalculator();
		test.add(newline+"1");
	}
	@Test (expected = StringCalculatorException.class )
	public void test_line_break_at_end() throws  StringCalculatorException
	{
		String newline = System.getProperty("line.separator");
		StringCalculator test = new StringCalculator();
		test.add("1"+newline);
	}
	
	@Test (expected = StringCalculatorException.class )
	public void test_comma_at_start() throws  StringCalculatorException
	{
		StringCalculator test = new StringCalculator();
		test.add(",1");
	}
	@Test (expected = StringCalculatorException.class )
	public void test_comma_at_end() throws  StringCalculatorException
	{
		StringCalculator test = new StringCalculator();
		test.add("1,");
	}

	@Test (expected = StringCalculatorException.class )
	public void negative_number() throws  StringCalculatorException
	{
		StringCalculator test = new StringCalculator();
		test.add("-1,-1");
	}
	
	

	


	
	
}
