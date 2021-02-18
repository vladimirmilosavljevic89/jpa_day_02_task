package org.engineering.jpa_day_02_task;

import javax.persistence.Persistence;

import org.engineering.jpa_day_02_task.entity.City;
import org.engineering.jpa_day_02_task.service.CityService;


public class StartCity {

	private final CityService cityService;
	public StartCity(){
		cityService = new CityService(Persistence.createEntityManagerFactory("JPADay02_TASK"));
	}
	public static void main(String[] args) {
		StartCity startCity = new StartCity();
		startCity.save("21000", "Novi SAd");

	}
	private void save(String number, String name) {
		try {
			cityService.saveOrUpdate(new City(number, name));
			System.out.println("Main: uspesno izvrsena save metoda...");
		} catch (Exception e) {
			System.out.println("Main: greska -> " + e.getMessage());
		}
	}

}
