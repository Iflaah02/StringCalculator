public class StringCalculator {
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		
		if (!validateString(numbersStr)) {
			return 0;
		}
		
		String[] strings = numbersStr.split(",");
		int[] parsedNumbers = parseStringsToIntegers(strings);
		int sum = sumNumbers(parsedNumbers);
		
		return sum;
	}
	
	public boolean validateString(String numbersStr) {
		if (numbersStr.length() == 0) return false;
		
		return true;
	}
	
	public int[] parseStringsToIntegers(String[] numberStrings) {
		int[] parsedNumbers = new int[numberStrings.length];
		
		for (int i = 0; i < numberStrings.length; i++) {
			parsedNumbers[i] = Integer.parseInt(numberStrings[i]);
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
