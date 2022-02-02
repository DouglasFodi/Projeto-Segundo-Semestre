package Model;

import java.util.Date; 

public class Boleto {

	private int numeroDoBanco;
	private int contaCorrente;
	private int agencia;
	private int operacao;
	private String carteira;
	private int seuNumero;
	private int moeda;
	private int convenio;
	private Date dataVencimento;
	private double valor;

	public int getConvenio() {
		return convenio;
	}
	public void setConvenio(int convenio) {
		this.convenio = convenio;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public String getCarteira() {
		return carteira;
	}
	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}
	public int getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(int contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public int getMoeda() {
		return moeda;
	}
	public void setMoeda(int moeda) {
		this.moeda = moeda;
	}
	public String getNossoNumero() {
		return Integer.toString(getConvenio()) + Integer.toString(getSeuNumero());
	}
	public int getNumeroDoBanco() {
		return numeroDoBanco;
	}
	public void setNumeroDoBanco(int numeroDoBanco) {
		this.numeroDoBanco = numeroDoBanco;
	}
	public int getOperacao() {
		return operacao;
	}
	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}
	public int getSeuNumero() {
		return seuNumero;
	}
	public void setSeuNumero(int seuNumero) {
		this.seuNumero = seuNumero;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}       
}
