/*
 * Роман Гуткович
 */
package by.epam.task01.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import by.epam.task01.creator.*;
import by.epam.task01.entity.*;

/**
 * Класс-манипулятор устройствами.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class DeviceManager {
	private static final Logger LOG = Logger.getLogger(DeviceManager.class);
	private DeviceComparator compr = new DeviceComparator();
	
	/** Список электроприборов в квартире */
	private List<Device> devices = new ArrayList<Device>();
	
	/** Заглушка на формирование списка электроприборов */
	public void takeDevices() throws Exception {
		DishWasherBuilder dwb = new DishWasherBuilder("GEFEST", 1600, 18, "ISO 2412.14-98");
		dwb.setLoudness(24);
		dwb.setVolume(77);
		dwb.setWashCycleTime(18);
		dwb.setWaterIntake(23);
		setDevice(dwb.build());
		
		FridgeBuilder fb = new FridgeBuilder("ATLANT", 2000, 55, "ISO/MEC 1971.09-01");
		fb.setCompressors(1);
		fb.setStorageTemp(-2);
		fb.setVolume(120);
		setDevice(fb.build());
		
		SteamPurifierBuilder spb = new SteamPurifierBuilder("FIRST Austria", 500, 1, "ГОСТ 1241.24-06");
		spb.setBoilVolume(1);
		spb.setHeatTime(5);
		spb.setMaxPressure(6);
		setDevice(spb.build());
		
		DVDBuilder dvdb = new DVDBuilder("SAMSUNG", 15, 1, "ISO/MEC 2219.03-99");
		dvdb.setChildrenProtection(true);
		dvdb.setSupBluray(false);
		dvdb.setHasInternetConnection(false);
		setDevice(dvdb.build());
	}
	
	public void setDevice(Device dev){
		devices.add(dev);
	}
	
	public Device getDevice(int numb) {
		try {
			devices.get(numb);
		} catch (IndexOutOfBoundsException iobex) {
			LOG.error(iobex);
		} catch (Exception ex) {
			LOG.error(ex);
		}
		return devices.get(numb);
	}
	
	/** Включить конкретное устройство */
	public void turnOnDevice(int numb) {
		try {
			devices.get(numb).hookUp();
		} catch (IndexOutOfBoundsException iobex) {
			LOG.error(iobex);
		} catch (Exception ex) {
			LOG.error(ex);
		}
	}
	
	/** Выключить конкретное устройство */
	public void turnOffDevice(int numb) {
		try {
			devices.get(numb).hookDown();
		} catch (IndexOutOfBoundsException iobex) {
			LOG.error(iobex);
		} catch (Exception ex) {
			LOG.error(ex);
		}
	}
	
	/** Сортировка устройств на основе мощности */
	public void sortDevices() {
		Collections.sort(devices, compr);
	}
	
	public List<Device> getAll() {
		return Collections.unmodifiableList(devices);
	}
	
	/** Включить устройства в розетку */
	public void turnOn() {
		for (Device dev : devices) {
			dev.hookUp();
		}
	}
	
	/** Потребляемая мощность в текущий момент */
	public int consumablePower() {
		int sum = 0;
	
		for (Device dev : devices) {
			if (dev.isPlugged()) {
				sum += dev.getPower();
			}
		}	
		return sum;
	}
	
	/** Найти электроприбор по заданным параметрам */
	public Device find (Device what) {
		for (Device dev : devices) {
			if (dev.equals(what)) {
				return dev;
			}
		}
		LOG.info("Device not found");
		return null;
	}
	
	/** Выключить все устройства */
	public void turnOff() {
		for (Device dev : devices) {
			dev.hookDown();
		}		
	}
}
