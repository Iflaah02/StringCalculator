
public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		int sum = 0;
		int[] newNumbersInt = invalidNegtive(numbersStr);
		
		if(newNumbersInt.length == 0){
			return 0;
		}
				
		for(int i=0; i<newNumbersInt.length; i++){
			sum = sum + newNumbersInt[i];
			}
				
		return sum;
	
	}
	
	public String handleNewLines(String numberStr){
		String newString = numberStr.replaceAll("\n", ",");
		return newString;
	}
	
	public int counterSpliter(String newString){
		int count = 0;
		
		for(int i=0;i<newString.length(); i++){
			if(newString.charAt(i) == ','){
				count++;
			}
		}
		return count;
	}
	
	public int[] invalidNegtive(String numbersStr) throws StringCalculatorException{
		String numberStr = handleNewLines(numbersStr);
		int count1 = counterSpliter(numberStr);
		String[] newString = numberStr.split(",");
		int[] numbersInt = new int[newString.length];
		
		try{
			for(int i=0; i< numbersInt.length; i++){
				int integer = Integer.parseInt(newString[i]);
				
				if(integer<0){
					throw new StringCalculatorException("Negtive number!");
				} 
				
				if(count1 != (numbersInt.length - 1)){
					throw new StringCalculatorException("invalid!");
				}
				numbersInt[i] = integer; 
			}			
			}catch(NumberFormatException e){
				throw new StringCalculatorException("invalid!");
		}
		
		return numbersInt;
	}
}
