package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;


public class BuscaEmpresa implements Tarefa{

	// Response = Envia para o cliente
	// Request = recebe a requisição do cliente
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) 
			{
		String filtro = req.getParameter("filtro");
		// Chama o metodo para pequisar empresas que contenham este nome
		Collection<Empresa>empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		//setando um atributo de requisição do servidor como objeto empresa
		req.setAttribute("empresas", empresas);
		//criando uma variavel "despachante" para encaminhar o servidor para outra pagina
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
		//dispatcher.forward(req, resp);
		
	}
	
}
