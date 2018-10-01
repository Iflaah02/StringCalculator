package defaultpackage;
import java.util.Scanner;
import java.lang.StringBuilder;

public class StringCalculator {
	Scanner getString=new Scanner(System.in);
	StringBuilder deleter= new StringBuilder();
	private String calculatorMethod(String numbers){
		char[] numberArray;
		numberArray=numbers.toCharArray();
		if(numberArray.length>2)
		{
			for(int j=0;j<numberArray.length;j++)
			{
				if(numberArray[j]=='\\'&&numberArray[j+1]=='n')
				{
					numbers= new String(numberArray);
					deleter.append(numbers);
					deleter.deleteCharAt(j);
					deleter.deleteCharAt(j);
					numberArray=deleter.toString().toCharArray();
					System.out.println("Numberarray in for after all: "+numberArray[0]+numberArray[1]);
					System.out.println("Numberarray length: "+numberArray.length);
					numbers=new String(numberArray);
				}
			}
		}
		System.out.println("The char array created:"+numberArray[0]);
		int a, b=0;
		System.out.println("Integers defined");
		int theSum=-1;
		System.out.println("Sum set minus one and defined.");
		String stringBack=null;
		System.out.println("stringBack defined and set null.");
		//String theStringOfTheCalculator=getString.nextLine();
		//System.out.println("The string added: "+theStringOfTheCalculator);
		if(!unknownAmountOfNumbers(numbers)){
			System.out.println("Unknown amount of numbers.");
			unknownNumberHandler(numbers);
		}
		else{
			a=Integer.parseInt(String.valueOf(numberArray[0]));			
			System.out.println("a set to something.");
			if(numberArray.length>1)
			{
				b=Integer.parseInt(String.valueOf(numberArray[1]));
				System.out.println("b set to:"+b);
			}
			System.out.println("A is:"+a+"\n And B is: "+b);
			theSum=a+b;
			System.out.println("The sum is: "+theSum);
			stringBack=Integer.toString(theSum);
			System.out.println("stringBack is: "+stringBack);
		}
		return stringBack;
	}
	public String addNumbers()
	{
		String theStringForTheCalculator=getString.nextLine();
		System.out.println("The string added: "+theStringForTheCalculator);
		return calculatorMethod(theStringForTheCalculator);
	}
	private boolean unknownAmountOfNumbers(String stringFromCalc){
		if(stringFromCalc.length()>2||stringFromCalc.length()<0)
		{
			return false;
		}
		else{
			return true;
		}
	}
	private void unknownNumberHandler(String unknownNumbers)
	{
		unknownNumbers=null;
		//This is how to handle unknown numbers. We destroy them.
	}
}
