package projeto.refatorado.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.refatorado.model.Produto;
import projeto.refatorado.service.ProdutoService;

public class ExcluirProduto implements Command {

	Produto produto;
	ProdutoService ps;
	
	public ExcluirProduto() {
		produto = new Produto();
		ps = new ProdutoService();
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			produto.setId(Long.parseLong(request.getParameter("id")));

			ps.excluir(produto);

			response.setStatus(HttpServletResponse.SC_OK);

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

	}

}
