/**
 * 
 */
package br.com.iterativejr.service.negocio.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iterativejr.data.dao.UsuarioDao;
import br.com.iterativejr.domain.entidade.Usuario;

/**
 * @author edsf
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier("usuarioDao")
	private UsuarioDao usuarioDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Transactional
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {

		final Usuario usuario = usuarioDao.buscarPorLogin(login);
		
		return new UserDetails () {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getPassword() {
				// TODO Auto-generated method stub
				return usuario.getSenha();
			}

			public String getUsername() {
				// TODO Auto-generated method stub
				return usuario.getLogin();
			}

			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}

			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}

			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}

			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
		};
	}

	

}
