/*
 * Роман Гуткович
 */
package by.epam.task01.cleaners;

import org.apache.log4j.Logger;

import by.epam.task01.mainpkg.Device;

/**
 * Класс, описывающий пылесос.
 * Используется паттерн Builder.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class VacuumCleaner extends Device {
	public static final Logger LOG = Logger.getLogger(VacuumCleaner.class);
	
	/** Флажок наличия водного фильтра */
	private final boolean WITH_WATER;
	
	/** Флажок наличия HSPA фильтра */
	private final boolean HAS_HSPA_FILTER;
	
	/** Флажок наличия телескопической трубки */
	private final boolean TELESCOPIC_TUBE;
	
	/** Уровень шума */
	private final int LOUDNESS;
	
	/** Построитель пылесоса */
	public static class VacuumCleanerBuilder extends Builder {
		private boolean withWater;
		private boolean hasHSPAFilter;
		private boolean telescopicTube;
		private int loudness;
		
		public VacuumCleanerBuilder(String manuf,int pow,int mas,String exOr) {
			super(manuf, pow, mas, exOr);
		}
		
		public VacuumCleanerBuilder withWater(boolean val) {
			this.withWater = val;
			return this;
		}
		
		public VacuumCleanerBuilder hasHSPAFilter(boolean val) {
			this.hasHSPAFilter = val;
			return this;
		} 
		
		public VacuumCleanerBuilder telescopicTube(boolean val) {
			this.telescopicTube = val;
			return this;
		}
		
		public VacuumCleanerBuilder loudness(int val) {
			try {
				if (val < 0) {
					throw new IllegalArgumentException("Loudness cannot be negative!");
				}
				this.loudness = val;
			} catch (IllegalArgumentException iae) {
				LOG.error("VacuumCleaner exception: "+iae);
			}		
			return this;
		} 
		
		public VacuumCleaner build() {
			return new VacuumCleaner(this);
		}
	}
	
	public VacuumCleaner(VacuumCleanerBuilder builder) {
		super(builder);
		
		WITH_WATER = builder.withWater;
		HAS_HSPA_FILTER = builder.hasHSPAFilter;
		TELESCOPIC_TUBE = builder.telescopicTube;
		LOUDNESS = builder.loudness;
		LOG.info("VacuumCleaner building complete!");
	}
	
	public boolean isWaterFilter() {
		return WITH_WATER;
	}
	
	public boolean isHSPAFilter() {
		return HAS_HSPA_FILTER;
	}
	
	public boolean isTelescopicTube() {
		return TELESCOPIC_TUBE;
	}
	
	public int getLoudness() {
		return LOUDNESS;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("Has water filter: ").append(isWaterFilter()).append("\n");
		sb.append("Has HSPA filter: ").append(isHSPAFilter()).append("\n");
		sb.append("Has telescopic tube): ").append(isTelescopicTube()).append("\n");
		sb.append("Loudness level: ").append(getLoudness()).append("\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		
		result = prime * result + (HAS_HSPA_FILTER ? 1231 : 1237);
		result = prime * result + LOUDNESS;
		result = prime * result + (TELESCOPIC_TUBE ? 1231 : 1237);
		result = prime * result + (WITH_WATER ? 1231 : 1237);
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
		
		VacuumCleaner other = (VacuumCleaner) obj;		
		if (!super.equals(other)) {
			return false;
		}
		
		if (HAS_HSPA_FILTER != other.HAS_HSPA_FILTER) {
			return false;
		}
		
		if (LOUDNESS != other.LOUDNESS) {
			return false;
		}
		
		if (TELESCOPIC_TUBE != other.TELESCOPIC_TUBE) {
			return false;
		}
		
		if (WITH_WATER != other.WITH_WATER) {
			return false;
		}	
		return true;
	}
	
	
}
