import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		int result = 0;
		// If numbStr is empty string, return 0
		if (numbersStr.equals("")) {
			return 0;
		}
		// Parse string
		List<Integer> numbers = parseString(numbersStr);
		// Calculate sum
		for(int num : numbers) {
			result = result + num;
		}
		return result;
	}
	
	public List<Integer> parseString(String numbersStr) throws StringCalculatorException {
		List<Integer> numbers = new ArrayList<>();
		// If ends with (, or ,\n) throw exception
		if (numbersStr.endsWith(",") || numbersStr.endsWith(",\n")) {
			throw new StringCalculatorException();
		}
		// Split string to string parts (new line or comma)
		for(String token : numbersStr.split(",|\n")) {
			if (token.isEmpty() || token.endsWith(",") || token.endsWith(",\n")) {
				throw new StringCalculatorException();
			}
			try {
				int number = Integer.parseInt(token);
				if (number < 0) {
					throw new StringCalculatorException();
				}
				numbers.add(number);
			} catch (NumberFormatException e){
				throw new StringCalculatorException();
			}
			
		}
		return numbers;
	}
}
