import static org.junit.Assert.*;
import org.junit.Test;

public class StringCalculatorTest {
  @Test
  public void isInputValid_ReturnsTrueForEmptyInput() {
    StringCalculator calc = new StringCalculator();
    boolean result = calc.isInputValid("");
    assertTrue("Empty string returned false.", result);
  }

  @Test
  public void isInputValid_ReturnsTrueForOneNumber() {
    StringCalculator calc = new StringCalculator();
    boolean result = calc.isInputValid("1");
    assertTrue("One number string returned false.", result);
  }

  @Test
  public void isInputValid_ReturnsTrueForTwoNumbers() {
    StringCalculator calc = new StringCalculator();
    boolean result = calc.isInputValid("3,13");
    assertTrue("Two number string returned false.", result);
  }

  @Test
  public void isInputValid_ReturnsFalseForThreeNumbers() {
    StringCalculator calc = new StringCalculator();
    boolean result = calc.isInputValid("8, 1, 3");
    assertFalse("Three number string returned true.", result);
  }

  @Test
  public void isInputValid_ReturnsFalseIfNoNumberAtStart() {
    StringCalculator calc = new StringCalculator();
    boolean result = calc.isInputValid(", 1, 3");
    assertFalse("No number at start string returned true.", result);
  }

  @Test
  public void isInputValid_ReturnsFalseIfNoNumberAtEnd() {
    StringCalculator calc = new StringCalculator();
    boolean result = calc.isInputValid("3,4,");
    assertFalse("No number at end string returned true.", result);
  }

  @Test
  public void getNumbers_ReturnsEmptyArrayForNoNumbers() throws StringCalculatorException {
    StringCalculator calc = new StringCalculator();
    int[] numbers = calc.getNumbers("");
    int[] expected = new int[] {};
    assertArrayEquals(expected, numbers);
  }

  @Test
  public void getNumbers_ReturnsTheNumbersForOneNumber() throws StringCalculatorException {
    StringCalculator calc = new StringCalculator();
    int[] numbers = calc.getNumbers("3");
    int[] expected = new int[] { 3 };
    assertArrayEquals(expected, numbers);
  }

  @Test
  public void getNumbers_ReturnsTheNumbersForTwoNumbers() throws StringCalculatorException {
    StringCalculator calc = new StringCalculator();
    int[] numbers = calc.getNumbers("8, 10");
    int[] expected = new int[] { 8, 10 };
    assertArrayEquals(expected, numbers);
  }

  @Test
  public void addNumbers_AddsNumbersForEmptyArray() {
    StringCalculator calc = new StringCalculator();
    int[] numbers = new int[] {};
    int sum = calc.addNumbers(numbers);
    assertEquals(0, sum);
  }

  @Test
  public void addNumbers_AddsNumbersForOneNumber() {
    StringCalculator calc = new StringCalculator();
    int[] numbers = new int[] { 3 };
    int sum = calc.addNumbers(numbers);
    assertEquals(3, sum);
  }

  @Test
  public void addNumbers_AddsNumbersForTwoNumbers() {
    StringCalculator calc = new StringCalculator();
    int[] numbers = new int[] { 8, 1 };
    int sum = calc.addNumbers(numbers);
    assertEquals(9, sum);
  }

  @Test
  public void add_IsCorrectForNoNumbers() throws StringCalculatorException {
    StringCalculator calc = new StringCalculator();
    int result = calc.add("");
    assertEquals(0, result);
  }
  @Test
  public void add_IsCorrectForOneNumber() throws StringCalculatorException {
    StringCalculator calc = new StringCalculator();
    int result = calc.add("4");
    assertEquals(4, result);
  }
  @Test
  public void add_IsCorrectForTwoNumbers() throws StringCalculatorException {
    StringCalculator calc = new StringCalculator();
    int result = calc.add("5,6");
    assertEquals(11, result);
  }
  @Test
  public void add_IsCorrectForTwoNumbersLineSeparator() throws StringCalculatorException {
    StringCalculator calc = new StringCalculator();
    int result = calc.add("4\n8");
    assertEquals(12, result);
  }
  @Test(expected = StringCalculatorException.class)
  public void add_ThrowsForTooManyNumbers() throws StringCalculatorException {
    StringCalculator calc = new StringCalculator();
    int result = calc.add("4,5,6");
  }
  @Test(expected = StringCalculatorException.class)
  public void add_ThrowsForNoNumberAtStart() throws StringCalculatorException {
    StringCalculator calc = new StringCalculator();
    int result = calc.add(",6,8");
  }
  @Test(expected = StringCalculatorException.class)
  public void add_ThrowsForNoNumberAtEnd() throws StringCalculatorException {
    StringCalculator calc = new StringCalculator();
    int result = calc.add("4,5,");
  }
}
