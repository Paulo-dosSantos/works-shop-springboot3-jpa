package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Pedido;
import com.educandoweb.course.entities.Usuario;
import com.educandoweb.course.repositories.RepositorioDePedidos;
import com.educandoweb.course.repositories.RepositorioDeUsuarios;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private RepositorioDeUsuarios userRepository;
	@Autowired
	private RepositorioDePedidos repositorioDePedidos;
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1= new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2= new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		Pedido p1= new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Pedido p2= new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Pedido p3= new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		userRepository.saveAll(Arrays.asList(u1,u2));
		repositorioDePedidos.saveAll(Arrays.asList(p1,p2,p3));
		
	}
	
	
	

}
