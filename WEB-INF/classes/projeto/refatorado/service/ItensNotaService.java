package projeto.refatorado.service;

import java.util.List;

import projeto.refatorado.dao.ItensNotaDAO;
import projeto.refatorado.model.ItensNota;
import projeto.refatorado.model.Produto;

public class ItensNotaService {

	private ItensNotaDAO dao;

	public ItensNotaService() {
		dao = new ItensNotaDAO();
	}

	public void gerarItensNota(long prodId, long notaId) {
		long idItens = dao.gerarItensNota(prodId, notaId);
	}

	public void excluirItensNota(long id) {
		dao.excluirItensNota(id);
	}

	public ItensNota carregarItensNota(long id) {
		return dao.carregarItensNota(id);
	}

	public List<ItensNota> listarTodosItensNota() {
		return dao.listarTodosItensNota();
	}

}
