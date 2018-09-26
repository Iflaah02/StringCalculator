
public class StringCalculator {

	// Is an integer number? Returns -1, if not
	private int parsePositiveInt(String str) throws StringCalculatorException {
		// Edge case: -0 parsed as 0
		if (str.equals("-0"))
			throw new StringCalculatorException();
		else
			try {
				int res = Integer.parseInt(str);
				if (res < 0)
					throw new StringCalculatorException();
				else
					return res;
			} catch (NumberFormatException ex) {
				return -1;
			}
	}

	// Returns the sum of the numbers given in numbersStr
	public int add(String numbersStr) throws StringCalculatorException {
		int res;
		if (numbersStr.isEmpty())
			return 0;
		else {
			res = parsePositiveInt(numbersStr);
			if (res != -1)
				//if (res < )
				return res;
			else if (numbersStr.contains("\n"))
				return handleLineBreaks(numbersStr);
			else {
				String[] numbers = numbersStr.split(",");
				if (numbers.length == 0)
					throw new StringCalculatorException();
				else if (numbers.length == 2)
					try {
						int num1, num2;
						if ((num1 = Integer.parseInt(numbers[0])) < 0)
							throw new StringCalculatorException();
						else if ((num2 = Integer.parseInt(numbers[1])) < 0)
							throw new StringCalculatorException();
						else
							return num1 + num2;
					} catch (NumberFormatException ex) {
						throw new StringCalculatorException();
					}
				else
					return addUnknownAmount(numbers);
			}
		}
	}

	// Returns the sum of the numbers given in numbersStr
	public int addUnknownAmount(String[] numbers) throws StringCalculatorException {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++)
			try {
				int n = Integer.parseInt(numbers[i]);
				if (n < 0)
					throw new StringCalculatorException();
				else sum += n; 
			} catch (NumberFormatException ex) {
				throw new StringCalculatorException();
			}
		return sum;
	}
	
	// Handle \n
	public int handleLineBreaks(String numbersStr) throws StringCalculatorException {
		String[] numbers = numbersStr.split("[,\n]");
		if (numbers.length == 0)
			throw new StringCalculatorException();
		else if (numbers.length == 2)
			try {
				int num1, num2;
				if ((num1 = Integer.parseInt(numbers[0])) < 0)
					throw new StringCalculatorException();
				else if ((num2 = Integer.parseInt(numbers[1])) < 0)
					throw new StringCalculatorException();
				else
					return num1 + num2;
			} catch (NumberFormatException ex) {
				throw new StringCalculatorException();
			}
		else
			return addUnknownAmount(numbers);
	}
}
