import java.util.ArrayList;

/**/

public class StringCalculator {
	
	public static int splitLength;
	public static int lengthNumbers;
	
	
	// Refactoring: Make Method shorter and Extract class and Introduce Parameter Object (DataSum)
	// Befor:
	/* public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
			
		num = new ArrayList<String>();
		newError(numbersStr);
		numbers = getStringContent(numbersStr);
		newLines();	
		initializeSumOfNumbers(numbersStr);		
		int sum = sumOfNumbers();
		System.out.println(sum);
		return sum;*/

	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr	
		ArrayList <String>num = new ArrayList<String>();
		DataSum dataSum = new DataSum(num,numbersStr);
		return getSum(dataSum);
	}
	
	private int getSum(DataSum dataSum) throws StringCalculatorException {
		CalculateSum calculateSum = new CalculateSum();		
		initializeSumOfNumbers(dataSum);		
		int sum = calculateSum.sumOfNumbers(dataSum.getNum());
		System.out.println(sum);
		return sum;
	}
	
	private void initializeSumOfNumbers(DataSum dataSum) throws StringCalculatorException {				
		newError(dataSum.getNumbersStr());		
		newLines(dataSum.getNum(), getStringContent(dataSum.getNumbersStr()));		
	}

	public String[] getStringContent(String numbersStr) {
		String[] split = numbersStr.split(",");
		splitLength = split.length;
		return split;
	}
	
	
	//Refactoring: Extract class
	/*public int sumOfNumbers() throws StringCalculatorException {
		int sum = 0;
		try {
			for (int i = 0; i < num.size(); i++) {
				sum = sum + Integer.parseInt(num.get(i));
			}
		} catch (NumberFormatException ex) {
			if (num.get(0) == "") {
				sum = 0;
			} else {
				throw new StringCalculatorException();
			}
		}
		return sum;
	}*/

	public void newLines(ArrayList<String>num, String[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			String split[] = numbers[i].split("\n");
			if (split.length == 2) {
				num.add(split[0]);
				num.add(split[1]);
			} else {
				num.add(split[0]);
			}
		}
		lengthNumbers = num.size();
	}
	
	// Refactoring: Consolidate Conditionals
	//Old code:
	/*public void newError(String numbersStr) throws StringCalculatorException {
		if (numbersStr.contains(",\n")) {
			throw new StringCalculatorException();
		}
		if (numbersStr.contains("-")) {
			throw new StringCalculatorException();
		}

	}*/
	public void newError(String numbersStr) throws StringCalculatorException {
		if (numbersStr.contains(",\n")||numbersStr.contains("-")) {
			throw new StringCalculatorException();
		}		
	}
}
