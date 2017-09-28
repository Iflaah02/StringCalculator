import java.util.List;

public class StringCalculator {
	
	private static char SEPARATOR; 
	private static String SEPARATOR_STRING; 
	private static String[] VALID_SEP_CHARACTERS;
	private StringParser parser;
	
	public StringCalculator() {
		parser = new StringParser();
		SEPARATOR = ',';
		setSeparatorString(SEPARATOR);
		
		String lineSeparator = System.getProperty("line.separator");
		VALID_SEP_CHARACTERS = new String[] {",", lineSeparator};
	}
	
	public int add(String numbersStr) throws StringCalculatorException {
		numbersStr = preprocess(numbersStr);
		
		if(!isValidString(numbersStr)) {
			throw new StringCalculatorException();
		}
		
		List<Integer> arguments = parser.parseIntegerList(numbersStr, getSeparatorString());
		
		if(hasNegatives(arguments)) {
			throw new StringCalculatorException();
		}
			
		return sumListElements(arguments);
	}
	
	private void setSeparatorString(char separator) {
		SEPARATOR_STRING = "" + SEPARATOR;
	}
	
	private String getSeparatorString() {
		return SEPARATOR_STRING;
	}
	
	private String preprocess(String string) {
		for(String sep : VALID_SEP_CHARACTERS) {
			string = string.replace(sep, getSeparatorString());
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
	
	private boolean isValidString(String string) {
		char[] charArray = string.toCharArray();
		
		if(string.isEmpty()) {
			return true;
		}
		
		for(char x : charArray) {
			if((x < '0' || x > '9') && x != SEPARATOR) {
				return false;
			}
		}
		
		if(charArray[charArray.length - 1] == SEPARATOR) {
			return false;
		}
		
		return true;
	}
	
	private Integer sumListElements(List<Integer> integerList) {
		Integer sum = 0;
		
		for(Integer x : integerList) {
			sum += x;
		}
		
		return sum;
	}
}
