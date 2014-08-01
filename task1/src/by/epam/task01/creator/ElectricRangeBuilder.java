package by.epam.task01.creator;

import by.epam.task01.entity.kitchen.ElectricRange;

public class ElectricRangeBuilder extends Builder {
	private int maxTemperature;
	private int panCount;
	private int divisionsCount;
	
	public ElectricRangeBuilder(String manuf,int pow,int mas,String exOr) {
		super(manuf,pow, mas, exOr);		
	}
	
	public void setMaxTemperature(int val) {
		if (val <= 0) {
			LOG.error("ElectricRangeBuilder exception.");
			throw new IllegalArgumentException("Max. temperature cannot be negative or equal zero!");
		}
		this.maxTemperature = val;			
	}
	
	public void setPanCount(int val){
		if (val <= 0) {
			LOG.error("ElectricRangeBuilder exception.");
			throw new IllegalArgumentException("Pans count cannot be negative or equal zero!");
		}
		this.panCount = val;			
	}
	
	public void setDivisionsCount(int val){
		if (val < 0) {
			LOG.error("ElectricRangeBuilder exception.");
			throw new IllegalArgumentException("Cutout divisions count cannot be negative!");
		}
		this.divisionsCount = val;			
	}
	
	public int getMaxTemperature() {
		return maxTemperature;
	}

	public int getPanCount() {
		return panCount;
	}

	public int getDivisionsCount() {
		return divisionsCount;
	}
	
	public ElectricRange build(){
		return new ElectricRange(this);
	}
}
