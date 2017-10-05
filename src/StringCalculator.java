
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		
		int result = 0;
		List<Integer> numbers = parseNumbers(numbersStr);
		//count
		for(int i = 0; i < numbers.size(); i++) {
			result = result + numbers.get(i);
		}
		return result;
	}

	private List<Integer> parseNumbers(String numbersStr) {
		List<Integer> numbers = new ArrayList<>();
		try {
		numbers = parseInput(numbersStr);
		} catch (StringCalculatorException e) {
			
		}
		return numbers;
	}
	
	public boolean hasInvalidInput(char[] charNumbers) {
		for (int i = 0 ; i < charNumbers.length; i++) {
			if (charNumbers[i] != '\n' && charNumbers[i] != ',' && !Character.isDigit(charNumbers[i])) {
				return true;
			}
		}
		return false;
	}
	
	public List<Integer> parseInput(String numbersStr) throws StringCalculatorException{
		List<Integer> numbers = new ArrayList<>();
		char[] charNumbers = numbersStr.toCharArray();
		
		
		if (hasInvalidInput(charNumbers)) {
			throw new StringCalculatorException();
		}
		
		//extract numbers from characterArray
		numbers = extractNumbers(charNumbers);
		return numbers;
	}
	
	public List<Integer> extractNumbers(char[] charNumbers){
		/*this function takes the user inputted string as characterarray and extracts all numbers in it. this integer list is then returned */
		
		List<Integer> numbers = new ArrayList<>();
		String currentNumber = new String("");
		for(int i = 0; i < charNumbers.length; i++) {
			
			if (charNumbers[i] == ',' || charNumbers[i] == '\n') {
				//check if string is empty
				if (!currentNumber.isEmpty()) {							
				//add number to array
				int currentInt = Integer.parseInt(currentNumber);
				numbers.add(currentInt);
				currentNumber = "";
				}
			} 
			else {
				currentNumber = currentNumber + charNumbers[i];
			}
			
			if (i == charNumbers.length - 1) {
				//last character, add the last number
				if (!currentNumber.isEmpty()) {
				int currentInt = Integer.parseInt(currentNumber);
				numbers.add(currentInt);		
				}
			}
		}
		return numbers;
	}
}