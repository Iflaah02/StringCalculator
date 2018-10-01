//import java.text.ParseException;

public class StringCalculator {
	
		
			
	public int add(String numbersStr) throws StringCalculatorException {
		
		// Returns the sum of the numbers given in numbersStr
		
		numbersStr=checkIfEmpty(numbersStr);		
		numbersStr=LinesToCommas(numbersStr); //replaces "\n" with ","
		checkInvalidCommas(numbersStr); //Checks if there is more than 1 comma in a row
		
		String [] StrArray=removeCommas(numbersStr); //removes commas from the string
		
		checkForNumeric(StrArray);//checks if is numeric, if not, throws exception
		int[] intArray=ChangeToInt(StrArray);//Strings to integer
		checkForNegatives(intArray);//Checks that numbers are positive, if not, throws exception
		checkNumberCount(intArray);//Checks how many numbers given, if more than 2, throws exception
						
		int sum=0;
		for (int i : intArray) {
			sum=sum+i;
	    }
		System.out.print("Sum is: ");
        System.out.print(sum);
		
		return sum;
	}
	
	public String checkIfEmpty(String numbersStr) {
		if (numbersStr=="") {
			numbersStr="0";
		}
		return numbersStr;
	}

	public void checkNumberCount(int[] intArray) throws StringCalculatorException {
		
		if (intArray.length>2) {
			throw new StringCalculatorException("");
			
		}
		
	}

	public int[] ChangeToInt(String[] strArray) {
		String[] arrOfStr =strArray; 
				
		int[] arrOfInt = new int[arrOfStr.length]; 
        
		for (int i = 0; i < arrOfStr.length; i++) {
	       
			arrOfInt[i] = Integer.parseInt(arrOfStr[i]);
		}
	        
		return arrOfInt;
	}

	public void checkForNegatives(int[] intArray) throws StringCalculatorException {
		int[] array = intArray;
		for (int i=0; i<array.length;i++)
		{
			if (array[i]<0) {
				throw new StringCalculatorException("");
				}
		}
		
	}

	public void checkForNumeric(String[] strArray) throws StringCalculatorException {
		
		String[] arrOfStr =strArray; 
					
		
		int[] arrOfInt = new int[arrOfStr.length];  
        
		for (int i = 0; i < arrOfStr.length; i++) {
	        try {
			arrOfInt[i] = Integer.parseInt(arrOfStr[i]);
	        }
	        catch (NumberFormatException e) {
	            throw new StringCalculatorException("");      
	        	}		
			}       		
		}
		
	

	public String LinesToCommas(String numbersStr) {
		String NoLines=numbersStr.replace("\n",",");
		return NoLines;
		
	}

	public String[] removeCommas(String numbersStr) {
		String [] NoCommas=numbersStr.split(",",-1);
		return NoCommas;
	}

	public void checkInvalidCommas(String numbersStr) throws StringCalculatorException { 
		int a=numbersStr.indexOf(",,");
				
		if (a>=0) {
		throw new StringCalculatorException("");
		}
	}

	
	
}
