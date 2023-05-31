package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Pedido;

public interface RepositorioDePedidos extends JpaRepository<Pedido, Long>{

}
