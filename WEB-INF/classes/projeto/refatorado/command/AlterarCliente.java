package projeto.refatorado.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.refatorado.model.Cliente;
import projeto.refatorado.service.ClienteService;

public class AlterarCliente implements Command {
	Cliente cliente;
	ClienteService cs;

	public AlterarCliente() {
		cliente = new Cliente();
		cs = new ClienteService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			cliente.setId(Integer.parseInt(request.getParameter("id")));
			cliente.setNome(request.getParameter("nome"));
			cliente.setRg(request.getParameter("rg"));
			cliente.setCpf(request.getParameter("cpf"));
			cliente.setTelefone(request.getParameter("telefone"));
			cliente.setEmail(request.getParameter("email"));

			cs.atualizar(cliente);

			response.setStatus(HttpServletResponse.SC_OK);

		} catch (Exception e) {
			e.printStackTrace();

			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
