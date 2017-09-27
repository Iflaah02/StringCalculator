
public class StringCalculator {
	public String delims;
	public int return_value;
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		if(numbersStr=="")
		{
			return 0;
		}
		String[] t= split(numbersStr);
		int size = check_length(t);
		check_int(t);
		
		check_if_positive(t);
		if(size==0) {
			return 0;			
		}
		
		return_value= calculate(size, t);
		
		return return_value;
			
	}
	//calculates the sum
	public int calculate(int length, String[] numbersStr) {
		int sum=0;
		int value=0;
		for(int i=0;i<length;i++) {
			value=Integer.valueOf(numbersStr[i]);
			sum=sum+value;					
		}
		
		return sum;
	}
	//splits a string in to string array
	public String[] split(String s) {
		delims = "[ ,\n]+";
		String[] t = s.split(delims);
	return t;	
	}
	//check length of the string array. if value is larger than 2 it sets it to 2
	public int check_length(String[] s) {
	int length= s.length;
	
	if (length>3)
	{
		length=3;
	}
	else if(length ==1 && s[0]=="")
	{
		length=0;
	}
	return length;	
	}
	
	public boolean check_int(String[] s) throws StringCalculatorException {
		
		for(int i =0;i<s.length;i++) {
			try {
			Integer.valueOf(s[i]);
			}catch(NumberFormatException e) {
				throw new StringCalculatorException();
			}
			
		}
			
		
		
		return true;
	}
	public boolean check_if_positive(String[] s) throws StringCalculatorException {
		
		for(int i =0;i<s.length;i++) {
			if(Integer.valueOf(s[i])<0) {
				throw new StringCalculatorException();
			}
			
		}
		
		return true;
	}
	
}


