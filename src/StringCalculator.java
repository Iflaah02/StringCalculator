import java.util.ArrayList;

public class StringCalculator {

	// First: adding 2 ready numbers
    public int sum(int num1, int num2) {
	    return num1 + num2;
    }

    // Second: adding any quantity of numbers
    public int sum(ArrayList<Integer> numArray) {
        int result = 0;
        for(int number : numArray) {
            result += number;
        }
        return result;
    }

    // Third: extracting numbers from the string
    // This is a high-value feature!
    public ArrayList<Integer> getNumbers(String numbersStr) throws StringCalculatorException{
        // dividing the string by "\n" and ","
        String[] numbersArray = numbersStr.split("[\n,]");

        // process the array and create the final list of numbers
        ArrayList<Integer> numbersList = new ArrayList<Integer>();

        for(String numberString : numbersArray) {
            if(numberString.equals("")) { //happens when there is no number between "," and "\n". Or when it's an empty string
                if(numbersArray.length == 1) { // empty string case
                    numbersList.add(0);
                }
                else {  // cases like 1,\n5 or 1\n,5
                    throw new StringCalculatorException();
                }
            }
            else {
                int number = -1;
                try {
                    number = Integer.parseInt(numberString);
                }
                catch (Exception e) {
                    throw new StringCalculatorException(); // the string was not a number
                }

                if(number < 0) {
                    throw new StringCalculatorException(); // throwing exceptions for negative numbers
                }

                // if all the checks have been successful, let's add the number to our final List:
                numbersList.add(number);
            }
        }
        return numbersList;
    }

    // Final slice!
    // Returns the sum of the numbers given in numbersStr:
    public int add(String numbersStr) throws StringCalculatorException {
        return sum(getNumbers(numbersStr));
    }
}
