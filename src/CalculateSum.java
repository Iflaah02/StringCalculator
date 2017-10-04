import java.util.ArrayList;

//Refectoring: Extract method

public class CalculateSum {
	public CalculateSum() {		
	}
	
	public int sumOfNumbers(ArrayList<String> num) throws StringCalculatorException {
		int sum = 0;
		try {
			for (int i = 0; i < num.size(); i++) {
				sum = sum + Integer.parseInt(num.get(i));
			}
		} catch (NumberFormatException ex) {
			if (num.get(0) == "") {
				sum = 0;
			} else {
				throw new StringCalculatorException();
			}
		}
		return sum;
	}

}
