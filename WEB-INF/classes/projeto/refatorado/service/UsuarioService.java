package projeto.refatorado.service;

import java.util.List;

import projeto.refatorado.dao.UsuarioDAO;
import projeto.refatorado.model.Usuario;

public class UsuarioService {

	UsuarioDAO dao;
	
	public UsuarioService(){
		dao = new UsuarioDAO();
	}
	
	public void adicionar(Usuario usuario){
		dao.adicionar(usuario);
	}
	
	public void excluir(Usuario usuario){
		dao.excluir(usuario);
	}
	
	public void alterarSenha(Usuario usuario){
		dao.alterarSenha(usuario);
	}
	
	public List<Usuario> listarTodos(Usuario usuario){
		return dao.listarTodos();
	}
	
	public boolean acesso(Usuario usuario){
		return dao.acesso(usuario);
	}
}
