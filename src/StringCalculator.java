import java.util.List;

public class StringCalculator {
	
	private StringParser parser;
	
	public StringCalculator() {
		parser = new StringParser();
	}
	
	public int add(String numbersStr) throws StringCalculatorException{
		List<Integer> arguments = parser.parseIntegerList(numbersStr, ",");
		
		if(hasNegatives(arguments)) {
			throw new StringCalculatorException();
		}
			
		switch(arguments.size()) {
			case 0: return 0; 
			case 1: return arguments.get(0);
			case 2: return arguments.get(0) + arguments.get(1);
			default:
				throw new StringCalculatorException();
		}
		
	}
	
	private boolean hasNegatives(List<Integer> integerList) {
		for(Integer x : integerList) {
			if(x < 0) {
				return true;
			}
		}
		
		return false;
	}
}
