package br.com.iterativejr.service.negocio.impl;

import java.io.Serializable;
import java.util.ArrayList;

import javax.inject.Inject;

import br.com.iterativejr.data.dao.impl.AlunoDAO;
import br.com.iterativejr.domain.entidade.Aluno;
import br.com.iterativejr.domain.exception.SisapException;
import br.com.iterativejr.service.negocio.util.TransacionalCdi;

public class AlunoService implements Serializable {

	@Inject
	private transient AlunoDAO alunoDAO;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6694613964483092616L;

	/**
	 * Metodo para realizar a busca do Aluno pela matricula do mesmo. A
	 * matricula deve ser passada como parametro para que a busca no banco possa
	 * ser realizada, retornando o cadastro referente.
	 * 
	 * @param idAluno
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public Aluno buscarPorMatricula(Long matricula) throws SisapException {
		return this.alunoDAO.buscarPorId(matricula);
	}

	/**
	 * Metodo para realizar a busca das notas do Aluno pela matricula do mesmo.
	 * A matricula deve ser passada como parametro para que a busca no banco
	 * possa ser realizada, retornando o cadastro referente.
	 * 
	 * @param matricula
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public ArrayList<Float> buscarNotasDoAluno(Long matricula)
			throws SisapException {
		return this.alunoDAO.buscarNotaPorMatricula(matricula);
	}

	/**
	 * Metodo para realizar a busca das frequencias do Aluno pela matricula do
	 * mesmo. A matricula deve ser passada como parametro para que a busca no
	 * banco possa ser realizada, retornando o cadastro referente.
	 * 
	 * @param matricula
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public String buscarFrequenciaDoAluno(Long matricula) throws SisapException {
		return this.alunoDAO.buscarFrequenciaDoAluno(matricula);
	}

}
