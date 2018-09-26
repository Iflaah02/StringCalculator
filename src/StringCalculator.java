import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	public Integer stringToInt(String str) {
		return Integer.parseInt(str);
	}
	
	public boolean checkEmptyString(String str) {
		return str.isEmpty();
	}

	public boolean checkValidInput(String numberString) {
		char[] chars = numberString.toCharArray();
		
		if (this.checkEmptyString(numberString)) {
			return true;
		}
		
		if (chars[0] == ',' || chars[chars.length - 1] == ',') {
			return false;
		}
		if (chars[0] == '\n' || chars[chars.length - 1] == '\n') {
			return false;
		}
		
		for (char ch: chars) {
			if ((ch > '9' || ch < '0') && ch != ',' && ch != '\n') {
				return false;
			}
		}
		
		return true;
	}
	
	public void handleNegativeNumbers(ArrayList<Integer> numbers) throws StringCalculatorException {
		for (Integer number: numbers) {
			if (number < 0) {
				throw new StringCalculatorException();
			}
		}
	}
	
	public String[] handleNewLines(String str) throws StringCalculatorException {
		// split the string by newlines
		return str.split("\n");
	}
	
	public ArrayList<Integer> getMaxTwoNumbersFromString(String str) throws StringCalculatorException {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		String[] numberStrings = str.split(",");
		
		for (int i = 0; i < Math.min(2, numberStrings.length); i++) {
			numbers.add(stringToInt(numberStrings[i]));
		}

		return numbers;
	}

	public ArrayList<Integer> getUnknownAmountOfNumbersFromString(String str) throws StringCalculatorException {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		String[] numberLines = handleNewLines(str);
		for (String line: numberLines) {
			String[] numberStrings = line.split(",");
			for (String numberStr: numberStrings) {
				numbers.add(stringToInt(numberStr));
			}
		}

		return numbers;
	}
	
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr (0, 1 or 2 numbers)
		if (!this.checkValidInput(numbersStr)) {
			throw new StringCalculatorException();
		}
		
		if (this.checkEmptyString(numbersStr)) {
			return 0;
		}
		
		ArrayList<Integer> numbers = this.getMaxTwoNumbersFromString(numbersStr);
			
		return numbers.stream().mapToInt(x -> x).sum();
	}
	
	public int addUnknown(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr (unknown amount of numbers)
		if (!this.checkValidInput(numbersStr)) {
			throw new StringCalculatorException();
		}
		
		if (this.checkEmptyString(numbersStr)) {
			return 0;
		}
		
		ArrayList<Integer> numbers = this.getUnknownAmountOfNumbersFromString(numbersStr);
			
		return numbers.stream().mapToInt(x -> x).sum();
	}
}
