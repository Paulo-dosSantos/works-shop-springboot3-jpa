package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long>{

}
