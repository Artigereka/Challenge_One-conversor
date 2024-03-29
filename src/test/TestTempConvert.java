package test;

import java.math.BigDecimal;

import enums.Temperature;
import util.TemperatureConverter;

public class TestTempConvert {
	
	public static void main(String[] args) {
		Temperature inputTo = Temperature.KELVIN;
		Temperature inputFrom = Temperature.FARENHEIT;
		BigDecimal inputValue = new BigDecimal("123.325"); 
		BigDecimal convertedTemp = TemperatureConverter.getConversionValue(inputValue, inputFrom, inputTo);
		System.out.println(convertedTemp);
	}

}
