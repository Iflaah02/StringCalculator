
public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		if (numbersStr.length() > 1 && numbersStr.length() < 4){
			String[] list = numbersStr.split(",|\\\n");
			int num1 = Integer.parseInt(list[0]);
			int num2 = Integer.parseInt(list[1]);
			return(num1 + num2);
		}
		if (numbersStr.length() > 3) {
			int result = addMultiple(numbersStr);
			return result;
		}

		else return 0;
	}
	
	private int addMultiple(String numbersStr) {
		String[] list = numbersStr.split(",|\\\n");
		int result = 0;
		//System.out.println(list.length);
		for (int i=0; list.length > i ; i++) {
			result = result + Integer.parseInt(list[i]);
		}
		return result;
	}
}
