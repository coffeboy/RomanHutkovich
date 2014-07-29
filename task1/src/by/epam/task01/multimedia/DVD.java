/*
 * Роман Гуткович
 */
package by.epam.task01.multimedia;

import org.apache.log4j.Logger;

import by.epam.task01.mainpkg.Device;

/**
 * Класс, описывающий DVD-плеер.
 * Используется паттерн Builder.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class DVD extends Device{
	private static final Logger LOG = Logger.getLogger(DVD.class);
	
	/** Флажок, поддерживает ли Blu-Ray технологию */
	private final boolean SUP_BLURAY;
	
	/** Флажок наличия защиты от детей */
	private final boolean CHILDREN_PROTECTION;
	
	/** Флажок наличия интерфейсов для подключения к сети Интернет */
	private final boolean HAS_INTERNET_CONNECTION;
	
	public static class DVDBuilder extends Builder{
		private boolean supBluray;
		private boolean childrenProtection;
		private boolean hasInternetConnection;
		
		public DVDBuilder(String manuf,int pow,int mas,String exOr) {
			super(manuf,pow, mas, exOr);
		}
		
		public DVDBuilder supBluray(boolean val) {
			this.supBluray = val;
			return this;
		}
		
		public DVDBuilder childrenProtection(boolean val) {
			this.childrenProtection = val;
			return this;
		}
		
		public DVDBuilder hasInternetConnection(boolean val) {
			this.hasInternetConnection = val;
			return this;
		}
		
		public DVD build(){
			return new DVD(this);
		}
	}
	
	public DVD(DVDBuilder builder) {
		super(builder);
		
		SUP_BLURAY = builder.supBluray;
		CHILDREN_PROTECTION = builder.childrenProtection;
		HAS_INTERNET_CONNECTION = builder.hasInternetConnection;
		LOG.info("DVD building complete!");
	}
	
	public boolean isBluRaySupporting(){
		return SUP_BLURAY;
	}
	
	public boolean isChildrenProtectionPresent(){
		return CHILDREN_PROTECTION;
	}
	
	public boolean isInternetPresent(){
		return HAS_INTERNET_CONNECTION;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("Support blu-ray: ").append(isBluRaySupporting()).append("\n");
		sb.append("Has children protection: ").append(isChildrenProtectionPresent()).append("\n");
		sb.append("Has internet connection (Ethernet/WiFi): ").append(isInternetPresent()).append("\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		
		result = prime * result + (CHILDREN_PROTECTION ? 1231 : 1237);
		result = prime * result + (HAS_INTERNET_CONNECTION ? 1231 : 1237);
		result = prime * result + (SUP_BLURAY ? 1231 : 1237);
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
		
		DVD other = (DVD) obj;
		if (!super.equals(other)) {
			return false;
		}
		
		if (CHILDREN_PROTECTION != other.CHILDREN_PROTECTION) {
			return false;
		}
		
		if (HAS_INTERNET_CONNECTION != other.HAS_INTERNET_CONNECTION) {
			return false;
		}
		
		if (SUP_BLURAY != other.SUP_BLURAY) {
			return false;
		}
		return true;
	}
}
