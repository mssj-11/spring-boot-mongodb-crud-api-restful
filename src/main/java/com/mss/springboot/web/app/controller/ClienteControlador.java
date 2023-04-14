package com.mss.springboot.web.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mss.springboot.web.app.model.Cliente;
import com.mss.springboot.web.app.repository.ClienteRepositorio;



@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
	
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	
	
	//	Crear
	@PostMapping
	public ResponseEntity<?> saveClient(@RequestBody Cliente cliente){
		try {
			Cliente client = clienteRepositorio.save(cliente);
			return new ResponseEntity<Cliente>(client, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//	Actualizar
	@PutMapping
	public ResponseEntity<?> updateClient(@RequestBody Cliente cliente){
		try {
			Cliente client = clienteRepositorio.save(cliente);
			return new ResponseEntity<Cliente>(client, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//	Listar
	@GetMapping
	public ResponseEntity<?> findAllClient(){
		try {
			List<Cliente> client = clienteRepositorio.findAll();
			return new ResponseEntity<List<Cliente>>(client, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//	Buscar por ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getClientById(@PathVariable("id") Integer id){
		Optional<Cliente> client = clienteRepositorio.findById(id);
		if(client.isPresent()) {
			return new ResponseEntity<Cliente>(client.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Usuario no encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//	Eliminar
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable("id") Integer id){
		try {
			clienteRepositorio.deleteById(id);
			return new ResponseEntity<String>("Usuario eliminado", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}