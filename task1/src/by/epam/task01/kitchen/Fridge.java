/*
 * Роман Гуткович
 */
package by.epam.task01.kitchen;

import org.apache.log4j.Logger;

import by.epam.task01.mainpkg.Device;

/**
 * Класс, описывающий холодильник.
 * Используется паттерн Builder.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class Fridge extends Device {
	private static final Logger LOG = Logger.getLogger(Fridge.class);
	
	/** Количество компрессоров */
	private final int COMPRESSORS;
	
	/** Объем камеры (л) */
	private final int VOLUME;
	
	/** Средняя температура хранения */
	private final int STORAGE_TEMP;
	
	public static class FridgeBuilder extends Builder {
		private int compressors;
		private int volume;
		private int storageTemp;
		
		public FridgeBuilder(String manuf,int pow,int mas,String exOr) {
			super(manuf,pow, mas, exOr);		
		}
		
		public FridgeBuilder compressors(int val){
			try {
				if (val <= 0) {
					throw new IllegalArgumentException("Fridge compressors count can't be negative or equal zero!");
				}
				this.compressors = val;
			} catch(IllegalArgumentException e) {
				LOG.error("FridgeBuilder exception: " + e);
			}
			return this;
		}
		
		public FridgeBuilder volume(int val){
			try {
				if (val <= 0) {
					throw new IllegalArgumentException("Fridge volume can't be negative or equal zero!");
				}
				this.volume = val;
			} catch(IllegalArgumentException e) {
				LOG.error("FridgeBuilder exception: " + e);
			}
			return this;
		}
		
		public FridgeBuilder storageTemp(int val){
			this.storageTemp = val;
			return this;
		}	
		
		public Fridge build(){
			return new Fridge(this);
		}
	}
	
	public Fridge(FridgeBuilder builder) {
		super(builder);
		
		COMPRESSORS = builder.compressors;
		VOLUME = builder.volume;
		STORAGE_TEMP = builder.storageTemp;
		LOG.info("Fridge building complete!");
	}
	
	public int getCompressCount() {
		return COMPRESSORS;
	}
	
	public int getVolume() {
		return VOLUME;
	}
	
	public int getStorageTemp() {
		return STORAGE_TEMP;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("Compressors count: ").append(getCompressCount()).append("\n");
		sb.append("Fridge volume (lt.): ").append(getVolume()).append("\n");
		sb.append("Fridge storage temperature (C): ").append(getStorageTemp()).append("\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		
		result = prime * result + COMPRESSORS;
		result = prime * result + STORAGE_TEMP;
		result = prime * result + VOLUME;
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
		
		Fridge other = (Fridge) obj;
		if (!super.equals(other)) {
			return false;
		}
		
		if (COMPRESSORS != other.COMPRESSORS) {
			return false;
		}
		
		if (STORAGE_TEMP != other.STORAGE_TEMP) {
			return false;
		}
		
		if (VOLUME != other.VOLUME) {
			return false;
		}
		return true;
	}	
}
