package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Categoria;
import com.educandoweb.course.repositories.RepositorioCategoria;

@Service
public class ServicoDeCategoria {
	
	@Autowired
	private RepositorioCategoria repository;
	
	public List<Categoria>findAll() {
		return repository.findAll();
	}
	
	public Categoria findById(Long id) {
		 Optional<Categoria>obj= repository.findById(id);
		 return obj.get();
		
	}

}
