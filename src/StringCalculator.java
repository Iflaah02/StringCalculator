import java.util.Arrays;
import java.util.List;

public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		int sum = 0;
		
		if(verifyString(numbersStr)) {
			List<String> numberList = Arrays.asList(numbersStr.split(",|\\n"));
			for(int i=0; i < numberList.size(); i++) {
				if(Integer.parseInt(numberList.get(i)) < 0) {
					throw new StringCalculatorException();
				}
			}
			for(int i=0; i < numberList.size(); i++) {
				sum = sum + Integer.parseInt(numberList.get(i));
			}
			return sum;
		}else if(numbersStr.length() == 0) {
			return 0;
		}else {
			throw new StringCalculatorException();
		}
	}
	
	boolean verifyString(String stringToVerify) {
		boolean isValid = true;
		
		if(stringToVerify.length() == 0) {
			isValid = false;
		}else {
			List<String> stringList = Arrays.asList(stringToVerify.split(",|\\n"));
			boolean notANumber = false;
			
			for(int i=0; i < stringList.size(); i++) {
				if(notANumber == true) {
					break;
				}else if(stringList.get(i).length() == 0) {
					notANumber = true;
					break;
				}
				for(int j=0; j < stringList.get(i).length(); j++) {
					if(Character.digit(stringList.get(i).charAt(j), 10) == -1) {
						notANumber = true;
						break;
					}
				}
			}
			
			if(notANumber == true) {
				isValid = false;
			}else {
				isValid = true;
			}
		}
		return isValid;
	}
}
