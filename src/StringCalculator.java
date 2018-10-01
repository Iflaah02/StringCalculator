
// 1. The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will
//    return 0) for example “” or “1” or “1,2”
// 2. Add method to handle an unknown amount of numbers
// 3. Add method to handle new lines between numbers (instead of commas).
//    1. the following input is ok: “1\n2,3” (will equal 6)
//    2. the following input is NOT ok: “1,\n”
// 4. Calling Add with a negative numbers or invalid input (not numbers) will throw an
//    StringCalculatorException

import java.util.ArrayList;
import java.util.regex.*;

public class StringCalculator {
  public int add(String numbersStr) throws StringCalculatorException {
    if (!isInputValid(numbersStr)) {
      throw new StringCalculatorException();
    }
    int[] numbers = getNumbers(numbersStr);
    int sum = addNumbers(numbers);
    return sum;
  }

  public boolean isInputValid(String input) {
    // The empty string is valid.
    if (input.equals("")) {
      return true;
    }
    Matcher matcher = Pattern.compile("([0-9]+)").matcher(input);
    int count = 0;
    while (matcher.find()) {
      count++;
    }
    // If this is not 0, 1 or 2, it is invalid.
    if (count < 0 || count > 2) {
      return false;
    }

    // If the string doesn't start or end with a number, it is invalid.
    boolean numberAtStart = Pattern.compile("^([0-9]+)").matcher(input).find();
    boolean numberAtEnd = Pattern.compile("([0-9]+)$").matcher(input).find();

    return numberAtStart && numberAtEnd;
  }

  public int[] getNumbers(String input) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    Matcher matcher = Pattern.compile("([0-9]+)").matcher(input);
    while (matcher.find()) {
      for (int i = 0; i < matcher.groupCount(); i++) {
        String match = matcher.group(i);
        list.add(Integer.parseInt(match));
      }
    }
    int[] returnList = new int[list.size()];
    for (int i = 0; i < returnList.length; i++) {
      returnList[i] = list.get(i);
    }
    return returnList;
  }

  public int addNumbers(int[] numbers) {
    if (numbers.length == 0) {
      return 0;
    }
    int sum = 0;
    for (int i : numbers) {
      sum += i;
    }
    return sum;
  }
}
