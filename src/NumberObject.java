
// Refactor: Introduce Parameter Object
public class NumberObject {
	private String numbersStr;
	private int value;
	private String[] numbersArray;
	
	public NumberObject(String numbersStr) {
		this.numbersStr = numbersStr;
		this.value = 0;
		this.numbersArray = null;
	} 

	public String getNumbersStr() {
		return this.numbersStr;
	}
	
	public String[] getNumbersArray() {
		return this.numbersArray;
	}
	
	public void setNumbersArray(String[] numbersArray) {
		this.numbersArray = numbersArray;
	}

	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	// Refactor: BAD SMELL, JDEADORANT MOVED
	public boolean isNumberStrValid() {
		return getNumbersStr() != null && getNumbersStr() != "";
	}

	// Refactor: Extract method
	// Refactor: BAD SMELL, JDEADORANT MOVED
	public int calculate() throws StringCalculatorException {
		try {
			// Remove the "" from the list
			setNumbersArray(CalculatorUtils.convertToNumberStringArray(getNumbersStr()));
			setNumbersArray(CalculatorUtils.removeEmptyStrings(getNumbersArray()));
			
			int val = 0;
			for (String numberString : getNumbersArray()) {
				val += Integer.parseInt(numberString);
			}
			setValue(val);
		}
		catch (IllegalArgumentException e) {
			throw new StringCalculatorException();
		}
		return getValue();
	}

}