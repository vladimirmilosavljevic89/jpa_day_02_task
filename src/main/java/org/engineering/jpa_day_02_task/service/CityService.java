package org.engineering.jpa_day_02_task.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.engineering.jpa_day_02_task.entity.City;

public class CityService {
	private EntityManagerFactory emf;

	public CityService(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void saveOrUpdate(City city) throws Exception {
		EntityManager em = emf.createEntityManager();
		try {
			City existingCity = em.find(City.class, city.getId());
			if (existingCity != null)
				throw new Exception("City already exist");

			em.getTransaction().begin();
			em.persist(city);
			em.getTransaction().commit();

			System.out.println("City is saved");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error: " + e.getMessage());

			// throw e;
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
	}
}
