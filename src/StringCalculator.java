import java.util.ArrayList;

public class StringCalculator {
	private static String[] numbers;
	public static int splitLength;
	public static int lengthNumbers;
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		
		
		numbers=getStringContent(numbersStr);
		
		//testLength(numbers);
		
		
		
		
		
		
		// not yet implemented
		return 0;
	}
	
	private String[] getStringContent(String numbersStr) {			
		
		String[]split = numbersStr.split(",");
		splitLength = split.length;
		
		return split;
	}
	
	/*private void testLength(String[]split) throws StringCalculatorException {
		if (split.length >2) {
			throw new StringCalculatorException();
		}
	}*/
	
	public int sumOfNumbers() {
		//Integer[] intNumber = new Integer[numbers.length];
		int sum =0;
		
		for (int i=0; i<numbers.length;i++) {
			//intNumber[i]=Integer.parseInt(numbers[i]);
			sum = sum + Integer.parseInt(numbers[i]);
		}
		
		return sum;
	}
	
	public void newLines () {
		ArrayList num =new ArrayList();
		for (int i=0; i<numbers.length;i++) {
			//intNumber[i]=Integer.parseInt(numbers[i]);
			String split[]=numbers[i].split("\n");
			if (split.length==2) {
				num.add(split[0]);
				num.add(split[1]);
			} else {
				num.add(split[0]);
			}			
			
		}		
		lengthNumbers = num.size();
		
	} 
	
	public void newLinesError(String numbersStr) throws StringCalculatorException {
		if (numbersStr.contains(",\n")) {
			throw new StringCalculatorException();
			
		}
	}
	
	
}
