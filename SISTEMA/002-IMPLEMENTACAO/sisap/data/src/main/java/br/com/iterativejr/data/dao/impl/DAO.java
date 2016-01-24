package br.com.iterativejr.data.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.inject.Inject;

public abstract class DAO implements Serializable {

	private static final long serialVersionUID = -315740615092329279L;

	@Inject
	private transient EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
