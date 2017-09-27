

class Slicer {
	public String[] slice(String str){
		String delimiters = extractDelimiters(str);
		String[] numbers = extractNumbers(str,delimiters);
		
		return numbers;
	}

	private String[] extractNumbers(String str, String delimiters) {
		// TODO Auto-generated method stub
		if (str.startsWith("//"))
			str = str.substring(4);
		String[] numbers = str.split(delimiters);
		return numbers;
	}

	private String extractDelimiters(String str) {
		// TODO Auto-generated method stub
		String delimiters = ",|\n";
		if (str.startsWith("//"))
			delimiters += "|" + str.substring(2, 3);
		return delimiters;
	}
}

public class StringCalculator {
	Slicer slicer;
	
	public StringCalculator() {
		slicer = new Slicer();
	}
	
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		if ("".equals(numbersStr))
			return 0;
		String[] numbers = slicer.slice(numbersStr);
		checkForNegatives(numbers);
		length(numbers);
		return addArray(numbers);
	}
	
	public void length(String[] numbers) {
		if(numbers.length > 3) {
			System.out.println("too long");
			System.exit(0);
		}
	}
	
	public int parseInt(String str) {
		int sum = Integer.parseInt(str);
		return sum;
	}
	
	public void checkForNegatives(String[] numbers) {
		String negatives = "";
		for (String number : numbers) {
			if (number.contains("-"))
				negatives += "," + number;
		}
		if (!"".equals(negatives))
			try {
				throw new StringCalculatorException();
			} catch (StringCalculatorException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
	}
	
	public int addArray(String []numbers){
		int sum = 0;
		for (String number : numbers) {
			sum += parseInt(number);
		}
		return sum;
	}
}
