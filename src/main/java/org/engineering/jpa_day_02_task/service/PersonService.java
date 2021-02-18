package org.engineering.jpa_day_02_task.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.engineering.jpa_day_02_task.entity.City;
import org.engineering.jpa_day_02_task.entity.Person;

public class PersonService {
	private EntityManagerFactory emf;

	public PersonService(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public Person saveOrUpdate(Person person) throws Exception {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			City city = em.find(City.class, person.getCity().getId());
			if (city == null) {
				em.persist(person.getCity());
			}

			person = em.merge(person);

			em.getTransaction().commit();
			System.out.println("ID is: " + person.getId());
			return person;
		} catch (Exception e) {
			e.printStackTrace();

			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

	}

	public void printAll() {
		EntityManager em = emf.createEntityManager();
		List<Person> persons = em.createQuery("SELECT p FROM Person p").getResultList();
		for (Person p : persons) {
			System.out.println(p);
		}
		em.close();
	}

	public void printAllNamedQuery() {
		EntityManager em = emf.createEntityManager();
		List<Person> persons = em.createNamedQuery("City.findAllOrderByCity").getResultList();
		for (Person p : persons) {
			System.out.println(p);
		}
		em.close();
	}
}
