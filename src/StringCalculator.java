
public class StringCalculator {
	
	boolean errorsfound;
	
	
	private void checkerrors(String str) throws StringCalculatorException{
	
		//throws an exception if there are illegal characters in input
		
		for(int i=0;i<str.length();i++) {
			if((str.charAt(i)=='-') || (str.charAt(i)>57)) {
				errorsfound=true;
				throw new StringCalculatorException();
			}
			if (str.charAt(i)==',') {
				if (str.charAt(i+1)=='\n') {
					//won't except newline and comma back to back
					errorsfound=true;
					throw new StringCalculatorException();
				}
			}
			if (str.charAt(i)=='\n') {
				if (str.charAt(i+1)==',') {
					errorsfound=true;
					throw new StringCalculatorException();
				}
			}
				
			else {
				errorsfound=false;
			}
			
			
			
		}
	}
	
	public int countnumbers(String str) throws StringCalculatorException{
		
		int result=0;
		int dummy1,dummy2=0;
		
		if (!(str.length()==0)) {
			
			checkerrors(str); //check the errors first
			
			
			for(int i=0;i<str.length();i++) {
				dummy1=str.charAt(i);
				if((48<dummy1) && (dummy1<=57)) { 
					//ascii codes for numbers 0-9
					dummy2=dummy1-'0'; 
				//subtract the ascii code value of zero to get real number value
				
					result =result+dummy2; //adds all the valid numbers
				
				}
				
			}
		
			return result;
			
		}
			
			
		else {
			return 0;
			}
	}
	
	
}
