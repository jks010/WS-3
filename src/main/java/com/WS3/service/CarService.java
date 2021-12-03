package com.WS3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WS3.model.Cars;
import com.WS3.repository.CarRep;

@Service
public class CarService {

	@Autowired
	 private CarRep carRep;
	
	
	
	public List<Cars> findAll(){
		return (List<Cars>) carRep.findAll();
	}
	public Cars findbyId(int id){
		Cars car = carRep.findById(id)
			  .orElseThrow(RuntimeException::new);
		return car;
	}
	
	public Cars savebyId(int id,int factoryId,String model,int year,String fuel,int doors,double cost,String color){
		Cars car = carRep.findById(id)
			  .orElseThrow(RuntimeException::new);
		
		car.setFactoryId(factoryId);
		car.setModel(model);
		car.setYear(year);
		car.setFuel(fuel);
		car.setDoors(doors);
		car.setCost(cost);
		car.setColor(color);
		
		carRep.save(car);
		return car;
	}

	public List<Cars> Add(Cars car) {
		// TODO Auto-generated method stub
		carRep.save(car);
		return (List<Cars>) carRep.findAll();
	}
	
	
	public List <Cars> delete(int id){
		Cars car = carRep.findById(id)
			  .orElseThrow(RuntimeException::new);
		carRep.deleteById(id);
		return (List<Cars>) carRep.findAll();
	}
	

	
}
