
public class StringCalculator {
	// Returns the sum of the numbers given in numbersStr:
	public int add(String numbersStr) {

		return 0;
	}

	// First: adding 2 ready numbers
    public int sum(int num1, int num2) {
	    return num1 + num2;
    }

    // Second: adding an array of
    public int sum(int[] numArray) {
        int result = 0;
        for(int number : numArray) {
            result += number;
        }
        return result;
    }
}
