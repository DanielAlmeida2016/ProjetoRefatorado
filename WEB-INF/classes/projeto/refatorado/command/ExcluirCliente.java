package projeto.refatorado.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.refatorado.model.Cliente;
import projeto.refatorado.service.ClienteService;

public class ExcluirCliente implements Command {
	Cliente cliente;
	ClienteService cs;

	public ExcluirCliente() {
		cliente = new Cliente();
		cs = new ClienteService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			cliente.setId(Integer.parseInt(request.getParameter("id")));
			cliente = cs.buscaPorId(cliente.getId());
			cs.excluir(cliente);

			response.setStatus(HttpServletResponse.SC_OK);

		} catch (Exception e) {
			e.printStackTrace();

			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
