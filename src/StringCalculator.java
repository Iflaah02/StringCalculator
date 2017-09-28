package calculator;

import org.junit.*;
import static org.junit.Assert.*;


public class StringCalculator {
	public static int add(String text) {
		if(text.empty()) {
		return 0;
	} else {
		return Integer.parseInt(text);
	}
	}
}

