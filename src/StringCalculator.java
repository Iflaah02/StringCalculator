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
			
		return sumListElements(arguments);
	}
	
	private boolean hasNegatives(List<Integer> integerList) {
		for(Integer x : integerList) {
			if(x < 0) {
				return true;
			}
		}
		
		return false;
	}
	
	private Integer sumListElements(List<Integer> integerList) {
		Integer sum = 0;
		
		for(Integer x : integerList) {
			sum += x;
		}
		
		return sum;
	}
}
