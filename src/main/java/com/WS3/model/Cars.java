package com.WS3.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.sql.DataSource;

@Entity
@Table(name = "cars")
public class Cars {
	
	@Id
	private int id;
	private int factory_id;
	private String model;
	private int year;
	private String fuel;
	private int doors;
	private double cost;
	private String color;
	
	
	
	public Cars() {
		
	}
	public Cars(int id,int factory_id,String model,int year,
			String fuel,int doors, double cost,String color) {
		this.id= id;
		this.factory_id= factory_id;
		this.model= model;
		this.year= year;
		this.fuel= fuel;
		this.doors= doors;
		this.cost= cost;
		this.color= color;
	}
	public int getId() {
		return this.id;
	}
	public int getFactoryId() {
		return this.factory_id;
	}
	public String getModel() {
		return this.model;
		
	}
	public int getYear() {
		return this.year;
	}
	public String getFuel() {
		return this.fuel;
		
	}
	public int getDoors() {
		return this.doors;
	}
	public double getCost() {
		return this.cost;
		
	}
	public String getColor() {
		return this.color;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public void setFactoryId(int factory_id) {
		this.factory_id=factory_id;
	}
	
	public void setModel(String model) {
		this.model=model;
	}
	public void setYear(int year) {
		this.year=year;
	}
	public void setFuel(String fuel) {
		this.fuel=fuel;
	}
	public void setDoors(int doors) {
		this.doors=doors;
	}
	public void setCost(double cost) {
		this.cost=cost;
	}
	public void setColor(String color) {
		this.color=color;
	}
}
