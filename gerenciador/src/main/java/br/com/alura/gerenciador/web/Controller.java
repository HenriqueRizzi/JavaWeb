package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@WebServlet(urlPatterns ="/executar")
public class Controller extends HttpServlet{

	//Metodo que trabalha com doGet e doPost
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Class<?> tipo = null;
		String tarefa = req.getParameter("tarefa");
		if(tarefa==null){
			throw new IllegalArgumentException("Voce Esqueceu de passar a tarefa");
		}
		//pegando a classe da tarefa---------------------
		tarefa = "br.com.alura.gerenciador.web."+tarefa;
		
		try {
			
			tipo = Class.forName(tarefa);
			//---------------------------------------------
			//Instanciando esta classe-----------------------
			Tarefa instancia = (Tarefa) tipo.newInstance();
			//-----------------------------------------------
			String pagina = instancia.executa(req,resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		}catch (ClassNotFoundException | InstantiationException | IllegalAccessException  e ) {
			throw new ServletException();
		}
	}
}
