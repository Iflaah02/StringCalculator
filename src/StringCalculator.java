import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Implement a simple String calculator with a method int Add(string numbers)
1. The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will
return 0) for example “” or “1” or “1,2”
2. Add method to handle an unknown amount of numbers
3. Add method to handle new lines between numbers (instead of commas).
1. the following input is ok: “1\n2,3” (will equal 6)
2. the following input is NOT ok: “1,\n”
4. Calling Add with a negative numbers or invalid input (not numbers) will throw an
StringCalculatorException
*/

public class StringCalculator {
	// Main function
	public int add(String numbersStr) throws StringCalculatorException {
		
		int val = 0;
		if (numbersStr != null && numbersStr != "") {			
			try {
				// Remove the "" from the list
				String[] numbersArray = convertToNumberStringArray(numbersStr);
				numbersArray = removeEmptyStrings(numbersArray);
			
				for (String numberString : numbersArray) {
					val += Integer.parseInt(numberString);
				}
			}
			catch (IllegalArgumentException e) {
				throw new StringCalculatorException();
			}
		}
		return val;
	}
	
	// Beautify this class and handle errors
	public String[] convertToNumberStringArray(String numbers) {
		
		String[] arrayOfNumbers = numbers.split("\\s*,\\s*"); 
	
		return arrayOfNumbers;
	}
	
	public String[] removeEmptyStrings(String[] numbersArray) {
		
		List<String> myList = new ArrayList<String>(Arrays.asList(numbersArray));
		myList.remove("");
		
		String[] myStrArray = myList.toArray(new String[0]);
		
		return myStrArray;
	}
}
