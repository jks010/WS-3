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
@Table(name = "factories")
public class Factories {
	
	@Id
	private int id;
	private String name;
	private int country_code;
		
	
	public Factories() {
		
	}
	public Factories(int id,String name,int country_code) {
		this.id= id;
		this.name=name;
		this.country_code=country_code;
		
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public int getCountryCode() {
		return this.country_code;
		
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public void setCountryCode(int country_code) {
		this.country_code=country_code;
	}
	}
