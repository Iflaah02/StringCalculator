import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Refactor: Extract method

public class CalculatorUtils {

	// Beautify this class and handle errors
	public static String[] convertToNumberStringArray(String numbers) {
		
		String[] arrayOfNumbers = numbers.split("\\s*,\\s*"); 
	
		return arrayOfNumbers;
	}
	
	public static String[] removeEmptyStrings(String[] numbersArray) {
		
		List<String> myList = new ArrayList<String>(Arrays.asList(numbersArray));
		myList.remove("");
		
		String[] myStrArray = myList.toArray(new String[0]);
		
		return myStrArray;
	}
	
}
