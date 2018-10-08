
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

}