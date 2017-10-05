
public class StringCalculator {	
	public int add(String numbersStr) throws StringCalculatorException {
		if(IsNullOrEmpty(numbersStr))
			return 0;
		else if(!verifyInput(numbersStr))
			throw new StringCalculatorException();
			
		String[] splittedString = splitString(numbersStr);
		
		return CalculateSum(splittedString);
	}
	
	public String[] splitString(String numbersStr)
	{
		String[] splitString = null;
		
		splitString = numbersStr.split(",|\\n");
		
		return splitString;
	}
	
	public boolean verifyInput(String numbersStr)
	{
		if(IsNullOrEmpty(numbersStr) || !ContainsNumbers(numbersStr) || InvalidSeparators(numbersStr))
			return false;
		else if(numbersStr.matches("^[,\\d\\n]+$"))
			return true;
		else
			return false;
	}
	
	public boolean InvalidSeparators(String string)
	{
		return (string.contains(",\n") || 
				string.contains("\n,") || 
				string.contains(",,") || 
				string.contains("\n\n") || 
				string.endsWith(",") || 
				string.endsWith("\n"));
	}
	
	public boolean IsNullOrEmpty(String string)
	{
		return (string == null || string.isEmpty());
	}
	
	public boolean ContainsNumbers(String string)
	{
	    boolean containsDigit = false;

	    if (string != null && !string.isEmpty()) {
	        for (char c : string.toCharArray()) {
	            if (containsDigit = Character.isDigit(c)) {
	                break;
	            }
	        }
	    }

	    return containsDigit;		
	}
	
	private int CalculateSum(String[] numberArray)
	{
		int amount = 0;
		
		for(int i = 0; i < numberArray.length; i++)
			amount += Integer.parseInt(numberArray[i]);
		
		return amount;
	}
}