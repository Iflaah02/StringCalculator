import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class StringParserTest {
	
	@Test
	public void parseIntegerList_emptyString_emptyArray() {
		//Init
		String input = "";
		
		//Act
		StringParser parser = new StringParser();
		List<Integer> result = parser.parseIntegerList(input, ",");
		
		//Test
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void parseIntegerList_oneIntegerString_oneElementArray() {
		//Init
		String input = "12";
		
		//Act
		StringParser parser = new StringParser();
		List<Integer> result = parser.parseIntegerList(input, ",");
		
		//Test
		assertEquals(1, result.size());
	}
	
	@Test
	public void parseIntegerList_multipleIntegerString_multipleElementArray() {
		//Init
		String input = "12,13,15,20";
		
		//Act
		StringParser parser = new StringParser();
		List<Integer> result = parser.parseIntegerList(input, ",");
		
		//Test
		assertEquals(4, result.size());
	}
	
	@Test
	public void parseIntegerList_oneIntegerString_correctValue() {
		//Init
		String input = "12";
		
		//Act
		StringParser parser = new StringParser();
		List<Integer> result = parser.parseIntegerList(input, ",");
		
		//Test
		Integer expected = 12;
		Integer actual = result.get(0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseIntegerList_multipleIntegerString_correctValues() {
		//Init
		String input = "12,13";
		
		//Act
		StringParser parser = new StringParser();
		List<Integer> result = parser.parseIntegerList(input, ",");
		
		//Test
		Integer value1 = 12;
		Integer value2 = 13;
		Integer actual1 = result.get(0);
		Integer actual2 = result.get(1);
		assertTrue(value1 == actual1 && value2 == actual2);
	}
	
	@Test
	public void parseIntegerList_negativeIntegerString_correctValues() {
		//Init
		String input = "-12,13";
		
		//Act
		StringParser parser = new StringParser();
		List<Integer> result = parser.parseIntegerList(input, ",");
		
		//Test
		Integer value1 = -12;
		Integer value2 = 13;
		Integer actual1 = result.get(0);
		Integer actual2 = result.get(1);
		assertTrue(value1 == actual1 && value2 == actual2);
	}
	
	@Test(expected = NumberFormatException.class) 
	public void parseIntegerList_invalidString_throwException() {
		//Init
		String input = "dsadas";
		
		//Act
		StringParser parser = new StringParser();
		List<Integer> result = parser.parseIntegerList(input, ",");
	}
}
