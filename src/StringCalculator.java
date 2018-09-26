
public class StringCalculator{
	
	public int add(String numbersStr) throws StringCalculatorException{
		int returnednumber = 0;
		char lastchar = 'a';
		
		if(numbersStr.isEmpty()) {
			returnednumber = 0;
		}else {
			for(int i = 0; i < numbersStr.length(); i++) {
				if(Character.isDigit(numbersStr.charAt(i)) ) {
					if(Character.isDigit(lastchar)) {
						throw new StringCalculatorException();
					}else {
						returnednumber = returnednumber + Character.getNumericValue(numbersStr.charAt(i));
					}
				}else if(numbersStr.charAt(i) == ',' || numbersStr.charAt(i) == '\n'){
					if(lastchar == ',' || lastchar == '\n'){
						throw new StringCalculatorException();
					}
				}else {
					throw new StringCalculatorException();
				}
				lastchar = numbersStr.charAt(i);
			}
		}

		return returnednumber;
	}
}
