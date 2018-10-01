
public class StringCalculator {
	
	public int add(String numbersStr) 
	{
	// System.out.println("This is the string : "+numbersStr);
	numbersStr.replaceAll("\\n", ","); // this should reduce the number of checked characters
	// System.out.println("This is the string : "+numbersStr); apparently the above line does not function or the feed does not accept \
	int[] numbertable = find_numbers(numbersStr); 
	int i = 0;
	int result = 0;
	for (i = 0; i<numbertable.length; i++)
		{
		result = result + numbertable[i];
		}
 
	
	
	return result;
	}
	
	public int cN (String a) // cN = ChangeNumber 
	{
	return Integer.parseInt(a);	
	}
	
	// this checks only if a character is a digit or one of the three other allowed figures
	public int cC (char a)
	{
	// was used to test why system failed : System.out.println("character is " +a);	
	if (Character.isDigit(a)) return 1; 
	// became obsolete with the split - command if (a == ',') return 2;
	/* these two might become obsolete when string "\n" can be replaced with "," leaving them in code
	to remind me in similar selections in future programs
	if (a == '\\') return 3; 
	if (a == 'n') return 4;		
	*/
	return 0;
	
	}
	// completely useless after finding out about split - command for strings
	public String separate (String a, int x, int y) //
	{
	return a.substring(x, y);	
	}	

	public int[] find_numbers(String numbersStr) 
	{
	System.out.println("Stringi on "+ numbersStr);	
	String luvut[] = toStrings(numbersStr); // new String[3]; // Finnish for numbers[]
	int numbers = luvut.length;
	int brakes[] = new int[numbers]; // used to store the ints changed from strings.
	int i, j;
	for (i=0; i<numbers; i++) brakes[i]=0;
	int passed = 0;
	
	char c;
	int digits = 0;
	
	for (j = 0; j<numbers; j++)
		{
		for (i=0; i<luvut[j].length(); i++)
			{
			c = luvut[j].charAt(i);
			passed = cC(c); // character sent for inspection
			if (passed == 1) digits++;
			}
		if (digits == luvut[j].length())
			{
			brakes[j] = cN(luvut[j]);
			System.out.println("number [j] " + j + " as letters " + luvut[j] + " and as a number " + brakes[j] );
			}
		else System.out.println("Feed has invalid characters and cannot be calculated");
		
		digits=0;
		}
	
	
	return brakes;	
	}
	
	public String[] toStrings (String numbersStr )
	// changes the string to multiple strings based on the location on ","
	{
	String [] feedback = numbersStr.split(",");
		
	return feedback;
	
	}
	
}

