
public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		
		String[] parts = separateNumbers(numbersStr);
		
		int sum = 0;
		
		for (int i=0; i<parts.length; ++i) {
			if (validateSubstring(parts[i])) {
				int value = intFromString(parts[i]);
				throwOnNegative(value);
				sum += value;
			}
		}
		
		return sum;
	}

	
	public boolean validateSubstring(String substring) {
		try {
			Integer.parseInt(substring);
		} catch (NumberFormatException exception) {
			return false;
		} catch (NullPointerException exception) {
			return false;
		}
		return true;
	}
	
	public int intFromString(String str) {
		if (validateSubstring(str)) {
			return Integer.parseInt(str);
		} else {
			return 0;
		}
	}
	
	public void throwOnNegative(int checkNegative) throws StringCalculatorException {
		if (checkNegative < 0) {
			throw new StringCalculatorException();
		}
	}
	
	public String[] separateNumbers(String str) throws StringCalculatorException {
		
		String commaStr = str.replace('\n', ',');
		String[] commaSplit = commaStr.split(",");
		
		for (int j=0; j<commaSplit.length; ++j) {
			if (commaSplit[j].length() == 0) {
				throw new StringCalculatorException();
			}
		}

		return commaSplit;
		
	}
	
	
}
