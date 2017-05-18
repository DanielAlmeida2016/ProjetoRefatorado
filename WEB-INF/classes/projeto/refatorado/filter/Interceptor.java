package projeto.refatorado.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projeto.refatorado.model.Usuario;

public class Interceptor implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		String path = req.getContextPath();
		String uri = req.getRequestURI();
		String command = req.getParameter("command");
		if (command == null) {
			command = "";
		}
		if (usuarioLogado == null && !command.equals("UsuarioLogin") && !uri.contains("login.jsp")) {
			((HttpServletResponse) response).sendRedirect(path + "/login.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
