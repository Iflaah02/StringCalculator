package defaultpackage;


public class StringCalculatorProduct {
	//This is the God Class that the JDeodorant structured by itself.
	//I was not able to understand what the JDeodorant is suggesting and I had to see what it does.
	private int a;
	private int b = 0;
	private char[] numberArray;
	private String numbers;

	public int calculateSum() {
		int sum = 0;
		sum = a + b;
		return sum;
	}

	public void setB() {
		//This is the first change I created. From Long Method feature of the JDeodorant it came up there is this too long method in if-clause. 
		b = Integer.parseInt(String.valueOf(numberArray[1]));
		System.out.println("b set to:" + b);
	}

	public String calculatorMethod(String numbersSend,
			StringBuilder thisDeleter, StringCalculator stringCalculator) {
		numbers = numbersSend;
		numberArray = numbers.toCharArray();
		if (numberArray.length > 2) {
			for (int j = 0; j < numberArray.length; j++) {
				if (numberArray[j] == '\\' && numberArray[j + 1] == 'n') {
					numbers = new String(numberArray);
					thisDeleter.append(numbers);
					thisDeleter.deleteCharAt(j);
					thisDeleter.deleteCharAt(j);
					numberArray = thisDeleter.toString().toCharArray();
					System.out.println("Numberarray in for after all: "
							+ numberArray[0] + numberArray[1]);
					System.out.println("Numberarray length: "
							+ numberArray.length);
					numbers = new String(numberArray);
				}
			}
		}
		System.out.println("The char array created.");
		int theSum = theSum(stringCalculator);
		System.out.println("Sum set minus one and defined.");
		String stringBack = null;
		System.out.println("stringBack defined and set null.");
		if (!stringCalculator.unknownAmountOfNumbers(numbers))
			unknownNumb();
		else {
			System.out.println("a set to something.");
			System.out.println("A is:" + a + "\n And B is: " + b);
			System.out.println("The sum is: " + theSum);
			stringBack = Integer.toString(theSum);
			System.out.println("stringBack is: " + stringBack);
		}
		return stringBack;
	}

	public int theSum(StringCalculator stringCalculator)
			throws java.lang.NumberFormatException {
		int theSum = -1;
		if (!stringCalculator.unknownAmountOfNumbers(numbers)) {
		} else {
			a = Integer.parseInt(String.valueOf(numberArray[0]));
			if (numberArray.length > 1)
				setB();
			theSum = calculateSum();
		}
		return theSum;
	}

	public void unknownNumb() {
		System.out.println("Unknown amount of numbers.");
		unknownNumberHandler(numbers);
	}

	public void unknownNumberHandler(String unknownNumbers) {
		unknownNumbers = null;
	}
}