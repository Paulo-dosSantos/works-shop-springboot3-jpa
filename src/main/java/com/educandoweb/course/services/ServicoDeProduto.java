package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.educandoweb.course.entities.Produto;
import com.educandoweb.course.repositories.RepositorioProduto;

@Service
public class ServicoDeProduto {
	
	@Autowired
	private RepositorioProduto repository;
	
	public List<Produto>findAll() {
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		 Optional<Produto>obj= repository.findById(id);
		 return obj.get();
		
	}

}
