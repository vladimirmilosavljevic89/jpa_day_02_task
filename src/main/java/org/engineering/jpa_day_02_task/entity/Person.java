package org.engineering.jpa_day_02_task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({	
	@NamedQuery(name = "City.findAllOrderByCity", query = "SELECT p FROM Person p ORDER BY p.city")
})
public class Person {
	private static final long serialVersionUID = 1802202111410L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String personalIdentityNumber;
	private String firstname;
	private String lastname;
	@ManyToOne
	@JoinColumn(name = "bornCity",referencedColumnName = "id")
	private City city;
	public Person() {
		super();
	}

	public Person(String personalIdentityNumber, String firstname, String lastname, City city) {
		super();
		this.personalIdentityNumber = personalIdentityNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
	}

	

	@Override
	public String toString() {
		return "Person [id=" + id + ", personalIdentityNumber=" + personalIdentityNumber + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", city=" + city + "]";
	}

	public Person(int id, String personalIdentityNumber, String firstname, String lastname, City city) {
		super();
		this.id = id;
		this.personalIdentityNumber = personalIdentityNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonalIdentityNumber() {
		return personalIdentityNumber;
	}

	public void setPersonalIdentityNumber(String personalIdentityNumber) {
		this.personalIdentityNumber = personalIdentityNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
