import java.util.*;

public class StringCalculator {
	
	//1. Method retrieving the input
	//2. Method to verify the input
	//3. Method to split the input string
	//4. Method which sums up the digits
	//5. Add method to perform the calculation
	//6. Add exception class and throw exception
	//7. Todo: handle new lines between numbers (instead of commas)
	
	int sumNumbers;
	String numberStr;
	
	public StringCalculator() {
		this.sumNumbers = 0;
		this.numberStr = null;
	}
	
	//4. Method which sums up the digits
	public int sumDigits (ArrayList<Integer> numbers){
		int tempSum = 0;
	    ArrayList<Integer> numbersToAdd = numbers;
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
	
	//5. Add method to perform the calculation
	public int add(String numbersStr) throws StringCalculatorException {

	//Add Exception
		if(!verificationInput(numbersStr)) {
			throw new StringCalculatorException("Invalid Values");
		}
		else{
			ArrayList<Integer> numbers = splitInput(numbersStr);
			int addedValues = sumDigits(numbers);
			return addedValues;				
		}

	}


	//1. Method retrieving the input
	
	public String retrieveInput() {
		
		//System.out.println("Enter you numbers which should be sumed up sperated with a \",\" : ");
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



