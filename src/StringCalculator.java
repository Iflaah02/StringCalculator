
public class StringCalculator {
	public int add(String numbersStr) {

		String arr[] = numbersStr.trim().split(",\\s+"); // ",\\s+" "[a-zA-Z ]+"
		int sum = 0;

		if (!validInput(arr.length, numbersStr)) {
			return 0;
		}
		for (int i = 0; i < arr.length; i++) {

			int parsedNumber = Integer.parseInt(arr[i]);

			if (parsedNumber < 0) {
				return 0;
			}

			sum = sum + parsedNumber;
		}
		return sum;

	}

	public boolean validInput(int length, String input) {
		if (length > 2) {
			return false;
		} else if (input == " ") {
			return false;
		} else {
			return true;
		}
	}

}
