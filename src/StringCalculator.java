public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		String[] strings = splitString(numbersStr);
		int[] parsedNumbers = parseAndValidateStrings(strings);
		int sum = sumNumbers(parsedNumbers);
		
		return sum;
	}
	
	public String[] splitString(String numbersStr) {
		if (numbersStr.length() == 0) return new String[0];
		
		int numberCount = 1 + countSeparatorSymbols(numbersStr);
		String[] strings = new String[numberCount];
		int i = 0;
		
		String[] substrings = numbersStr.split(",");
		for (int j = 0; j < substrings.length; j++) {
			String[] subsubstrings = substrings[j].split("\n");
			for (int k = 0; k < subsubstrings.length; k++) {
				strings[i] = subsubstrings[k];
				i++;
			}
		}
		
		return strings;
	}
	
	public int countSeparatorSymbols(String str) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ',' || str.charAt(i) == '\n') {
				count++;
			}
		}
		
		return count;
	}
	
	public int[] parseAndValidateStrings(String[] numberStrings) throws StringCalculatorException {
		int[] parsedNumbers = new int[numberStrings.length];
		
		for (int i = 0; i < numberStrings.length; i++) {
			try {
				String stringToParse = numberStrings[i];
				int parsed = Integer.parseInt(stringToParse);
				
				if (parsed < 0) {
					// Negative numbers not allowed
					throw new StringCalculatorException();
				}
				
				parsedNumbers[i] = parsed;
			} catch (NumberFormatException e) {  
				throw new StringCalculatorException();
			}  
		}
		
		return parsedNumbers;
	}

	public int sumNumbers(int[] numbers) {
		int sum = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		
		return sum;
	}
}
