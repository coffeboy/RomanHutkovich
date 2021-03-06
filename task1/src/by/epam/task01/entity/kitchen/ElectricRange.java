/*
 * Роман Гуткович
 */
package by.epam.task01.entity.kitchen;

import org.apache.log4j.Logger;

import by.epam.task01.creator.ElectricRangeBuilder;
import by.epam.task01.entity.Device;

/**
 * Класс, описывающий электроплиту.
 * Используется паттерн Builder.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class ElectricRange extends Device {
	private static final Logger LOG = Logger.getLogger(ElectricRange.class);
	
	/** Максимальная температура нагрева конфорок */
	private final int MAX_TEMPERATURE;
	
	/** Количество конфорок */
	private final int PAN_COUNT;
	
	/** Количество делений перелючателя */
	private final int DIVISIONS_COUNT;
	
	public ElectricRange(ElectricRangeBuilder builder) {
		super(builder);
		
		MAX_TEMPERATURE = builder.getMaxTemperature();
		PAN_COUNT = builder.getPanCount();
		DIVISIONS_COUNT = builder.getDivisionsCount();
		LOG.info("ElectricRange building complete!");
	}
	
	public int getMaxTemperature() {
		return MAX_TEMPERATURE;
	}
	
	public int getPanCount() {
		return PAN_COUNT;
	}
	
	public int getDivisionsCount() {
		return DIVISIONS_COUNT;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("Max temperatrue (C): ").append(getMaxTemperature()).append("\n");
		sb.append("Pans count: ").append(getPanCount()).append("\n");
		sb.append("Cutout steps count: ").append(getDivisionsCount()).append("\n");
		return sb.toString();	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		
		result = prime * result + DIVISIONS_COUNT;
		result = prime * result + MAX_TEMPERATURE;
		result = prime * result + PAN_COUNT;
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
		
		ElectricRange other = (ElectricRange) obj;
		if (!super.equals(other)) {
			return false;
		}
		
		if (DIVISIONS_COUNT != other.DIVISIONS_COUNT) {
			return false;
		}
		
		if (MAX_TEMPERATURE != other.MAX_TEMPERATURE) {
			return false;
		}
		
		if (PAN_COUNT != other.PAN_COUNT) {
			return false;
		}		
		return true;
	}
}
