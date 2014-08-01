package by.epam.task01.creator;

import by.epam.task01.entity.Device;

import org.apache.log4j.*;

public abstract class Builder {		
	public static final Logger LOG = Logger.getLogger(Builder.class);
	private final int power;
	private final int mass;
	private final String standart;
	private final String manufacturer;
	
	public Builder(String manuf,int pow,int mas,String stndrt) {
		LOG.info("Device builder...");
		if (manuf.length() == 0) {
			LOG.error("Illegal builder arguments.");
			throw new IllegalArgumentException("Empty manufacturer name!");
		}
		
		if ( (pow <= 0) || (mas <= 0) ) {
			LOG.error("Illegal builder arguments.");
			throw new IllegalArgumentException("Negative power or mass!");
		}
		
		power = pow;
		mass = mas;
		standart = stndrt;			
		manufacturer = manuf;
		LOG.info("Building complete!");
	}
	
	public abstract Device build();

	public int getPower() {
		return power;
	}

	public int getMass() {
		return mass;
	}

	public String getStandart() {
		return standart;
	}

	public String getManufacturer() {
		return manufacturer;
	}
}
