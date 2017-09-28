import java.util.Scanner;

public class StringCalculator {
	
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		
		int sum = 0;
		int ncount = 0;
		
		try {
			ncount = numberCount(numbersStr);
		} catch (StringCalculatorException exception){
			System.out.println("Invalid input.");
			return 0;
		}
		
		int[] ints = getIntegers(numbersStr, ncount);

		for(int i : ints) {
			sum = sum + i;
		}
		
		return sum;
	}

	/*public String readInput() 
	{
		String str = "";
		
		System.out.println("Give up to three numbers: ");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
	
		return str;
	}*/
	
	public int numberCount(String str) throws StringCalculatorException
	{
		int com = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				if(!Character.isWhitespace(str.charAt(i))) {
					if(str.charAt(i) != ',') {
						throw new StringCalculatorException();
					}
					else com++;
				}
				else if (str.charAt(i) == '\n') com++;
			}
		}
		if (com+1 > 3) {
			throw new StringCalculatorException();
		}
			
		
		return com+1;
	}
	
	public int[] getIntegers(String str, int count) 
	{
		int[] numbers = new int[count];
		String sub = "";
		int calc=0;
		
		for(int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				sub = sub + str.charAt(i);
			}
			else
			{
				if (!sub.isEmpty()) {
					numbers[calc] = Integer.parseInt(sub);
					sub = "";
					calc++;
				}
			}
			if (i == (str.length()-1)) {
				numbers[calc] = Integer.parseInt(sub);
			}
		}
		
		return numbers;
	}
	
}

	