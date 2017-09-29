
public class StringCalculator {
	
	public int add(String numbersStr) throws StringCalculatorException {
		
		String[] numbers = splitInput(numbersStr);
		int sum = 0;
		
		for (int i=0; i<numbers.length; i++) {
			if (validateNumber(numbers[i])) {
				int value = transferToInt(numbers[i]);
				if (validateNonNegative(value)) {
					sum += value;
				}
			}
		}
		
		return sum;
	}

	// splits input string to separate string symbols removing breaks and commas
	public String[] splitInput(String input) throws StringCalculatorException {
	
		String nobreaks = input.replace('\n', ',');
		String[] splitted = nobreaks.split(",");
	
		for (int i=0; i<splitted.length; i++) {
			if (splitted[i].length() == 0) {
				throw new StringCalculatorException();
			}
		}

		return splitted;
	}

	// check if the element can be parse to integer
	public boolean validateNumber(String element)  throws StringCalculatorException  {
		try {
			Integer.parseInt(element);
		} catch (NumberFormatException exception) {
			throw new StringCalculatorException();
		} catch (NullPointerException exception) {
			throw new StringCalculatorException();
		}
		return true;
	}
	
	// check if the element is not negative
	public boolean validateNonNegative(int element) throws StringCalculatorException {
		if (element >= 0) {
			return true;
		} else {
			throw new StringCalculatorException();
		}
	}
	
	// transforms number in string format to int
	public int transferToInt(String string) {
		return Integer.parseInt(string);
	}
	
}
