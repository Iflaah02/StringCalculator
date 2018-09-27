import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StringCalculator
{
	private String newline = System.getProperty("line.separator");
	private List<Integer> ListOfItems = new ArrayList<Integer>();
	
	
	public StringCalculator() {};
	
	public int add(String input) throws StringCalculatorException
	{
		verifyCommas(input);
		verifyLineBreaks(input);
		verifyInput(input);
		int sum=calculateSum(input);
		return sum;
	}
	public void verifyCommas(String input) throws StringCalculatorException
	{
		if (input.contains(","))
		{
			if (input.endsWith(",") || input.startsWith(",")  ) 
			{
				ListOfItems.clear();
				throw new StringCalculatorException();
			}
		}
	}
	public void verifyLineBreaks(String input) throws StringCalculatorException
	{
		if (input.contains(newline) )
		{
			if (input.endsWith(newline) || input.startsWith(newline)) 
			{
				ListOfItems.clear();
				throw new StringCalculatorException();
			}
		}
	}

	public int calculateSum(String input)
	{
		int sum=0;
		for(Integer anInput : ListOfItems)
		{
			sum = sum + anInput;
		}
		return sum;
	}

	public void verifyInput(String input) throws StringCalculatorException
	{
		String[] inputList = input.split(",");
		for(String anInput : inputList)
		{
			String[] anotherList = anInput.split(newline);
			for(String another : anotherList)
			{
				int number = isAValidNumber(another);
				if (number < 0)
				{
					ListOfItems.clear();
					throw new StringCalculatorException();
				}
				
				ListOfItems.add(number);
			}
		}
	}
	public int isAValidNumber(String str) throws StringCalculatorException
	{
		try
		{
			return(Integer.parseInt(str));
		}
		catch(Exception e)
		{
			ListOfItems.clear();
			throw new StringCalculatorException();
		}
	}
}