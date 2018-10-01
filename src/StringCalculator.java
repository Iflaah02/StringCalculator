import java.util.StringTokenizer;

public class StringCalculator{
	
	public int int1;
	public int int2;
	
	public int add(String numbersStr) throws StringCalculatorException{
		
		int int1 = 0;
		int int2 = 0;
		int result = -1;
		String[] token = new String[2];
		
		if(countLines(numbersStr) > 1) {
			
			result = addlines(numbersStr);
			
		}
		
		else {
		
			if(countTokens(numbersStr) == 0) {
					
				
				result = 0;
				
			}
				
			else if(countTokens(numbersStr) == 1) {
				
			
				token = getToken(numbersStr);
				int1 = getNumber(token[0]);
				result = int1;
				
			}
			
			
			else if(countTokens(numbersStr) == 2) {
				
				token = getToken(numbersStr);
				int1 = getNumber(token[0]);
				int2 = getNumber(token[1]);
				result = sum(int1, int2);
				
			}
				
			else{
				
				result = addMoreThanTwoNumbers(numbersStr);
				
			}
			
		}
	
		return result;
		
	}
	
	public int addMoreThanTwoNumbers(String s) throws StringCalculatorException{
		
		int numTokens = countTokens(s);
		
		String[] token = getToken(s);
		
		int number = 0;
		
		int sum = 0;
		
		for(int i = 0; i < numTokens; i++) {
			
			number = getNumber(token[i]);
			
			sum += number;
			
		}
		
		return sum;
		
	}
	
	public int addlines(String s) throws StringCalculatorException{
		
		String[] line = getLine(s);
		int number = 0;
		int sum = 0;
		int numToken = 0;
		
		for(int i = 0; i < line.length; i++) {
			
			numToken = countTokens(line[i]);
			
			String[] token = new String[numToken];
			
			token = getToken(line[i]);
			
			for(int j = 0; j < numToken; j++) {
				
				number = getNumber(token[j]);
				sum += number;
				
			}
			
		}
		
		return sum;
		
	}
	
	public int countTokens(String s) {
		
		StringTokenizer st = new StringTokenizer(s, ",");
		
		int tokenNum = 0;
		
		while(st.hasMoreTokens()) {
			
			tokenNum ++;
			st.nextToken();
			
		}
		
		return tokenNum;
		
	}
	
	public int countLines(String s) {
		
		StringTokenizer st = new StringTokenizer(s, "\n");
		
		int lineNum = 0;
		
		while(st.hasMoreTokens()) {
			
			lineNum ++;
			st.nextToken();
			
		}
		
		return lineNum;
		
	}
	
	public String[] getLine(String s) {
		
		String[] st = s.split("\n");
		
		return st;
		
	}
	
	public String[] getToken(String s) {
		
		String[] st = s.split(",");
	
		return st;
	}
	
	public int getNumber(String s)
			  throws StringCalculatorException
	  {  
		
		int number = 0;
		number = Integer.parseInt(s);
	    if(number < 0)
	    	throw new StringCalculatorException();
	    else
	    {
	    	return number;
	    }
	    
	    
	    
	  }
	
	public int sum(int int1, int int2) {
		
		return int1 + int2;
		
	}
	
}
