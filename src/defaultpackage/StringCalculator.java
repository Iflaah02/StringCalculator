package defaultpackage;
import java.util.Scanner;
import java.lang.StringBuilder;

public class StringCalculator {
	private StringCalculatorProduct stringCalculatorProduct = new StringCalculatorProduct();
	Scanner getString=new Scanner(System.in);
	StringBuilder deleter= new StringBuilder();
	public String addNumbers()
	{
		String theStringForTheCalculator=getString.nextLine();
		System.out.println("The string added: "+theStringForTheCalculator);
		return stringCalculatorProduct.calculatorMethod(theStringForTheCalculator, this.deleter, this);
	}
	public boolean unknownAmountOfNumbers(String stringFromCalc){
		if(stringFromCalc.length()>2||stringFromCalc.length()<0)
		{
			return false;
		}
		else{
			return true;
		}
	}
}
