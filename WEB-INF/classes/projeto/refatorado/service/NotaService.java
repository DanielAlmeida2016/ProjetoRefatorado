package projeto.refatorado.service;

import java.util.List;

import projeto.refatorado.dao.NotaDAO;
import projeto.refatorado.model.ItensNota;
import projeto.refatorado.model.Nota;
import projeto.refatorado.model.Produto;

public class NotaService {

	private NotaDAO dao;
	private ItensNotaService ins;
	private ProdutoService ps;

	public NotaService() {
		dao = new NotaDAO();
		ins = new ItensNotaService();
		ps = new ProdutoService();
	}

	public void gerarNota(Nota nota, long prodId, int qtdComprada) {
		long notaId = dao.gerarNota(nota);
		ins.gerarItensNota(prodId, notaId);
		ps.alterarQuantidadeEmEstoque(prodId, qtdComprada);
	}

	public void excluirNota(long id) {
		dao.excluirNota(id);
	}

	public Nota carregarNota(long id) {
		return dao.carregarNota(id);
	}

	public List<Nota> listarTodasNotas() {
		return dao.listarTodasNotas();
	}

}
