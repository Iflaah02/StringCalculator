public class StringCalculator {
	private ValuesHandler vh;
	ValuesHandler valuesHandler = new ValuesHandler();
	
	public int add(String numbersStr) {
		splitNumbers(numbersStr);
		vh = this.valuesHandler;
		vh.execute();
		return vh.sum;
	}
	
	public void splitNumbers(String numbers) {
		vh = this.valuesHandler;
		for (String s : numbers.split(",|\\n")) {
			if (checkEmptyString(s) == "0") {
				break;
			} else {
				if (vh.checkStringValue(s) == true) {
					vh.checkCount(s);
				}
				else {
					System.out.println("Check value!");
					System.exit(0);
				}
			}
		}
		
	}
	
	public String checkEmptyString(String s) {
		if (s == "") {
			return "0";
		}
		else {
			return "1";
		}
	}
	
}
