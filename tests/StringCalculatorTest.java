import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testNumOfnums() {
		StringCalculator strC = new StringCalculator();
		
		String testStr = "";
		int testSize = strC.numOfnums(testStr);
		assertEquals(testSize, 0);
		
		String testStr2 = "1,2";
		int testSize2 = strC.numOfnums(testStr2);
		assertEquals(testSize2, 2);
	}
	
	@Test
	public void testReplaceNL() {
		StringCalculator strC = new StringCalculator();
		
		String testStr = "1\n2";
		String testStr2 = "1,2";
		String testStr3 = "1";
		
		String newStr = strC.replaceNewlines(testStr);
		String newStr2 = strC.replaceNewlines(testStr2);
		String newStr3 = strC.replaceNewlines(testStr3);
		
		assertEquals(newStr, "1,2");
		assertEquals(newStr2, "1,2");
		assertEquals(newStr3, "1");
	}
	
	@Test
	public void testAdd() throws StringCalculatorException {
		StringCalculator strC = new StringCalculator();
		
		String testStr1 = "1,2";
		int result1 = strC.add(testStr1);
		assertEquals(result1, 3);
		
		String testStr2 = "2\n2";
		int result2 = strC.add(testStr2);
		assertEquals(result2, 4);
		
		String testStr3 = "1";
		int result3 = strC.add(testStr3);
		assertEquals(result3, 1);
		
		String testStr4 = "";
		int result4 = strC.add(testStr4);
		assertEquals(result4, 0);
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testCheckInput() throws StringCalculatorException {
		StringCalculator strC = new StringCalculator();
		
		String testStr1 = "-1,2";
		strC.checkInput(testStr1);
		
		String testStr2 = "///";
		strC.checkInput(testStr2);
		
		String testStr3 = "1\na";
		strC.checkInput(testStr3);
		
		String testStr4 = "abc";
		strC.checkInput(testStr4);
		
		String testStr5 = "1, 2";
		strC.checkInput(testStr5);
		
		String testStr6 = "1,,";
		strC.checkInput(testStr6);
	}

}
