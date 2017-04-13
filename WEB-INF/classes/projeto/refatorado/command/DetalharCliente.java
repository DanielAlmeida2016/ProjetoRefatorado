package projeto.refatorado.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.refatorado.model.Cliente;
import projeto.refatorado.service.ClienteService;

public class DetalharCliente implements Command {
	Cliente cliente;
	ClienteService cs;

	public DetalharCliente() {
		cliente = new Cliente();
		cs = new ClienteService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			cliente.setId(Integer.parseInt(request.getParameter("id")));

			cliente = cs.buscaPorId(cliente.getId());

			request.setAttribute("cliente", cliente);

			RequestDispatcher view = request.getRequestDispatcher("views/cliente/alterarCliente.jsp");

			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
