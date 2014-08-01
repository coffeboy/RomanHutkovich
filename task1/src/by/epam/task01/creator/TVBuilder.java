package by.epam.task01.creator;

import by.epam.task01.entity.multimedia.TV;

public class TVBuilder extends Builder{
	private boolean colorful;
	private float diagonal;
	private boolean slim;
	private int dpi;
	private String resolution;
	
	public TVBuilder(String manuf,int pow,int mas,String exOr) {
		super(manuf,pow, mas, exOr);
	}
	
	public void setColorful(boolean val) {
		this.colorful = val;
	}
	
	public void setDiagonal(float val) {
		if (val <= 0) {
			LOG.error("TV exception.");
			throw new IllegalArgumentException("Diagonal cannot be negative or equal zero!");
		}
		this.diagonal = val;
	}
	
	public void setSlim(boolean val) {
		this.slim = val;
	}
	
	public void setDpi(int val) {
		if (val <= 0) {
			LOG.error("TV exception.");
			throw new IllegalArgumentException("DPI cannot be negative or equal zero!");
		}
		this.dpi = val;			
	}
	
	public void setResolution(String val) {
		if ( (val.length() > 0) && (val.contains("x")) ) {
			this.resolution = val;
		} else {
			 LOG.error("TV exception.");
			 throw new IllegalArgumentException("Wrong resolution type!");			   
		}
	}
	
	public TV build(){
		return new TV(this);
	}

	public boolean isColorful() {
		return colorful;
	}

	public float getDiagonal() {
		return diagonal;
	}

	public boolean isSlim() {
		return slim;
	}

	public String getResolution() {
		return resolution;
	}

	public int getDpi() {
		return dpi;
	}
}
