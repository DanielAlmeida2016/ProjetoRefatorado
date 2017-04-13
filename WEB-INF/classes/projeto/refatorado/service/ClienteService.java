package projeto.refatorado.service;

import java.util.List;

import projeto.refatorado.dao.ClienteDAO;
import projeto.refatorado.model.Cliente;

public class ClienteService {

	private ClienteDAO dao;
	
	public ClienteService(){
		dao = new ClienteDAO();
	}
	
	public void criar(Cliente cliente) throws Exception{
		dao.criar(cliente);
	}
	
	public void excluir(Cliente cliente){
		dao.excluir(cliente);
	}
	
	public void atualizar(Cliente cliente){
		dao.atualizar(cliente);
	}
	
	public Cliente buscaPorId(int id){
		return dao.buscaPorId(id);
	}
	
	public List<Cliente> listarTodos(){	
		return dao.listarTodos();
	}
}
