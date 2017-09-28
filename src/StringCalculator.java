
public class StringCalculator {
	private int result;
	
	public StringCalculator () {
		result = 0;
	}
	
	private void setResult(int res) {
		result = res;
	}
	
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		int res = 0;
		if (numbersStr != "") {	
		String [] numbers = numbersStr.split(",");
			for (int i=0; i<numbers.length; i++) {
				res+= Integer.parseInt(numbers[i]);
			}
		}
		setResult(res);
		return result;
	}
}
