/*
 * Роман Гуткович
 */
package by.epam.task01.entity.kitchen;

import org.apache.log4j.Logger;

import by.epam.task01.creator.FridgeBuilder;
import by.epam.task01.entity.Device;

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
	
	public Fridge(FridgeBuilder builder) {
		super(builder);
		
		COMPRESSORS = builder.getCompressors();
		VOLUME = builder.getVolume();
		STORAGE_TEMP = builder.getStorageTemp();
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
