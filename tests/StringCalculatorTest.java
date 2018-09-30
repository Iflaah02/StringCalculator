import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test() {
		StringCalculator cal = new StringCalculator();
		cal.add("");	
		cal.add("2");		
		cal.add("-2");		
		cal.add("a");		
		cal.add("1,2,3");		
		cal.add("1,\n");	
		cal.add("\n,1");	
		cal.add("-1,a");
		cal.add("a,-1");
		
		cal.add("1\n2,3");
		cal.add("1\n2,3\n4");
		cal.add("1,3\n4");
		cal.add("1,2");

		cal.add("a,2");
		cal.add("-1,2");
		cal.add("1,a");
		cal.add("1,-2");
				
		cal.add("a\n2,3");		
		cal.add("-1\n2,3");
		cal.add("1\na,3");
		cal.add("1\n-2,3");
		cal.add("1,a\n4");
		cal.add("1,-3\n4");
		cal.add("1,3\na");
		cal.add("1,3\n-4");

		cal.add("1\n2,a");
		cal.add("1\n2,-2");
		cal.add("a,3\n4");
		cal.add("-1,3\n4");
		cal.add("a\nb,c\nd");
		cal.add("-1\n-2,-3\n-4");
		cal.add("-1\n\n,-3\n-4");
	}

}
