package br.com.fiap.entity;
import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pedidos")

public class Pedidos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDPEDIDO")
	private Integer idPedido;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCLIENTE")
	private Clientes idCliente;
	
	@Column(name = "DATA")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Column(name = "DESCRICAO", length = 45)
	private String descricao;
	
	@Column(name = "VALOR")
	private double valor;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Clientes getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Clientes idCliente) {
		this.idCliente = idCliente;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pedidos(){
		super();
	}

	public Pedidos(int idPedido, Clientes idCliente, Calendar data, String descricao, double valor) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		this.idPedido=idPedido;
		this.idCliente=idCliente;
	}

	public Pedidos(Clientes idCliente, Calendar data, String descricao, double valor) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		this.idCliente=idCliente;
	}

	@Override
	 
	 public String toString() {
	  return "Id do Pedido :" + idPedido + "\nID Cliente: "+  idCliente.getIdCliente() +"\nData :" + data.getTime() +"\nDescrição: "+ descricao  + "\nValor :" + valor;
	 }
}