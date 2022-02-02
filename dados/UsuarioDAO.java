package dados;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
//import com.mysql.jdbc.PreparedStatement; //trocar
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import com.mysql.jdbc.Connection; //trocar
import java.sql.Connection;

import Model.Usuario;

public class UsuarioDAO { //UsuarioDAO, LivroDAO, 
	//DAO -> Data Access Object
	//CRUD - salvar(), alterar(), excluir()...

	public void salvar(Usuario u) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = ("INSERT INTO usuario (nome, cpf, sexo, dataNasc," +
				" telefone1, telefone2, cep, num, rua, comp, bairro, cidade, estado, login, senha) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
		//Criar o objeto para conexão com BD
		ConexaoMySQL conexao = new ConexaoMySQL(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
		//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
		//Formatando a data
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		// ? = 1 -> nome
		comando.setString(2, u.getNome());
		// ? = 2 -> CPF
		comando.setString(3, u.getCpf());
		// ? = 3 -> Sexo
		comando.setString(4, u.getSexo());
		// ? = 4 -> Data
		String data = dateFormat.format(u.getDataNasc());
		comando.setString(5, data);
		// ? = 5 -> Telefone1
		comando.setString(6, u.getTelefone1());
		// ? = 6 -> Telefone2
		comando.setString(7, u.getTelefone2());
		// ? = 7 -> CEP
		comando.setString(8, u.getCep());
		// ? = 8 -> Número
		comando.setInt(9, u.getNum());
		// ? = 9 -> Rua
		comando.setString(10, u.getRua());
		// ? = 10 -> Complemento
		comando.setString(11, u.getComp());
		// ? = 11 -> Bairro
		comando.setString(12, u.getBairro());
		// ? = 12 -> Cidade
		comando.setString(13, u.getCidade());
		// ? = 13 -> Estado
		comando.setString(14, u.getEstado());
		// ? = 14 -> Login
		comando.setString(15, u.getLogin());
		// ? = 15 -> Senha
		comando.setString(16, u.getSenha());

		//executar o comando SQL
		comando.execute();
		//fechar a conexão!
		con.close();

	}

	public void alterar(Usuario u, String nomeAntigo) throws ClassNotFoundException, SQLException { //p=novos valores do produto
		//Comando SQL -> insert...
		String sql = ("UPDATE Usuario SET nome = ?, cpf = ?, sexo = ?, dataNasc = ?," +
				" telefone1 = ?, telefone2 = ?, cep = ?, num = ?, rua = '?', comp = ?," +
				" bairro = ?, cidade = ?, estado = ?, login = ?, senha = ? WHERE id = ?;");
		//Criar o objeto para conexão com BD
		ConexaoMySQL conexao = new ConexaoMySQL(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
		//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
		// 1 -> ?
		Usuario user = new Usuario();
		comando.setString(2, u.getNome());
		comando.setString(3, u.getCpf());
		comando.setString(4, u.getSexo());
		comando.setDate(5, new java.sql.Date(u.getDataNasc().getTime()));
		comando.setString(6, u.getTelefone1());
		comando.setString(7, u.getTelefone2());
		comando.setString(8, u.getCep());
		comando.setInt(9, u.getNum());
		comando.setString(10, u.getRua());
		comando.setString(11, u.getComp());
		comando.setString(12, u.getBairro());
		comando.setString(13, u.getCidade());
		comando.setString(14, u.getEstado());
		comando.setString(15, u.getLogin());
		comando.setString(16, u.getSenha());
		comando.setInt(17, u.getId());
		//executar o comando SQL
		comando.setString(18, nomeAntigo);
		comando.execute(); //não tem retorno
		//fechar a conexão!
		con.close();		
	}

	
	
	
	
	

	//Criar método pra Read (listar)
	public List<Usuario> listartodos() throws SQLException, ClassNotFoundException{ //retornar os dados SELECT
		//Comando SQL -> insert...
		String sql = ("SELECT * FROM usuario WHERE deleted_at is NULL;");
		//+ "where nome like ?%"

		//Criar o objeto para conexão com BD
		ConexaoMySQL conexao = new ConexaoMySQL(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
		//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
		// 1 -> ? parâmetros where nome like ? or preco >= ...

		//
		List<Usuario> lista = new ArrayList<>();
		//ResultSet - conjunto de dados do SELECT
		ResultSet rs = comando.executeQuery(); 

		//.next() -> próximo resultado do ResultSet
		while(rs.next()) { //repetir para o número de linhas do BD
			Usuario u1 = new Usuario();
			u1.setId(rs.getInt("id"));
			u1.setNome(rs.getString("nome"));
			u1.setCpf(rs.getString("cpf"));
			u1.setSexo(rs.getString("sexo"));
			u1.setDataNasc(rs.getDate("dataNasc"));
			u1.setTelefone1(rs.getString("telefone1"));
			u1.setTelefone2(rs.getString("telefone2"));
			u1.setCep(rs.getString("cep"));
			u1.setNum(rs.getInt("num"));
			u1.setRua(rs.getString("rua"));
			u1.setComp(rs.getString("comp"));
			u1.setBairro(rs.getString("bairro"));
			u1.setCidade(rs.getString("cidade"));
			u1.setEstado(rs.getString("estado"));
			u1.setLogin(rs.getString("login"));
			u1.setSenha(rs.getString("senha"));

			lista.add(u1);
		} //repete enquanto o .next() == true

		con.close();
		return lista;
	}

	public List<Usuario> listarporid(String id) throws SQLException, ClassNotFoundException{ //retornar os dados SELECT
		//Comando SQL -> insert...
		String sql = ("SELECT * FROM usuario WHERE id LIKE ? AND deleted_at is NULL;");
		//+ "where nome like ?%"

		//Criar o objeto para conexão com BD
		ConexaoMySQL conexao = new ConexaoMySQL(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
		//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
		// 1 -> ? parâmetros where nome like ? or preco >= ...

		//
		List<Usuario> lista = new ArrayList<>();
		//ResultSet - conjunto de dados do SELECT
		ResultSet rs = comando.executeQuery(); 

		//.next() -> próximo resultado do ResultSet
		while(rs.next()) { //repetir para o número de linhas do BD
			Usuario u1 = new Usuario();
			u1.setId(rs.getInt("id"));
			u1.setNome(rs.getString("nome"));
			u1.setCpf(rs.getString("cpf"));
			u1.setSexo(rs.getString("sexo"));
			u1.setDataNasc(rs.getDate("dataNasc"));
			u1.setTelefone1(rs.getString("telefone1"));
			u1.setTelefone2(rs.getString("telefone2"));
			u1.setCep(rs.getString("cep"));
			u1.setNum(rs.getInt("num"));
			u1.setRua(rs.getString("rua"));
			u1.setComp(rs.getString("comp"));
			u1.setBairro(rs.getString("bairro"));
			u1.setCidade(rs.getString("cidade"));
			u1.setEstado(rs.getString("estado"));
			u1.setLogin(rs.getString("login"));
			u1.setSenha(rs.getString("senha"));

			lista.add(u1);
		} //repete enquanto o .next() == true

		con.close();
		return lista;
	}

	public List<Usuario> listarpornome(String nome) throws SQLException, ClassNotFoundException{ //retornar os dados SELECT
		//Criar o objeto para conexão com BD
		ConexaoMySQL conexao = new ConexaoMySQL(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
		//Criar um objeto que constroi o comando SQL
		String sql = ("SELECT * FROM usuario WHERE nome LIKE ? AND deleted_at is NULL;"); //+ "where nome like ?%"
		PreparedStatement comando = con.prepareStatement(sql);
		comando.setString(1, "%" + nome + "%");

		//
		List<Usuario> lista = new ArrayList<>();
		//ResultSet - conjunto de dados do SELECT
		ResultSet rs = comando.executeQuery(); 

		//.next() -> próximo resultado do ResultSet
		while(rs.next()) { //repetir para o número de linhas do BD
			Usuario u1 = new Usuario();
			u1.setId(rs.getInt("id"));
			u1.setNome(rs.getString("nome"));
			u1.setCpf(rs.getString("cpf"));
			u1.setSexo(rs.getString("sexo"));
			u1.setDataNasc(rs.getDate("dataNasc"));
			u1.setTelefone1(rs.getString("telefone1"));
			u1.setTelefone2(rs.getString("telefone2"));
			u1.setCep(rs.getString("cep"));
			u1.setNum(rs.getInt("num"));
			u1.setRua(rs.getString("rua"));
			u1.setComp(rs.getString("comp"));
			u1.setBairro(rs.getString("bairro"));
			u1.setCidade(rs.getString("cidade"));
			u1.setEstado(rs.getString("estado"));
			u1.setLogin(rs.getString("login"));
			u1.setSenha(rs.getString("senha"));

			lista.add(u1);
		} //repete enquanto o .next() == true

		con.close();
		return lista;
	}

	public int idAutoIncrement() {
		// TODO Auto-generated method stub
		return 0;
	}
}