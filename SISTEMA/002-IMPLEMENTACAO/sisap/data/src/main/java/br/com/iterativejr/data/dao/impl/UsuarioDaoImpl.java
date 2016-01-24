/**
 * 
 */
package br.com.iterativejr.data.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.iterativejr.data.dao.UsuarioDao;
import br.com.iterativejr.domain.entidade.Usuario;

/**
 * @author edsf
 *
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Long> implements
		UsuarioDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.br.iterativejr.sisap.data.dao.UsuarioDao#buscarPorLogin(java.lang
	 * .String)
	 */
	public Usuario buscarPorLogin(String login) {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(1l);
		usuario.setLogin("teste");
		usuario.setSenha("teste");
		usuario.setNome("teste");
		
		return usuario;
	}

}
