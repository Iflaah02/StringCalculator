import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	private
	int sum = 0;
	
	public String trimInput(String inputString) {
		return inputString.replace("\n", "").trim();
	}
	
	public String[] splitInput(String inputString) {
		return inputString.split(",");
	}
	
	public ArrayList convertToIntegerArray(String[] InputArray) throws StringCalculatorException {

		ArrayList numbers = new ArrayList();
		
		for(int i=0; i < InputArray.length; i++) {
			int number = 0;
			System.out.println("Checking if '" + InputArray[i] + "' is number");
			
			try {
				number = Integer.parseInt(InputArray[i]);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				throw new StringCalculatorException();
			}
			finally {
				System.out.println("Adding number to array");
				numbers.add(number);
				System.out.println(number);
			}
		}
		
		return numbers;
	}
	
	public int[] numberArrayListToList(ArrayList InputArrayList) {
		
		int array_size = InputArrayList.size();
		int[] numberArray = new int[array_size];
		for (int j=0; j < array_size; j++) {
			numberArray[j] = (int) InputArrayList.get(j);
		}
		
		return numberArray;
	}
	
	public int calculateSum(int[] numbers) {
		System.out.println("Calculating the sum");
		for ( Integer value: numbers) {
			System.out.println(sum + " = " + sum + " + " + value);
			sum = sum + value;
		}
		return sum;
	}
	
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		
		String numberStringTrimmed = trimInput(numbersStr);
		String[] numberStringArray = splitInput(numberStringTrimmed);
		
		ArrayList numberArrayList = convertToIntegerArray(numberStringArray);
		
		int[] numberArray = numberArrayListToList(numberArrayList);
		
		return calculateSum(numberArray);
		
		
		
		
	}
}
