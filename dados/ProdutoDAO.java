package dados;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import com.mysql.jdbc.PreparedStatement; //trocar
import java.sql.PreparedStatement;

//import com.mysql.jdbc.Connection; //trocar
import java.sql.Connection;

import Model.Produto;
import Model.Usuario;

public class ProdutoDAO { //UsuarioDAO, LivroDAO, 
	//DAO -> Data Access Object
	//CRUD - salvar(), alterar(), excluir()...
	
	public void salvar(Produto p) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = "insert into "
				+ "Produto(tamanho, cor, malha, estampa, nome, id, preco, qtd, tipoUn, estoqueMin) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		//Conectar ao BD
		ConexaoMySQL conexao = new ConexaoMySQL();
		//Connection = static
		Connection con = conexao.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		// ? = 1 -> tamanho
		comando.setDouble(1, p.getTamanho());
		// ? = 2 -> cor
		comando.setString(2, p.getCor());
		// ? = 3 -> malha
		comando.setString(3, p.getMalha());
		// ? = 4 -> estampa
		comando.setString(4, p.getEstampa());
		// ? = 5 -> nome
		comando.setString(5, p.getNome());
		// ? = 6 -> id
		comando.setInt(6, p.getId());
		// ? = 7 -> preco
		comando.setFloat(7, p.getPreco());
		// ? = 8 -> qtd
		comando.setDouble(8, p.getQtd());
		// ? = 9 -> tipoUn
		comando.setString(9, p.getTipoUn());
		// ? = 10 -> estoqueMin
		comando.setDouble(10, p.getEstoqueMin());
		//executar o comando SQL
		comando.execute();
		//fechar a conexão!
		con.close();
	}
		public void alterar(Produto p, String nomeAntigo) throws ClassNotFoundException, SQLException { //p=novos valores do produto
			//Comando SQL -> insert...
			String sql = ("UPDATE Usuario SET tamanho = ?, cor = ?, malha = ?, estampa = ?," +
					" nome = ?, id = ?, preco = ?, qtd = ?, tipoUn = ?, estoqueMin = ?, WHERE nome like = ?;");
			ConexaoMySQL conexao = new ConexaoMySQL();
			//Connection = static
			Connection con = conexao.conectar();
			//definir dados que serão gravados na(s) tabela(s)
			PreparedStatement comando = con.prepareStatement(sql);
			// ? = 1 -> tamanho
			comando.setDouble(1, p.getTamanho());
			// ? = 2 -> cor
			comando.setString(2, p.getCor());
			// ? = 3 -> malha
			comando.setString(3, p.getMalha());
			// ? = 4 -> estampa
			comando.setString(4, p.getEstampa());
			// ? = 5 -> nome
			comando.setString(5, p.getNome());
			// ? = 6 -> id
			comando.setInt(6, p.getId());
			// ? = 7 -> preco
			comando.setFloat(7, p.getPreco());
			// ? = 8 -> qtd
			comando.setDouble(8, p.getQtd());
			// ? = 9 -> tipoUn
			comando.setString(9, p.getTipoUn());
			// ? = 10 -> estoqueMin
			comando.setDouble(10, p.getEstoqueMin());
			//executar o comando SQL
			comando.execute();
			//fechar a conexão!
			con.close();
	}
		public int idAutoIncrement() {
			// TODO Auto-generated method stub
			return 0;
		}
		public Produto read(int idProd) {
			// TODO Auto-generated method stub
			return null;
		}
	

}