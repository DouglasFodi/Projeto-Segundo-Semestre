package Model;
import java.util.Scanner;

public class Pagamento {
	// Atributos:forma de Pagamento, valor total
	// Declaração dos atributos
	int formaPagamento;

	//Métodos (operações)
	void seleciona(){
		System.out.println("Forma de pagamento: \n(1)Boleto \n(2)Cartão ");
		Scanner forma = new Scanner(System.in);
		formaPagamento = forma.nextInt();
		System.out.println("Forma" + formaPagamento);
	}
}
