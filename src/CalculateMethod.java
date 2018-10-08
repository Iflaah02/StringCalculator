// Refactor: Extract method

public class CalculateMethod {

	public int calculate(NumberObject numberObject) throws StringCalculatorException {
		try {
			// Remove the "" from the list
			numberObject.setNumbersArray(CalculatorUtils.convertToNumberStringArray(numberObject.getNumbersStr()));
			numberObject.setNumbersArray(CalculatorUtils.removeEmptyStrings(numberObject.getNumbersArray()));
			
			int val = 0;
			for (String numberString : numberObject.getNumbersArray()) {
				val += Integer.parseInt(numberString);
			}
			numberObject.setValue(val);
		}
		catch (IllegalArgumentException e) {
			throw new StringCalculatorException();
		}
		return numberObject.getValue();
	}

}