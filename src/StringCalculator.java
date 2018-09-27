
public class StringCalculator {
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		
		if (numbersStr.equals("")) {
			return 0;
		}
		
		String[] splits = numbersStr.split(",");
		int sum = 0;
		
		System.out.println(splits.length);
		
		if (splits.length > 0) {
			sum += Integer.parseInt(splits[0]);
		} 
		
		if (splits.length > 1) {
			sum += Integer.parseInt(splits[1]);
		} 
		
		if (splits.length > 2) {
			sum += Integer.parseInt(splits[2]);
		} 
		
		return sum;
	}
}
