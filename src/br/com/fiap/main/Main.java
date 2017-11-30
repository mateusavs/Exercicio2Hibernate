package br.com.fiap.main;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;
import br.com.fiap.helper.ClientesHelper;

public class Main {
	private static ClientesHelper helper = new ClientesHelper();
	
	public static void main(String[] args) {
		
		Clientes c1 = new Clientes();
		c1.setNome("Mateus Santos");
		c1.setEmail("mateus.artur@hotmail.com");
		
		Clientes c2 = new Clientes();
		c2.setNome("George Santos");
		c2.setEmail("georarturvieirasantos@gmail.com");
		
		Pedidos p1 = new Pedidos();
		p1.setDescricao("Notebook");
		p1.setValor(5000.0);
		p1.setData(Calendar.getInstance());
		
		Pedidos p2 = new Pedidos();
		p2.setDescricao("Mouse");
		p2.setValor(150.0);
		p2.setData(Calendar.getInstance());
		
		Pedidos p3 = new Pedidos();
		p3.setDescricao("Teclado");
		p3.setValor(350.0);
		p3.setData(Calendar.getInstance());
		
		Pedidos p4 = new Pedidos();
		p4.setDescricao("Monitor");
		p4.setValor(1500.0);
		p4.setData(Calendar.getInstance());
		
		c1.adicionarPedidos(p1);
		c1.adicionarPedidos(p2);
		c2.adicionarPedidos(p3);
		c2.adicionarPedidos(p4);
		helper.cadastrarCliente(c1);
		helper.cadastrarCliente(c2);
		
		
		List<Pedidos>pedidoCliente1 = helper.listarPedidosPorIdCliente(c1.getIdCliente());
		List<Pedidos>pedidoCliente2 = helper.listarPedidosPorIdCliente(c2.getIdCliente());
		
		pedidoCliente1.stream().forEach(System.out::println);
		pedidoCliente2.stream().forEach(System.out::println);
		
		List<Clientes>buscarClientes=helper.listarClientes();
		buscarClientes.stream().forEach(System.out::println);
		
		
	}
}
