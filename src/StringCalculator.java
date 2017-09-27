
public class StringCalculator {
	private int sum = 0;
	private String[] arrString;
	public int add(String numbersStr) throws StringCalculatorException{
		// Returns the sum of the numbers given in numbersStr
		
		if (numbersStr.endsWith(",") || numbersStr.endsWith("\n")) throw new StringCalculatorException();
		splitString(numbersStr);
	
		for (String s : this.arrString) {
			if (!verifyString(s) || s.length() == 0) throw new StringCalculatorException();
			this.sum += Integer.parseInt(s);
		}
		return this.sum;		
	}
	
	public void splitString(String str) {
		this.arrString = str.split(",|\\n");	
	}
	
	
	public int getSum() {
		return this.sum;
	}
	
	public String[] getArrString() {
		return this.arrString;
	}
	
	public boolean verifyString(String numberStr) {
		for (char c : numberStr.toCharArray()) {
			if (!Character.isDigit(c)) return false;
		}
		return true;
	}
	
}
