package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		super();
		this.cookies = cookies;
	}

	public Cookie getUsuarioLogado() {

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("usuarioLogado")) {
					return cookie;
				}
			}
		}
		return null;
	}

}
