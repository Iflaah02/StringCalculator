import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		ArrayList<String> stringArray = new ArrayList<String>();
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
		int result; 
		
		stringArray = getArrayFromString(numbersStr); 
		try {
			integerArray = convertArrayList(stringArray);
		} catch (StringCalculatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		result = calculateSum(integerArray);
		
		// not yet implemented
		return result;
	}
	
	public ArrayList<String> getArrayFromString(String numbersStr){ 
		
		if(numbersStr == "")
			return new ArrayList<String>(Arrays.asList("0")); 
		
		String[] numbers = numbersStr.split(",|\\n", -1); 
		ArrayList<String> stringArray = new ArrayList<String>(Arrays.asList(numbers)); 
		
		return stringArray; 
	}
	
	public ArrayList<Integer> convertArrayList(ArrayList<String> stringArray) throws StringCalculatorException{
		
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
		
		boolean numeric = true;
		int number = 0; 
		
		for(String stringValue : stringArray) {
			
			try {
				number = Integer.parseInt(stringValue); 
				integerArray.add(number); 
			}catch(Exception e) {
				numeric = false; 
			}
			
			if(numeric == false) {
				throw new StringCalculatorException(); 
			}else if(number < 0) {
				throw new StringCalculatorException(); 
			}
			
		}
		
		return integerArray; 
	}
	
	public int calculateSum(ArrayList<Integer> integerArray) {
		
		int sum = 0; 
		
		for(int number : integerArray) {
			sum += number; 
		}
		return sum; 
	}
	
	
}
