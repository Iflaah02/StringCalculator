import java.io.IOException;
import java.util.Scanner;

public class StringCalculator {
	
	int num1 = 0;
	int num2 = 0;
	
	int sum = 0;
	
	public void detectNumbers(String inputStr) throws StringCalculatorException
	{
		if (inputStr.isEmpty()) 
			{
				num1 = 0;
				num2 = 0;
			}
		else 
		{
			if (hasValidInputs(inputStr))
			{
				if (hasOneNumber(inputStr))
				{
					num1 = Integer.parseInt(inputStr);
					num2 = 0;
				}
				else
				{
					if (hasTwoNumbers(inputStr)) 
					{
						if (isInCorrectOrder(inputStr))
						{
							String[] tokens = parseString(inputStr);
							int[] nums = convertStringToInteger(tokens);
							num1 = nums[0];
							num2 = nums[1];
							if (num1 < 0 || num2 < 0) throw new StringCalculatorException("Negative numbers detected!");
						}
						else throw new StringCalculatorException("Wrong order detected!");
					}
					else throw new StringCalculatorException("Unknown amount of numbers or invalid usage detected!");
				}
			}
			else throw new StringCalculatorException("Invalid input!");
		}
	}
	
	public boolean hasOneNumber(String s)
	{
		boolean state = true;
		char[] chars = s.toCharArray();
		for(int i = 0; i < s.length(); i++)
		{
			switch(chars[i])
			{
				case '0': break;
				case '1': break;
				case '2': break;
				case '3': break;
				case '4': break;
				case '5': break;
				case '6': break;
				case '7': break;
				case '8': break;
				case '9': break;
				default: state = false; break;
			}
		}
		return state;
	}
	
	public boolean hasTwoNumbers(String s)
	{
		boolean state = false;
		char[] chars = s.toCharArray();
		int ctr = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if (chars[i] == ',') ctr++;
		}
		if (ctr == 1) state = true;
		else state = false;
		return state;
	}
	
	public boolean hasValidInputs(String s)
	{
		boolean state = true;
		char[] chars = s.toCharArray();
		for(int i = 0; i < s.length(); i++)
		{
			switch(chars[i])
			{
				case '0':  break;
				case '1':  break;
				case '2':  break;
				case '3':  break;
				case '4':  break;
				case '5':  break;
				case '6':  break;
				case '7':  break;
				case '8':  break;
				case '9':  break;
				case ',':  break;
				case '\n': break;
				case '-':  break;
				default: state = false; break;
			}
		}
		return state;
	}
	
	public boolean isDigit(char c)
	{
		boolean state = true;
		switch(c)
			{
				case '0':  break;
				case '1':  break;
				case '2':  break;
				case '3':  break;
				case '4':  break;
				case '5':  break;
				case '6':  break;
				case '7':  break;
				case '8':  break;
				case '9':  break;
				default: state = false; break;
			}
		return state;
	}
	
	public boolean isInCorrectOrder(String s)
	{
		boolean state = true;
		char[] chars = s.toCharArray();
		for(int i = 0; i < s.length(); i++)
		{
			if (chars[i] == ',')  
				if (i>0 && i<s.length()-1)
				{
					if (isDigit(chars[i-1]) && isDigit(chars[i+1])) state = true;
					else state = false;
				}
				else state = false;
		}
		return state;
	}
	
	public String[] parseString(String s)
	{
		String tokens[] = s.split(",");
		return tokens;
	}
	
	public boolean hasNewLine(String s)
	{
		return false;
	}
	
	public int[] convertStringToInteger(String[] tokens)
	{
		int[] nums = new int[2];
		nums[0] = Integer.parseInt(tokens[0]);
		nums[1] = Integer.parseInt(tokens[1]);
		
		return nums;
	}
	
	public int add(String inputStr) throws StringCalculatorException
	{
		detectNumbers(inputStr);
		sum = num1 + num2;
		return sum;
	}
}
