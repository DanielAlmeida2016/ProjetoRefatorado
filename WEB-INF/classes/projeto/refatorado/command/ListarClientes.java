package projeto.refatorado.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.refatorado.model.Cliente;
import projeto.refatorado.service.ClienteService;

public class ListarClientes implements Command {
	ClienteService cs;

	public ListarClientes() {
		cs = new ClienteService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			List<Cliente> lista = new ArrayList<Cliente>();
			
			lista = cs.listarTodos();
			
			request.setAttribute("clientes", lista);

			RequestDispatcher view = request.getRequestDispatcher("views/cliente/listarClientes.jsp");

			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
