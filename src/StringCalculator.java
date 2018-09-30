public class StringCalculator {
	private StringCalculatorException stringCalculatorException;

	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		boolean correctStr = true;
		int sum = 0, sum1 = 0, sum2 = 0;
		int sum11 = 0, sum12 = 0, sum21 = 0, sum22=0;
		
		String printStr = numbersStr.replaceAll("\n","\\\\n");
		System.out.println("The input string is: \"" + printStr + "\"");		
		
		if (numbersStr =="")
			sum = 0;
		else
		{
			int count = numbersStr.length() - numbersStr.replaceAll(",","").length();
			//check how many "," in the numberStr
			switch (count) {
			case 0:  //one number
				try {
					  sum = Integer.parseInt(numbersStr);
				} catch (NumberFormatException e) {
					correctStr = false;
					stringCalculatorException = new StringCalculatorException("invalid input (not numbers): " + numbersStr);
				}
				if (sum < 0) {
					correctStr = false;
					stringCalculatorException = new StringCalculatorException("negative numbers" + numbersStr);
				}
				break;
			case 1:  //two or more numbers
				String[] parts = numbersStr.split(",");
				String firstnum = parts[0]; 
				String secondnum = parts[1]; 
				if (firstnum.equals( "\n") || secondnum.equals( "\n")) {
					correctStr = false;
					stringCalculatorException = new StringCalculatorException("invalid input: \\n");
				} else
				{
					int count1 = firstnum.length() - firstnum.replaceAll("\n","").length();
					//check how many "\n" in the numberStr
					switch (count1) {
					case 0:  //one number
						try {
							  sum1 = Integer.parseInt(firstnum);
						} catch (NumberFormatException e) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("invalid input (not numbers): " + firstnum);
						}
						if (sum1 < 0) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("negative numbers: "+ firstnum);
						}
						break;
					case 1:  	
						String[] twoparts = firstnum.split("\n");
						String firstpart = twoparts[0]; 
						String secondpart = twoparts[1]; 
						try {
							  sum11 = Integer.parseInt(firstpart);
						} catch (NumberFormatException e) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("invalid input (not numbers): " + firstpart);
						}
						if (sum11 < 0) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("negative numbers: "+ firstpart);
						}
						try {
							  sum12 = Integer.parseInt(secondpart);
						} catch (NumberFormatException e) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("invalid input (not numbers): " + secondpart);
						}
						if (sum12 < 0) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("negative numbers:" + secondpart);
						}
						sum1 = sum11 + sum12;
						break;
					default:   
						correctStr = false;
						stringCalculatorException = new StringCalculatorException("invalid input: too many \\n");
		          		break;
					}	
					int count2 = secondnum.length() - secondnum.replaceAll("\n","").length();
					//check how many "\n" in the numberStr
					switch (count2) {
					case 0:  //one number
						try {
							  sum2 = Integer.parseInt(secondnum);
						} catch (NumberFormatException e) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("invalid input (not numbers): "+ secondnum);
						}
						if (sum2 < 0) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("negative numbers: " + secondnum);
						}
						break;
					case 1:  	
						String[] twoparts = secondnum.split("\n");
						String firstpart = twoparts[0]; 
						String secondpart = twoparts[1]; 
						try {
							  sum21 = Integer.parseInt(firstpart);
						} catch (NumberFormatException e) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("invalid input (not numbers): " + firstpart);
						}
						if (sum21 < 0) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("negative numbers: " + firstpart);
						}
						try {
							  sum22 = Integer.parseInt(secondpart);
						} catch (NumberFormatException e) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("invalid input (not numbers): " + secondpart);
						}
						if (sum22 < 0) {
							correctStr = false;
							stringCalculatorException = new StringCalculatorException("negative numbers: "+ secondpart);
						}
						sum2 = sum21 + sum22;
						break;
					default:   
						correctStr = false;
						stringCalculatorException = new StringCalculatorException("invalid input: too many \\n");
		          		break;
					}
					sum = sum1 + sum2;
				}
                break;
			default:   
				correctStr = false;
				stringCalculatorException = new StringCalculatorException("invalid input: too many ,");
          		break;
			
			}
		  }
		  
		  if (correctStr) {
				System.out.println("The sum of the numbers is: " + String.valueOf(sum));	
				System.out.println();		
		  }  
		  
		  return 0;
	}
	

}
