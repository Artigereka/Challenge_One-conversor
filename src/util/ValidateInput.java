package util;

public class ValidateInput {
	
	private static String validationError;

	public static boolean validateInput(String amount) {
		/**
		 * Input must have at least a number
		 * followed by an optional dot and at least one number	
		 */
		if (amount.matches("^\\d+(\\.\\d+)?$") || amount.matches("")) {
			return true;
		} else {
			if (amount.matches("-.*")) {
				validationError = "Only positive numbers";
				return false;
			} else {
				validationError = "Only numbers and optional a dot followed by decimals";
				return false;
			}
		}
	}

	public static String getValidationError() {
		return validationError;
	}

}
