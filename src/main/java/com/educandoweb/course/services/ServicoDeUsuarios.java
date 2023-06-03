package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Usuario;
import com.educandoweb.course.repositories.RepositorioUsuario;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicoDeUsuarios {
	
	@Autowired
	private RepositorioUsuario repository;
	
	public List<Usuario>findAll() {
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		 Optional<Usuario>obj= repository.findById(id);
		 return obj.orElseThrow(()-> new ResourceNotFoundException(id));
		 
		 
		
	}
	public Usuario inserir(Usuario usuario) {
		return repository.save(usuario);
	}
	public void deletar(Long id) {
		
	
		repository.deleteById(id);
		
	}
	public Usuario atualizar(Long Id, Usuario usuario) {
		try {
			Usuario entidade= repository.getReferenceById(Id);
			atualizarDados(entidade,usuario);
			return repository.save(entidade);
		}
		catch(EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(Id);
		}
	}

	private void atualizarDados(Usuario entidade, Usuario usuario) {
		entidade.setNome(usuario.getNome());
		entidade.setEmail(usuario.getEmail());
		entidade.setTelefone(usuario.getTelefone());
		
	}
	
	

}
