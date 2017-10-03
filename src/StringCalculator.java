
public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		if (numbersStr.equals(""))
		      return 0;
		int commaIndex = -1;
	    for (int i = 0; i < numbersStr.length(); i++) {
	      if (numbersStr.charAt(i) == '-' || !( (numbersStr.charAt(i)>=48 && numbersStr.charAt(i)<= 57) || numbersStr.charAt(i)==',')){
	        StringCalculatorException ex = new StringCalculatorException();
	        throw ex;
	      }
	      if (numbersStr.charAt(i) == 50)
	        commaIndex = i;
	    }
		
		
		// not yet implemented
		return 0;
	}
	
	public int addUnknown(String numbersStr) throws StringCalculatorException {
		int numberCount = countNumber(numbersStr);
		int result = 0;	
		if (numberCount < 2)
		      return add(numbersStr);
		    else {
		      String numberStr = "";
		      for (int i = 0; i < numbersStr.length(); i++) {
		        String current = numbersStr.substring(i,i+1);
		        if(current != ",")
		          numberStr += current;
		        else{
		          result += Integer.parseInt(numberStr);
		          numberStr="";
		        }
		      }
		      return result;
		    }
		
			
		
	}

	private int countNumber(String numbersStr) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public int addNewLines(String numbersStr) throws StringCalculatorException {
		
		int result = 0;
	    String numberStr = "";
	    for (int i = 0; i < numbersStr.length(); i++) {
	      String current = numbersStr.substring(i,i+1);
	      if(current != "," || current != "\n")
	        numberStr += current;
	      else{
	        result += Integer.parseInt(numberStr);
	      }
	    }
	    return result;
	  }
}
