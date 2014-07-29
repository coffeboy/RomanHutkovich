/*
 * Роман Гуткович
 */
package by.epam.task01.cleaners;

import org.apache.log4j.Logger;

import by.epam.task01.mainpkg.Device;

/**
 * Класс, описывающий пароочиститель.
 * Используется паттерн Builder.
 * 
 * @author Роман Гуткович
 * @version 1.0 28 Июл 2014
 */
public class SteamPurifier extends Device {
	private static final Logger LOG = Logger.getLogger(SteamPurifier.class);
	
	/** Максимальное давление котла пароочистителя */
	private final float MAX_PRESSURE;
	
	/** Время нагрева */
	private final int HEAT_TIME;
	
	/** Объем котла */
	private final float BOIL_VOLUME;
	
	/** Вложенный класс построителя */
	public static class SteamPurifierBuilder extends Builder {
		private float maxPressure;
		private int heatTime;
		private float boilVolume;
		
		public SteamPurifierBuilder(String manuf,int pow,int mas,String exOr) {
			super(manuf, pow, mas, exOr);
		}
		
		public SteamPurifierBuilder maxPressure(float val) {
			try {
				if (val <= 0) {
					throw new IllegalArgumentException("Max. pressure cannot be negative or equal zero!");
				}
				this.maxPressure = val;
			} catch (IllegalArgumentException iae) {
				LOG.error("SteamPurifier exception: "+iae);
			}			
			return this;
		}
		
		public SteamPurifierBuilder heatTime(int val) {
			try {
				if (val <= 0) {
					throw new IllegalArgumentException("Heat time cannot be negative or equal zero!");
				}
				this.heatTime = val;
			} catch (IllegalArgumentException iae) {
				LOG.error("SteamPurifier exception: "+iae);
			}			
			return this;
		}
		
		public SteamPurifierBuilder boilVolume(float val) {
			try {
				if (val <= 0) {
					throw new IllegalArgumentException("Boil volume cannot be negative or equal zero!");
				}
				this.boilVolume = val;
			} catch (IllegalArgumentException iae) {
				LOG.error("SteamPurifier exception: "+iae);
			}			
			return this;
		}
		
		public SteamPurifier build() {
			return new SteamPurifier(this);
		}		
	}
	
	public SteamPurifier(SteamPurifierBuilder builder) {
		super(builder);
		
		MAX_PRESSURE = builder.maxPressure;
		HEAT_TIME = builder.heatTime;
		BOIL_VOLUME = builder.boilVolume;
		LOG.info("SteamPurifier building complete!");
	}
	
	public float getMaxPressure(){
		return MAX_PRESSURE;
	}
	
	public int getHeatTime() {
		return HEAT_TIME;
	}
	
	public float getBoilVolume() {
		return BOIL_VOLUME;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("Max pressure: ").append(getMaxPressure()).append("\n");
		sb.append("Heat time: ").append(getHeatTime()).append("\n");
		sb.append("Boil volume (lt.): ").append(getBoilVolume()).append("\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		
		result = prime * result + Float.floatToIntBits(BOIL_VOLUME);
		result = prime * result + HEAT_TIME;
		result = prime * result + Float.floatToIntBits(MAX_PRESSURE);
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
		
		SteamPurifier other = (SteamPurifier) obj;
		if (!super.equals(other)) {
			return false;
		}
				
		if (Float.floatToIntBits(BOIL_VOLUME) != Float
				.floatToIntBits(other.BOIL_VOLUME)) {
			return false;
		}
		
		if (HEAT_TIME != other.HEAT_TIME) {
			return false;
		}
		
		if (Float.floatToIntBits(MAX_PRESSURE) != Float
				.floatToIntBits(other.MAX_PRESSURE)) {
			return false;
		}		
		return true;
	}
	
	
	
}
