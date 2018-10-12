package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login implements Tarefa {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp)  {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		//PrintWriter writer = resp.getWriter();
		if(usuario==null) {
			//writer.println("<html><body>Usuario Invalido</body></html>");
			return "/WEB-INF/paginas/login.jsp";
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario); 
			//writer.print("<html><body>Usuario logado: "+usuario.getEmail()+"</body></html>");
			return "/WEB-INF/paginas/login.jsp";
		}
		
		
	}

}
