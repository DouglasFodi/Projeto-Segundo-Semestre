import Model.Produto;

public class Classe {
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
