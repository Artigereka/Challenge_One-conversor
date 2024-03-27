package conversor;

public class Conversor {
	
	public boolean validateInput(String amount) {
		// Input should have at least a number after an optional dot
		// and up to 8 digits after the dot.
		if(!amount.matches("^\\d+(\\.\\d{0,3})?$")) {
			// If input doesn't aprove, check the existence of the
			// lines to give hints that are only acceptable positive
			// numbers
			if(!amount.matches(".*-.*")) {
				System.out.println("Negative numbers are not allowed.");
				return false;
			}
			System.out.println("Only numeric numbers, up to 3 digits are optional after the dot.");
			return false;
		}
		System.out.println(amount);
		return false;
	}

}
