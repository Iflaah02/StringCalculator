public class StringCalculator {
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		int summary = HandleUnknownAmountOfNumber(numbersStr);

		return summary;
	}

	public int HandleUnknownAmountOfNumber (String numbersStr) {
		int StrLength = numbersStr.length();
		
		if (StrLength == 0) {
			return 0;
		}
		
		else if (StrLength > 0) {
			int summary = HandleNewLinesBetweenNumbers(numbersStr);
			return summary;
		}
		return 0;
	}
	
	public int HandleNewLinesBetweenNumbers(String numbersStr) {
		
		String[] numbers = numbersStr.split("\n" + ",");
		int summary = 0;

		int numLength = numbers.length;
		while (numLength != 0){
			try {
				int number = Integer.parseInt(numbers[0]);
				
				if (number < 0) {
					Exception exc = new StringCalculatorException();
				}
				else {
					summary = summary + number;				
				}
			}
			catch (NumberFormatException e) {
				Exception exc = new StringCalculatorException();
			}
			numLength = numLength -1;
		}
		
		return summary;
	}
}
