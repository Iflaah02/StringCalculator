/*
 * Focus	on	slicing	the	requirements	into	small	user-stories	and	implement	a	user-story	in	each	cycle.	
• Write	unit	tests	immediately	after	you	complete	a	user-story.

*:	adapted	from http://osherove.com/tdd-kata-1/
String	Calculator Task	Description*
Implement a simple String calculator with a method int Add(string numbers)
1. The method can take  0, 1 or 2 numbers , and will return their sum (for an empty string it will
return 0) for example “” or “1” or “1,2”
2. Add method to handle an unknown amount of numbers
3. Add method to handle new lines between numbers (instead of commas).
1. the following input is ok: “1\n2,3” (will equal 6)

Newline is replaced with \n


2. the following input is NOT ok: “1,\n”
4. Calling Add with a negative numbers or invalid input (not numbers) will throw an
StringCalculatorException

 */
//https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html

import java.util.function.*;
import static ch.lambdaj.Lambda.*;
import java.util.stream.*;

public class StringCalculator {
	public static int add(String numbersStr) {

		if (numbersStr.isEmpty()) {
			return 0;

		} else if (numbersStr.contains(",")) {
			//splitataan pilkku
			//String[] tokens luo sen nimisen splitin vissin, tallentaa muuttujaan tokens
			String[] tokens = numbersStr.split(",");
			
			
			
			// tässä ekan kerran vasta summataan
			// Interger.parseIntin tilalle vois laittaa toInt, mutta antaa olla
			return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
		}
			
			
			
			/*
			 for
			 */


//		} else if (numbersStr.contains("/n")) {
//					String[] tokens = numbersStr.split("/n");
//			return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
//
		}
		
		
		else {
			// parsii luvuksi
			return toInt(numbersStr);
		}
		
		

	}
// parsii luvuksi stringin
	private static int toInt(String numbersStr) throws NumberFormatException {
		return Integer.parseInt(numbersStr);
	}
}
