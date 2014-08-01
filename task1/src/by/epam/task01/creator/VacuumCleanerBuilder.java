package by.epam.task01.creator;

import by.epam.task01.creator.Builder;
import by.epam.task01.entity.cleaner.VacuumCleaner;

public class VacuumCleanerBuilder extends Builder {
	private boolean withWater;
	private boolean hasHSPAFilter;
	private boolean telescopicTube;
	private int loudness;
	
	public VacuumCleanerBuilder(String manuf,int pow,int mas,String exOr) {
		super(manuf, pow, mas, exOr);
	}
	
	public void setLoudness(int val) {
			if (val < 0) {
				LOG.error("VacuumCleaner exception.");
				throw new IllegalArgumentException("Loudness cannot be negative!");
			}
			this.loudness = val;
	} 
	
	public boolean isWithWater() {
		return withWater;
	}

	public void setWithWater(boolean withWater) {
		this.withWater = withWater;
	}

	public boolean isHasHSPAFilter() {
		return hasHSPAFilter;
	}

	public void setHasHSPAFilter(boolean hasHSPAFilter) {
		this.hasHSPAFilter = hasHSPAFilter;
	}

	public boolean isTelescopicTube() {
		return telescopicTube;
	}

	public void setTelescopicTube(boolean telescopicTube) {
		this.telescopicTube = telescopicTube;
	}

	public int getLoudness() {
		return loudness;
	}
	
	public VacuumCleaner build() {
		return new VacuumCleaner(this);
	}
}
