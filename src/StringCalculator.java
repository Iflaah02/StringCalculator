
public class StringCalculator {
	
	private String string; 
	
	public int add(String numbersStr) throws StringCalculatorException {
		
		string = numbersStr;
		
		String[] numbers = splitByCommasOrNewlines(string);
		
		int result = 0;
		
		for(String number : numbers) {
			
			result += validateNumber(number);
			
		}
	
		return result;
	}
	
	private String[] splitByCommasOrNewlines(String numbers) throws StringCalculatorException {
		String[] result = numbers.split("[,\\n]");
		if (numbers.matches(".[\n,][\n,]")) { // Sixth slice implementation (just the if branch)
			throw new StringCalculatorException("Malformed input");
		}
		return result;
	}
	
	private int validateNumber(String number) throws StringCalculatorException {
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
	
	public String getString() {
		return string;
	}
	
}
