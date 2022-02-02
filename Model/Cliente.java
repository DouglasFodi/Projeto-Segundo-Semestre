package Model;
import java.util.Date;
import java.text.DateFormat;
import java.util.InputMismatchException;

public class Cliente {

  //public Cliente(String nome, double CPF, String login, String senha, Date data) {
        //setNome(nome);
    
    //Atributos: nome, cpf, rg, login, senha
  private String nome;
  //Date dataNascimento; // Camel Case = padrão de desenvolvimento
  private double cpf; // objetos/atributos -> minúscula
  private String login;
  private int senha;
  private Date data;
  private int tell;
  private int cep;
  private String rua;
  private String bairro;
  private String cidade; 
  private String estado;        

    public Cliente(String nome, double cpf, String login, int senha, Date data, int tell, int cep, String rua, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.cpf = 0;
        this.login = login;
        this.senha = 0;
        this.data = data;
        this.tell = 0;
        this.cep = 0;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    public void  novoUsuario(){ //em desenvolvimento
        //senha maior que 4 digitos
        if (this.getSenha() > 3 ){
            System.out.println("senha salva com sucesso!");
            
        } else {
            System.out.println("tente novamente");
        }
        
        
    
    }

    public String getNome() {
        return nome;
    }
    //Verificar métodos getCpf (guarda e não valida) -> getisCpf(valida e não guarda)

    public String getLogin() {
        return login;
    }

    public int getSenha() {
        return senha;
    }

    public Date getData() {
        return data;
    }
   //Métodos set:
    public void setNome(String nome) {
         //validação
          this.nome = nome;
    }

    public void setCpf(double cpf) {
        this.cpf = cpf;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void setData(Date data) {
        this.data = data;
    }
     public int getTell() {
        return tell;
    }

    public int getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setCPF(double cpf) {
        this.cpf = cpf;
    }

    public void setTell(int tell) {
        this.tell = tell;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    
      //para verificar se e verdadeiro os estados 
    public boolean setEstado(String estado) {
        if (estado.equals("AC")||
           estado.equals("AL")||estado.equals("AP")||     
           estado.equals("AM")||estado.equals("BA")||
           estado.equals("CE")||estado.equals("ES")||
           estado.equals("GO")||estado.equals("MA")||
           estado.equals("MT")||estado.equals("MS")||
           estado.equals("MG")||estado.equals("PA")||
           estado.equals("PB")||estado.equals("PR")||
           estado.equals("PE")||estado.equals("PI")||
           estado.equals("RJ")||estado.equals("RN")||
           estado.equals("RS")||estado.equals("RO")||
           estado.equals("RR")||estado.equals("SC")||
           estado.equals("SP")||estado.equals("SE")||
           estado.equals("TO")||estado.equals("DF"))
            return (true);
        
        //falta um test para falso
      return false;
                
                
    }
    
    
    
   
    public static boolean isCPF(String cpf) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ||
            (cpf.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }

        public static String imprimeCPF(String cpf) {
            return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
            cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
        }

       
    
}

