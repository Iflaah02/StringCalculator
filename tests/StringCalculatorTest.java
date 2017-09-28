import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
    private StringCalculator calculator = new StringCalculator();
	@Test
	public void whenSingleStringCharacterThenReturnValue() {
		addStringValue("", 0);
		addStringValue("0", 0);
		addStringValue("1", 1);
		addStringValue("2", 2);
	}
	@Test
	public void whenMultipleStringCharactersWithCommaThenReturnValue() {
		addStringValue("0,1", 1);
		addStringValue("1,1", 2);
		addStringValue("1,2", 3);
		addStringValue("2,2", 4);
	}
	@Test
	public void whenMultipleStringCharactersWithNewLineThenReturnValue() {
		addStringValue("1\n1", 2);
		addStringValue("2\n2", 4);
		addStringValue("3\n3", 6);
	}
	@Test
	public void whenMultipleStringCharactersWithNewLineAndCommaThenReturnValue() {
		addStringValue("1\n1,3", 5);
		addStringValue("2,2\n3", 7);
		addStringValue("3\n3", 6);
	}

	private void addStringValue(String numbersStr, int i) {
		assertEquals(i, calculator.add(numbersStr));
	}

}
