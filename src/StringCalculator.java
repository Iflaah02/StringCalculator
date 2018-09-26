
public class StringCalculator {
	
	
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		boolean lengthCheck = checkLength(numbersStr);
		int sum = 0;
		if (lengthCheck = true) {
			String[] strArray = numbersStr.split(",|\\\n");
			int[] intArray = new int[strArray.length];
			for(int i = 0; i < strArray.length; i++) {
			    intArray[i] = Integer.parseInt(strArray[i]);
			}
			
			for (int j = 0; j < strArray.length; j++ ) {
				sum = sum + intArray[j];
			}
		} 
		// not yet implemented
		return sum;
	}
	
	public boolean checkLength (String numbersStr) {
		int stringLength = numbersStr.length();
		
		if (stringLength <= 0) {
			return false;
		} else {
			String[] strArray = numbersStr.split(",|\\\n");
			int[] intArray = new int[strArray.length];
			for(int i = 0; i < strArray.length; i++) {
			    intArray[i] = Integer.parseInt(strArray[i]);
			}
			if (strArray.length > 1) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkInput (String numbersStr) {
		String[] strArray = numbersStr.split(",|\\\n");
		
		if (numbersStr.matches("^[0-9,\n]+$")) {
			return true;
		} 
		
		return false;
	}
	
}
