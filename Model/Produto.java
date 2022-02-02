package Model;

import java.awt.Dimension;

public class Produto {
	private double tamanho;
	private String cor;
	private String malha;
	private String estampa;
	private String nome;
	private int id;
	private float preco;
	private double qtd;
	private String tipoUn;
	private double estoqueMin;

	public Produto(double tamanho, String cor, String malha, String estampa, String nome, int id, float preco, double qtd, String tipoUn, double estoqueMin) {
		this.tamanho = tamanho;
		this.cor = cor;
		this.malha = malha;
		this.estampa = estampa;
		this.nome = nome;
		this.id = id;
		this.preco = preco;
		this.qtd = qtd;
		this.tipoUn = tipoUn;
		this.estoqueMin = estoqueMin;
	}

	public Produto() {

	}

	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	//-------x----------------x--------
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	//-------x----------------x--------
	public String getMalha() {
		return malha;
	}
	public void setMalha(String malha) {
		this.malha = malha;
	}
	//-------x----------------x--------
	public String getEstampa() {
		return estampa;
	}
	public void setEstampa(String estampa) {
		this.estampa = estampa;
	}

	//-------x----------------x--------
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	//-------x----------------x--------
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	//-------x----------------x--------
	public float getPreco(){
		return this.preco;
	}
	public void setPreco(float preco){
		this.preco = preco;
	}
	//-------x----------------x--------
	public double getQtd(){
		return this.qtd;
	}
	public void setQtd(double qtd){
		this.qtd = qtd;
	}
	//-------x----------------x--------
	public String getTipoUn(){
		return this.tipoUn;
	}
	public void setTipoUn(String tipoUn){
		this.tipoUn = tipoUn;
	}
	//-------x----------------x--------
	public double getEstoqueMin(){
		return this.estoqueMin;
	}
	public void setEstoqueMin(double estoqueMin){
		this.estoqueMin = estoqueMin;
	}

	public void cobertor(){
		System.out.println("Qual a cor que voce deseja : "+this.getCor());
		System.out.println("Voce deseja Uma Estampa no seu Cobertor : "+this.getEstampa());
		System.out.println("Qual tipo de malha voce deseja ultilizar: "+this.getMalha());
		System.out.println("Qual o tamanha que voce deseja: "+this.getTamanho());
	}

	public void lencol(){
		System.out.println("Qual a cor que voce deseja : "+this.getCor());
		System.out.println("Qual tipo de malha voce deseja ultilizar: "+this.getMalha());
		System.out.println("Qual o tamanha que voce deseja: "+this.getTamanho());
		System.out.println("Quantas unidades que você deseja: "+this.getQtd());
	}
}