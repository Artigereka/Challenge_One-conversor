package test;

import enums.Temperature;
import util.TemperatureConverter;

public class TestTempConvert {
	
	public static void main(String[] args) {
//		TemperatureConvert tc = new TemperatureConvert("10.012", "C", "F");
//		System.out.println(tc.getConversion());
		
		TemperatureConverter tc = new TemperatureConverter();
		Temperature inputFrom = null;
		Temperature inputTo = null;
		inputFrom.setUnitName("CELCIUS");
		tc.getConversionValue(10.25, inputFrom, inputTo);
	}

}
