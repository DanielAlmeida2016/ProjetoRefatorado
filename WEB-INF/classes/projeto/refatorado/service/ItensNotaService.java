package projeto.refatorado.service;

import projeto.refatorado.dao.ItensNotaDAO;
import projeto.refatorado.model.Produto;

public class ItensNotaService {

	private ItensNotaDAO dao;

	public ItensNotaService() {
		dao = new ItensNotaDAO();
	}

	public void gerarItensNota(Produto produto, long notaId) {
		dao.gerarItensNota(produto, notaId);
	}

	public void excluirItensNota(long id) {
		dao.excluirItensNota(id);
	}

	/* public ArrayList<ItensNota> listarTodosItensNota(long id) {
		return dao.listarTodosItensNota(id);
	} */

}
