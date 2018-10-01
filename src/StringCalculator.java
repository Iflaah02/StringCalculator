public class StringCalculator {
	
	public StringCalculator( ) {
		
		
	}
	
	public static int Add(String text) throws StringCalculatorException{
		if(text.contains("\n")) {
			text = text.replaceAll("\n",",").replace("\r", ",");
		}
		
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("-"))
			throw new StringCalculatorException();
		else if(text.contains(",,"))
			throw new StringCalculatorException();
		else if(text.contains(",")){
			return sum(splitNumbers(text));	
		}
		else if(text=="1")
		{
			return 1;
		}
		else
			throw new StringCalculatorException();
	}


	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}
      
    private static int sum(String[] numbers) throws StringCalculatorException{
 	    int total = 0;
        for(String number : numbers){
        	int temp;
        	try {
        		temp = Integer.parseInt(number);
        	}
        	catch (NumberFormatException e) {
        		throw new StringCalculatorException();
        	}
		    total += temp;
		}
		return total;
    }

}


