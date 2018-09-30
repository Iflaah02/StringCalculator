import java.util.StringTokenizer;


public class StringCalculator {
	
	public int add(String numbersStr) throws StringCalculatorException {
		int result= 0;
		try {
			int LineCounter = countLines(numbersStr);
			StringTokenizer Line = new StringTokenizer(numbersStr, "\n");
			while(LineCounter != 0)
			{
				String CurrentLine = Line.nextToken();
				switch(countTokensPerLine(CurrentLine)) {
				case(0):
					result = result + 0;
					break;
				case(1):
					if(checkDigit(CurrentLine,1) == 1)
						result = result + Integer.parseInt(CurrentLine);
					else
						throw new StringCalculatorException();
					break;
				case(2):
					if(checkDigit(CurrentLine,2) == 1) {
						result = result + sumTwoNumbers(CurrentLine);
					}
					else
						throw new StringCalculatorException();
					break;
				default:
				if(checkDigit(CurrentLine,countTokensPerLine(CurrentLine))==1) 
					result = result + sumUnknownNumbers(CurrentLine);
				else
					throw new StringCalculatorException();
					break;
				}

				LineCounter--;
			}
		}catch(StringCalculatorException e) {
			e.PrintError();
		}
		
		return result;
	}
	
	public int countLines(String numbersStr) {
		StringTokenizer st = new StringTokenizer(numbersStr, "\n");
		int i=0;
		if(st.hasMoreTokens())
		{
			while(st.hasMoreTokens()) {
				i++;
				st.nextToken();
			}
		}
		else
		i = 1;
		return i;
	}
	
	public int countTokensPerLine(String numbersStr) {
		StringTokenizer st = new StringTokenizer(numbersStr, ",");
		int i=0;
		while(st.hasMoreTokens()) {
			i++;
			st.nextToken();
		}
		return i;
	}
	
	//If the tokens are all digits then the method will return 1 otherwise 0
	public int checkDigit(String numbersStr, int TokensNum) {
		int flag = 1; //Default value
		try {
			switch(TokensNum) {
			case(1):
				Integer.parseInt(numbersStr);
				if(Integer.parseInt(numbersStr) < 0)
					flag = 0;
				break;
			default:
				StringTokenizer st = new StringTokenizer(numbersStr, ",");
				while(st.hasMoreTokens()) {
					if(Integer.parseInt(st.nextToken()) < 0)
						flag = 0;
				}
			}
		}catch(NumberFormatException e) {
			flag = 0;
		}
		return flag;
	}
	
	public int sumTwoNumbers(String numbersStr) {
		StringTokenizer st = new StringTokenizer(numbersStr, ",");
		int sum;
		int value1 = Integer.parseInt(st.nextToken());
		int value2 = Integer.parseInt(st.nextToken());
		sum = value1 + value2;
		return sum;
	}
	
	public int sumUnknownNumbers(String numbersStr) {
		StringTokenizer st = new StringTokenizer(numbersStr, ",");
		int sum = 0;
		while(st.hasMoreTokens()) {
			sum = sum + Integer.parseInt(st.nextToken());
		}
		return sum;
	}
}
