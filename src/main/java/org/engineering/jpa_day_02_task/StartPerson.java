package org.engineering.jpa_day_02_task;

import javax.persistence.Persistence;

import org.engineering.jpa_day_02_task.entity.City;
import org.engineering.jpa_day_02_task.entity.Person;
import org.engineering.jpa_day_02_task.service.PersonService;

public class StartPerson {
	private final PersonService personService;

	public StartPerson() {
		personService = new PersonService(Persistence.createEntityManagerFactory("JPADay02_TASK"));
	}

	public static void main(String[] args) {
		StartPerson startPerson = new StartPerson();
		//startPerson.saveOrUpdatePerson("18029989710204", "mika", "mikic", 2);
	     //startPerson.printAll();
	     startPerson.printAllNamedQuery();
	}
	

	private void saveOrUpdatePerson(String personalIdentityNumber, String firstname, String lastname, int cityId) {
		City city = new City();
		city.setId(cityId);

		Person person = new Person();
		person.setPersonalIdentityNumber(personalIdentityNumber);
		person.setFirstname(firstname);
		person.setLastname(lastname);

		person.setCity(city);

		try {
			person = personService.saveOrUpdate(person);

			System.out.println("Person saved...");
			System.out.println(person);
		} catch (Exception e) {
			System.out.println("MAIN: error ->" + e.getMessage());
		}
	}

	private void printAll() {
		personService.printAll();
		System.out.println("=========");

	}
	private void printAllNamedQuery() {
		personService.printAllNamedQuery();
		System.out.println("=========");

	}
}
