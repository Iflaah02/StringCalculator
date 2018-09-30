
public class StringCalculator {
	public int add(String numbersStr) {	
		
		if (numbersStr.equals(""))
		return 0;
		
		removeLine(numbersStr);
		explicitNumbers(numbersStr);
		try {
			checkNegative(numbersStr);
		} catch (StringCalculatorException e) {
			//
			e.printStackTrace();
		}
		calculateStringNumbersSize(numbersStr);
		
		String numbers[] = numbersStr.split("\\s+");   
		  int sum = 0;
		  for (String number : numbers) {  
		    Integer n = Integer.parseInt(number);  
		    sum += n;    
		  }
		
		return sum;
		
	}
	
	public String removeLine(String inNumbers) {	
		inNumbers = inNumbers.replaceAll("\n", ",");
		
		return inNumbers;
 	}
	
	public String explicitNumbers(String inNumbers) {	
		inNumbers = inNumbers.replaceAll("[^-?0-9]+", " ");
		return inNumbers; 
				
 	}
	
	public void checkNegative(String inNumbers) throws StringCalculatorException {	
		
		if (inNumbers.matches("-\\d+")) {
			throw new StringCalculatorException();
		}
		
 	}
	
	public boolean calculateStringNumbersSize (String inNumbers) {
		String[] items = inNumbers.split(",");
		if (items.length < 4)
			return true;
		else
			return false;
	}
	
	
	
	
}
