package projeto.refatorado.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.refatorado.model.Produto;
import projeto.refatorado.service.ProdutoService;

public class AlterarProduto implements Command {

	Produto produto;
	ProdutoService ps;

	public AlterarProduto() {

		produto = new Produto();
		ps = new ProdutoService();

	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			produto.setId(Long.parseLong(request.getParameter("id")));
			produto.setCategoria(request.getParameter("categoria"));
			produto.setDescricao(request.getParameter("descricao"));
			produto.setFornecedor(request.getParameter("fornecedor"));
			produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			produto.setValorCompra(Double.parseDouble(request.getParameter("valorCompra")));
			produto.setValorVenda(Double.parseDouble(request.getParameter("valorVenda")));

			ps.alterar(produto);

			response.setStatus(HttpServletResponse.SC_OK);

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

	}

}
