
public class StringCalculator {
	
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		if (numbersStr.length() == 0 || numbersStr == "") {
			return 0;
		}
		
		boolean isValid = inputValidityChecker(numbersStr);
		if (isValid == true) {
			return 0;
		} else {
			int[] sumArr = sliceString(numbersStr);
			int sum = sumArr[0] + sumArr[1] + sumArr[2];
			return sum;
		}
	}
	
	public boolean inputValidityChecker(String theString) {
		boolean invalidStr = false;
		int[] arr2Check = sliceString(theString);
		if (arr2Check.length > 3 || theString.endsWith(",") || theString.endsWith("\n")) {
			//throw new StringCalculatorException();
			invalidStr = true;
		} else if (invalidStr != true){
			for (int i = 0; i < arr2Check.length; i++) {
				if (arr2Check[i] < 0) {
					//throw new StringCalculatorException();
					invalidStr = true;
				}
			}
		}
		return invalidStr;
	}
	
	public int[] sliceString(String theString) {
		String[] numbers = theString.split(",|\\n");
			int[] numArr = new int[numbers.length];
			for (int i = 0; i < numbers.length; i++) {
				numArr[i] = Integer.parseInt(numbers[i]);
			}
			return numArr;
		}
	}
