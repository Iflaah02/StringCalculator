

public class StringCalculator {
	
	protected String[] inputs;
	protected int[] numbers;
	
	StringCalculator(){
	}
	
	protected void setInput(String input) {
		inputs = input.split(",");
	}
	
	public boolean checkInput() {
		
		if(inputs.length == 1 && inputs[0].isEmpty()) {
			return true;
		}
		
		for(int i = 0; i < inputs.length; i++) {
			for(int j = 0; j < inputs[i].length(); j++) {
				if(!Character.isDigit(inputs[i].charAt(j))) {
					return false;
				}
			}
		}	
		
		return true;
	}
	
	
	
	public int add(String numbersStr) {
		// Returns the sum of the numbers given in numbersStr
		
		// not yet implemented
		
		
		return 0;
	}
	
	
}
