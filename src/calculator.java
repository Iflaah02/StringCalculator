import java.io.*;
import java.util.Scanner;
public class calculator {
public static void main(String []args){
	Scanner reader = new Scanner(System.in);
	int nextnum = 0;
	int total = 0;
	/*String line;
	String[] lineVector;
	int i;*/
	
	while (nextnum >=0) {
	System.out.println("Enter a number between 0-2: ");
	int num = reader.nextInt();
	/*line = reader.nextLine();
	lineVector = line.split(",");
	
	i = Integer.parseInt(lineVector[0]);*/
	
	if (num<=2 && num>=0) {
		total = total + num;
		nextnum++;
	}
	
	else {
		total = total;
		nextnum = -1;
	}
	
	System.out.println(total);
	}
	
}
}