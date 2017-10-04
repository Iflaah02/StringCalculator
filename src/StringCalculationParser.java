
public class StringCalculationParser { //Extracted class
	
	public static String[] splitByCommasOrNewlines(String numbers) throws StringCalculatorException {
		String[] result = numbers.split("[,\\n]");
		throwIfStringContainsConsecutiveDelimiters(numbers); //Consolidated conditionals
		return result;
	}
	
	private static void throwIfStringContainsConsecutiveDelimiters(String input) throws StringCalculatorException {
		if (input.matches(".[\n,][\n,]")) { // Sixth slice implementation (just the if branch)
			throw new StringCalculatorException("Malformed input");
		}
	}
	
	public static int validateNumber(String number) throws StringCalculatorException {
		int result;
		try {
			result = Integer.valueOf(number);
			if(result < 0 || number.isEmpty()) {
				throw new StringCalculatorException("Negative numbers aren't allowed");
			}
		}
		catch(NumberFormatException e) {
			throw new StringCalculatorException("Can't add something that is not a number");
		}
		
		return result;
	}

}
