package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Pedido;
import com.educandoweb.course.repositories.RepositorioDePedidos;

@Service
public class ServicoDePedidos {
	
	@Autowired
	private RepositorioDePedidos repository;
	
	public List<Pedido>findAll() {
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		 Optional<Pedido>obj= repository.findById(id);
		 return obj.get();
		
	}

}
