package enums;

public enum Temperature {
	
	CELCIUS("C"),
	FARENHEIT("F"),
	KELVIN("K");
	
	private String unitName;
	
	Temperature(String unitName){
		this.unitName = unitName;
	}
	
	public String getUnitName() {
		return unitName;
	}

}
