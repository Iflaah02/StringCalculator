import java.util.ArrayList;

/**/

public class StringCalculator {
	private static String[] numbers;
	public static int splitLength;
	public static int lengthNumbers;
	public static ArrayList<String> num;

	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		num = new ArrayList<String>();
		newError(numbersStr);
		numbers = getStringContent(numbersStr);
		newLines();
		int sum = sumOfNumbers();
		System.out.println(sum);

		return sum;
	}

	public String[] getStringContent(String numbersStr) {

		String[] split = numbersStr.split(",");
		splitLength = split.length;
		return split;
	}

	public int sumOfNumbers() throws StringCalculatorException {
		int sum = 0;
		try {

			for (int i = 0; i < num.size(); i++) {
				sum = sum + Integer.parseInt(num.get(i));
			}
		} catch (NumberFormatException ex) {
			if (num.get(0) == "") {
				sum = 0;
			} else {
				throw new StringCalculatorException();
			}

		}

		return sum;
	}

	public void newLines() {
		for (int i = 0; i < numbers.length; i++) {
			String split[] = numbers[i].split("\n");
			if (split.length == 2) {
				num.add(split[0]);
				num.add(split[1]);
			} else {
				num.add(split[0]);
			}
		}
		lengthNumbers = num.size();

	}

	public void newError(String numbersStr) throws StringCalculatorException {
		if (numbersStr.contains(",\n")) {
			throw new StringCalculatorException();
		}
		if (numbersStr.contains("-")) {
			throw new StringCalculatorException();
		}

	}

}
