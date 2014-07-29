/*
 * Роман Гуткович
 */

package by.epam.task01.mainpkg;

import org.apache.log4j.*;

/**
 * Базовый класс для всех электроприборов.
 * Используется паттерн Builder.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */

public class Device {
	private static final Logger LOG = Logger.getLogger(Device.class);
	
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
	
	public static class Builder {		
		private final int power;
		private final int mass;
		private final String standart;
		private final String manufacturer;
		
		public Builder(String manuf,int pow,int mas,String stndrt) {
			LOG.info("Device builder...");
			try {
				if (manuf.length() == 0) {
					throw new IllegalArgumentException("Empty manufacturer name!");
				}
				
				if ( (pow <= 0) || (mas <= 0) ) {
					throw new IllegalArgumentException("Negative power or mass!");
				}
			} catch(IllegalArgumentException iae) {
				LOG.error("Illegal builder arguments: "+iae);
			}
			
			power = pow;
			mass = mas;
			standart = stndrt;			
			manufacturer = manuf;
			LOG.info("Building complete!");
		}
		
		public Device build() {
			return new Device(this);
		}
	}
	
	public Device(Builder builder) {
		POWER = builder.power;
		MASS = builder.mass;
		STANDART = builder.standart;
		MANUFACTURER = builder.manufacturer;
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
