package com.WS3.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.WS3.model.Factories;

@ComponentScan
@Repository
public interface FactoryRep extends CrudRepository<Factories, Integer>{
}
