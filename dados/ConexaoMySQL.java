package dados;

import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.jdbc.Connection; se necessário, alterar:
import java.sql.Connection;

public class ConexaoMySQL {
	//1º passo: definir os atributos de acesso ao MySQL
	private String database = "Projeto"; // use vendas;
	private String usuario = "root"; // usuário de acesso
	private String senha = "Alice041988*";
	//url=endereço do servidor MySQL
	private String url = "jdbc:mysql://localhost:3306/"+database;
	
	//2º passo: métodos
	public Connection conectar() throws ClassNotFoundException, SQLException { //cada conexão = id (Connection)
		//Carrega a API para aplicação:
		Class.forName("com.mysql.jdbc.Driver");
		//Fazer a conexão:
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		return conexao;
	}
}