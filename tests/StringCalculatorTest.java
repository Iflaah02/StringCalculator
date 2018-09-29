import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
	//when more than 2 numbers are used (Failure case) 
//    @Test(expected = RuntimeException.class)
//    public final void whenMoreThanTwoNumbersAreUsedThenThrowAnException() {
//        StringCalculator.add("9,8,7");
//    }
    //when 2 numbers are input (Success case)
    @Test
    public final void whenTwoNumbersAreInputThenNoExceptionIsThrown() {
        StringCalculator.add("4,10");
        Assert.assertTrue(true);
    }
    //when non number is input (Failure case)
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsInputThenThrowAnException() {
        StringCalculator.add("6,a");
    }
    //when empty string is input (Success case)
    @Test
    public final void whenEmptyStringInputIsUsedThenReturnOutputIsZero() {
        Assert.assertEquals(0, StringCalculator.add(""));
    } 
   
    //when one number is used as input then output is that same number
    @Test
    public final void whenOneNumberInputIsUsedThenReturnedOutputIsThatSameNumber() {
        Assert.assertEquals(1, StringCalculator.add("1"));
    }
    //when two numbers are input then output is their sum
    @Test
    public final void whenTwoNumbersAreInputThenOutputIsTheirSum() {
        Assert.assertEquals(5+2, StringCalculator.add("5,2"));
    }
    
    //when more than 2 numbers are used (Failure case)
    //when multiple number of inputs are used then output is their sum 
    @Test
    public final void whenMultipleNumberOfInputsAreUsedThenOutputIsTheirSum() {
        Assert.assertEquals(10+20+3+40+50, StringCalculator.add("10,20,3,40,50"));
    }
    
    //when new line is used between input numbers then output is their sum 
    @Test
    public final void whenNewLineIsUsedBetweenInputNumbersThenOutputIsTheirSum() {
        Assert.assertEquals(4+1+22, StringCalculator.add("4,1n22"));
    }
    //when negative number is in input (Failure case)
    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumberIsInInputThenThrowRuntimeException() {
        StringCalculator.add("10,-20,3,40,50");
    }
    //when multiple negative numbers are in input (Failure case)
    @Test
    public final void whenMultipleNegativeNumbersAreInInputThenThrowRuntimeException() {
        RuntimeException exception = null;
        try {
            StringCalculator.add("10,-20,3,-40,50");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals("Negative Numbers are not allowed: [-20, -40]", exception.getMessage());
    }
}

 
