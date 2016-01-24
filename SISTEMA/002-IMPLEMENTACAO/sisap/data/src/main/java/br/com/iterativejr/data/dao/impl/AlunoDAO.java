package br.com.iterativejr.data.dao.impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.iterativejr.domain.entidade.Aluno;
import br.com.iterativejr.domain.entidade.Pedagogo;
import br.com.iterativejr.domain.exception.SisapException;

public class AlunoDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -601004838687928376L;

	private static final Log LOGGER = LogFactory.getLog(AlunoDAO.class);

	/**
	 * Realiza a busca da entidade Aluno atraves do ID passado como parametro no
	 * metodo.
	 * 
	 * @param id
	 * @return
	 * @throws SisapException
	 */
	public Aluno buscarPorId(Long id) throws SisapException {
		EntityManager em = getEntityManager();
		Aluno resultado = null;
		try {
			resultado = em.find(Aluno.class, id);
		} catch (PersistenceException e) {
			LOGGER.warn("Ocorreu um problema ao buscar o Aluno!", e);
		}
		return resultado;
	}

	/**
	 * Realiza a busca de uma determinada entidade PEdagogo atraves da matricula
	 * do pedagogo passada como parametro.
	 * 
	 * @param matriculaPedagogo
	 * @return
	 * @throws SisapException
	 */
	public ArrayList<Float> buscarNotaPorMatricula(Long matriculaAluno)
			throws SisapException {
		ArrayList<Float> notas = new ArrayList<Float>();
		EntityManager em = getEntityManager();
		Float resultado = null;
		if (matriculaAluno == null) {
			matriculaAluno = Long.valueOf("");
		}
		try {
			TypedQuery<Pedagogo> query = em
					.createQuery(
							"select nota from TB_NOTA_DE_AVALIACAO where notaDaAvaliacao.aluno.matricula like :matriculaAluno",
							Pedagogo.class);
			query.setParameter("matricula", "%" + matriculaAluno + "%");
			notas.add(resultado);
		} catch (PersistenceException e) {
			LOGGER.warn("Ocorreu um problema ao buscar as notas!", e);
		}

		return notas;

	}

	public String buscarFrequenciaDoAluno(Long matricula) {
		return null;
	}

}
