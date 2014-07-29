/*
 * Роман Гуткович
 */
package by.epam.task01.logic;

import java.util.Comparator;

import by.epam.task01.mainpkg.Device;

/**
 * Класс, реализующий интерфейс Comparator<T>.
 * 
 * @version 1.0 28 Июл 2014
 * @author Роман Гуткович
 */
public class DeviceComparator implements Comparator<Device> {

	@Override
	public int compare(Device arg0, Device arg1) {
		
		/* Сравнение производится на основе мощности. */
		if (arg0.getPower() < arg1.getPower()) {
			return -1;
		}
		
		if (arg0.getPower() > arg1.getPower()) {
			return 1;
		}
		return 0;
	}
}
