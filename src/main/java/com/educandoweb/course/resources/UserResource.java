package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.Usuario;
import com.educandoweb.course.services.ServicoDeUsuarios;

@RestController
@RequestMapping(value="/usuarios")
public class UserResource {
	
	@Autowired
	private ServicoDeUsuarios service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>>findAll(){
		List<Usuario>list= service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Usuario>findById(@PathVariable Long id){
		Usuario obj= service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Usuario>inserir(@RequestBody   Usuario usuario){
		
		usuario= service.inserir(usuario);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
		
	}
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void>deletar(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
		
	}
	@PutMapping(value= "/{id}")
	public ResponseEntity<Usuario>atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
		usuario=service.atualizar(id, usuario);
		return ResponseEntity.ok().body(usuario);
		
		
	}

}
