package test;

import java.math.BigDecimal;

import enums.TemperatureUnit;
import util.TemperatureConverter;

public class TestTempConvert {
	
	public static void main(String[] args) {
		TemperatureUnit inputTo = TemperatureUnit.KELVIN;
		TemperatureUnit inputFrom = TemperatureUnit.FARENHEIT;
		BigDecimal inputValue = new BigDecimal("123.325"); 
		BigDecimal convertedTemp = TemperatureConverter.getConversionValue(inputValue, inputFrom, inputTo);
		System.out.println(convertedTemp);
	}

}
