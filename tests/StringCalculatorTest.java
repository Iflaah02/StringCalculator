import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    void addWorksWithEmptyString() throws StringCalculatorException {

        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add(""));
    }

    @Test
    void addWorksWithOneNumber() throws StringCalculatorException {

        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("1"));
    }

    @Test
    void addWorksWithTwoNumbers() throws StringCalculatorException {

        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("1,2"));
    }

    @Test
    void addWorksWithThreeNumbers() throws StringCalculatorException {

        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1,2,3"));
    }

    @Test
    void addWorksWithAnyNumberOfNumbers() throws StringCalculatorException {

        int testTo = 62;

        int sum = 0;

        // Build test string
        String str = "";

        for(int i = 0; i < testTo; ++i){

            if(i > 0)
                str += ",";

            str += Integer.toString(i);
            sum += i;
        }

        StringCalculator calc = new StringCalculator();
        assertEquals(sum, calc.add(str));
    }

    @Test
    void addWorksWithNewLinesAsSeparators() throws StringCalculatorException {

        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2\n3"));
    }

    @Test
    void addWorksWithNewLinesAndMixedCommasAsSeparators() throws StringCalculatorException {

        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }

    @Test
    void addThrowsIfEndingWithSeparator() throws StringCalculatorException {

        StringCalculator calc = new StringCalculator();
        assertThrows(StringCalculatorException.class,
                () -> {
            calc.add("1,2,");
        });
    }

    @Test
    void addThrowsIfEndingWithDoubleSeparator() throws StringCalculatorException {

        StringCalculator calc = new StringCalculator();
        assertThrows(StringCalculatorException.class,
                () -> {
                    calc.add("1,2,\n");
                });
    }

    @Test
    void addThrowsWithNegativeNumbers() throws StringCalculatorException {

        StringCalculator calc = new StringCalculator();
        assertThrows(StringCalculatorException.class,
                () -> {
                    calc.add("1,2,-3");
                });
    }

    @Test
    void addThrowsWithNotNumbers() throws StringCalculatorException {

        StringCalculator calc = new StringCalculator();
        assertThrows(StringCalculatorException.class,
                () -> {
                    calc.add("1,2,a");
                });
    }
}