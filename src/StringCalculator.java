// There didn't appear to be an opportunity to introduce a parameter object due
// to a lack of multiparameter methods
public class StringCalculator {
	
	private String string; 
	
	public int add(String numbersStr) throws StringCalculatorException {
		
		string = numbersStr;
		
		String[] numbers = StringCalculationParser.splitByCommasOrNewlines(string);
		
		int result = 0;
		
		for(String number : numbers) {
			
			result += StringCalculationParser.validateNumber(number);
			
		}
	
		return result;
	}
	
	public String getString() {
		return string;
	}
	
}
