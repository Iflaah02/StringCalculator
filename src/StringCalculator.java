import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		if (numbersStr.length() == 0)
			return 0;
		
		
		if (!checkInputValidity(numbersStr))
			throw new StringCalculatorException();
			
		String[] numbers = splitNumbersString(numbersStr);
		
		checkNumbersListForNegativeIntegersAndNonIntegers(numbers);
		
		if (numbers.length == 1) {
			return Integer.parseInt(numbers[0]);
		}
		else if (numbers.length > 1) {
			return addMultiple(numbers);
		}
		
		return 0;
	}
	
	private boolean checkInputValidity(String numbersString) {
		String[] delimiters = {"\n", ","};
		boolean lastCharacterWasDelimiter = false;
		
		for (int i = 0; i < numbersString.length(); ++i) {
			boolean foundDelimiter = false;
			
			String currentCharacter = String.valueOf(numbersString.charAt(i));
			if (Arrays.asList(delimiters).contains(currentCharacter)) {
				if (i == 0 || i == numbersString.length()-1)
					return false;
				
				foundDelimiter = true;
			}
			
			if (foundDelimiter && lastCharacterWasDelimiter)
				return false;
			
			if (foundDelimiter)
				lastCharacterWasDelimiter = true;
			else
				lastCharacterWasDelimiter = false;
		}
		
		return true;
	}
	
	private void checkNumbersListForNegativeIntegersAndNonIntegers(String[] numbers) throws StringCalculatorException {
		for (int i = 0; i < numbers.length; ++i) {
			int temp = 0;
			
			try {
				temp = Integer.parseInt(numbers[i]);
			}
			catch (NumberFormatException e) {
				throw new StringCalculatorException();
			}
			
			if (temp < 0)
				throw new StringCalculatorException();
		}
	}
	
	// Add an array of Strings by converting every element to an integer
	private int addMultiple(String[] numbers) {
		int ret = 0;
		for (int i = 0; i < numbers.length; ++i)
			ret += Integer.parseInt(numbers[i]);
		
		return ret;
	}
	
	// Method to split a String on newlines and commas
	private String[] splitNumbersString(String numbersString) {
		List<String> numbersList = new ArrayList<String>();
		String delimiters = "\n,";
		StringTokenizer tokenizer = new StringTokenizer(numbersString, delimiters);
		
		while (tokenizer.hasMoreTokens())
			numbersList.add(tokenizer.nextToken());
		
		String[] splitted = numbersList.toArray(new String[0]);
		return splitted;
	}
}
