package acesso;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Produto;
import dados.ConexaoMySQL;
import dados.ProdutoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;


//Pacote: Acesso (tela) interface com o usuário
public class TelaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txNome;
	private JTextField txPreco;
	private JTextField txArquivo;
	private JTextField textField;
	private JTextField txNomeAntigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProduto frame = new TelaProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(24, 67, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o");
		lblNewLabel_1.setBounds(24, 129, 46, 14);
		contentPane.add(lblNewLabel_1);
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				ConexaoMySQL con = new ConexaoMySQL();
				try {
					con.conectar();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); // console = erro
				}
				//Apertar botão Salvar -> salva no BD
				Produto p = new Produto();
				p.setNome(txNome.getText());
				p.setPreco(Float.parseFloat(txPreco.getText()));
				//Criar um objeto da classe DAO
				ProdutoDAO pDAO = new ProdutoDAO();
				try {
					pDAO.alterar(p, txNomeAntigo.getText());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private ProdutoDAO ProdutoDAO() {
				// TODO Auto-generated method stub
				return null;
			} 
		});
		btSalvar.setBounds(236, 216, 89, 23);
		contentPane.add(btSalvar);
		
		txNome = new JTextField();
		txNome.setBounds(81, 64, 277, 20);
		contentPane.add(txNome);
		txNome.setColumns(10);
		
		txPreco = new JTextField();
		txPreco.setBounds(85, 126, 141, 20);
		contentPane.add(txPreco);
		txPreco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastro de Produtos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(147, 0, 155, 43);
		contentPane.add(lblNewLabel_2);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false); //oculta
			}
		});
		btSair.setBounds(335, 216, 89, 23);
		contentPane.add(btSair);
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btLimpar.setBounds(137, 216, 89, 23);
		contentPane.add(btLimpar);
		JLabel lbImagem = new JLabel("lbimagem");
		lbImagem.setBounds(461, 27, 178, 154);
		contentPane.add(lbImagem);
		
		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Abrir arquivo
				JFileChooser abrirArquivo = new JFileChooser();
				abrirArquivo.showOpenDialog(getParent());
				//Mostrar o caminho do arquivo
				txArquivo.setText(abrirArquivo.getSelectedFile().toString());
				//.setIcon -> colocar a imagem dentro do JLabel
				//.setIcon(new ImageIcon("c:\\user\\usuario\arquivo.jpg")
				lbImagem.setIcon(new ImageIcon(txArquivo.getText()));
			}
		});
		btnNewButton.setBounds(335, 170, 89, 23);
		contentPane.add(btnNewButton);
		
		txArquivo = new JTextField();
		txArquivo.setBounds(80, 185, 222, 20);
		contentPane.add(txArquivo);
		txArquivo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Arquivo");
		lblNewLabel_3.setBounds(80, 167, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 95, 141, 20);
		contentPane.add(textField);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setBounds(24, 97, 46, 14);
		contentPane.add(lblTamanho);
		
		txNomeAntigo = new JTextField();
		txNomeAntigo.setBounds(81, 33, 202, 20);
		contentPane.add(txNomeAntigo);
		txNomeAntigo.setColumns(10);
		
		
	}
}