package br.com.iterativejr.domain.entidade;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Pedagogo")
@Table(name = "TB_PEDAGOGO")
@DiscriminatorValue("PEDAGOGO")
public class Pedagogo extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5222738149854183983L;

	public Pedagogo() {
	}

}