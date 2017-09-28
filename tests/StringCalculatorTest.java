package calculator;

import org.junit.*;
import static org.junit.Assert.*;

public class stringcalculatortest {
	@Test
	public void whenEmptyShouldReturnZero() {
	assertEquals(0, stringcalculator.add(""));
}
	
	@Test
	public void shouldReturnNumbrerOneNumber() {
	assertEquals(1, stringcalculator.add("1"));
	}
	
}