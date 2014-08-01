/*
 * Роман Гуткович
 */
package by.epam.task01.mainpkg;

import org.apache.log4j.Logger;

import by.epam.task01.entity.Device;
import by.epam.task01.logic.*;

/**
 * Главный класс.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class Main {
	public static final Logger LOG = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		DeviceManager dk = new DeviceManager();
		
		try {
			dk.takeDevices();
		} catch (Exception e) {
			LOG.error(e);
		}
		
		LOG.info("Consumable power: " + dk.consumablePower());
		dk.turnOnDevice(0);
		dk.turnOnDevice(3);
		LOG.info("Consumable power: " + dk.consumablePower());
		
		LOG.info("Unsorted devices: ");
		for (Device dev: dk.getAll()) {
			LOG.info(dev);
		}
		
		dk.sortDevices();
		LOG.info("Sorted devices: ");
		for (Device dev: dk.getAll()) {
			LOG.info(dev);
		}
		
		
	}
}
