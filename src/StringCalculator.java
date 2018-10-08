/*
Implement a simple String calculator with a method int Add(string numbers)
1. The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will
return 0) for example “” or “1” or “1,2”
2. Add method to handle an unknown amount of numbers
3. Add method to handle new lines between numbers (instead of commas).
1. the following input is ok: “1\n2,3” (will equal 6)
2. the following input is NOT ok: “1,\n”
4. Calling Add with a negative numbers or invalid input (not numbers) will throw an
StringCalculatorException
*/

public class StringCalculator {
	// Main function
	public int add(String numbersStr) throws StringCalculatorException {
		
		NumberObject numberObject = new NumberObject(numbersStr);
		CalculateMethod calculator = new CalculateMethod();
		
		int val = 0;
		if (isNumberStrValid(numberObject)) {			
			val = calculator.calculate(numberObject);
		}
		return val;
	}
	
	// Refactor: Consolidate conditionals && Preserve Whole Object
	public boolean isNumberStrValid(NumberObject numberObject) {
		return numberObject.getNumbersStr() != null && numberObject.getNumbersStr() != "";
	}

}
