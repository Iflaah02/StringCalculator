import java.io.*;
import java.io.Console;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

// methods: main-part, input, split into parts, combine parts to int
 public class StringCalculator {

	public static void main(String [] args)
	{
	 //the program structure, execute methods in order	
	 String inputs = null;
	 
	 System.out.println("Welcome to the string calculator program.\n");
	 StringCalculator calc = new StringCalculator();
	 inputs = calc.input();
	 System.out.println("Your input was: "+inputs+".\n");//to confirm that it works
	 ArrayList<Integer> splitInputs = calc.splitString(inputs);
	 int sumTotal = calc.add(splitInputs);
	 System.out.print("Added sum is "+sumTotal+".\n");	 
	}

	public static String input()
	{
	//takes the input, checks that it is valid, returns the input
	
	//could probably refine the checking to run an iterator through the input string
    //and check char by char it through to detect '-' symbols in case of negative numbers
	//and '\' 'n' for line changes, then parse them out or something.

	//but first, I want the basic functionality working. Despite being granted more time
    //to finish this, I've been sick for the last few days so not much has come out of it :(
		 String inputs = null;
	     boolean ok = false;
		 Scanner reader = new Scanner(System.in);
		 System.out.println("Input the numbers: ");
		 
	   do
	   {
		 try
		 {
		  inputs = reader.nextLine();
		  ok = true;
		 }
		 catch( InputMismatchException wrong)			 
		 {
		  //haven't been able to figure out the StringCalculatorException stuff yet,
		  //so using this as a placeholder.
		  inputs = "0";
		  ok = true;
          System.out.print("Illegal input, resolving to 0. ");	 
		 }
	   }
	   while(!ok);
	
	   reader.close();
	   return inputs;
	}
	
	public static ArrayList<Integer> splitString(String inputs)
	{
	 //takes the inputs as a mess, tries to make sense of it and split it into int-parts
     //form an ArrayList<int> with those parts, return it for further use
	 
	 //Arrays.asList(str.split(","));
	 ArrayList<Integer> whole = new ArrayList<Integer>();

	 //Welp, I'm giving up. Despite all logic, I'm repeatedly getting
	 //numberformatexception when the input tries to use \n instead of ,
	 //even when I am replacing those with commas here.
	 //Also tried with read.next instead of read.nextLine, in case that input
	 //had an extra \n at the end which would then feed a "" to the array if that
	 //ending \n is replaced with a , but I don't think that is the case, because
	 //the error does not pop up with commas as separators.

	 //How will I learn about testing if I have to code the testable software myself in a language
	 //I am not comfortable with first, I wonder.
	 String correction = inputs;
	 correction = correction.replaceAll("\\n", ",");
	 correction = correction.replaceAll("\n", ",");
	 
	 for (String chunks : correction.split(",|\\n"))
	 {
	  int temp = Integer.parseInt(chunks);
	  
	  whole.add(temp);	 
	 }
	 
	 return whole;
	}
	
	public static int add(ArrayList<Integer> numbers) 
	{
		// Returns the sum of the numbers given in numbers
		int sum = 0;
		
		for(int i = 0; i < numbers.size(); i++)
		{
		 sum += numbers.get(i);	
		}

		return sum;
	}
}