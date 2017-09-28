import java.util.Arrays;

public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {	
		int total = 0;
		boolean	checkForbidden = checkString(numbersStr);
		boolean	checkNumberAmount = false;
		
		
		if (checkForbidden) {
			throw new StringCalculatorException();
		}
		else {

		int[] numberArrays = processNumber(numbersStr);	
		
		checkNumberAmount = checkAmount(numberArrays);
		if (checkNumberAmount) {
			throw new StringCalculatorException();
		}
		else {
		total = calculateSum(numberArrays);
		}
		}
		return total;
	}
	public int[] processNumber(String stringNumber) {
		String[] numbers = stringNumber.split("\\/n+|,+");
		int[] intNumber = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();
		return intNumber;
	}
	
	public int calculateSum(int[] numbers) {		
		int total = 0;
		for(int i=0;i<numbers.length;i++) {
			total+=numbers[i];
		}
		return total;
	}
	public boolean checkString(String numberString){
		boolean check = numberString.contains("-") || numberString.contains("[ABCDEFGHJKLMOPQRSTUWYZ]+") || numberString.matches(",/n");
		return check;
	}
	public boolean checkAmount(int[] numbers){
		boolean check = numbers.length>20;
		return check;
	}
}

