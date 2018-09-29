public class StringCalculator {
	private int helpnumnber;

	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		int summary = HandleUnknownAmountOfNumber(numbersStr);
		System.out.println("Summary is " + summary);

		return summary;
	}

	public int HandleUnknownAmountOfNumber (String numbersStr) {
		int StrLength = numbersStr.length();
		
		if (StrLength == 0) {
			System.out.println("1");
			return 0;
		}
		
		else if (StrLength > 0) {
			int summary = HandleNewLinesBetweenNumbers(numbersStr);
			return summary;
		}
		return 0;
	}
	
	public int HandleNewLinesBetweenNumbers(String numbersStr) {
		 
		if(numbersStr.matches("(.*),\n(.*)|(.*)\n,(.*)" )) {
			Exception exc = new StringCalculatorException();
		}
		else {
			String[] numbers = numbersStr.split("\n|\\,");
			int helpnumber = 0;
			int summary = 0;
			int numLength = numbers.length;
			
			while (numLength != 0){
				try {
					int number = Integer.parseInt(numbers[helpnumber]);
					
					if (number < 0) {
						Exception exc = new StringCalculatorException();
						return 0;
						
					}
					else {
						summary = summary + number;				
					}
				}
				catch (NumberFormatException e) {
					Exception exc = new StringCalculatorException();
					return 0;
				}
				numLength = numLength -1;
				helpnumber = helpnumber +1;
			}
		
		return summary;
		}
		return 0;
	}
}
