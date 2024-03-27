package util;

import java.math.BigDecimal;
import enums.Temperature;

public class TemperatureConverter {
	
//	private BigDecimal inputValue;
//	private String inputUnitFrom;
//	private String inputUnitTo;
//	
//	private BigDecimal cToF = new BigDecimal("2");
//	
//	public TemperatureConverter(String inputValue, String inputUnitFrom, String inputUnitTo) {
////		this.inputValue = Double.parseDouble(inputValue);
//		this.inputValue = new BigDecimal(inputValue);
//		this.inputUnitFrom = inputUnitFrom;
//		this.inputUnitTo = inputUnitTo;
//	}
	
	/**
	 * Converts inputValue from one unit to another
	 * using C as a medium if needed to
	 * i.e: from F to K: convertToC(F) -> convertFromC(K)
	 */
	public double getConversionValue(double inputValue, Temperature fromUnit, Temperature toUnit) {
	if (fromUnit.toString() == "CELSIUS") {
		convertFromC(inputValue, toUnit);
//		return inputValue.multiply(cToF).toString();
	} else if (toUnit.toString() == "CELSIUS") {
		convertToC(inputValue, fromUnit);
	} else {
		convertFromC(convertToC(inputValue,fromUnit),toUnit);
	}
	return 0;
}
	
	/**
	 * Converts value from any unit to C
	 */
	private double convertToC(double inputValue, Temperature unitFrom) {
		switch(unitFrom) {
		case FARENHEIT:
			return (inputValue - 32) * 5/9;
		case KELVIN:
			return inputValue - 273.15;
		default:
			throw new IllegalArgumentException("Unexpected value: " + unitFrom);
		}
	}
	
	/**
	 * Converts value from C to any unit
	 */
	public double convertFromC(double inputValue, Temperature unitFrom) {
	switch (unitFrom) {
	case FARENHEIT:
		return inputValue * 9 / 5 + 32;
	case KELVIN:
		return inputValue + 273.15;
	default:
		throw new IllegalArgumentException("Unexpected value: " + unitFrom);
	}
}

}
