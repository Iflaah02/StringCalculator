import java.io.IOException;
import java.util.Scanner;

public class StringCalculator {
	
	public int num1;
	public int num2;
	
	int sum;
	
	public boolean getNumbers(String inputStr)
	{
		if (isEmpty(inputStr)) 
			{
				num1 = 0;
				num2 = 0;
				return true;
			}
		else 
		{
			String[] tokens = parseString(inputStr);
			if (hasMoreThanTwoOperands(tokens)) 
			{
				System.out.println("The unknown amount of numbers have been detected.");
				return false;
			}
			else 
				{
					int[] nums = getNumbersFromString(tokens);
					num1 = nums[0];
					num2 = nums[1];
					return true;
				}
		}
		
	}
	
	public boolean isEmpty(String s)
	{
		if (s.isEmpty()) return true;
		else return false;
	}
	
	public String[] parseString(String s)
	{
		String tokens[] = s.split(",");
		return tokens;
	}
	
	public boolean hasMoreThanTwoOperands(String[] tokens)
	{
		if (tokens.length > 2) return true;
		else return false;
	}
	
	public boolean hasNewLine(String s)
	{
		return false;
	}
	
	public int[] getNumbersFromString(String[] tokens)
	{
		int[] nums = new int[2];
		nums[0] = Integer.parseInt(tokens[0]);
		nums[1] = Integer.parseInt(tokens[1]);
		
		return nums;
	}
	
	public int add(String inputStr) 
	{
		boolean state = getNumbers(inputStr);
		if (state) 
			{
				sum = num1 + num2;
				return sum;
			}
		else 
			{
				System.out.println("invalid inputs");
				return 0;
			}
	}
}
