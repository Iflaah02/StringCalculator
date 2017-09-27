import java.util.*;

public class StringCalculator {
	/** Returns the sum of the numbers given in numbersStr. */
	public int add(String numbersStr) throws StringCalculatorException {
		if (numbersStr.equals("")) {
			return 0;
		}
		Integer[] intAr = get_intAr(numbersStr);
		int sum = 0;
		for (int i = 0; i < intAr.length; i++) {
			sum += intAr[i];
		}
		return sum;
	}
	
	public int str2int(String str) throws StringCalculatorException {
		int num;
		
		// To string
		try {
			num = Integer.parseInt(str);
		} catch(NumberFormatException e) {
			throw(new StringCalculatorException());
		}
		
		// Check negative numbers
		if (num < 0) {
			throw(new StringCalculatorException());
		}
		
		return num;
	}
	
	public Integer[] get_intAr(String numbersStr) throws StringCalculatorException {
		String[] strAr = numbersStr.split(",|\n");
		ArrayList<Integer> intAr = new ArrayList<Integer>();
		for (int i = 0; i < strAr.length; i++) {
			intAr.add(str2int(strAr[i]));
		}
		return intAr.toArray(new Integer[intAr.size()]);
	}
}
