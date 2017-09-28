
public class StringCalculator {
	
	public int add(String numbersStr) {
		if (numbersStr.length() == 0) 
			return 0;
	
	String[] values = numbersStr.split(",|\n");

	int total = 0;
	for (String value : values) {
		total += Integer.valueOf(value);
		}
		return total;
	}
}
