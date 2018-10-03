import java.util.ArrayList;
import java.lang.Object;
public class ValuesHandler {
	public ArrayList<String> strsArr = new ArrayList();
	public ArrayList<Integer> numsArr = new ArrayList();
	public int sum = 0;
	public int count = 0;


	public void execute() {
		parseStringsArray();
		parseNumbersArray();
	}

	public void parseStringsArray() {
		for (String i : strsArr) {
			numsArr.add(Integer.parseInt(i));
		}
	}
	
	public void parseNumbersArray() {
		for (int num : numsArr) {
			sum += num;
		}
	}
	
	public boolean checkStringValue(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}
		catch (NumberFormatException n) {
			return false;
		}
	}
	
	public void checkCount(String s) {
		count++;
		if (count < 4) {
			strsArr.add(s);
		}
	}
}
