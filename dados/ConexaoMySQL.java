package dados;

import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.jdbc.Connection; se necess�rio, alterar:
import java.sql.Connection;

public class ConexaoMySQL {
	//1� passo: definir os atributos de acesso ao MySQL
	private String database = "Projeto"; // use vendas;
	private String usuario = "root"; // usu�rio de acesso
	private String senha = "Alice041988*";
	//url=endere�o do servidor MySQL
	private String url = "jdbc:mysql://localhost:3306/"+database;
	
	//2� passo: m�todos
	public Connection conectar() throws ClassNotFoundException, SQLException { //cada conex�o = id (Connection)
		//Carrega a API para aplica��o:
		Class.forName("com.mysql.jdbc.Driver");
		//Fazer a conex�o:
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		return conexao;
	}
}