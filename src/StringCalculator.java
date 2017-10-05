
public class StringCalculator {

	public int add(String numbersStr) throws StringCalculatorException {
		int sum = (numbersStr == "") ? 0 : calculateSum(numbersStr);
		return sum;
	}

	private void validateLength(int length) throws StringCalculatorException {
		if (length > 2) {
			throw new StringCalculatorException();
		}
	}

	private int validateNumber(String number) throws StringCalculatorException {
		int value = 0;
		try {
			value = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new StringCalculatorException();
		}
		return value;
	}

	private String[] splitNumbers(String numberString) throws StringCalculatorException {
		String numbers[] = numberString.split("[, || \\n]");
		return numbers;
	}

	private int stringToNumber(String numberString) throws StringCalculatorException {
		int number = validateNumber(numberString);
		return number;
	}

	private int sumUpArray(String[] numberArray) throws StringCalculatorException {
		int sum = 0;
		for (int i = 0; i < numberArray.length || i == 0; i++) {
			int value = stringToNumber(numberArray[i]);
			sum += value;
		}
		return sum;
	}

	private int calculateSum(String numbersStr) throws StringCalculatorException {
		String numbers[] = splitNumbers(numbersStr);
		validateLength(numbers.length);
		int sum = sumUpArray(numbers);
		return sum;
	}
}
