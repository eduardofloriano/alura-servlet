package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/executa")
public class Controller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String tarefa = req.getParameter("tarefa");
		if (tarefa == null) {
			throw new IllegalArgumentException(
					"Não foi passado a tarefa a ser executada!");
		}

		String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;
		try {
			Class<?> type = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa) type.newInstance();
			String redireciona = instancia.executa(req, resp);
			RequestDispatcher dispatcher = req
					.getRequestDispatcher(redireciona);
			dispatcher.forward(req, resp);
						
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
