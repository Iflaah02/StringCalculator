import java.util.Scanner;
import java.util.stream.IntStream;

public class StringCalculator {
	
	public int add(String numbersStr) throws StringCalculatorException {
		String[] strArray = toStringArray(numbersStr);
		int[] intArray = toIntArray(strArray);
		int sum = IntStream.of(intArray).sum();
		return sum;
	}
	
	public String[] toStringArray (String numbersStr) throws StringCalculatorException {
		String text1 = handleUnknownNumbers(numbersStr);
		String text2 = handleEmptyString(text1);
		String text3 = handleLineBreakAndComma(text2);
		String text4 = handleAlphabeticAndNegative(text3);
		String[] split = text4.split(",");
		return split;
	}
	
	public int[] toIntArray (String[] arr) {
		int[] ints = new int [arr.length];
		for (int i = 0; i < arr.length; i++) {
			ints[i] = Integer.parseInt(arr[i]);
		}
		return ints;
	}
	
	public String handleLineBreakAndComma (String numbersStr) throws StringCalculatorException{
		if (numbersStr.contains(",\n")) {
			throw new StringCalculatorException();
		}else{
		String text = numbersStr.replace("\n", ",");
		return text;
		}
	}	
	public String handleEmptyString (String numbersStr) {
		if (numbersStr == "0") {
			return "";
		}else { 
			return numbersStr;
		}
	}
	public String handleUnknownNumbers(String numbersStr) throws StringCalculatorException  {
		if (numbersStr.length() > 3 && numbersStr.contains("\n") == false) {
			throw new StringCalculatorException();
		}else {
			return numbersStr;
		}
	}
	public String handleAlphabeticAndNegative(String numbersStr) throws StringCalculatorException {
		if (numbersStr.matches("[0-9,]+") == false) {
			throw new StringCalculatorException();
		}else {
			return numbersStr;
		}
	}
}