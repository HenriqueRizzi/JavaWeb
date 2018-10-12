package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

//Filter = Cadeia de execução; Adicionando uma caracteristica ao um conjunto de URIs
@WebFilter (urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		
	}

	//chain = Cadeia de filtros (próxima coisa que sera executada)
	@Override
	public void doFilter(ServletRequest request , ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String requestURI = req.getRequestURI();
		String usuario = getUsuario((HttpServletRequest) request);
		System.out.println("Usuario "+usuario+" acessando URI: " + requestURI);
		chain.doFilter(request, response);
		
	}
	
	//Atraves do metodo BuscaUsuarioLogado da classe Cookies, que retorna o cookie que informa o usuario logado
	//Pegamos a String de valor deste cookie, que contem o nome do usuário
	public String getUsuario(HttpServletRequest req) {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario == null)return "<deslogado>";
		return usuario.getEmail();
	}

	//Quando o filtro é inicializado
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
