package com.cts.modal;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class MenuItem {

	public MenuItem() {
		super();
	}

	public MenuItem(String name, Double cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private Double cost;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}
	
}
