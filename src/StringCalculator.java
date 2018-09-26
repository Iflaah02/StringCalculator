import java.util.ArrayList;

public class StringCalculator {
	public boolean tooManyNumbers;
	public int count = 0;
	public int sum = 0;
	ArrayList<String> strsArr = new ArrayList();
	ArrayList<Integer> numsArr = new ArrayList();
	StringCalculatorTest tests = new StringCalculatorTest();
	
	public static void main(String[] args) {
		StringCalculator sc = new StringCalculator();
	}
	
	public int add(String numbersStr) {
		splitNumbers(numbersStr);
		for (String i : strsArr) {
			numsArr.add(Integer.parseInt(i));
		}
		for (int num : numsArr) {
			sum += num;
		}
		return sum;
	}
	
	
	public void splitNumbers(String numbers) {
		for (String s : numbers.split(",|\\n")) {
			if (s == "") {
				break;
			}
			else {
				checkCount(s);
			}
		}
	}
	
	public boolean checkCount(String s) {
		count++;
		if (count < 4) {
			strsArr.add(s);
			return false;
		}
		else {
			return true;
		}
	}
	
}
