package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Cookie[] cookies = req.getCookies();
		Cookie cookie = new Cookies(cookies).getUsuarioLogado();
		PrintWriter writer = resp.getWriter();
		if(cookie != null){					
			writer.println("<html><body>Usuario Deslogado com sucesso!</body></html>");
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}else{
			writer.println("<html><body>Usuario nao estava logado</body></html>");
		}
		
	
	}
	
	
}
