
public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		int sum = 0;
		if (numbersStr.isEmpty()) {
			return 0;
		} else {
			int numericArray[] = getIntArray(numbersStr);
			for (int i = 0; i < numericArray.length; i++) {
				sum = sum + numericArray[i];
			}
			return sum;
		}
		// not yet implemented

	}

	public int getLength(String str) {
		return str.length();

	}

	public boolean handleLength(String str) {
		if (str.length() < 20) {
			return true;
		} else {
			return false;
		}

	}

	public int[] getIntArray(String str) {
		int arr[] = new int[str.length()];
		int index = 0;
		// System.out.println(str.length() + " ");
		// if (isValid(str)) {
		for (int i = 0; i < str.length(); i++) {
			// if ((str.charAt(i)+str.charAt(i+1)+"") != "\n" ||
			// (str.charAt(i)
			// + "") != ",") {
			if (!(str.charAt(i) + "").equals(",")) {
				if (!(str.charAt(i) + "").equals("\n")) {
					// System.out.println(str.charAt(i) + "");
					arr[index++] = Integer.parseInt(str.charAt(i) + "");

				}
				// System.out.println(str.length() + " " + str.charAt(i) +
				// "");
			}
		}
		// }
		return arr;

	}

	public boolean isValid(String str) {

		return str.matches("(.*),\n(.*)") || str.matches("(.*)-(.*)") || str.matches("(.*)[a-z](.*)");
		// return str.matches(",\n") || str.matches("-");
		// boolean isvalid = true;
		// System.out.println(str.length() + "");
		/*
		 * if (str.length() >= 2) { for (int i = 0; i < str.length() - 1; i++) {
		 * if (((char)str.charAt(i) + (char)str.charAt(i + 1) +
		 * "").equals(",\n")) { //System.out.println(str.charAt(i) +
		 * str.charAt(i + 1) + ""); isvalid = false; break; }
		 * 
		 * } }
		 */

		// return isvalid;

	}
}
