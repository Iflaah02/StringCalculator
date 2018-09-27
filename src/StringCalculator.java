
public class StringCalculator {
	public int add(String numberStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		int sum = 0;
		int numbers[];
		int len = numberStr.length();
		boolean lineBreak = false;
		
		for(int i = 0; i < len; i++) {
			if(numberStr.charAt(i) == '\n') {
				lineBreak = true;
			}
		}
		
		if(lineBreak) {
			String handled[] = handleRowChange(numberStr);
			int handledLen = handled.length;
			for(int i = 0; i < handledLen; i++){
				String temp = handled[i];
				int tempNum[] = parseString(temp);
				int numLen = tempNum.length;
				for(int k = 0; k < numLen; k++) {
					sum = sum + tempNum[k];
				}
			}
			return sum;
		}else{
			numbers = parseString(numberStr);
			int numLen = numbers.length;
			for(int i = 0; i < numLen; i++) {
				sum = sum + numbers[i];
			}
			return sum;
		}
		
		
		// not yet implemented
	}
	
	public int[] toIntArray(String numberStr) throws StringCalculatorException{
		String[] numberStrArray = numberStr.split(",");
		int len = numberStrArray.length;
		int[] numbers = new int[len];
		for(int i = 0; i < len; i++) {
			numbers[i] = Integer.parseInt(numberStrArray[i]);
			if(numbers[i] < 0) {
				throw new StringCalculatorException();
			}
		}
		int numLen = numbers.length;
		if(numLen > 2) {
			throw new StringCalculatorException();
		}
		return numbers;
	}
	
	public int[] parseString(String numberStr) throws StringCalculatorException{
		
		if(numberStr == null || numberStr.isEmpty()) {
			int numbers[] = {0};
			return numbers;
		}
		
		if(!Character.isDigit(numberStr.charAt(0))) {
			throw new StringCalculatorException();
			}
		
		for(int i = 0; i < numberStr.length(); i++) {
			if(Character.isAlphabetic(numberStr.charAt(i))) {
				throw new StringCalculatorException();
			}
		}
		
		int numbers[] = toIntArray(numberStr);
 		return numbers;
	}
	
	public String[] handleRowChange(String numberStr) throws StringCalculatorException{
		
		String numberStrArray[] = numberStr.split("\\n");
		int len = numberStrArray.length;
		for(int i = 0; i < len; i++) {
			String temp = numberStrArray[i];
			int tempLength = temp.length();
			if(temp.charAt(tempLength-1) == ',') {
				throw new StringCalculatorException();
			}
		}
		return numberStrArray;
	}
}