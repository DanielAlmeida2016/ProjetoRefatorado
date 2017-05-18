package projeto.refatorado.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projeto.refatorado.model.Usuario;
import projeto.refatorado.service.UsuarioService;

public class UsuarioLogin implements Command {

	Usuario usuario;
	UsuarioService us;

	public UsuarioLogin() {
		usuario = new Usuario();
		us = new UsuarioService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			if (request.getParameter("metodo").equals("valida")) {
				valida(request, response);
			} else if (request.getParameter("metodo").equals("redireciona")) {
				redireciona(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	public void valida(HttpServletRequest request, HttpServletResponse response) {

		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setSenha(request.getParameter("senha"));

		boolean isUsuario = us.acesso(usuario);

		if (isUsuario) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

	}

	public void redireciona(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			System.out.println("fuichamado");
			RequestDispatcher view = request.getRequestDispatcher("principal.jsp");
			view.forward(request, response);
			System.out.println("fuichamado2");
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
