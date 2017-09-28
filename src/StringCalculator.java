
public class StringCalculator {
	int result = 0;


	
	
	///round1
//	public int add(String numbersStr) {
//		int num1 = Integer.parseInt(numbersStr);
//		
//		// Returns the sum of the numbers given in numbersStr
//		
//		// not yet implemented
//		return num1;
//	}
	
	//round2
//	public int add(String numbersStr) {
//		if(numbersStr != "") {
//		int num1 = Integer.parseInt(numbersStr);
//				
//				// Returns the sum of the numbers given in numbersStr
//				
//				// not yet implemented
//				return num1;
//	}else {
//		return 0;
//	}
//	}
	
	//round3
	public int  add(String numbersStr)throws StringCalculatorException {
		String[] numStrArray = numbersStr.split(",");
//		int[] numIntArray = new int [numStrArray.length];
		if(numbersStr != "") {
		for(int i = 0; i < numStrArray.length; i++) {
			int number = Integer.parseInt(numStrArray[i]);			
			if(number > 0) {
			result += number;
			}else {
				throw new StringCalculatorException();
			}
		}
		}else {
		result = 0;
	}
		System.out.println(result);
		return result;
	}
	
	//TESTING  CLASS
	public static void main(String[] args) {
		StringCalculator calc = new StringCalculator();
		try {
		calc.add("1,3,5");
		}catch(StringCalculatorException e) {
			e.printStackTrace();
		}
	}
	
}
