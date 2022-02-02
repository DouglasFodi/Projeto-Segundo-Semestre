package dados;

import Model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FornecedorDAO {

	public void add(Fornecedor f) throws ClassNotFoundException, SQLException {
		String sql = ("INSERT INTO fornecedor(nome, cnpj, tel1, tel2, cep, num, rua, comp, bairro, cidade, estado)" +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
		ConexaoMySQL conexao = new ConexaoMySQL();
		Connection con = conexao.conectar();
		PreparedStatement comando = con.prepareStatement(sql);
		comando.setString(1, f.getNome());
		comando.setString(2, f.getCnpj());
		comando.setString(3, f.getTelefone1());
		comando.setString(4, f.getTelefone2());
		comando.setString(5, f.getCep());
		comando.setInt(6, f.getNum());
		comando.setString(7, f.getRua());
		comando.setString(8, f.getComp());
		comando.setString(9, f.getBairro());
		comando.setString(10, f.getCidade());
		comando.setString(11, f.getEstado());
		comando.executeUpdate();

		con.close();
	}

	public void up(Fornecedor f) throws ClassNotFoundException, SQLException  {
		String sql = ("UPDATE fornecedor SET nome = ?, cnpj = ?, tel1 = ?, tel2 = ?, " +
				"cep = ?, num = ?, rua = ?, comp = ?, bairro = ?, cidade = ?, estado = ? WHERE id = ?;");
		ConexaoMySQL conexao = new ConexaoMySQL();
		Connection con = conexao.conectar();
		PreparedStatement comando = con.prepareStatement(sql);


		comando.setString(1, f.getNome());
		comando.setString(2, f.getCnpj());
		comando.setString(3, f.getTelefone1());
		comando.setString(4, f.getTelefone2());
		comando.setString(5, f.getCep());
		comando.setInt(6, f.getNum());
		comando.setString(7, f.getRua());
		comando.setString(8, f.getComp());
		comando.setString(9, f.getBairro());
		comando.setString(10, f.getCidade());
		comando.setString(11, f.getEstado());
		comando.setInt(12, f.getId());

		comando.executeUpdate();

		con.close();
	}


public List<Fornecedor> listAll() throws ClassNotFoundException, SQLException {
	String sql = ("SELECT * FROM fornecedor WHERE deleted_at is NULL;");
	ConexaoMySQL conexao = new ConexaoMySQL();
	Connection con = conexao.conectar();
	PreparedStatement comando = con.prepareStatement(sql);
	ResultSet rs = comando.executeQuery(); 
	List<Fornecedor> lista = new ArrayList<>();


	while (rs.next()){
		Fornecedor forn = new Fornecedor();
		forn.setId(rs.getInt("id"));
		forn.setNum(rs.getInt("num"));
		forn.setNome(rs.getString("nome"));
		forn.setRua(rs.getString("rua"));
		forn.setBairro(rs.getString("bairro"));
		forn.setCep(rs.getString("cep"));
		forn.setCidade(rs.getString("cidade"));
		forn.setCnpj(rs.getString("cnpj"));
		forn.setEstado(rs.getString("estado"));
		forn.setTelefone1(rs.getString("tel1"));
		forn.setTelefone2(rs.getString("tel2"));
		lista.add(forn);
	}

	con.close();
	return lista;
}

public List<Fornecedor> listAllById(String id) throws ClassNotFoundException, SQLException {
	String sql = ("SELECT * FROM fornecedor WHERE id LIKE ? AND deleted_at is NULL;");
	ConexaoMySQL conexao = new ConexaoMySQL();
	Connection con = conexao.conectar();
	PreparedStatement comando = con.prepareStatement(sql);
	ResultSet rs = comando.executeQuery(); 
	List<Fornecedor> lista = new ArrayList<>();

	comando.setString(1, "%" + id + "%");


	while (rs.next()){
		Fornecedor forn = new Fornecedor();
		forn.setId(rs.getInt("id"));
		forn.setNum(rs.getInt("num"));
		forn.setNome(rs.getString("nome"));
		forn.setRua(rs.getString("rua"));
		forn.setBairro(rs.getString("bairro"));
		forn.setCep(rs.getString("cep"));
		forn.setCidade(rs.getString("cidade"));
		forn.setCnpj(rs.getString("cnpj"));
		forn.setEstado(rs.getString("estado"));
		forn.setTelefone1(rs.getString("tel1"));
		forn.setTelefone2(rs.getString("tel2"));
		lista.add(forn);
	}
	con.close();
	return lista;
}

public List<Fornecedor> listAllByName(String nome) throws ClassNotFoundException, SQLException {
	String sql = ("SELECT * FROM fornecedor WHERE nome LIKE ? AND deleted_at is NULL;");
	ConexaoMySQL conexao = new ConexaoMySQL();
	Connection con = conexao.conectar();
	PreparedStatement comando = con.prepareStatement(sql);
	ResultSet rs = comando.executeQuery(); 
	List<Fornecedor> lista = new ArrayList<>();

		comando.setString(1, "%" + nome + "%");

		while (rs.next()){
			Fornecedor forn = new Fornecedor();
			forn.setId(rs.getInt("id"));
			forn.setNum(rs.getInt("num"));
			forn.setNome(rs.getString("nome"));
			forn.setRua(rs.getString("rua"));
			forn.setBairro(rs.getString("bairro"));
			forn.setCep(rs.getString("cep"));
			forn.setCidade(rs.getString("cidade"));
			forn.setCnpj(rs.getString("cnpj"));
			forn.setEstado(rs.getString("estado"));
			forn.setTelefone1(rs.getString("tel1"));
			forn.setTelefone2(rs.getString("tel2"));
			lista.add(forn);
		}
		con.close();
	return lista;
}

public void del(Fornecedor f) throws ClassNotFoundException, SQLException {   // ou pelo id, public void del(int id)
	String sql = ("UPDATE fornecedor SET deleted_at = ? WHERE id = ?;");
	ConexaoMySQL conexao = new ConexaoMySQL();
	Connection con = conexao.conectar();
	PreparedStatement comando = con.prepareStatement(sql);

	//Formatando a data
	DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
	Date date = new Date(System.currentTimeMillis());
	String data = dateFormat.format(date);

		comando.setString(1, data);
		comando.setInt(2, f.getId());

		comando.executeUpdate();

		con.close();
	}


public Fornecedor read(int id) throws ClassNotFoundException, SQLException {
	String sql = ("SELECT id, nome, cnpj, tel1, tel2, cep, " +
			"num, rua, comp, bairro, cidade, estado" +
			" FROM fornecedor WHERE id = ? and deleted_at is NULL;");
	ConexaoMySQL conexao = new ConexaoMySQL();
	Connection con = conexao.conectar();
	PreparedStatement comando = con.prepareStatement(sql);
	ResultSet rs = comando.executeQuery(); 
	Fornecedor forn = new Fornecedor();

		comando.setInt(1, id);


		if(rs.next()) {
			forn.setId(rs.getInt("id"));
			forn.setNome(rs.getString("nome"));
			forn.setCnpj(rs.getString("cnpj"));
			forn.setTelefone1(rs.getString("tel1"));
			forn.setTelefone2(rs.getString("tel2"));
			forn.setCep(rs.getString("cep"));
			forn.setNum(rs.getInt("num"));
			forn.setRua(rs.getString("rua"));
			forn.setComp(rs.getString("comp"));
			forn.setBairro(rs.getString("bairro"));
			forn.setCidade(rs.getString("cidade"));
			forn.setEstado(rs.getString("estado"));
		}
		con.close();
		return forn;
	}


public int idAutoIncrement() throws ClassNotFoundException, SQLException {
	int id = 0;
	String sql = ("SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'fornecedor' AND table_schema = 'controlx'");
	ConexaoMySQL conexao = new ConexaoMySQL();
	Connection con = conexao.conectar();
	PreparedStatement comando = con.prepareStatement(sql);
	ResultSet rs = comando.executeQuery(); 

		if (rs.next()){
			id = rs.getInt("AUTO_INCREMENT");
		}
		con.close();
		return id;
	}

}
