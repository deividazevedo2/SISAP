/**
 * 
 */
package br.com.iterativejr.visao.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import br.com.iterativejr.service.negocio.LoginService;

/**
 * @author edsf
 *
 */
@Controller("loginController")
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3351747538385229488L;

	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;

	private String login;

	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String executarLogin() {

		loginService.autenticarUsuario(this.getLogin(), this.getSenha());

		return "main";
	}

}
