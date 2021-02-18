package org.engineering.jpa_day_02_task.entity;

import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City implements Serializable {
	private static final long serialVersionUID = 18022021113100L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	private String name;
	public City(int id, String number, String name) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
	}
	public City(String number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	public City() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", number=" + number + ", name=" + name + "]";
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
