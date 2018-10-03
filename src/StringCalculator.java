import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		
		int size = numOfnums(numbersStr);
		String corStr = replaceNewlines(numbersStr);
		checkInput(corStr);
		Scanner s = new Scanner(corStr).useDelimiter(",");
		//ArrayList<Integer> arr = new ArrayList<Integer>();

		int j = 0;
		int x = 0;
		if (size==0) return 0;
		else {
			while (size > j) {
				x += s.nextInt();
				j++;
			}
			return x;
		}

	}
	
	public int numOfnums(String numberStr) {
		if (numberStr.length()==0) return 0;
		String commaStr = replaceNewlines(numberStr);
		List<String> splittedStr = Arrays.asList(commaStr.split(","));
		int size = splittedStr.size();
		return size;
	}
	
	public String replaceNewlines(String str) {
		String commaStr = str.replace("\n", ",");
		return commaStr;
	}
	
	public void checkInput(String str) throws StringCalculatorException{
		String input = replaceNewlines(str);
		if (input.length()>0 && !input.matches(".*\\d+.*")) throw new StringCalculatorException();
		if (input.length()>1 && !input.matches("\\d.*\\d")) throw new StringCalculatorException();
		if (input.matches(".*[a-z].*")) throw new StringCalculatorException();
		if (input.contains("-")) throw new StringCalculatorException();
		if (input.contains(" ")) throw new StringCalculatorException();
	}
}
