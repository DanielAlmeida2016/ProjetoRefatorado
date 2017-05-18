package projeto.refatorado.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.refatorado.model.Nota;
import projeto.refatorado.model.Produto;
import projeto.refatorado.service.NotaService;

public class GerarNotaFiscal implements Command {

	Nota nota;
	NotaService ns;
	Produto produto;

	public GerarNotaFiscal() {

		nota = new Nota();
		ns = new NotaService();
		produto = new Produto();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			nota.setCnpj(request.getParameter("cnpj"));
			nota.setFornecedor(request.getParameter("fornecedor"));
			nota.setObservacao(request.getParameter("observacao"));
			produto.setId(Long.parseLong(request.getParameter("prodId")));
			int quantidade = Integer.parseInt(request.getParameter("qtdComprada"));

			ns.gerarNota(nota, produto, quantidade);
			response.setStatus(HttpServletResponse.SC_OK);

		} catch (

		Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

	}

}
