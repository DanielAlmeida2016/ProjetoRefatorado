package projeto.refatorado.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.refatorado.model.Produto;
import projeto.refatorado.service.ProdutoService;

public class CadastrarProduto implements Command {

	Produto produto;
	ProdutoService ps;

	public CadastrarProduto() {

		produto = new Produto();
		ps = new ProdutoService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		double valorVenda = 0, valorCompra = 0;
		int quantidade = 0;
		String sValorVenda, sValorCompra, sQuantidade;

		try {
			produto.setCategoria(request.getParameter("categoria"));
			produto.setDescricao(request.getParameter("descricao"));
			produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			produto.setValorCompra(Double.parseDouble(request.getParameter("valorCompra")));
			produto.setValorVenda(Double.parseDouble(request.getParameter("valorVenda")));

			ps.criar(produto);

			response.setStatus(HttpServletResponse.SC_OK);

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

	}

}
