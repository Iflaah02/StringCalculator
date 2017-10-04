import java.util.ArrayList;

//Refactoring: Introduce Parameter Object: new Parameter Object

public class DataSum {
	private ArrayList<String> num;
	private String numbersStr;
	
	public DataSum(ArrayList<String> num,String numbersStr) {
		this.num=num;
		this.numbersStr = numbersStr;		
	} 
	
	public ArrayList<String> getNum () {
		return num;
	} 	
	
	public String getNumbersStr () {
		return numbersStr;
	}
	
	public void setNumbersStr (String numbersStr) {
		this.numbersStr = numbersStr;
	}
	
	public void setNum (ArrayList<String> num) {
		this.num=num;
	}
	

}
