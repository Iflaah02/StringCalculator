
public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		
		if (numbersStr.length() == 0) {
			return 0;
		}
		
		int sum = 0;
		int index = 0;
				
		while (index < numbersStr.length()) {
			
			char character  = numbersStr.charAt(index);
				
			if (character != ',' && character != '\n') {
				if (Character.isDigit(character) == false) {
					throw new StringCalculatorException();
				} else {
					sum+= Character.getNumericValue(character);
				}
			} else {
				if ((index + 1) < numbersStr.length() &&
					Character.isDigit(numbersStr.charAt(index + 1)) == false) {
					throw new StringCalculatorException();
				} 
			}
								
			index++;
		}
		
		return sum;
	}
}
