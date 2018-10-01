/*Implement a simple String calculator with a method int Add(string numbers)
1. The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will
return 0) for example “” or “1” or “1,2”
2. Add method to handle an unknown amount of numbers
3. Add method to handle new lines between numbers (instead of commas).
1. the following input is ok: “1\n2,3” (will equal 6)
2. the following input is NOT ok: “1,\n”
4. Calling Add with a negative numbers or invalid input (not numbers) will throw an
StringCalculatorException*/

public class StringCalculator {
	
	
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		String redString = numbersStr;
		boolean empty = redString.isEmpty();
		
		if(empty) {
			return 0;
		}
		
		else if(!empty) {
			//int x = Character.getNumericValue(element.charAt(2));
			
			int luku = Character.getNumericValue(redString.charAt(0));
			return luku;
			
			
			 
		}
		return 0;
	
	}
	public int emptyString(String numbersStr0) throws StringCalculatorException {
		String redString0 = numbersStr0;
		boolean empty0 = redString0.isEmpty();
		if(empty0) {
		return 0;
		}
		return -1;
	}
	public int oneString(String numbersStr1) throws StringCalculatorException {
		String redString1 = numbersStr1;
		int luku = Character.getNumericValue(redString1.charAt(0));
		return luku;
		
		
	}
	public int numberOne(String numbersStr1) throws StringCalculatorException {
		String redString1 = numbersStr1;
		int lenght = redString1.length();
		boolean hadComma = redString1.contains(",");
		if(!hadComma && (lenght >=1)) {
			int luku = Integer.parseInt(redString1);
			return luku;
		}
		else return -1;
	}
	
	public int twoNumbers(String numbersStr1) throws StringCalculatorException {
		String redString1 = numbersStr1;
		int lenght = redString1.length();
		boolean hadComma = redString1.contains(",");
		if(hadComma && (lenght >=1)) {
			int endIndex = redString1.indexOf(",");
			String luku1 = redString1.substring(0, endIndex);
			String luku2 = redString1.substring(endIndex+1);
			int luku_1 = Integer.parseInt(luku1);
			int luku_2 = Integer.parseInt(luku2);
			int luku = luku_1 + luku_2;
			
			return luku;
		}
		else return -1;
	}

	public int twoNumbersWithN(String numbersStr1) throws StringCalculatorException {
		String redString1 = numbersStr1;
		int lenght = redString1.length();
		boolean hadSlashN = redString1.contains("\n");
		if(hadSlashN && (lenght >=1)) {
			int endIndex = redString1.indexOf("\n");
			String luku1 = redString1.substring(0, endIndex);
			String luku2 = redString1.substring(endIndex+1);
			int luku_1 = Integer.parseInt(luku1);
			int luku_2 = Integer.parseInt(luku2);
			int luku = luku_1 + luku_2;
			
			return luku;
		}
		else return -1;
	}

	public int numbers(String numbersStr1) throws StringCalculatorException {
		String redString1 = numbersStr1;
		boolean empty = redString1.isEmpty();
			if(empty) {
				return 0;
			}
		boolean hadCommaSlash = redString1.contains(",\n");
		if(hadCommaSlash) {
			return -1;
		}		
		String delims = "[,\n]";
		String[] numbers = redString1.split(delims);
		int lukuja = numbers.length;
		int summa = 0;
		for (int i = 0; i < lukuja ; i++ ) {
			summa = summa+ Integer.parseInt(numbers[i]);
		}
		return summa;
		
			
		}
	public int numbersNochar(String numbersStr1) throws StringCalculatorException {
		String redString1 = numbersStr1;
		boolean empty = redString1.isEmpty();
			if(empty) {
				return 0;
			}
		boolean hadCommaSlash = redString1.contains(",\n");
		if(hadCommaSlash) {
			return -1;
		}		
		String delims = "[,\n]";
		String[] numbers = redString1.split(delims);
		
		int lukuja = numbers.length;
		int summa = 0;
		
		for (int i = 0; i < lukuja ; i++ ) {
			char[] c = numbers[i].toCharArray();
			int  merkkeja = c.length;
			if(Character.isAlphabetic(c[merkkeja-1])) {
				//do nothing
				
			}else if (Character.isDigit(c[merkkeja-1])) {
			summa = summa+ Integer.parseInt(numbers[i]);
			}
		}
		return summa;
		
			
		}
			
}
