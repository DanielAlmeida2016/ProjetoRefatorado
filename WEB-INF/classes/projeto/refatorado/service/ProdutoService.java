package projeto.refatorado.service;

import projeto.refatorado.dao.ProdutoDAO;
import projeto.refatorado.model.Produto;

public class ProdutoService {
	
	private ProdutoDAO dao;
	
	
	public ProdutoService(){
		dao = new ProdutoDAO();		
	}
	
	public void criar(Produto produto){
		System.out.println(produto.toString());
		dao.criar(produto);
	}
	
	public void alterar(Produto produto){
		dao.alterar(produto);
	}
	
	public void excluir(Produto produto){
		dao.excluir(produto);
	}
	
	public Produto carregar(long id){
		return dao.carregar(id);
		
	}

}
