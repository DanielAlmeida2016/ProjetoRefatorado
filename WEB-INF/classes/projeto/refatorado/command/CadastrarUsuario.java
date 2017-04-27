package projeto.refatorado.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto.refatorado.model.Usuario;
import projeto.refatorado.service.UsuarioService;

public class CadastrarUsuario implements Command{

	Usuario usuario;
	UsuarioService us;

	public CadastrarUsuario() {
		usuario = new Usuario();
		us = new UsuarioService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			usuario.setUsuario(request.getParameter("usuario"));
			usuario.setSenha(request.getParameter("senhaConf"));

			us.adicionar(usuario);

			response.setStatus(HttpServletResponse.SC_OK);

		} catch (Exception e) {
			e.printStackTrace();

			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
