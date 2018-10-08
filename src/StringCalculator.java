import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private StringCalculatorData data = new StringCalculatorData(".*[,\n][,\n].*");

	public boolean checkNumbersLength(CheckNumbersLengthParameter parameterObject) {
		if (parameterObject.numbers.size() > 2) {
			return false;
		}
		return true;
	}
	
	public List<String> handleNewlineComma(String numbersStr) throws StringCalculatorException {
		
		if (numbersStr.matches(getRex())) {
			throw new StringCalculatorException();
		}
		return Arrays.asList(numbersStr.split(",|\n"));
	}
	
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		if(numbersStr == null || numbersStr.isEmpty()) {
			return 0;
		}
		
		List<String> numbers = handleNewlineComma(numbersStr);
		
		if (!checkNumbersLength(new CheckNumbersLengthParameter(numbers))) {
			return 0;
		}

		int sum = 0;
		try {
			
			int intx;
			for (String x : numbers) {
				intx = Integer.parseInt(x);
				if (intx < 0) {
					throw new StringCalculatorException();
				}
				sum += intx;
			}
		} catch (NumberFormatException e){
			throw new StringCalculatorException();
		}
		
		
		return sum;
	}

	String getRex() {
		return data.rex;
	}

	void setRex(String rex) {
		this.data.rex = rex;
	}
}
