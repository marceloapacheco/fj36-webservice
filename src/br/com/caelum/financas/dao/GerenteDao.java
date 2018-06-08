package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.financas.modelo.Gerente;

@Stateless
public class GerenteDao {

	@PersistenceContext
	EntityManager manager;

	public void adiciona(Gerente gerente) {
		manager.joinTransaction();
		this.manager.persist(gerente);
	}

	public Gerente busca(Integer id) {
		return this.manager.find(Gerente.class, id);
	}

	public List<Gerente> lista() {
		manager.joinTransaction();
		return this.manager.createQuery("select g from Gerente g", Gerente.class)
				.getResultList();
	}

	public void remove(Gerente gerente) {
		manager.joinTransaction();
		Gerente gerenteParaRemover = this.manager.find(Gerente.class, gerente.getId());
		this.manager.remove(gerenteParaRemover);
	}
	
	public void altera(Gerente gerente) {
		manager.joinTransaction();
		this.manager.merge(gerente);
	}

}




