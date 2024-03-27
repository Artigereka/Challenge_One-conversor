package test;

import enums.Temperature;
import util.TemperatureConverter;

public class TestTempConvert {
	
	public static void main(String[] args) {
//		TemperatureConvert tc = new TemperatureConvert("10.012", "C", "F");
//		System.out.println(tc.getConversion());
		
//		TemperatureConverter tc = new TemperatureConverter();
		Temperature inputFrom = Temperature.KELVIN;
		System.out.println(inputFrom.toString());
		Temperature inputTo = Temperature.FARENHEIT;
		double convertedTemp = TemperatureConverter.getConversionValue(10.25, inputFrom, inputTo);
		System.out.println(convertedTemp);
//		tc.getConversionValue(10.25, inputFrom, inputTo);
	}

}
