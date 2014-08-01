/*
 * Роман Гуткович
 */

package by.epam.task01.entity;

import by.epam.task01.creator.Builder;
/**
 * Базовый класс для всех электроприборов.
 * Используется паттерн Builder.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */

public abstract class Device {
	/** Производитель */
	private final String MANUFACTURER;
	
	/** Мощность (Вт) */
	private final int POWER;
	
	/** Масса (кг) */
	private final int MASS;
	
	/** Стандарт соответствия */
	private final String STANDART;
	
	/** Состояние (выкл/вкл) */
	private boolean stateOn;
	

	
	public Device(Builder builder) {
		POWER = builder.getPower();
		MASS = builder.getMass();
		STANDART = builder.getStandart();
		MANUFACTURER = builder.getManufacturer();
	}
	
	public String getManufacturer() {
		return MANUFACTURER;
	}
	
	public int getPower() {
		return POWER;
	}
	
	public String getstandart() {
		return STANDART;
	}
	
	public int getMass() {
		return MASS;
	}
	
	public void hookUp() {
		stateOn = true;
	}
	
	public void hookDown(){
		stateOn = false;
	}
	
	public boolean isPlugged() {
		return stateOn;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getClass()).append("@").append(this.hashCode()).append("\n");
		sb.append("Manufacturer: ").append(getManufacturer()).append("\n");
		sb.append("Power: ").append(getPower()).append("\n");
		sb.append("Mass: ").append(getMass()).append("\n");
		sb.append("Certificate: ").append(getstandart()).append("\n");
		sb.append("State: ").append( (isPlugged())? "plugged":"not plugged" ).append("\n");
		return sb.toString();		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + MANUFACTURER.length();
		result = prime * result + MASS;
		result = prime * result + POWER;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Device other = (Device) obj;
		if (!MANUFACTURER.equals(other.MANUFACTURER)) {
			return false;
		}
		
		if (MASS != other.MASS) {
			return false;
		}
		
		if (POWER != other.POWER) {
			return false;
		}
		return true;
	}
}
