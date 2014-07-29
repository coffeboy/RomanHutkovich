/*
 * Роман Гуткович
 */
package by.epam.task01.kitchen;

import org.apache.log4j.Logger;

import by.epam.task01.mainpkg.Device;

/**
 * Класс, описывающий посудомойку.
 * Используется паттерн Builder.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class DishWasher extends Device {
	public static final Logger LOG = Logger.getLogger(DishWasher.class);
	
	/** Объем посудомойки (л) */
	private final int VOLUME;
	
	/** Уровень шума (дБ) */
	private final int LOUDNESS;
	
	/** Количество потребляемой воды (л) */
	private final int WATER_INTAKE;
	
	/** Время цикла очистки (мин) */
	private final int WASH_CYCLE_TIME;
	
	public static class DishWasherBuilder extends Builder {	
		private int volume;
		private int loudness;
		private int waterIntake;
		private int washCycleTime;
		
		public DishWasherBuilder(String manuf,int pow,int mas,String exOr) {
			super(manuf, pow, mas, exOr);		
		}
		
		public DishWasherBuilder volume(int val){
			try {
				if (val <= 0) {
					throw new IllegalArgumentException("DishWasher volume cannot be negative or equal zero!");
				}
				this.volume = val;
			} catch (IllegalArgumentException iae) {
				LOG.error("DishWasher exception: "+iae);
			}
			return this;
		}
		
		public DishWasherBuilder loudness(int val){
			try {
				if (val < 0) {
					throw new IllegalArgumentException("DishWasher loudness cannot be negative!");
				}
				this.loudness = val;
			} catch (IllegalArgumentException iae) {
				LOG.error("DishWasher exception: "+iae);
			}
			return this;
		}
		
		public DishWasherBuilder waterIntake(int val){
			try {
				if (val < 0) {
					throw new IllegalArgumentException("Water intake cannot be negative!");
				}
				this.waterIntake = val;
			} catch (IllegalArgumentException iae) {
				LOG.error("DishWasher exception: "+iae);
			}			
			return this;
		}
		
		public DishWasherBuilder washCycleTime(int val) {
			try {
				if (val <= 0) {
					throw new IllegalArgumentException("Wash cycle time cannot be negative or equal zero!");
				}
				this.washCycleTime = val;
			} catch (IllegalArgumentException iae) {
				LOG.error("DishWasher exception: "+iae);
			}			
			return this;
		}
		
		public DishWasher build() {
			return new DishWasher(this);
		}
	}

	public DishWasher(DishWasherBuilder builder) {
		super(builder);
		
		VOLUME = builder.volume;
		LOUDNESS = builder.loudness;
		WATER_INTAKE = builder.waterIntake;
		WASH_CYCLE_TIME = builder.washCycleTime;
		LOG.info("DishWasher building complete!");
	}
	
	public int getVolume() {
		return VOLUME;
	}
	
	public int getLoudness() {
		return LOUDNESS;
	}
	
	public int getWaterIntake() {
		return WATER_INTAKE;
	}

	public int getWashingTime() {
		return WASH_CYCLE_TIME;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("Volume (lt.): ").append(getVolume()).append("\n");
		sb.append("Loudness level (dB): ").append(getLoudness()).append("\n");
		sb.append("Water intake (lt.): ").append(getWaterIntake()).append("\n");
		sb.append("Washing time (min): ").append(getWashingTime()).append("\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		
		result = prime * result + LOUDNESS;
		result = prime * result + VOLUME;
		result = prime * result + WASH_CYCLE_TIME;
		result = prime * result + WATER_INTAKE;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (null == obj) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		DishWasher other = (DishWasher) obj;
		if (!super.equals(other)) {
			return false;
		}
		
		if (LOUDNESS != other.LOUDNESS) {
			return false;
		}
		
		if (VOLUME != other.VOLUME) {
			return false;
		}
		
		if (WASH_CYCLE_TIME != other.WASH_CYCLE_TIME) {
			return false;
		}
		
		if (WATER_INTAKE != other.WATER_INTAKE) {
			return false;
		}		
		return true;
	}
}
