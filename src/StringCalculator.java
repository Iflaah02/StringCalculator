import java.util.List;

public class StringCalculator {
	
	private StringParser parser;
	
	public StringCalculator() {
		parser = new StringParser();
	}
	
	public int add(String numbersStr) throws StringCalculatorException{
		List<Integer> arguments = parser.parseIntegerList(numbersStr, ",");
		
		switch(arguments.size()) {
			case 0: return 0; 
			case 1: return arguments.get(0);
			case 2: return arguments.get(0) + arguments.get(1);
			default:
				throw new StringCalculatorException();
		}
		
	}
}
