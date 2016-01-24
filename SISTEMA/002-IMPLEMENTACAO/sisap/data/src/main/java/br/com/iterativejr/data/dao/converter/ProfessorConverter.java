package br.com.iterativejr.data.dao.converter;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.iterativejr.data.dao.impl.ProfessorDAO;
import br.com.iterativejr.domain.entidade.Professor;
import br.com.iterativejr.domain.exception.SisapException;

@Named
@RequestScoped
public class ProfessorConverter implements Converter {

	private static final Log LOGGER = LogFactory
			.getLog(ProfessorConverter.class);

	@Inject
	private ProfessorDAO professores;

	public Object getAsObject(FacesContext context, UIComponent component,
			String valor) {
		if (valor == null || valor.trim().isEmpty()) {
			return null;
		}
		String matricula = String.valueOf(valor);

		try {
			return professores.buscarPorMatricula(matricula);
		} catch (SisapException e) {
			String msgErroStr = String
					.format("Erro de conversao! Nao foi possivel realizar a conversao da string '%s' para o tipo esperado.",
							valor);
			FacesMessage msgErro = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);
			LOGGER.warn(msgErro, e);
		}
		return null;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object valor) {
		if (valor == null) {
			return null;
		}
		String cpfProfessor = ((Professor) valor).getCpf();

		return (cpfProfessor != null) ? cpfProfessor.toString() : null;
	}

}
