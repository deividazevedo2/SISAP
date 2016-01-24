/**
 * 
 */
package br.com.iterativejr.domain.entidade;

/**
 * @author edsf
 *
 */
public class Usuario extends EntidadeBasica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3197020246204795849L;

	private Long id;

	private String nome;

	private String login;

	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
