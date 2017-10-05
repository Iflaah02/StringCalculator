
public class StringCalculator {
	
	public int add(String numbersStr) {
		if (numbersStr.length() == 0) 
			return 0;
	
	String delimiter = delimiter(numbersStr);
	String numbers = numbers(numbersStr);
	return sum(numbers.split(delimiter));
	}
	private String delimiter(String numbersStr) {
		String delimiter = ",|\n";
		if(numbersStr.startsWith("//"))
			delimiter = numbersStr.substring(2, 3);
		return delimiter;
	}
	private String numbers(String numbersStr) {
		String values = numbersStr;
		if(numbersStr.startsWith("//"))
			values = numbersStr.substring(3);
		return values;
	}
private int sum(String[] values) {
	int total = 0;
	for (String value : values) {
		total += Integer.valueOf(value);
		}
		return total;
	}
	
}

