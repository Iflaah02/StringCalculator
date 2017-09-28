import java.util.ArrayList;

import javax.print.attribute.IntegerSyntax;

public class StringCalculator {
	// first slice: store and fetch a string input
	private String stringInput;
	// second slice: implement an ArrayList to store and fetch integer values
	private ArrayList<Integer> integers = new ArrayList<Integer>();
	// first slice
	public StringCalculator() {}
	public void setInput(String input) {
		stringInput = input;
	}
	public String getInput() {
		return stringInput;
	}
	// second slice
	public void extractandStoreIntegers(String input) {
		if(!input.isEmpty()) {
			for(int i = 0; i < input.length(); i++) {
				char character = input.charAt(i);
				switch(character) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					integers.add(Character.getNumericValue(character));
					break;
				default:
					break;
				}
			}
		}
	}
	// second slice
	public ArrayList<Integer> getIntegersArrayList(){
		return integers;
	}
	// third slice
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		setInput(numbersStr);
		extractandStoreIntegers(stringInput);
		int sum = 0;
		for(int i = 0; i < integers.size(); i++) {
			sum = sum + integers.get(i);
		}
		return sum;
	}
}
