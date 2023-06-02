package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Usuario;
import com.educandoweb.course.repositories.RepositorioUsuario;

@Service
public class ServicoDeUsuarios {
	
	@Autowired
	private RepositorioUsuario repository;
	
	public List<Usuario>findAll() {
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		 Optional<Usuario>obj= repository.findById(id);
		 return obj.get();
		
	}
	public Usuario inserir(Usuario usuario) {
		return repository.save(usuario);
	}

}
