
public class StringCalculator {
	private int result;
	
	public StringCalculator () {
		result = 0;
	}
	
	private void setResult(int res) {
		result = res;
	}
	
	public int add(String numbersStr) throws StringCalculatorException  {
		// Returns the sum of the numbers given in numbersStr
		int res = 0;
		if (numbersStr.matches("([0-9]+((,|\\n)[0-9]+)*)*")) { // Input is matching
			if (numbersStr != "") {	
				String [] numbers = numbersStr.split(",");
					for (int i=0; i<numbers.length; i++) {
						if (numbers[i].contains("\n")) {
							String [] numbersEndl = numbers[i].split("\n");
							for (int j=0; j<numbersEndl.length; j++) {
								res+=Integer.parseInt(numbersEndl[j]);
							}
						} else {
							res+= Integer.parseInt(numbers[i]);					
						}
					}
				}
				setResult(res);
				return result;
		} else {
			throw new StringCalculatorException();
		}
	}
}
