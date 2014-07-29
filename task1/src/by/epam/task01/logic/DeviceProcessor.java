/*
 * Роман Гуткович
 */
package by.epam.task01.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import by.epam.task01.kitchen.*;
import by.epam.task01.cleaners.*;
import by.epam.task01.multimedia.*;
import by.epam.task01.mainpkg.*;
/**
 * Класс-манипулятор устройствами.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class DeviceProcessor {
	private static final Logger LOG = Logger.getLogger(DeviceProcessor.class);
	private DeviceComparator compr = new DeviceComparator();
	
	/** Список электроприборов в квартире */
	private List<Device> devices = new ArrayList<Device>();
	
	/** Заглушка на формирования списка электроприборов */
	public void takeDevices() {
		addDevice(new Fridge.FridgeBuilder("ATLANT", 1800, 80, "ГОСТ 2331.16-88").compressors(1).
				storageTemp(5).volume(100).build());
		
		addDevice(new DishWasher.DishWasherBuilder("BOSCH", 300, 26, "ISO 2412-05").loudness(23).
				volume(75).washCycleTime(18).waterIntake(33).build());
		
		addDevice(new VacuumCleaner.VacuumCleanerBuilder("Panasonic", 1600, 3, "ISO 1999.14-99").
				withWater(false).hasHSPAFilter(true).loudness(39).telescopicTube(true).build());
		
		addDevice(new DVD.DVDBuilder("SAMSUNG", 5, 2, "ISO 4490-05").supBluray(true).
				hasInternetConnection(true).childrenProtection(true).build());
	}
	
	public void addDevice(Device dev){
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
	
	public List<Device> getDevices() {
		return devices;
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
	
	/** Вывести в консоль все устройства в квартире */
	public void printAll() {
		for (Device dev : devices) {
			System.out.println("+---------------------------------+");
			System.out.println(dev);
			System.out.println("+---------------------------------+");
		}
	}	
}
