/*
 * Роман Гуткович
 */
package by.epam.task01.entity.kitchen;

import org.apache.log4j.Logger;

import by.epam.task01.creator.DishWasherBuilder;
import by.epam.task01.entity.Device;

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
	
	public DishWasher(DishWasherBuilder builder) {
		super(builder);
		
		VOLUME = builder.getVolume();
		LOUDNESS = builder.getLoudness();
		WATER_INTAKE = builder.getWaterIntake();
		WASH_CYCLE_TIME = builder.getWashCycleTime();
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
