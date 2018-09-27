
public class StringCalculator {
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		int sum = 0;
		int numbersInt = 0;
		
		numbersStr = format(numbersStr);

		if (validate(numbersStr)) {
			try {
				numbersInt = Integer.parseInt(numbersStr);
			} catch(NumberFormatException | AssertionError e) {
				System.out.println("Invalid input");
				return 0;
			}
			while (numbersInt > 0) {
				sum = sum + numbersInt % 10;
				numbersInt = numbersInt / 10;
			}
		return sum;
		} else {
			return 0;
		}
	}
	
	public boolean validate(String numbersStr) {
		boolean stringIsValid = true;
		
		if (numbersStr.matches("[0-9]+") == false) {
			stringIsValid = false;
		} else if (numbersStr.length() == 0) {
			stringIsValid = false;
		}
		
		return stringIsValid;
	}
	
	public String format(String numbersStr) {
		// get rid of the columns and spaces and such
		numbersStr = numbersStr.replaceAll(",", "");
		numbersStr = numbersStr.replaceAll("\\s+","");
		return numbersStr;
	}
	
}
