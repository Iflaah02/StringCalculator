import java.lang.Object.*;
import java.util.*;
import java.lang.*;

public class StringCalculator {
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int sum = 0;
		
		if(numbersStr == ""){
			return 0;
		}
		nums = checkNums(numbersStr);
		for(int value : nums){
		    sum = sum + value;
		}
		return sum;
	}
	
	public ArrayList<Integer> checkNums(String string){
	    String str = handleNewLines(string);
		String[] nums = str.split(",");
		ArrayList<Integer> numsParsed = new ArrayList<Integer>();
		if(nums.length == 1){
			try{
				int num = Integer.parseInt(nums[0]);
			    numsParsed.add(num);
			}catch(NumberFormatException | NullPointerException nfe) {
				
			}
		}
		else if(nums.length == 2) {
			try{
				int num = Integer.parseInt(nums[0]);
				int num2 = Integer.parseInt(nums[1]);
				numsParsed.add(num);
				numsParsed.add(num2);
			}catch(NumberFormatException | NullPointerException nfe) {
			    
			}
		}
		return numsParsed;
	}
	
	public String handleNewLines(String str){
		String newStr = str.replaceAll("\n", ",");
		return newStr;
	}
	
}
