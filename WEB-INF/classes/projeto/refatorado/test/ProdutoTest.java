package projeto.refatorado.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.refatorado.model.Produto;
import projeto.refatorado.service.ProdutoService;

public class ProdutoTest {

	Produto p, copia;
	ProdutoService ps;
	long id;

	@Before
	public void setUp() throws Exception {

		ps = new ProdutoService();
		p = new Produto();
		p.setCategoria("Roupa");
		p.setDescricao("Calça");
		p.setQuantidade(10);
		p.setValorCompra(50.00);
		p.setValorVenda(100.00);

		copia = p;

		// System.out.println("setup");
	}

	@Test
	public void test001Criar() {

		System.out.println("criar");

		System.out.println(p.toString());

		ps.criar(p);

		// id = p.getId();

		// System.out.println(p.getId());

		assertEquals("Criar Teste", p, copia);

	}

	@Test
	public void test002Carregar() {
		System.out.println("carregar");
		ps.carregar(1);

		assertEquals("Carregar Teste", p, copia);

	}

	@Test
	public void test003Alterar() {

		System.out.println("Alterar");

		Produto produto = ps.carregar(2);

		produto.setDescricao("Marisa");
		copia.setDescricao("Marisa");
		copia.setId(2L);

		ps.alterar(produto);

		assertEquals(ps.carregar(2), copia);
	}

	@Test
	public void test004Excluir() {

		System.out.println("Alterar");

		Produto produtoExclusao = ps.carregar(2);

		ps.excluir(produtoExclusao);

		copia.setCategoria(null);
		copia.setDescricao(null);
		copia.setQuantidade(0);
		copia.setValorCompra(0.0);
		copia.setValorVenda(0.0);

		assertEquals(p, copia);

	}

}
