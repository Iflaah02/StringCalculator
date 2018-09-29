import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
	//when more than 2 numbers are used (Failure case) 
//    @Test(expected = RuntimeException.class)
//    public final void whenMoreThanTwoNumbersAreUsedThenThrowAnException() {
//        StringCalculator.add("1,2,3");
//    }
    //when 2 numbers are input (Success case)
    @Test
    public final void whenTwoNumbersAreInputThenNoExceptionIsThrown() {
        StringCalculator.add("1,2");
        Assert.assertTrue(true);
    }
    //when non number is input (Failure case)
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsInputThenThrowAnException() {
        StringCalculator.add("1,X");
    }
    //when empty string is input (Success case)
    @Test
    public final void whenEmptyStringInputIsUsedThenReturnOutputIsZero() {
        Assert.assertEquals(0, StringCalculator.add(""));
    } 
   
    //when one number is used as input then output is that same number
    @Test
    public final void whenOneNumberInputIsUsedThenReturnedOutputIsThatSameNumber() {
        Assert.assertEquals(3, StringCalculator.add("3"));
    }
    //when two numbers are input then output is their sum
    @Test
    public final void whenTwoNumbersAreInputThenOutputIsTheirSum() {
        Assert.assertEquals(3+6, StringCalculator.add("3,6"));
    }
    
    //when more than 2 numbers are used (Failure case)
    //when multiple number of inputs are used then output is their sum 
    @Test
    public final void whenMultipleNumberOfInputsAreUsedThenOutputIsTheirSum() {
        Assert.assertEquals(3+6+15+18+46+33, StringCalculator.add("3,6,15,18,46,33"));
    }
    
    //when new line is used between input numbers then output is their sum 
    @Test
    public final void whenNewLineIsUsedBetweenInputNumbersThenOutputIsTheirSum() {
        Assert.assertEquals(3+6+15, StringCalculator.add("3,6n15"));
    }
    
    //when negative number is in input (Failure case)
    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumberIsInInputThenThrowRuntimeException() {
        StringCalculator.add("3,-6,15,18,46,33");
    }
    //when multiple negative numbers are in input (Failure case)
    @Test
    public final void whenMultipleNegativeNumbersAreInInputThenThrowRuntimeException() {
        RuntimeException exception = null;
        try {
            StringCalculator.add("3,-6,15,-18,46,33");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
    }
}

 
