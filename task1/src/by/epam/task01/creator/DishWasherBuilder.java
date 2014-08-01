package by.epam.task01.creator;

import by.epam.task01.entity.kitchen.DishWasher;

public class DishWasherBuilder extends Builder {	
	private int volume;
	private int loudness;
	private int waterIntake;
	private int washCycleTime;
	
	public DishWasherBuilder(String manuf,int pow,int mas,String exOr) {
		super(manuf, pow, mas, exOr);		
	}
	
	public void setVolume(int val){
			if (val <= 0) {
				LOG.error("DishWasher exception.");
				throw new IllegalArgumentException("DishWasher volume cannot be negative or equal zero!");
			}
			this.volume = val;	
	}
	
	public void setLoudness(int val){
			if (val < 0) {
				LOG.error("DishWasher exception.");
				throw new IllegalArgumentException("DishWasher loudness cannot be negative!");
			}
			this.loudness = val;
			
	}
	
	public void setWaterIntake(int val){
			if (val < 0) {
				LOG.error("DishWasher exception.");
				throw new IllegalArgumentException("Water intake cannot be negative!");
			}
			this.waterIntake = val;
	}
	
	public void setWashCycleTime(int val) {
			if (val <= 0) {
					LOG.error("DishWasher exception.");
					throw new IllegalArgumentException("Wash cycle time cannot be negative or equal zero!");
			}
			this.washCycleTime = val;
		
	}
	
	public int getVolume() {
		return volume;
	}

	public int getLoudness() {
		return loudness;
	}

	public int getWaterIntake() {
		return waterIntake;
	}

	public int getWashCycleTime() {
		return washCycleTime;
	}
	
	public DishWasher build() {
		return new DishWasher(this);
	}
}
