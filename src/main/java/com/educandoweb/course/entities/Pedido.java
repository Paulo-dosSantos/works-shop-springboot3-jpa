package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.educandoweb.course.entities.enums.StatusDoPedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Pedido implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone="GMT")
	private Instant momento;
	
	
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name= "id_cliente")
	private Usuario cliente;
	
	public Pedido() {
		
	}

	public Pedido(Long id, Instant momento, StatusDoPedido status, Usuario cliente) {
		super();
		this.id = id;
		this.momento = momento;
		setStatus(status);
		this.cliente = cliente;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	

	public StatusDoPedido getStatus() {
		return StatusDoPedido.valueOf(status);
	}

	public void setStatus(StatusDoPedido status) {
		if(status != null) {
			this.status = status.getCodigo();
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, id, momento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(id, other.id)
				&& Objects.equals(momento, other.momento);
	}
	
	
	

}
