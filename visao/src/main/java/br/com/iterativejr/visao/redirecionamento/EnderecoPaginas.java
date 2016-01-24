package br.com.iterativejr.visao.redirecionamento;

/**
 * Caminho das paginas para realizar o redirecionamento no bean.
 * 
 * @author Deivid Azevedo
 *
 */
public class EnderecoPaginas {
	
	private EnderecoPaginas() {
	}

	public static final String REDIRECT_TRUE = "?faces-redirect=true";

	public static final String PAGINA_PRINCIPAL_LOGIN = "/paginas/login"
			+ REDIRECT_TRUE;

	public static final String PAGINA_PRINCIPAL_PEDAGOGO = "/paginas/pedagogo/indexPedagogo"
			+ REDIRECT_TRUE;

	public static final String PAGINA_PRINCIPAL_PROFESSOR = "/paginas/professor/indexProfessor"
			+ REDIRECT_TRUE;

	public static final String PAGINA_PRINCIPAL_ADMIN = "/paginas/admin/indexAdmin"
			+ REDIRECT_TRUE;
}
