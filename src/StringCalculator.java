import java.io.IOException;
import java.util.Scanner;

public class StringCalculator {
	
	int num1 = 0;
	int num2 = 0;
	
	int sum = 0;
	
	public void detectNumbers(String inputStr) throws StringCalculatorException
	{
		//extracts the numbers from the input string and checks step by step that whether the string is empty, it has only valid characters, 
		//there are new lines used in the string, it has only two numbers or more, and if it is in correct order. if all checks are ok then it calculates the sum of them
		//and if something is wrong it returns proper exception to the user
		
		if (inputStr.isEmpty()) 
			{
				num1 = 0;
				num2 = 0;
			}
		else 
		{
			if (hasValidInputs(inputStr))
			{
				if (!hasNewLine(inputStr))
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
				else 
				{
					String[] lines = parseNewLine(inputStr);
					for(String line : lines)
					{
						if (hasOneNumber(line))
						{
							num1 =+ Integer.parseInt(line);
						}
						else
						{
							if (hasTwoNumbers(line)) 
							{
								if (isInCorrectOrder(line))
								{
									String[] tokens = parseString(line);
									int[] nums = convertStringToInteger(tokens);
									int n1 = nums[0];
									int n2 = nums[1];
									if (n1 < 0 || n2 < 0) throw new StringCalculatorException("Negative numbers detected!");
									else num2 =+ n1+n2;
								}
								else throw new StringCalculatorException("Wrong order detected!");
							}
							else throw new StringCalculatorException("Unknown amount of numbers or invalid usage detected!");
						}
					
					}
				}
			}
			else throw new StringCalculatorException("Invalid input!");
		}
	}
	
	public boolean hasOneNumber(String s)
	{
		//checks that whether the string has only one number like "1" or not
		
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
		//checks that there is only two numbers in a string using "," between them
		
		String[] tokens = s.split(",");
		if (tokens.length == 2) return true;
		else return false;
	}
	
	public boolean hasValidInputs(String s)
	{
		//checks that the user has entered only valid characters like 0~9, ',', '\n', '-'
		
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
		//checks that whether the character is only a digit (0~9)
		
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
		//checks that if the numbers and ',' are in correct order. consider "3,5" is correct but "35," or ",35" are incorrect
		
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
		//splits the string by ',' and put them in a string array
		
		String tokens[] = s.split(",");
		return tokens;
	}
	
	public boolean hasNewLine(String s)
	{
		// checks whether the '\n' is used in the string or not
		
		boolean state = false;
		char[] chars = s.toCharArray();
		for(int i = 0; i < s.length(); i++)
		{
			if (chars[i] == '\n') state = true;  
		}
		return state;
	}
	
	public String[] parseNewLine(String s)
	{
		//splits the string by new lines entered and put all lines in a string array
		
		String[] lines = s.split("\n");
		return lines;
	}
	
	public int[] convertStringToInteger(String[] tokens)
	{
		//converts string values to their correspondent integer values 
		
		int[] nums = new int[2];
		nums[0] = Integer.parseInt(tokens[0]);
		nums[1] = Integer.parseInt(tokens[1]);
		
		return nums;
	}
	
	public int add(String inputStr) throws StringCalculatorException
	{
		//adds two numbers and returns the result
		
		detectNumbers(inputStr);
		sum = num1 + num2;
		return sum;
	}
}
