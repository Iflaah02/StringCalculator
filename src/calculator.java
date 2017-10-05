import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
public class calculator {
public static void main(String []args){
	//Scanner reader = new Scanner(System.in);
	Scanner number = new Scanner(System.in);
	
	int nextnum = 0;
	int sumTotal = 0;
	int totalNum = 0;

	
	while (nextnum >=0) {
	System.out.println("Enter a number between 0-2: ");
	//int num = reader.nextInt();
	String userNum = number.nextLine();
	userNum = userNum.replaceAll("[/,]", "");
	//String userNumX = userNum;
	totalNum = Integer.parseInt(userNum);
	

	if(totalNum<=12 && totalNum>=0) {
		sumTotal = sumTotal + totalNum;
		System.out.println(sumTotal);
	}
	else {
		System.out.println(sumTotal);
		nextnum = -1;
	}

	}
	
}
}