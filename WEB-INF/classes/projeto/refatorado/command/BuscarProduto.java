package projeto.refatorado.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.refatorado.model.Produto;
import projeto.refatorado.service.ProdutoService;

public class BuscarProduto implements Command {

	String codigo;
	Produto produto;
	ProdutoService ps;

	public BuscarProduto() {
		produto = new Produto();
		ps = new ProdutoService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		long id = 0;
		try {
			codigo = request.getParameter("id");

			try {
				id = Long.parseLong(codigo);

			} catch (Exception e) {
				e.printStackTrace();
			}

			produto = ps.carregar(id);

			request.setAttribute("produto", produto);

			RequestDispatcher view = request.getRequestDispatcher("views/produto/alterarProduto.jsp");
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
