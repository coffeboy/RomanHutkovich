/*
 * Роман Гуткович
 */
package by.epam.task01.mainpkg;

import by.epam.task01.kitchen.Fridge;
import by.epam.task01.logic.*;

/**
 * Главный класс.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class Main {
	public static void main(String[] args) {
		DeviceProcessor dk = new DeviceProcessor();
		dk.takeDevices();
		
		System.out.println("Consumable power: " + dk.consumablePower());
		dk.turnOnDevice(0);
		dk.turnOnDevice(3);
		System.out.println("Consumable power: " + dk.consumablePower());
		
		System.out.println(dk.find(new Fridge.FridgeBuilder("ATLANT", 1800, 80, "ГОСТ 2331.16-88").
				compressors(1).storageTemp(5).volume(100).build()));

		dk.printAll();
	}
}
