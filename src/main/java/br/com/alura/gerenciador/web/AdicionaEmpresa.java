package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class AdicionaEmpresa implements Tarefa {

	private static final long serialVersionUID = 1L;

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String nome = req.getParameter("nome");

		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);

		req.setAttribute("empresa", empresa);
		return "/WEB-INF/paginas/adicionaEmpresa.jsp";
	}

}
