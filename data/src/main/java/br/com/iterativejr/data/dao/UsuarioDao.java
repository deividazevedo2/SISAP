/**
 * 
 */
package br.com.iterativejr.data.dao;

import br.com.iterativejr.domain.entidade.Usuario;

/**
 * @author edsf
 *
 */
public interface UsuarioDao extends GenericDao<Usuario, Long>  {

	public Usuario buscarPorLogin(String login);
}
