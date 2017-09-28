
public class StringCalculator {
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		if (numbersStr.length() == 0 || numbersStr == "") {
			return 0;
		}
		
		inputValidityChecker(numbersStr);
		int[] sumArr = sliceString(numbersStr);
		
		int sum = sumArr[0] + sumArr[1] + sumArr[2];
		return sum;
	}
	
	public void inputValidityChecker(String theString) {
		if (theString.endsWith(",") || theString.endsWith("\n")) {
			//throw new StringCalculatorException();
		}
		
		int[] arr2Check = sliceString(theString);
		
		for (int i = 0; i < arr2Check.length; i++) {
			if (arr2Check[i] < 0) {
				//throw new StringCalculatorException();
			}
		}
	}
	
	public int[] sliceString(String theString) {
		String[] numbers = theString.split(",|\\n");
		if (numbers.length > 3) {
			//throw new StringCalculatorException();
		} else {
			int[] numArr = new int[numbers.length];
			for (int i = 0; i < numbers.length; i++) {
				numArr[i] = Integer.parseInt(numbers[i]);
			}
			return numArr;
			}
		}
	}
