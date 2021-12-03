package com.WS3.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.WS3.model.Factories;
import com.WS3.service.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@RestController
public class FactoryController {
	@Autowired
	private FactoryService factoryService;
	
	
	
	@GetMapping("/getF")
	public List <Factories> findit(){
		return (List<Factories>) factoryService.findAll(); 
	}
	
	@GetMapping("/getF/{id}")
	public Factories findCar(@PathVariable(value = "id") int id){
		return factoryService.findbyId(id); 
	}
	
	
	@PostMapping("/createF")
	@PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_READ')")
	public List <Factories> save(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("countryCode") int countryCode){
		
		Factories factory = new Factories();
		
		factory.setId(id);
		factory.setName(name);
		factory.setCountryCode(countryCode);
						
		return factoryService.Add(factory);
	}
	@PutMapping("/updateF/{id}")
	@PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_READ')")
	public Factories put(@PathVariable(value = "id") int id,@RequestParam("name") String name,@RequestParam("countryCode") int countryCode){
		
		
		Factories factory = new Factories();
		
		factory = factoryService.savebyId(id,name,countryCode);
		
		
		return factory;
	}
	
	@DeleteMapping("/deleteF/{id}")
	@PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_READ')")
	public List<Factories> deleteCar(@PathVariable(value = "id") int id){
		return factoryService.delete(id); 
	}

	
}
