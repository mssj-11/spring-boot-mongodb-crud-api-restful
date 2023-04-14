package com.mss.springboot.web.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mss.springboot.web.app.model.Cliente;


public interface ClienteRepositorio extends MongoRepository<Cliente, Integer>{
	
}