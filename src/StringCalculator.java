public class StringCalculator {

    // public add method to be implemented and tested - main code 
	// Returns the sum of the numbers given in numbersStr
	public int add(String numbersStr) throws StringCalculatorException {
		int res;
		if (numbersStr.isEmpty()) // Checking if input is empty
			return 0;             // Yes - return 0
		else {
			res = getSingleNumber(numbersStr); // Calling private method for single number
			if (res != -1)                     // If ok? -1 is not ok
				return res;                    // Yes - return method's result
			else if (numbersStr.contains("\n"))       // If new lines in input
				return processNewLines(numbersStr);   // then call private method to process
			else { // Split input into array of numbers, separated by comma
				String[] numbers = numbersStr.split(",");  
				if (numbers.length == 0)   // If array's length = 0 - exception 
					throw new StringCalculatorException();
				else if (numbers.length == 2)  // exactly 2 numbers
					return addTwoNum(numbers);  
				else
					// And at last - private method for unknown amount of numbers in input
					return addUnknownAmountNum(numbers);  
			}
		}
	} // End of add method
	
	// ------------------------------------------------------------------------------------
	// private methods to use from add method
	// Note - in case we need to test these methods separately, we should redefine them as public 
	

	// Get an integer number from string input. Returns -1, if input is not number
	private int getSingleNumber(String str) throws StringCalculatorException {
		try {
				int res = Integer.parseInt(str); // Convert string to int
				if (res < 0)                     // Negative - exception
					throw new StringCalculatorException();
				else
					return res;
			} catch (NumberFormatException ex) {  // Not number - return -1
				return -1;
			}
	}

	// Process New Lines
	private int processNewLines(String numbersStr) throws StringCalculatorException {
		String[] numbers = numbersStr.split("[,\n]");  // Split input into string array,
		                                               // Separator is comma + new line
		if (numbers.length == 0)                       // Empty array - exception
			throw new StringCalculatorException();
		else if (numbers.length == 2)
			return addTwoNum(numbers);  
		else
			return addUnknownAmountNum(numbers);
	}
	

	// Returns the sum of two numbers given in string numbers array
	private int addTwoNum(String[] numbers) throws StringCalculatorException {
		try {
			int x1, x2;
			// Convert both strings to ints and check for negatives
			// For negatives - StringCalculatorException
			// For not numbers Integer.parseInt - NumberFormatException
			if ((x1 = Integer.parseInt(numbers[0])) < 0) 
				throw new StringCalculatorException();
			else if ((x2 = Integer.parseInt(numbers[1])) < 0)
				throw new StringCalculatorException();
			else
				return x1 + x2; // All ok - return sum of 2 numbers
			} catch (NumberFormatException ex) {
				throw new StringCalculatorException();
			}
	}
	
	
	// Returns the sum of the numbers given in string numbers array
	private int addUnknownAmountNum(String[] numbers) throws StringCalculatorException {
		int sum = 0; // Initialize sum
		for (int i = 0; i < numbers.length; i++) // Loop through...
			try {
				int n = Integer.parseInt(numbers[i]); // Convert string to int
				if (n < 0) // Negative - exception
					throw new StringCalculatorException();
				else sum += n; // add to sum
			} catch (NumberFormatException ex) { // Check for not number - exception
				throw new StringCalculatorException();
			}
		return sum;
	}
	

} // End of class