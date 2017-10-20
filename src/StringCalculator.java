import java.util.Arrays;

public class StringCalculator {
	
	private int firstNumber;
	private int secondNumber;
	
	public int add(String numbersStr) throws StringCalculatorException{
		// Returns the sum of the numbers given in numbersStr
		if (!numbersStr.isEmpty()){
			try {
				String [] strValues = parseString(numbersStr);
				if  (strValues.length == 1) {
					firstNumber = Integer.parseInt(strValues[0]);
					return firstNumber;
				} else if (strValues.length == 2) {
					firstNumber = Integer.parseInt(strValues[0]);
					secondNumber = Integer.parseInt(strValues[1]);
					return firstNumber + secondNumber;
				} else if (strValues.length > 2) {
					int [] numValues = parseStringToNumbers(strValues);
					int result = 0;
					for (int i = 0; i < numValues.length; i++) {
						result += numValues[i];
					}
					return result;
				}
			} catch (NumberFormatException e) {
				throw new StringCalculatorException();
			}
			
		}
		return 0;
	}

	private int[] parseStringToNumbers(String [] stringArray) throws StringCalculatorException{
		int [] numbers = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			//if (numbers [i] >= 0) {
			numbers [i] = Integer.parseInt(stringArray[i]);
			//}
			//else 
				//throw new StringCalculatorException();
		}
		return numbers;
	}
	
	private String [] parseString(String string) throws StringCalculatorException {
		String [] values;
		values = string.split("(,)|(\n)");
		boolean stringIsValid = false;
		for (int i = 0; i < values.length; i++) {
			if (values[i].matches("^[0-9]+$")) {
				stringIsValid = true;
			} else {
				stringIsValid = false;
				break;
			}
		}
		if (!stringIsValid)
			throw new StringCalculatorException();
		else 
			return values;
	}

}
