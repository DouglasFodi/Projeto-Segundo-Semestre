package Model;
import Model.Produto;

public class Carrinho {
	//atributos; produtos, valor
	Produto produtos[];
	double valorTotal;

	void isereProduto(Produto produtos){
		System.out.println("Nome: "+this.produtos[0]);
	}

	void isereValor(double valorTotal){
		System.out.println("Nome: "+this.valorTotal);
	}


}
