package projeto.refatorado.service;

import java.util.ArrayList;

import projeto.refatorado.dao.ItensNotaDAO;
import projeto.refatorado.model.ItensNota;

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

	/* public ArrayList<ItensNota> listarTodosItensNota(long id) {
		return dao.listarTodosItensNota(id);
	} */

}
