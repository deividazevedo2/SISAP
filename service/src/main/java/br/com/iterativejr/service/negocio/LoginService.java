/**
 * 
 */
package br.com.iterativejr.service.negocio;

import javax.validation.constraints.NotNull;

/**
 * @author edsf
 *
 */
public interface LoginService {

	public boolean autenticarUsuario(@NotNull String login,
			@NotNull String senha);
}
