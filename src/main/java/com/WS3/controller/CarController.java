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

import com.WS3.model.Cars;
import com.WS3.service.CarService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@RestController
public class CarController {
	@Autowired
	private CarService carService;
	
	
	
	@GetMapping("/getC")
	public List <Cars> findit(){
		return (List<Cars>) carService.findAll(); 
	}
	
	@GetMapping("/getC/{id}")
	public Cars findCar(@PathVariable(value = "id") int id){
		return carService.findbyId(id); 
	}
	
	@PostMapping("/createC")
	@PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_READ')")
	public List <Cars> save(@RequestParam("id") int id,@RequestParam("factory_id") int factory_id,@RequestParam("model") String model,@RequestParam("year") int year,
			@RequestParam("fuel") String fuel,@RequestParam("doors") int doors,@RequestParam("cost") double cost,@RequestParam("color") String color){
		
		Cars car = new Cars();
		car.setId(id);
		car.setFactoryId(factory_id);
		car.setModel(model);
		car.setYear(year);
		car.setFuel(fuel);
		car.setDoors(doors);
		car.setCost(cost);
		car.setColor(color);
		
		
		return carService.Add(car);
	}
	@PutMapping("/updateC/{id}")
	@PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_READ')")
	public Cars put(@PathVariable(value = "id") int id,@RequestParam("factoryId") int factoryId,@RequestParam("model") String model,@RequestParam("year") int year,
			@RequestParam("fuel") String fuel,@RequestParam("doors") int doors,@RequestParam("cost") double cost,@RequestParam("color") String color){
		
		
		Cars car = new Cars();
		
		car = carService.savebyId(id,factoryId,model,year,fuel,doors,cost,color);
		
		
		return car;
	}
	
	@DeleteMapping("/deleteC/{id}")
	@PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_READ')")
	public List<Cars> deleteCar(@PathVariable(value = "id") int id){
		return carService.delete(id); 
	}
	
	@PostMapping("/file")
	@PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_READ')")
	public void file(@RequestParam("file") MultipartFile file) throws IOException, CsvException{
		
		
		InputStream fileReader = (file.getInputStream());
		BufferedReader fileReaderr = new BufferedReader(new InputStreamReader(fileReader, "UTF-8"));
		try (CSVReader reader = new CSVReader(fileReaderr)) {
            List<String[]> r = reader.readAll();
            for (String[] strings : r) {
            	if(strings[0].equals("id")==false) {
            	
            		
            		
            		Cars car = new Cars();
            		car.setId(Integer.valueOf(strings[0]));
            		car.setFactoryId(Integer.valueOf(strings[1]));
            		car.setModel(String.valueOf(strings[2]));
            		car.setYear(Integer.valueOf(strings[4]));
            		car.setFuel(String.valueOf(strings[5]));
            		car.setDoors(Integer.valueOf(strings[6]));
            		car.setCost(Double.valueOf(strings[7]));
            		car.setColor(String.valueOf(strings[8]));
            		
            		
            		carService.Add(car);
            	}
            	
			}
            
        }
		
		
		
		
		
			
		
		
		return;
	}
	
}
