package br.com.fiap.helper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.fiap.config.HibernateUtil;
import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class ClientesHelper {
	Session session = null;
	Transaction transaction = null;

	private Session getSession() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		return session;
	}
	
	public String cadastrarCliente(Clientes cliente){ 
		try{
			session = getSession();
			transaction = session.beginTransaction();
			session.save(cliente);
			transaction.commit();
			return "Cliente salvo"; 
		}catch(Exception e){
			transaction.rollback();
			return e.getMessage();
		} 
	}
	public void cadastrarPedido(Pedidos pedido) {
		try{
			session = getSession();
			transaction = session.beginTransaction();
			session.save(pedido);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
		}
	}
		
	public List<Pedidos>listarPedidosPorIdCliente(int idCliente){
		List<Pedidos>pedidos =  new ArrayList<Pedidos>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query<Pedidos>query = session.createQuery("from Pedidos p where p.idCliente.id =:idCliente");
			query.setParameter("idCliente", idCliente);
			query.setCacheable(true);
			pedidos = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}
	
	public List<Clientes>listarClientes(){
		List<Clientes>clientes =  new ArrayList<Clientes>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query<Clientes>query = session.createQuery("from Clientes c");
			clientes = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
}

