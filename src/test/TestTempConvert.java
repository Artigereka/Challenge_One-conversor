package test;

import java.math.BigDecimal;

import enums.Temperature;
import util.TemperatureConverter;

public class TestTempConvert {
	
	public static void main(String[] args) {
		Temperature inputTo = Temperature.FARENHEIT;
		Temperature inputFrom = Temperature.KELVIN;
		BigDecimal inputValue = new BigDecimal("10.25"); 
		BigDecimal convertedTemp = TemperatureConverter.getConversionValue(inputValue, inputFrom, inputTo);
		System.out.println(convertedTemp);
	}

}
