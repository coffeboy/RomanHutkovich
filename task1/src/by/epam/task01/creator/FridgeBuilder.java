package by.epam.task01.creator;

import by.epam.task01.entity.kitchen.Fridge;

public class FridgeBuilder extends Builder {
	private int compressors;
	private int volume;
	private int storageTemp;
	
	public FridgeBuilder(String manuf,int pow,int mas,String exOr) {
		super(manuf,pow, mas, exOr);		
	}
	
	public void setCompressors(int val){
		if (val <= 0) {
			LOG.error("FridgeBuilder exception.");
			throw new IllegalArgumentException("Fridge compressors count can't be negative or equal zero!");
		}
		this.compressors = val;	
	}
	
	public void setVolume(int val){
		if (val <= 0) {
			LOG.error("FridgeBuilder exception.");
			throw new IllegalArgumentException("Fridge volume can't be negative or equal zero!");
		}
		this.volume = val;			
	}
	
	public void setStorageTemp(int val){
		this.storageTemp = val;
	}	
	
	public int getCompressors() {
		return compressors;
	}

	public int getVolume() {
		return volume;
	}

	public int getStorageTemp() {
		return storageTemp;
	}	
	
	public Fridge build(){
		return new Fridge(this);
	}
}
