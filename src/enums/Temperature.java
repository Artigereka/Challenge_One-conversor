package enums;

public enum Temperature {
	
	CELCIUS("Celcius"),
	FARENHEIT("Farenheit"),
	KELVIN("Kelvin");
	
	private String unitName;
	
	Temperature(String unitName){
		this.unitName = unitName;
	}
	
	public String getUnitName() {
		return unitName;
	}
	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

}
