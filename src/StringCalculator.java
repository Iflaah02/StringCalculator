
public class StringCalculator {
	
	static int StringSum(String str){
		int sum = 0;
		for (int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				sum+=str.charAt(i)-"0";
			}
		}
		return sum;
		
		
		
	}
	
	
	
	
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		
		// not yet implemented
		return 0;
	}
	
	
	
		//check if the input is a number
	public void isDigit(char input) {
		if		(input == '1' ||
				input == '2' ||
				input == '3' ||
				input == '4' ||
				input == '5' ||
				input == '6' ||
				input == '7' ||
				input == '8' ||
				input == '9' ||
				input == '0')
				    return;	
	}
	
	

}
