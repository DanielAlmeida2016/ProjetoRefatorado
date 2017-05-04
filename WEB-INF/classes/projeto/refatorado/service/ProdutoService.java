package projeto.refatorado.service;

import java.util.List;

import projeto.refatorado.dao.ProdutoDAO;
import projeto.refatorado.model.Produto;

public class ProdutoService {

	private ProdutoDAO dao;

	/*
	 * Crud Listar todos os produtos Listar todos produto por categoria Procurar
	 * produto pela descrição
	 */
	public ProdutoService() {
		dao = new ProdutoDAO();
	}

	public void criar(Produto produto) {
		System.out.println(produto.toString());
		dao.criar(produto);
	}

	public void alterar(Produto produto) {
		dao.alterar(produto);
	}

	public void excluir(Produto produto) {
		dao.excluir(produto);
	}

	public Produto carregar(long id) {
		return dao.carregar(id);

	}

	public List<Produto> listarTodosProdutos() {
		return dao.listarTodosProdutos();
	}

	public List<Produto> listarPorCategoria(String categoria) {
		return dao.listarPorCategoria(categoria);
	}

	public Produto buscarDescricao(String descricao) {
		return dao.buscarDescricao(descricao);
	}

	public void alterarQuantidadeEmEstoque(long prodId, int quantidade) {

		int quantidadeTotal = 0;
		int quantidadeLocal = dao.getQuantidade(quantidade);

		quantidadeTotal = quantidade + quantidadeLocal;

		dao.adicionarEstoque(quantidadeTotal, prodId);
	}

}
