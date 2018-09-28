import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {
	
	@Test
	public void sunEmptyStringTo0() {
		assertThat(StringCalculator.add(""), is(0));
	}
	
	@Test
	public void SumSingleNumberToItself() {
		assertThat(StringCalculator.add("5"), is(5));
		assertThat(StringCalculator.add("42"), is(42));
	}
	
	@Test
	public void sunsTwoNumbersSeparatedByComma() {
		assertThat(StringCalculator.add("1,2"), is(3));
	}
	
}