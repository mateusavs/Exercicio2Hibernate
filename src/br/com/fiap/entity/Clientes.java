package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")

public class Clientes implements Serializable{

	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDCLIENTE")
	private int idCliente;
	
	@Column(name = "NOME", length = 45)
	private String nome;
	
	@Column(name = "EMAIL", length = 45)
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente", fetch = FetchType.LAZY) 
	@Column(name = "IDPEDIDOS")
	private List<Pedidos> pedidos;
	

	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Clientes(int idCliente, String nome, String email) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
	}
	public Clientes(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	public Clientes(){
		super();
		pedidos = new ArrayList<Pedidos>();
	}
	
	public List<Pedidos> getPedidos() { 
		return pedidos;
	}

	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos; 
	}
	
	public void adicionarPedidos(Pedidos pedido) {
		pedido.setIdCliente(this);
		this.pedidos.add(pedido);
	}
	
	@Override
	public String toString() {
	 
	 return "Nome: " + nome + "\nEmail :" + email ;
	}
}