package Model;
import java.util.Scanner;

public class Pagamento {
	// Atributos:forma de Pagamento, valor total
	// Declara��o dos atributos
	int formaPagamento;

	//M�todos (opera��es)
	void seleciona(){
		System.out.println("Forma de pagamento: \n(1)Boleto \n(2)Cart�o ");
		Scanner forma = new Scanner(System.in);
		formaPagamento = forma.nextInt();
		System.out.println("Forma" + formaPagamento);
	}
}
