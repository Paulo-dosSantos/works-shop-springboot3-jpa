package com.educandoweb.course.entities.enums;

public enum StatusDoPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	private StatusDoPedido(int codigo) {
		this.codigo=codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public static StatusDoPedido valueOf(int codigo) {
		for(StatusDoPedido valor: StatusDoPedido.values()) {
			if(valor.getCodigo()==codigo) {
				return valor;
				
			}
			
		}
		throw new IllegalArgumentException("Código inválido");
		
	}

}
