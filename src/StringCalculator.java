import java.util.*;

public class StringCalculator {
	
	public StringCalculator() {}
	
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		int result = 0;
		
		try {
			String[] words = explode_newLineOrCommas(numbersStr);
			
			int[] numbers = convertStringArrayToIntArray(words);
			
			result = arrayAdd(numbers);
		}
		catch (Exception e) {
			throw new StringCalculatorException();
		}
			
		return result;
	}
	
	public boolean isNumber(char c) {
		// checks if a character is a number
		boolean res = false;
		char[] numbers = {'1','2','3','4','5','6','7','8','9','0'};
		for(char i : numbers) {
			if (i == c) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	public String[] explode_onlyCommas(String numbersStr) throws IllegalArgumentException {
		// return an int array, the numbers contained into the input string.
		String[] result = {};
		result = numbersStr.split(",");
		for (String i : result) {
			if(!isNumber(i.charAt(0))){
				throw new IllegalArgumentException();
			}
		}
		return result;
	}
	
	public String[] explode_newLineOrCommas(String numbersStr) throws IllegalArgumentException {
		// return an int array, the numbers contained into the input string.
		String[] result = {};
		result = numbersStr.split(",|\\n");
		for (String i : result) {
			if(!isNumber(i.charAt(0))){
				throw new IllegalArgumentException();
			}
		}
		return result;
	}
	
	// This was not part of the assignment. I misunderstood task 3.
	public String[] explode_anySeparator(String numbersStr) throws IllegalArgumentException {
		// return an int array, the numbers contained into the input string.
		String[] result = {};
		String temp = "";
		List<String> wordList = new LinkedList<String>();
		boolean alreadyASeparator = false;
		
		for (int i = 0; i < numbersStr.length(); i++) {
			char theChar = numbersStr.charAt(i);
			if(!isNumber(theChar)) {
				if(alreadyASeparator) {
					throw new IllegalArgumentException();
				}
				else {
					if (temp != "") {
						wordList.add(temp);
						temp = "";
						alreadyASeparator = true;
					}
				}
			}
			else {
				alreadyASeparator = false;
				if (temp != "") {
					temp = temp + theChar;
				}
				else {
					temp = "" + theChar;
				}
			}
		}
		if (temp != "") {
			wordList.add(temp);  // necessary to empty one last time tmp
		}
		result = (String[]) wordList.toArray(new String[0]);
		return result;
	}
	
	public int[] convertStringArrayToIntArray(String[] words) {
		// converts all characters from a string array to their int value
		int[] result = new int[words.length];
		
		for(int i = 0; i<words.length; i++) {
			result[i] = (Integer.parseInt(words[i]));
		}
		
		return result;
	}
	
	public int arrayAdd(int[] numbers) {
		// return the sum of all numbers from an array of int
		int result = 0;
		
		for(int i = 0; i<numbers.length; i++) {
			result += numbers[i];
		}
		
		return result;
	}

}