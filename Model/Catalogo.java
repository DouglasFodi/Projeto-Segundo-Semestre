package Model;
import Model.Produto;

public class Catalogo {
	// atributos: produtos, valores
	String categoria;
	Produto produtos; //lista de produtos
	// puxa o Produto a classe!!
	void isereCategoria(String categoria){
		System.out.println("Nome: "+this.categoria);
	}

	void isereproduto(String produto){
		System.out.println("Nome: "+this.produtos);
	}
}
