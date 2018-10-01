
public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		int total = 0;
		int list = 0;	
		
		if (numbersStr.length()==0) {
			return 0;
		}
		else {
	
			while (list < numbersStr.length()) {				
				char character  = numbersStr.charAt(list);
				if (character !=',' && character !='\n') {
					if (Character.isDigit(character) == true) {
						total+= Character.getNumericValue(character);
					} else {
						throw new StringCalculatorException();
					}
				} else {
					if (numbersStr.length() > (list + 1) &&
						Character.isDigit(numbersStr.charAt(list + 1)) == false) {
						throw new StringCalculatorException();
					} 
				}									
				list++;
			}
			return total;
		}
	}
}
