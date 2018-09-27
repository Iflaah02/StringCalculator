import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	public int add(String numberStr) throws StringCalculatorException {
		int result = 0;
		String splitStr = numberStr;
		String[] arrSplit = splitStr.split(",");

		if (numberStr == "") {
			return 0;
		}
		if (arrSplit.length == 1) {
			return Integer.parseInt(arrSplit[0]);
		}

		result = (handleNum(numberStr).get(0)+handleNum(numberStr).get(1));
		return result;
	}
	
	public ArrayList<Integer> handleNum(String numberStr) throws StringCalculatorException {

		String splitStr = numberStr;	
		String[] arrSplit = splitStr.split(",");
		if(arrSplit[0].matches("[A-Za-z]")) {
			System.out.println("Not numeric");
			throw new StringCalculatorException();
		}
		if (arrSplit.length > 2) {
			System.out.println("Invalid string");
			throw new StringCalculatorException();
		}
		if ( Integer.parseInt(arrSplit[0])  < 0 || Integer.parseInt(arrSplit[1]) < 0 ) {
			System.out.println("Negative string");
			throw new StringCalculatorException();
		}
		ArrayList <Integer> ints = new ArrayList<Integer>();
		ints.add(Integer.parseInt(arrSplit[0]));
		ints.add(Integer.parseInt(arrSplit[1]));
		return ints;
	}
}



