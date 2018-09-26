
public class StringCalculator {
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		
		String[] arrayOfNumbers = converToNumArray(numbersStr);
		
		int sum = 0;
		
		for(String elemint: arrayOfNumbers) {

			sum += Integer.parseInt(elemint);
		}
		
		return sum;
	}
	
	public String[] converToNumArray(String numbers) {
		
		String[] arrayOfNumbers = numbers.split("\\s*,\\s*"); 
	
		return removeEmptyString(arrayOfNumbers);
	}
	
	public String[] removeEmptyString(String[] arrayOfNumbersStr) {
		
		String[] numbers = new String[getCountNumStrs(arrayOfNumbersStr)];
		
		int count = 0; 
		
		for(int i = 0; i < arrayOfNumbersStr.length; i++) {
			
			if(!"".equals(arrayOfNumbersStr[i])) {
				
				numbers[count] = arrayOfNumbersStr[i];
				
				count++;
			}
		}
		return numbers;
	}
	
	public int getCountNumStrs(String[] arrayOfNumbersStr) {
		
		int counter = 0;
		
		for(int i = 0; i < arrayOfNumbersStr.length; i++) {
			
			if(!"".equals(arrayOfNumbersStr[i])) {
				
				counter++;
			}
		}
		return counter;
	}
	
	
	public static void main(String[] args) {
		
		StringCalculator sc = new StringCalculator();
		
		int result  = sc.add("1,255\n , ,3");
		
		System.out.println(result);
	}
}
