import static org.junit.Assert.fail;

public class StringCalculator {

	public int add(String numbersStr) throws StringCalculatorException {

		int sum = (numbersStr == "") ? 0 : calculateSum(numbersStr);
		return sum;
	}

	private int calculateSum(String numbersStr) throws StringCalculatorException {

		int sum = 0;

		String number[] = numbersStr.split("[, || \\n]");
		checkInputLimit(number.length);

			for (int i = 0; i < number.length || i == 0; i++) {
				int value = stringToNumber(number[i]);
				sum += value;	
		}
			
		return sum;
	}

	private void checkInputLimit(int length) throws StringCalculatorException {
		if (length > 2) {
			throw new StringCalculatorException();
		}
	}

	private int stringToNumber(String number) throws StringCalculatorException {
		int value = 0;
		try {
			value = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new StringCalculatorException();
		}
		return value;
	}

}
