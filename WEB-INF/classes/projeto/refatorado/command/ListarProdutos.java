package projeto.refatorado.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.refatorado.model.Produto;
import projeto.refatorado.service.ProdutoService;

public class ListarProdutos implements Command {

	Produto produto;
	ProdutoService ps;

	public ListarProdutos() {
		produto = new Produto();
		ps = new ProdutoService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		List<Produto> produtos = ps.listarTodosProdutos();

		request.setAttribute("produtos", produtos);

		RequestDispatcher view = request.getRequestDispatcher("views/produto/listarProdutos.jsp");
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
