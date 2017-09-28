
public class StringCalculator {
	public int add(String numbersStr) {

		String arr[] = numbersStr.trim().split(",\\s+"); // ",\\s+" "[a-zA-Z ]+"
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr.length > 2) {
				return 0;

			} else if (numbersStr == " ") {
				return 0;

			} else {

				int parsedNumber = Integer.parseInt(arr[i]);

				if (parsedNumber < 0) {
					return 0;
				}

				sum = sum + parsedNumber;
				System.out.printf("sum: " + sum + "\n");
			}

		}

		return sum;
	}
}
