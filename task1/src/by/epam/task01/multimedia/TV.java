/*
 * Роман Гуткович
 */
package by.epam.task01.multimedia;

import org.apache.log4j.Logger;

import by.epam.task01.mainpkg.Device;

/**
 * Класс, описывающий телевизор.
 * Используется паттерн Builder.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class TV extends Device{
	private static final Logger LOG = Logger.getLogger(TV.class);
	
	/** Флажок наличия полной цветопередачи */
	private final boolean COLORFUL;
	
	/** Размер диагонали (дюймы) */
	private final float DIAGONAL;
	
	/** Флажок, означающий плоский ли телевизор */
	private final boolean SLIM;
	
	/** Разрешающая способность экрана */
	private final int DPI;
	
	/** Разрешение экрана */
	private final String RESOLUTION;
	
	public static class TVBuilder extends Builder{
		private boolean colorful;
		private float diagonal;
		private boolean slim;
		private int dpi;
		private String resolution;
		
		public TVBuilder(String manuf,int pow,int mas,String exOr) {
			super(manuf,pow, mas, exOr);
		}
		
		public TVBuilder colorful(boolean val) {
			this.colorful = val;
			return this;
		}
		
		public TVBuilder diagonal(float val) {
			try {
				if (val <= 0) {
					throw new IllegalArgumentException("Diagonal cannot be negative or equal zero!");
				}
				this.diagonal = val;
			} catch (IllegalArgumentException iae) {
				LOG.error("TV exception: "+iae);
			}
			
			return this;
		}
		
		public TVBuilder slim(boolean val) {
			this.slim = val;
			return this;
		}
		
		public TVBuilder dpi(int val) {
			try {
				if (val <= 0) {
					throw new IllegalArgumentException("DPI cannot be negative or equal zero!");
				}
				this.dpi = val;
			} catch (IllegalArgumentException iae) {
				LOG.error("TV exception: "+iae);
			}
			
			return this;
		}
		
		public TVBuilder resolution(String val) {
			try {
				if (val.length() > 0 && val.contains("x")) {
					this.resolution = val;
				} else {
					throw new IllegalArgumentException("Wrong resolution type!");
				}
			} catch (IllegalArgumentException iae) {
				LOG.error("TV exception: "+iae);
			}
			return this;
		}
		
		public TV build(){
			return new TV(this);
		}
	}
	
	public TV(TVBuilder builder) {
		super(builder);
		
		COLORFUL = builder.colorful;
		DIAGONAL = builder.diagonal;
		SLIM = builder.slim;
		DPI = builder.dpi;
		RESOLUTION = builder.resolution;
		LOG.info("TV building complete!");
	}
	
	public boolean isColor(){
		return COLORFUL;
	}
	
	public float getDiagonal(){
		return DIAGONAL;
	}
	
	public boolean isSlim(){
		return SLIM;
	}
	
	public int getDpi(){
		return DPI;
	}
	
	public String gerResolution(){
		return RESOLUTION;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("Color TV: ").append(isColor()).append("\n");
		sb.append("Diagonal (inch): ").append(getDiagonal()).append("\n");
		sb.append("Slim: ").append(isSlim()).append("\n");
		sb.append("Dpi (ppi): ").append(getDpi()).append("\n");
		sb.append("Resolutin: ").append(gerResolution()).append("\n");
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		
		result = prime * result + (COLORFUL ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(DIAGONAL);
		result = prime * result + DPI;
		result = prime * result
				+ ((RESOLUTION == null) ? 0 : RESOLUTION.hashCode());
		result = prime * result + (SLIM ? 1231 : 1237);
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
		
		TV other = (TV) obj;
		if (!super.equals(other)) {
			return false;
		}
		
		if (COLORFUL != other.COLORFUL) {
			return false;
		}
		
		if (Float.floatToIntBits(DIAGONAL) != Float
				.floatToIntBits(other.DIAGONAL)) {
			return false;
		}
		
		if (DPI != other.DPI) {
			return false;
		}
		
		if (other.RESOLUTION != null) {
			return false;
		}
		
		if (!RESOLUTION.equals(other.RESOLUTION)) {
			return false;
		}
		
		if (SLIM != other.SLIM) {
			return false;
		}
		
		return true;
	}	
}
