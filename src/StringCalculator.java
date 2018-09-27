
public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		if(numbersStr.isEmpty())
		    return 0;

        int sum = getSum(numbersStr);

        return sum;
    }

    private int getSum(String numbersStr) throws StringCalculatorException {
        final String[] splitStr = splitInput(numbersStr);

        int sum = 0;

        for(int i = 0; i < splitStr.length; ++i){

            final int currentNumber  = verifyNumber(splitStr[i]);

            sum += currentNumber;
        }

        return sum;
    }

    private String[] splitInput(String numbersStr) {
        return numbersStr.split("[,\n]", -1);
    }

    /**
     * Checks that input string number is valid
     * @param numberStr
     * @return
     * @throws StringCalculatorException
     */
    private int verifyNumber(String numberStr) throws StringCalculatorException {
	    try {
            final int number = Integer.parseInt(numberStr);

            if(number < 0)
                throw new StringCalculatorException();

            return number;

        } catch (NumberFormatException e){
	        throw new StringCalculatorException();
        }
    }
}
