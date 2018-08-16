package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.GerenteDao;
import br.com.caelum.financas.modelo.Gerente;

@Named
@ViewScoped
public class GerentesBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Gerente gerente = new Gerente();
	
	@Inject
	private GerenteDao gerenteDao;

	private List<Gerente> gerentes;
	
	
	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public List<Gerente> getGerentes() {
		if (this.gerentes == null) {
			this.gerentes = gerenteDao.lista();
		}
		return gerentes;
	}

	public void setGerentes(List<Gerente> gerentes) {
		this.gerentes = gerentes;
	}

	public void grava() {
		System.out.println("Gravando o gerente");
		
		if (this.gerente.getId() == null) {
			gerenteDao.adiciona(gerente);
		} else {
			gerenteDao.altera(gerente);
		}
		
		this.gerentes = gerenteDao.lista();
		limpaFormularioDoJSF();
	}
	
	public void remove() {
		System.out.println("Removendo o gerente");
		gerenteDao.remove(gerente);
		this.gerentes = gerenteDao.lista();
		limpaFormularioDoJSF();
	}	
	
	private void limpaFormularioDoJSF() {
		this.gerente = new Gerente();
	}
	
}
