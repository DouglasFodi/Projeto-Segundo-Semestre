// identificação da classe: main (toda identificação de classe começa com letra maiuscula)
import java.util.Scanner;
import java.util.Date;
class Main { // bloco de instrução
  
  // inicio da execução:
  public static void main(String[] args) { // programa sempre começa aqui
    Cliente c1 = new Cliente();
    c1.nome = "Maria Márcia Batista Fodi";
    c1.cpf = 12345;
    c1.login = "MarciaFodi123";
    c1.senha = "Marcia123";

    Produto p1 = new Produto();
    p1.descricao = "Lençol de Solteiro";
    p1.valor = 45.00;
    
    Pagamento pa1 = new Pagamento();
    pa1.formaPagamento = 1; // boleto

    Boleto b1 = new Boleto();
    b1.codigoBanco = 9999;
    b1.codigoBarras = 4321;
    b1.dataVencimento = new Date(); // ver com o professor
    b1.cpf = 12345;

    //Criar o pedido
    Pedido pedido = new Pedido();
    pedido.p = p1; //Associando o produto p1 no objeto pedido
    
    Catalogo ca1 = new Catalogo();
    ca1.categoria = "Categoria - LENÇOL" ;
    ca1.produtos[0] = p1;

    Carrinho car1 = new Carrinho();
    car1.produtos[0] = p1 ;
    car1.valorTotal = 45.00;

  } 
  private static final String DATA_BASE = "07/10/1997";

    public static int geraDigitoVerificador(String valorCampo) {
	int fator = 2;
	int soma  = 0;
	for(int i = valorCampo.length() - 1; i >= 0; i--) {
	int mult = Integer.parseInt("" + valorCampo.charAt(i)) * fator;
	mult = mult > 9 ? mult - 9 : mult;
	soma += mult;
	fator = fator == 2 ? 1 : 2;
	}
		
		return 10 - (soma % 10);
	}
	
    public static Date geraData(String data) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(data);
    }
	
	public static int geraFatorDeVencimento(Date dataDeVencimento) {
		Date dataBase = null;
		
		try {
			dataBase = geraData(DATA_BASE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		long diferenca = dataDeVencimento.getTime() - dataBase.getTime();
		return (int)Math.ceil((double)diferenca / (double)(1000 * 60 * 60 * 24)); 
	}
	
	public static String completaComZeros(String str, int tamanho) {
		if(str.length() < tamanho) {
			String zeros = "";
			for(int i = 0; i < tamanho - str.length(); i++) {
				zeros += "0";
			}
			return zeros + str;
		}
		
		return str;
	}
	
	public static String divideComPonto(String campo) {
		return campo.substring(0, 5) + "." + campo.substring(5, campo.length());
	}
	
	public static String geraCampo1(Boleto boleto) {
		String campo = Integer.toString(boleto.getNumeroDoBanco()) + 
		               Integer.toString(boleto.getMoeda()) +
		               boleto.getNossoNumero().substring(0, 5);
		campo = campo + geraDigitoVerificador(campo);
		campo = completaComZeros(campo, 10);
		campo = divideComPonto(campo);
		return campo;
	}
	
	public static String geraCampo2(Boleto boleto) {
		String campo = boleto.getNossoNumero().substring(boleto.getNossoNumero().length() - 6) + 
		               completaComZeros(Integer.toString(boleto.getAgencia()), 4);
		campo = campo + geraDigitoVerificador(campo);
		campo = completaComZeros(campo, 10);
		campo = divideComPonto(campo);
		return campo;
	}
	
	public static String geraCampo3(Boleto boleto) {
		String campo = completaComZeros(Integer.toString(boleto.getContaCorrente()), 8) +
		               completaComZeros(boleto.getCarteira(), 2);
		
		campo = campo + geraDigitoVerificador(campo);
		campo = completaComZeros(campo, 10);
		campo = divideComPonto(campo);
		
		return campo;
	}
	
	public static String converteValor(double valor) {
		String str = Double.toString(valor);
		
		int indiceSeparadorDecimal = -1;
		String ret = "";
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) != '.' && str.charAt(i) != ','){
				ret += str.charAt(i);
			}else{
				indiceSeparadorDecimal = i;
			}
		}

		if(indiceSeparadorDecimal != str.length() - 3){
			if(indiceSeparadorDecimal > str.length() - 3) {
				for(int i = 0; i < 2 - (str.length() - indiceSeparadorDecimal - 1); i++){
					ret += "0";
				}
			}
		}
		
		return completaComZeros(ret, 10);
	}
	
	public static String geraCampo4(Boleto boleto) {
		return geraFatorDeVencimento(boleto.getDataVencimento()) + converteValor(boleto.getValor());
	}
	
	public static int geraDigitoControlador(Boleto boleto) {
		String campo = completaComZeros(Integer.toString(boleto.getNumeroDoBanco()), 3) +
		               Integer.toString(boleto.getMoeda()) + 
		               Integer.toString(geraFatorDeVencimento(boleto.getDataVencimento())) +
		               converteValor(boleto.getValor()) +
		               completaComZeros(boleto.getNossoNumero(), 11) +
		               completaComZeros(Integer.toString(boleto.getAgencia()), 4) + 
		               completaComZeros(Integer.toString(boleto.getContaCorrente()), 8) +
		               completaComZeros(boleto.getCarteira(), 2);
		
		int soma  = 0;
		int[] multArray = {4,3,2,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2,9,8,7,6,5,4,3,2};
		for(int i = campo.length() - 1; i >= 0; i--) {
			int mult = Integer.parseInt("" + campo.charAt(i)) * multArray[i];
			soma += mult;
		}
		
		int dv = 11 - (soma % 11);
		
		if(dv == 1 || dv == 0 || dv == 10){
			dv = 1;
		}
		
		return dv;
	}
	
	public static String geraLinhaDigitavel(Boleto boleto) {
		return geraCampo1(boleto) + " " + geraCampo2(boleto) + " " + geraCampo3(boleto) + " " + geraDigitoControlador(boleto) + " " + geraCampo4(boleto);
	}
	
	public static String geraCodigoDeBarras(Boleto boleto) {
		return 
	completaComZeros(Integer.toString(boleto.getNumeroDoBanco()), 3) +
        Integer.toString(boleto.getMoeda()) + 
        Integer.toString(geraDigitoControlador(boleto)) +
        Integer.toString(geraFatorDeVencimento(boleto.getDataVencimento())) +
        converteValor(boleto.getValor()) +
        completaComZeros(boleto.getNossoNumero(), 11) +
        completaComZeros(Integer.toString(boleto.getAgencia()), 4) + 
        completaComZeros(Integer.toString(boleto.getContaCorrente()), 8) +
        completaComZeros(boleto.getCarteira(), 2);
	}
	
	public static void main(String[] args) throws Exception {
		Boleto boleto = new Boleto();
		boleto.setAgencia(9);
		boleto.setNumeroDoBanco(4);
		boleto.setMoeda(9);
		boleto.setSeuNumero(22222);
		boleto.setContaCorrente(21060);
		boleto.setConvenio(21060);
		boleto.setCarteira("00");
		boleto.setValor(110.00);
		boleto.setDataVencimento(geraData("30/05/2006"));
		
		System.out.println(geraLinhaDigitavel(boleto));
		System.out.println(geraCodigoDeBarras(boleto));
	}

} 
  // fim da main()