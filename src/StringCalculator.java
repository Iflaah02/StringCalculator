/* 1. The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will 
return 0) for example “” or “1” or “1,2” 
2. Add method to handle an unknown amount of numbers 
3. Add method to handle new lines between numbers (instead of commas). 
1. the following input is ok: “1\n2,3” (will equal 6) 
2. the following input is NOT ok: “1,\n” 
4. Calling Add with a negative numbers or invalid input (not numbers) will throw an 
StringCalculatorException*/

//1. Method retrieving the input
//2. Method to verify the input
//3. Method to split the input string
//4. Method which sums up the digits in a string
//5. Add method to perform the calculation
import java.util.*;

public class StringCalculator {
	
	int sumNumbers;
	String numberStr;
	
	public StringCalculator() {
		this.sumNumbers = 0;
		this.numberStr = null;
	}
	
	
	//4. Method which sums up the digits in a string	
	public int add(String numbersStr) {
		
		try {
				if(verificationInput(numbersStr)==false) {
					throw new StringCalculatorException();
				}
		}
		catch (StringCalculatorException e) {
		    System.err.println("Invalid input");
		}
		
		int tempSum = 0;
	    ArrayList<Integer> numbersToAdd = splitInput(numbersStr);
		// Returns the sum of the numbers given in numbersStr
		if(numbersToAdd.isEmpty()) {
			return 0;
		}
		else {
			for(int i = 0; i < numbersToAdd.size();i++) {
				tempSum = tempSum + numbersToAdd.get(i);
			}
			return tempSum;
		}
	}


	//1. Method retrieving the input
	
	public String retrieveInput() {
		
		System.out.println("Enter you numbers which should be sumed up sperated with a \",\" : ");
		Scanner reader = new Scanner(System.in);
		String line = reader.nextLine();
		return line;
	}
	
	
	//2. Method for verification of input
	public boolean verificationInput (String numberStr) {
		Integer counter = 0;
		if(numberStr == null || numberStr == "") {
			return true;
		}
		else {
			for(int i = 0; i < numberStr.length(); i++) {
				char tempChar = numberStr.charAt(i);
				if(!Character.isDigit(tempChar) && !(tempChar == ',')){
					counter++;
				}
				//last char should be a digit
				if(i == numberStr.length()-1) {
					if(!Character.isDigit(tempChar)) {
						counter++;
					}
				}
			}
		}
		if(counter > 0) {
			return false;
		}else {
			return true;
		}
	}
	
	//3. Method to split the input string
	public ArrayList<Integer> splitInput (String numberStr) {
	    ArrayList<Integer> numbers = new ArrayList<Integer>();
	    
		if(numberStr == null || numberStr == "") {
			return numbers;
		}
		List<String> n = Arrays.asList(numberStr.split("\\s*,\\s*"));
		for(String s : n) numbers.add(Integer.valueOf(s));
		
		return numbers;
	}
	
}



