package util;

import java.math.BigDecimal;
import enums.Temperature;

public class TemperatureConvert {
	
	private BigDecimal inputValue;
	private String inputUnitFrom;
	private String inputUnitTo;
	
	private BigDecimal cToF = new BigDecimal("2");
	
	public TemperatureConvert(String inputValue, String inputUnitFrom, String inputUnitTo) {
//		this.inputValue = Double.parseDouble(inputValue);
		this.inputValue = new BigDecimal(inputValue);
		this.inputUnitFrom = inputUnitFrom;
		this.inputUnitTo = inputUnitTo;
	}
	
	/**
	 * Converts inputValue from one unit to another
	 * using C as a medium if needed to
	 * i.e: from F to K: convertToC(F) -> convertFromC(K)
	 */
	public BigDecimal getConversion() {
		if(inputUnitFrom == "C" && inputUnitTo == "F") {
			return inputValue.multiply(cToF);
		}
		return inputValue;
	}
	
	/**
	 * Converts value from C to any unit
	 */
//	public void convertFromC() {
//		
//	}

}
