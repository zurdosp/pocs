package br.com.saaasgateway.domain;

public class TransactionaData {

	private String bandeira;
	private String tipoPagamento;
	private String nome;
	
	public TransactionaData(){
		
	}

	public TransactionaData(String bandeira, String tipoPagamento, String nome) {
		super();
		this.bandeira = bandeira;
		this.tipoPagamento = tipoPagamento;
		this.nome = nome;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
