/*
 * Роман Гуткович
 */
package by.epam.task01.entity.cleaner;

import org.apache.log4j.Logger;

import by.epam.task01.creator.WashingMachineBuilder;
import by.epam.task01.entity.Device;

/**
 * Класс, описывающий стиральную машину.
 * Используется паттерн Builder.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class WashingMachine extends Device {
	private static final Logger LOG = Logger.getLogger(WashingMachine.class);
	
	/** Флажок наличия встроенной сушилки */
	private final boolean HAS_DRYER;
	
	/** Максимальная загрузка (кг) */
	private final float MAX_LOAD;
	
	/** Флажок наличия прямого хода */
	private final boolean HAS_DIRECT_DRIVE;
	
	/** Флажок способности крышки стиральной машины откидываться на 180 градусов */
	private final boolean CAN_OPEN_HATCH_180;
	
	/** Скорость отжима */
	private final int DRYING_SPEED;
	
	public WashingMachine(WashingMachineBuilder builder) {
		super(builder);
		
		HAS_DRYER = builder.isHasDryer();
		MAX_LOAD = builder.getMaxLoad();
		HAS_DIRECT_DRIVE = builder.isHasDirectDrive();
		CAN_OPEN_HATCH_180 = builder.isCanOpenHatch180();
		DRYING_SPEED = builder.getDryingSpeed();
		LOG.info("WashingMachine building complete!");
	}
	
	public boolean isDryerPresent() {
		return HAS_DRYER;
	}
	
	public float getMaxLoad() {
		return MAX_LOAD;
	}
	
	public boolean isDirectDrivePresent() {
		return HAS_DIRECT_DRIVE;
	}
	
	public boolean isOpenHatch() {
		return CAN_OPEN_HATCH_180;
	}
	
	public int getDryingSpeed() {
		return DRYING_SPEED;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("Has dryer: ").append(isDryerPresent()).append("\n");
		sb.append("Max load (kg): ").append(getMaxLoad()).append("\n");
		sb.append("Has direct drive: ").append(isDirectDrivePresent()).append("\n");
		sb.append("Can open hatch for 180 deg.: ").append(isOpenHatch()).append("\n");
		sb.append("Dryer speed: ").append(getDryingSpeed()).append("\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		
		result = prime * result + (CAN_OPEN_HATCH_180 ? 1231 : 1237);
		result = prime * result + DRYING_SPEED;
		result = prime * result + (HAS_DIRECT_DRIVE ? 1231 : 1237);
		result = prime * result + (HAS_DRYER ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(MAX_LOAD);
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
		
		WashingMachine other = (WashingMachine) obj;		
		if (!super.equals(other)) {
			return false;
		}
		
		if (CAN_OPEN_HATCH_180 != other.CAN_OPEN_HATCH_180) {
			return false;
		}
		
		if (DRYING_SPEED != other.DRYING_SPEED) {
			return false;
		}
		
		if (HAS_DIRECT_DRIVE != other.HAS_DIRECT_DRIVE) {
			return false;
		}
		
		if (HAS_DRYER != other.HAS_DRYER) {
			return false;
		}
		
		if (Float.floatToIntBits(MAX_LOAD) != Float
				.floatToIntBits(other.MAX_LOAD)) {
			return false;
		}
		return true;
	}
	
	
}
