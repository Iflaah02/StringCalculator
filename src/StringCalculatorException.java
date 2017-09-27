
public class StringCalculatorException extends Exception {
    // Parameterless Constructor
    public StringCalculatorException() {}

    // Constructor that accepts a message
    public StringCalculatorException(String message)
    {
       super(message);
    }
}
