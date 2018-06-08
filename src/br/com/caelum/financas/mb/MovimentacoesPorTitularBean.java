package br.com.caelum.financas.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;

@Named
@RequestScoped
public class MovimentacoesPorTitularBean {

	private List<Movimentacao> movimentacoes;
	private String titular;
	
	@Inject
	private MovimentacaoDao movimentacaoDao;

	public void lista() {
		System.out.println("Buscando as movimentacoes pelo titular da conta " + this.titular);
		this.movimentacoes = this.movimentacaoDao.buscaTodasMovimentacoes(titular);

	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
