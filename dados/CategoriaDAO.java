package dados;

import Model.Categoria;
import Model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoriaDAO {

	public void add(Categoria c) throws ClassNotFoundException, SQLException {
		String sql = ("INSERT INTO categoria (nome) " +
				"VALUES (?);");
		ConexaoMySQL conexao = new ConexaoMySQL();
		Connection con = conexao.conectar();
		PreparedStatement comando = con.prepareStatement(sql);

		comando.setString(1, c.getNome());
		comando.executeUpdate();
		//fechar a conexão!
		con.close();
	}
	public void up(Categoria c) throws ClassNotFoundException, SQLException {
		String sql = ("UPDATE categoria SET nome = ? WHERE id = ?;");
		ConexaoMySQL conexao = new ConexaoMySQL();
		Connection con = conexao.conectar();
		PreparedStatement comando = con.prepareStatement(sql);

		comando.setString(1, c.getNome());
		comando.setInt(2, c.getId());

		comando.executeUpdate();

		//fechar a conexão!
		con.close();

	}

	public List<Categoria> listAll() throws ClassNotFoundException, SQLException {
		String sql = ("SELECT * FROM categoria WHERE deleted_at is NULL;");
		ConexaoMySQL conexao = new ConexaoMySQL();
		Connection con = conexao.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		ResultSet rs = comando.executeQuery();
		List<Categoria> lista = new ArrayList<>();

			while (rs.next()){
				Categoria cat = new Categoria();
				cat.setId(rs.getInt("id"));
				cat.setNome(rs.getString("nome"));
				lista.add(cat);
			}
			con.close();
		return lista;
	}

	public List<Categoria> listAllById(String id) throws ClassNotFoundException, SQLException {
		String sql = ("SELECT * FROM categoria WHERE id = ? AND deleted_at is NULL;");
		ConexaoMySQL conexao = new ConexaoMySQL();
		Connection con = conexao.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		ResultSet rs = comando.executeQuery();
		Categoria cat = new Categoria();
		List<Categoria> lista = new ArrayList<>();

			comando.setString(1, id);
			rs = comando.executeQuery();

			while (rs.next()){
				Categoria cat1 = new Categoria();
				cat1.setId(rs.getInt("id"));
				cat1.setNome(rs.getString("nome"));
				lista.add(cat1);
			}
			con.close();
		return lista;
	}


	public List<Categoria> listAllByName(String nome) throws ClassNotFoundException, SQLException {
		String sql = ("SELECT * FROM categoria WHERE nome LIKE ? AND deleted_at is NULL;");
		ConexaoMySQL conexao = new ConexaoMySQL();
		Connection con = conexao.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		ResultSet rs = comando.executeQuery();
		Categoria cat = new Categoria();
		List<Categoria> lista = new ArrayList<>();
		comando.setString(1, "%" + nome + "%");
		rs = comando.executeQuery();

		while (rs.next()){
			Categoria cat1 = new Categoria();
			cat1.setId(rs.getInt("id"));
			cat1.setNome(rs.getString("nome"));
			lista.add(cat1);
		}
		con.close();

		return lista;
	}

	public void del(Categoria c) throws ClassNotFoundException, SQLException {   // ou pelo id, public void del(int id)
		String sql = ("UPDATE categoria SET deleted_at = ? WHERE id = ?;");
		ConexaoMySQL conexao = new ConexaoMySQL();
		Connection con = conexao.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		ResultSet rs = comando.executeQuery();
		Categoria cat = new Categoria();

		//Formatando a data
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Date date = new Date(System.currentTimeMillis());
		String data = dateFormat.format(date);

		comando.setString(1, data);
		comando.setInt(2, c.getId());

		comando.executeUpdate();

		con.close();
	}



public Categoria read(Categoria c) throws ClassNotFoundException, SQLException {
	String sql = ("SELECT id, nome FROM categoria WHERE id = ? and deleted_at is NULL;");
	ConexaoMySQL conexao = new ConexaoMySQL();
	Connection con = conexao.conectar();
	//definir dados que serão gravados na(s) tabela(s)
	PreparedStatement comando = con.prepareStatement(sql);
	ResultSet rs = comando.executeQuery();
	Categoria cat = new Categoria();
	comando.setInt(1, c.getId());
	if (rs.next()) {
		cat.setId(rs.getInt("id"));
		cat.setNome(rs.getString("nome"));
	}
	con.close();
	return cat;
}

public Categoria read(String nome) throws ClassNotFoundException, SQLException {
	String sql = ("SELECT id, nome FROM categoria WHERE nome = ? and deleted_at is NULL;");
	ConexaoMySQL conexao = new ConexaoMySQL();
	Connection con = conexao.conectar();
	//definir dados que serão gravados na(s) tabela(s)
	PreparedStatement comando = con.prepareStatement(sql);
	ResultSet rs = comando.executeQuery();
	Categoria cat = new Categoria();


	comando.setString(1, nome);

	if (rs.next()) {
		cat.setId(rs.getInt("id"));
		cat.setNome(rs.getString("nome"));
	}

	con.close();
	return cat;
}


public Categoria read(int id) throws ClassNotFoundException, SQLException {

	String sql = ("SELECT id, nome FROM categoria WHERE id = ? and deleted_at is NULL;");

	ConexaoMySQL conexao = new ConexaoMySQL();
	Connection con = conexao.conectar();
	//definir dados que serão gravados na(s) tabela(s)
	PreparedStatement comando = con.prepareStatement(sql);
	ResultSet rs = comando.executeQuery();
	Categoria cat = new Categoria();
	comando.setInt(1, id);
	if (rs.next()) {
		cat.setId(rs.getInt("id"));
		cat.setNome(rs.getString("nome"));
	}
	con.close();
	return cat;
}



public int idAutoIncrement() throws ClassNotFoundException, SQLException {
	int id = 0;

	String sql = ("SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'categoria' AND table_schema = 'controlx'");
	ConexaoMySQL conexao = new ConexaoMySQL();
	//Connection = static
	Connection con = conexao.conectar();
	//definir dados que serão gravados na(s) tabela(s)
	PreparedStatement comando = con.prepareStatement(sql);
	ResultSet rs = comando.executeQuery();

	if (rs.next()){
		id = rs.getInt("AUTO_INCREMENT");
	}
	con.close();
	return id;
}

}


