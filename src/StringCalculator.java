
public class StringCalculator {

	public int add(String numbersStr) throws StringCalculatorException {
		return numbersStr.isEmpty() ? 0 : addNumbersTogether(numbersStr,true,false);
	}

	public int addUnlimitedNumbers(String numberStr) throws StringCalculatorException
	{
		return numberStr.isEmpty() ? 0 : addNumbersTogether(numberStr,false,false);
	}

	public int addUnlimitedNumbersWithNewLinesSeparator(String numberStr) throws StringCalculatorException
	{
		return numberStr.isEmpty() ? 0 : addNumbersTogether(numberStr,false,true);
	}

	public int convertToNumber(String number) {
		try {
			int num =  Integer.valueOf(number);
			return num;
		} catch (NumberFormatException ex) {
			return -1;
		}
	}

	public int getSumFromArray(String[] numbers)throws StringCalculatorException{
		int sum = 0;
		for (String numStr : numbers) {
			int num = convertToNumber(numStr);
			if(num >= 0) sum +=num;
			else throw new StringCalculatorException();
		}
		return sum;
	}
	
	public int addNumbersTogether(String numbersStr, boolean maxTwoNumbers, boolean parseNewLines)  throws StringCalculatorException{
		String[] numbers = parseNumberString(numbersStr,parseNewLines);

		if(maxTwoNumbers)checkLengthOfInputString(numbers);
		return getSumFromArray(numbers);
	}

	public void checkLengthOfInputString(String[] numbers) throws StringCalculatorException {
		if(numbers.length > 2)
		{
			throw new StringCalculatorException();
		}
	}

	public String[] parseNumberString(String numbersStr,boolean parseNewLines) {
		if(parseNewLines)
		return numbersStr.split("\n|,");
		return numbersStr.split(",");
	}
}
