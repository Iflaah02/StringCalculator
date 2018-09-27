import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		
		//get the numbers
		ArrayList<Integer> intArray = getArrayInteger(numbersStr);
		
		//get the sum
		int result = calculateSum(intArray);
		
		return result;
	}
	//I would normally make all these methods private, but they are public here so I can test each one indicidually.
	public ArrayList<Integer> getArrayInteger(String str) throws StringCalculatorException {
		//check the length of string is not 0
		if (str.length() == 0 ) {
			Integer[] zero = new Integer[] {0};
			return new ArrayList<Integer>(Arrays.asList(zero));
		}
		
		//split with comma or newline
		String[] splitedStr = str.split(",|\\n", -1);
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		int temp;
		for (int i=0;i<splitedStr.length;i++) {
			try {
				temp = Integer.parseInt(splitedStr[i]);
			} catch(NumberFormatException e) {
				throw new StringCalculatorException();
			}
			if (temp < 0) {
				//negative number
				throw new StringCalculatorException();
			}
			else {
				intArray.add(temp);
			}
		}
		return intArray;
	}
	
	public int calculateSum(ArrayList<Integer> intArray) {
		int result = 0;
		for (int i=0; i<intArray.size(); i++) {
			result += intArray.get(i);
		}
		return result;
	}
}
