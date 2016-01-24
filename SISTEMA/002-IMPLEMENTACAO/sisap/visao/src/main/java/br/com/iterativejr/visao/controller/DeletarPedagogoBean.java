package br.com.iterativejr.visao.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.RollbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.iterativejr.domain.entidade.Pedagogo;
import br.com.iterativejr.domain.exception.SisapException;
import br.com.iterativejr.service.negocio.impl.PedagogoService;
import br.com.iterativejr.visao.redirecionamento.EnderecoPaginas;

@Named
@ConversationScoped
public class DeletarPedagogoBean extends ClasseAbstrata {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactory
			.getLog(DeletarPedagogoBean.class);

	private Pedagogo pedagogo;

	@Inject
	@RequestScoped
	private PedagogoService pedagogoService;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void init() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	/**
	 * Metodo para realizar a exclusao do cadastro do pedagogo.
	 * 
	 * @return
	 */
	public String excluirPedagogo() {
		conversation.end();

		try {
			if ((pedagogo.getMatriculaSuap() == "0")
					&& pedagogo.getMatriculaSuap().isEmpty()) {

				pedagogoService.remover(pedagogo);
				reportarMensagemDeSucesso("Pedagogo removido com sucesso!");

			}
		} catch (RollbackException | SisapException exception) {
			reportarMensagemDeErro(exception.getMessage());
			LOGGER.warn("Erro ao salvar cadastro!", exception);
			return null;
		}
		return EnderecoPaginas.REDIRECT_TRUE;
	}

	public String cancel() {
		conversation.end();
		return EnderecoPaginas.REDIRECT_TRUE;
	}

	public Pedagogo getPedagogo() {
		return pedagogo;
	}

	public void setAluno(Pedagogo pedagogo) {
		this.pedagogo = pedagogo;
	}

}
