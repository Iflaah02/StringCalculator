import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StringCalculatorTest {

	
	@Test
	public void testParseInput() {
		StringCalculator obj = new StringCalculator();
		List<Integer> list = new ArrayList<>();
		try {
		 list =  obj.parseInput("1,23,4");
		} catch (StringCalculatorException e) {
			
		}
		List<Integer> testList = new ArrayList<>();
		testList.add(1);
		testList.add(23);
		testList.add(4);
		
		//list should now be the same
		assertEquals(testList, list);
		
		testList.add(3);
		//list should not be equal
		assertNotEquals(testList, list);
		
	}
	@Test
	public void testParseInputWithNewLine() {
		StringCalculator obj = new StringCalculator();
		List<Integer> list = new ArrayList<>();
		try {
			  list =  obj.parseInput("1,23,4");
			} catch (StringCalculatorException e) {
				
			}
		List<Integer> testList = new ArrayList<>();
		testList.add(1);
		testList.add(23);
		testList.add(4);
		
		//list should now be the same
		assertEquals(testList, list);
		
		testList.add(3);
		//list should not be equal
		assertNotEquals(testList, list);	
	}
	@Test
	public void testParseInputWithOnlyComma() {
		StringCalculator obj = new StringCalculator();
		List<Integer> list = new ArrayList<>();
		try {
			  list =  obj.parseInput(",");
			} catch (StringCalculatorException e) {
				
			}
		List<Integer> testList = new ArrayList<>();
		//list should now be the same
		assertEquals(testList, list);
		
		testList.add(0);
		//list should not be same
		assertNotEquals(testList, list);
		
	}
	
	@Test
	public void testResult() {
		StringCalculator obj = new StringCalculator();
		
		int res = obj.add("1,2,4\n3");
		
		assertEquals(10, res);
		
		assertNotEquals(9, res);
	}

	
	
	

}
