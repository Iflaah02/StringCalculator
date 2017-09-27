import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		// Round 6: putting together the sub-methods. Returns the sum of the numbers given in numbersStr
		checkInput(numbersStr);
		String list[] = splitInputs(numbersStr);
		for (String i: list) {
			checkNumber(i);
		}
		int sum = addNumbers(list);
		return sum;
	}
	
	public String[] splitInputs(String numbers) {
		// Round 1 method: separating by ","
		String commaSplit[] = numbers.split(",");
		// Round 3: separating by "\n"
		List<String> list = new ArrayList<String>();
		for (String s: commaSplit) {
			if (s.contains("\n")) {
				String newLineSplit[] = s.split("\n");
				for (String x: newLineSplit) {				
					list.add(x);
				}
			} else {
				list.add(s);
			}
		}
		return list.toArray(new String[0]);
	}
	
	public void checkInput(String numbersStr) throws StringCalculatorException {
		// Round 4: checking for invalid string input with combinations of "\n" and ","
		if (numbersStr.contains("\n,") || numbersStr.contains(",\n") || numbersStr.contains("\n\n") || numbersStr.contains(",,") || numbersStr.endsWith(",") || numbersStr.endsWith("\n")) {
			throw new StringCalculatorException();
		} else {
			return;
		}
	}
	
	public void checkNumber(String number) throws StringCalculatorException {
		// Round 5: checking for non-numbers and negative numbers
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new StringCalculatorException();
		}
		if (Integer.parseInt(number) < 0) {
			throw new StringCalculatorException();
		}
	}
	
	public int addNumbers(String[] numbers) {
		// Round 2 method
		int sum = 0;
		for (String s: numbers) {
			sum = sum + Integer.parseInt(s);
		}
		return sum;
	}
}
