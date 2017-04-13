package projeto.refatorado.test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import projeto.refatorado.model.Cliente;
import projeto.refatorado.service.ClienteService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteTest {

	Cliente c;
	ClienteService cs;

	@Before
	public void setUp() {
		cs = new ClienteService();

		/*
		 * for (int i = 0; i < 8; i++) { c = new Cliente();
		 * c.setNome("Daniel de Almeida 201" + i); c.setRg("48331994" + i);
		 * c.setCpf("0847781653" + i); c.setTelefone("(11) 95277589" + i);
		 * c.setEmail("daniel" + i + "@hotmail.com"); }
		 */
	}

	@Test
    //@Ignore
	public void test01InserirCliente() {
		for (int i = 0; i < 8; i++) {
			c = new Cliente();
			c.setNome("Daniel de Almeida 201" + i);
			c.setRg("48331994" + i);
			c.setCpf("0847781653" + i);
			c.setTelefone("(11) 95277589" + i);
			c.setEmail("daniel" + i + "@hotmail.com");

			try {
				cs.criar(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	//@Ignore
	public void test02ListarClientes() {

		for (Cliente cliente : cs.listarTodos()) {
			System.out.println("Cliente: " + cliente.getId() + " Nome: " + cliente.getNome() + " RG: " + cliente.getRg()
					+ " CPF: " + cliente.getCpf() + " Telefone: " + cliente.getTelefone() + " Email: "
					+ cliente.getEmail() + "\n");
		}

		System.out.println();
		System.out.println();
	}

	@Test
	//@Ignore
	public void test03Atualizar() {

		Cliente c = cs.buscaPorId(4);
		c.setNome("Fui Alterado!");

		cs.atualizar(c);
	}

	@Test
	//@Ignore
	public void test04ListarClientes() {

		for (Cliente cliente : cs.listarTodos()) {
			System.out.println("Cliente: " + cliente.getId() + " Nome: " + cliente.getNome() + " RG: " + cliente.getRg()
					+ " CPF: " + cliente.getCpf() + " Telefone: " + cliente.getTelefone() + " Email: "
					+ cliente.getEmail() + "\n");
		}
		
		System.out.println();
		System.out.println();
	}
	
	@Test
	//@Ignore
	public void test05Deletar() {

		Cliente c = cs.buscaPorId(5);

		cs.excluir(c);
	}
	
	@Test
	//@Ignore
	public void test06ListarClientes() {

		for (Cliente cliente : cs.listarTodos()) {
			System.out.println("Cliente: " + cliente.getId() + " Nome: " + cliente.getNome() + " RG: " + cliente.getRg()
					+ " CPF: " + cliente.getCpf() + " Telefone: " + cliente.getTelefone() + " Email: "
					+ cliente.getEmail() + "\n");
		}
		
		System.out.println();
		System.out.println();
	}

}
