import java.util.Arrays;
import java.util.List;

class StringCalculator {

	/**
	 * add(String numbersStr)
	 *
	 * Adds the given numbers together.
	 *
	 * @param numbersStr - The numbers in a string
	 * @return The sum of the numbers
	 */
	int add(String numbersStr) throws StringCalculatorException {

		final int[] sum = {0};

		// Check that the string is not null or empty
		if (isStringNotNullAndNotEmpty(numbersStr)) {
		    String preparedStr = prepareStringForCalculation(numbersStr); // Prepare the string for calculation

			List<String> numbersList = Arrays.asList(preparedStr.split(",")); // Assign the expected numbers to an array
            numbersList.forEach((currentItem) -> {
                if(!currentItem.isEmpty()) {
                    sum[0] = sum[0] + Integer.parseInt(currentItem);
                }
            });
		}

		return sum[0]; // Return the sum of the items
	}

    /**
     * private boolean isStringNotNullAndNotEmpty
     * Checks if the given String is null or empty. The null check is performed first to ensure no NPE is thrown.
     *
     * @param stringToBeChecked - The String that needs to be checked
     * @return true/false depending on if the String was null/empty or not
     */
	private boolean isStringNotNullAndNotEmpty(String stringToBeChecked) {
	    return (stringToBeChecked != null && !stringToBeChecked.isEmpty());
    }

    /**
     * private String prepareStringForCalculation
     * Prepares the user input for calculation.
     *
     * @param originalStr - The original String that needs to be prepared
     * @return preparedStr - The prepared String
     * @throws StringCalculatorException - Throw if the regex doesn't match
     */
    private String prepareStringForCalculation(String originalStr) throws StringCalculatorException{
        String regex = "[0-9, /,]+"; //The regex that the check will be performed against

        // Replace whitespace with comma
        String preparedStr = originalStr.replaceAll("\\s", ",");

        // Abort execution if string contains characters other than numbers [0-9] or comma [/,].
        if (!preparedStr.matches(regex)) {
            throw new StringCalculatorException();
        }

	    return preparedStr;
    }

}
