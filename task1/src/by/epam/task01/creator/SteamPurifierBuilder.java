package by.epam.task01.creator;

import by.epam.task01.entity.cleaner.SteamPurifier;

public class SteamPurifierBuilder extends Builder {

	private float maxPressure;
	private int heatTime;
	private float boilVolume;
	
	public SteamPurifierBuilder(String manuf,int pow,int mas,String exOr) {
		super(manuf, pow, mas, exOr);
	}
	
	public void setMaxPressure(float val) {
			if (val <= 0) {
				LOG.error("SteamPurifier exception.");
				throw new IllegalArgumentException("Max. pressure cannot be negative or equal zero!");
			}
			this.maxPressure = val;	
	}
	
	public void setHeatTime(int val) {
			if (val <= 0) {
				LOG.error("SteamPurifier exception.");
				throw new IllegalArgumentException("Heat time cannot be negative or equal zero!");
			}
			this.heatTime = val;
	}
	
	public void setBoilVolume(float val) {
			if (val <= 0) {
				LOG.error("SteamPurifier exception.");
				throw new IllegalArgumentException("Boil volume cannot be negative or equal zero!");
			}
			this.boilVolume = val;
	}

	public float getMaxPressure() {
		return this.maxPressure;
	}
	
	public int getHeatTime() {
		return this.heatTime;
	}
	
	public float getBoilVolume() {
		return this.boilVolume;
	}
	
	public SteamPurifier build() {
		return new SteamPurifier(this);
	}
}
