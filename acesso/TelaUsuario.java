package acesso;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Usuario;
import dados.ConexaoMySQL;
import dados.UsuarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txId;
	private JTextField txNome;
	private JTextField txCPF;
	private JTextField txSexo;
	private JTextField txDataNascimento;
	private JTextField txTelefone1;
	private JTextField txTelefone2;
	private JTextField txCEP;
	private JTextField txNumero;
	private JTextField txRua;
	private JTextField txComplemento;
	private JTextField txBairro;
	private JTextField txCidade;
	private JTextField txEstado;
	private JTextField txLogin;
	private JTextField txSenha;
	private JTextField txNomeAntigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
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
	public TelaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblId = new JLabel("Id");
		
		txId = new JTextField();
		txId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		
		txNome = new JTextField();
		txNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF");
		
		txCPF = new JTextField();
		txCPF.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		
		txSexo = new JTextField();
		txSexo.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		
		txDataNascimento = new JTextField();
		txDataNascimento.setColumns(10);
		
		JLabel lblTelefone1 = new JLabel("Telefone 1");
		
		txTelefone1 = new JTextField();
		txTelefone1.setColumns(10);
		
		JLabel lblTelefone2 = new JLabel("Telefone 2");
		
		txTelefone2 = new JTextField();
		txTelefone2.setColumns(10);
		
		JLabel lblCEP = new JLabel("CEP");
		
		txCEP = new JTextField();
		txCEP.setColumns(10);
		
		JLabel lblNúmero = new JLabel("N\u00FAmero");
		
		txNumero = new JTextField();
		txNumero.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		
		txRua = new JTextField();
		txRua.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		
		txComplemento = new JTextField();
		txComplemento.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		
		txBairro = new JTextField();
		txBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		
		txCidade = new JTextField();
		txCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		
		txEstado = new JTextField();
		txEstado.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		
		txLogin = new JTextField();
		txLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		
		txSenha = new JTextField();
		txSenha.setColumns(10);
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
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
				Usuario u = new Usuario();
				u.setId(Integer.parseInt(txId.getText()));
				u.setNome(txNome.getText());
				u.setCpf(txCPF.getText());
				u.setSexo(txSexo.getText());
				DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
				try {
					u.setDataNasc(dateFormat.parse(txDataNascimento.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				u.setTelefone1(txTelefone1.getText());
				u.setTelefone2(txTelefone2.getText());
				u.setCep(txCEP.getText());
				u.setNum(Integer.parseInt(txNumero.getText()));
				u.setRua(txRua.getText());
				u.setComp(txComplemento.getText());
				u.setBairro(txBairro.getText());
				u.setCidade(txCidade.getText());
				u.setEstado(txEstado.getText());
				u.setLogin(txLogin.getText());
				u.setSenha(txSenha.getText());
				//Criar um objeto da classe DAO
				UsuarioDAO uDAO = new UsuarioDAO();
				try {
					uDAO.alterar(u, txNomeAntigo.getText());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			private UsuarioDAO UsuarioDAO() {
				// TODO Auto-generated method stub
				return null;
			} 
		});
		btSalvar.setBounds(236, 216, 89, 23);
		contentPane.add(btSalvar);
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false); //oculta
			}
		});
		
		JLabel lblCadastro_de_Usuário = new JLabel("Cadastro de Usu\u00E1rio");
		lblCadastro_de_Usuário.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_de_Usuário.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txNomeAntigo = new JTextField();
		txNomeAntigo.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblCidade)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txCidade, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lblCEP)
													.addComponent(lblCPF)
													.addComponent(lblSexo))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(txCEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(txCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
														.addComponent(txSexo, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
														.addComponent(lblTelefone2)))
												.addPreferredGap(ComponentPlacement.RELATED))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblNome)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
													.addComponent(txNome, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
													.addComponent(txNomeAntigo, Alignment.TRAILING))
												.addGap(19)
												.addComponent(lblTelefone1)))
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblBairro)
												.addComponent(lblRua))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(txRua, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
												.addComponent(txBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(19)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(36)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblEstado)
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(txEstado, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblNúmero)
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(txNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(txTelefone1, Alignment.LEADING)
													.addComponent(txTelefone2, Alignment.LEADING))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(39)
											.addComponent(lblDataNascimento)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblId)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(164))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(146)
							.addComponent(btSalvar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btLimpar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btSair))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSenha)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblComplemento)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(txSenha, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))))
							.addGap(184)))
					.addGap(219))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(149)
					.addComponent(lblCadastro_de_Usuário, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(619))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogin)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txLogin, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(760, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_de_Usuário, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataNascimento)
						.addComponent(txDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefone1)
								.addComponent(txTelefone1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txNomeAntigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txTelefone2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTelefone2))
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSexo))
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCPF))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(txEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txCEP, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCEP))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNúmero)
						.addComponent(txNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCidade))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRua))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblBairro)
										.addComponent(txBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblComplemento)
										.addComponent(txComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(lblLogin))
								.addComponent(txLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(42))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSenha)
								.addComponent(txSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btSalvar)
								.addComponent(btLimpar)
								.addComponent(btSair))
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
