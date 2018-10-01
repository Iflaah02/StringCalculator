
public class StringCalculator {
	
	
	public int add(String numbersStr) throws StringCalculatorException  {
		// Returns the sum of the numbers given in numbersStr
		int sum = 0;
		int[] numberArray = new int[3];
		
		if(!numbersStr.isEmpty()) {
			
			numberArray = splitInput(numbersStr);
			for(int i = 0; i < numberArray.length; i++) {
				if(numberArray[i] >= 0) {
					testOfValue(numberArray[i]);
					sum += numberArray[i];
				} else throw new StringCalculatorException();
			}
		}
		

		return sum;
	}
	
	private int[] splitInput(String numbersToSplit) {
		String [] numbers;
		int[] sum = new int[3];
		numbers = numbersToSplit.split("[,|\n]");
		if(testOfLength(numbers))		{
			for(int i = 0; i < numbers.length; i++) {				
					sum[i] = Integer.parseInt(numbers[i]);				
			}
		}
		
		return sum; 
	}
	
	private boolean testOfLength(String[] testString) {
		boolean test;
		if(testString.length >= 0 && testString.length < 3) {
			test = true;
		} else test = false;
		return test;
	}
	
	private boolean testOfValue(int value) throws StringCalculatorException {
		boolean test;
		if(value < 0) {
			 test = true;
		} else throw new StringCalculatorException();
		return test;
	}

}
