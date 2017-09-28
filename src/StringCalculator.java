import java.util.List;

public class StringCalculator {
	
	private static String SEPARATOR; 
	private static String[] VALID_SEP_CHARACTERS;
	private StringParser parser;
	
	public StringCalculator() {
		parser = new StringParser();
		SEPARATOR = ",";
		
		String lineSeparator = System.getProperty("line.separator");
		VALID_SEP_CHARACTERS = new String[] {",", lineSeparator};
	}
	
	public int add(String numbersStr) throws StringCalculatorException {
		numbersStr = preprocess(numbersStr);
		
		List<Integer> arguments = parser.parseIntegerList(numbersStr, SEPARATOR);
		
		if(hasNegatives(arguments)) {
			throw new StringCalculatorException();
		}
			
		return sumListElements(arguments);
	}
	
	private String preprocess(String string) {
		for(String sep : VALID_SEP_CHARACTERS) {
			string = string.replace(sep, SEPARATOR);
		}
		
		return string;
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
