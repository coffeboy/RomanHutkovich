package by.epam.task01.creator;

import by.epam.task01.creator.Builder;
import by.epam.task01.entity.cleaner.WashingMachine;

public class WashingMachineBuilder extends Builder {
	private boolean hasDryer;
	private float maxLoad;
	private boolean hasDirectDrive;
	private boolean canOpenHatch180;
	private int dryingSpeed;
	
	public WashingMachineBuilder(String manuf,int pow,int mas,String exOr) {
		super(manuf, pow, mas, exOr);
	}
	
	public void setHasDryer(boolean val) {
		this.hasDryer = val;
	}
	
	public void setMaxLoad(float val) {
			if (val <= 0) {
				LOG.error("WashingMachine exception.");
				throw new IllegalArgumentException("Max. load cannot be negative or equal zero!");
			}
			this.maxLoad = val;	
	}
	
	public void setHasDirectDrive(boolean val) {
		this.hasDirectDrive = val;
	}
	
	public void setCanOpenHatch180(boolean val) {
		this.canOpenHatch180 = val;
	}
	
	public void setDryingSpeed(int val) {
			if (val <= 0) {
				LOG.error("WashingMachine exception.");
				throw new IllegalArgumentException("Drying speed cannot be negative!");
			}
			this.dryingSpeed = val;
			
	}
	
	public boolean isHasDryer() {
		return hasDryer;
	}

	public float getMaxLoad() {
		return maxLoad;
	}

	public boolean isHasDirectDrive() {
		return hasDirectDrive;
	}

	public boolean isCanOpenHatch180() {
		return canOpenHatch180;
	}

	public int getDryingSpeed() {
		return dryingSpeed;
	}	
	
	public WashingMachine build() {
		return new WashingMachine(this);
	}
}
