package projeto.refatorado.service;

import java.io.IOException;

import projeto.refatorado.dao.ItensNotaDAO;
import projeto.refatorado.model.Produto;

public class ItensNotaService {

	private ItensNotaDAO dao;

	public ItensNotaService() {
		dao = new ItensNotaDAO();
	}

	public void gerarItensNota(Produto produto, long notaId, int qtdComprada) throws IOException {
		dao.gerarItensNota(produto, notaId, qtdComprada);
	}

	public void excluirItensNota(long id) {
		dao.excluirItensNota(id);
	}

	/* public ArrayList<ItensNota> listarTodosItensNota(long id) {
		return dao.listarTodosItensNota(id);
	} */

}
