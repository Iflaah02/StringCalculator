import java.util.LinkedList;
import java.util.List;

public class StringParser {
	public List<Integer> parseIntegerList(String numberStr, String separator) throws NumberFormatException{
		List<Integer> argumentList = new LinkedList<Integer>();
		
		if(numberStr.isEmpty()) {
			return argumentList;
		}
		else {
			String arguments[] = numberStr.split(separator);
			for(int i = 0; i < arguments.length; i++) {
				int argument = Integer.parseInt(arguments[0]);
				argumentList.add(argument);
			}
		}
		
		return argumentList;
	}
}
