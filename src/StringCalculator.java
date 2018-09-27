
public class StringCalculator {
	
	public int add(String numbersStr) 
	{
	String one;
	String two;
	String three;
	int numbers = 0;
	int eka = 0;
	int toka = 0;
	int kolmas = 0;
	int passed = 0;
	int i = 0;
	
	for (i = 0; i < numbersStr.length(); i++)
		{
	    char c = numbersStr.charAt(i); 
	    passed = cC (c);  // Send this character to rehab for evaluating if it is 0-9 or , or \n
	    if (passed == 0) System.out.println("Input includes invalid characters. Please give three numbers separated by a comma (,) or a new line");
	    if (passed == 2 || passed == 4)
	    	{
	    	numbers++;
	    	if (numbers == 1) toka = i;
	    	if (numbers == 2) kolmas = i;
	    	if (numbers > 2) System.out.println("Too many numbers in the input");
	    	}
	   
	    
		}
	one = separate(numbersStr,0,toka);
	two = separate(numbersStr,toka+1,kolmas);
	three = separate(numbersStr,kolmas+1,numbersStr.length());
	
	System.out.println(one + " " + two + " " + three);
	
	eka = cN(one);
	toka = cN(two);
	kolmas = cN(three);
	
	if (passed > 0) return eka+toka+kolmas;
		
		// Returns the sum of the numbers given in numbersStr
		
		// not yet implemented
	else return 0;
	}
	
	public int cN (String a) // cN = CheckNumber wtf was I planning to with this?
	{
	return Integer.parseInt(a);	
	}
	
	// this checks only if a character is a digit or one of the three other allowed figures
	public int cC (char a)
	{
	if (Character.isDigit(a)) return 1;
	if (a == ',') return 2;
	if (a == '\\') return 3;
	if (a == 'n') return 4;		
	return 0;
	
	}
	
	public String separate (String a, int x, int y) //
	{
	return a.substring(x, y);	
	}	
	
}

