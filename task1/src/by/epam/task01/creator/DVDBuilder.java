package by.epam.task01.creator;

import by.epam.task01.entity.multimedia.DVD;

public class DVDBuilder extends Builder{
	private boolean supBluray;
	private boolean childrenProtection;
	private boolean hasInternetConnection;
	
	public DVDBuilder(String manuf,int pow,int mas,String exOr) {
		super(manuf,pow, mas, exOr);
	}
	
	public void setSupBluray(boolean val) {
		this.supBluray = val;
	}
	
	public void setChildrenProtection(boolean val) {
		this.childrenProtection = val;
	}
	
	public void setHasInternetConnection(boolean val) {
		this.hasInternetConnection = val;
	}
	
	public boolean isSupBluray() {
		return supBluray;
	}

	public boolean isChildrenProtection() {
		return childrenProtection;
	}

	public boolean isHasInternetConnection() {
		return hasInternetConnection;
	}
	
	public DVD build(){
		return new DVD(this);
	}
}
