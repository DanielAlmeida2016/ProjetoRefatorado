package projeto.refatorado.service;

import java.util.ArrayList;
import java.util.List;

import projeto.refatorado.dao.NotaDAO;
import projeto.refatorado.model.Nota;

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

	public void excluirNota(long idNota, long idItens) {		
		ins.excluirItensNota(idItens);
		dao.excluirNota(idNota);
	}

	public Nota carregarNota(long id) {
		
		Nota nota = dao.carregarNota(id);
		
		//nota.setItensNota(ins.listarTodosItensNota(id));
		
		return nota;
	}

	public List<Nota> listarTodasNotas() {
		
		List<Nota> lista = new ArrayList<Nota>();
		
		lista = dao.listarTodasNotas();		
		
		return dao.listarTodasNotas();
	}

}
