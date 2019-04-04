package br.edu.unicid.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.NumericShaper;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

import br.edu.unicid.bean.Aluno;
import br.edu.unicid.dao.AlunoDAO;
import br.edu.unicid.util.ConnectionFactory;
import br.edu.unicid.util.DateHandler;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JLabel lblRgmDoAluno;
	private JLabel lblNomeDoAluno;
	private JLabel lblEmailDoAluno;
	private JLabel lblDataDeNascimento;
	private JLabel lblEndereco;
	private JLabel lblIdadeDoAluno;
	private JTextField txtRgm;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtNascimento;
	private JTextField txtEndereco;
	private JTextField txtIdade;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnConsultar;
	private JButton btnAlterar;
	private JButton btnApagar;
	private JButton btnListarTodos;
	private JTable table;
	private JPanel panel;
	private JScrollPane sp;
	private DefaultTableModel dt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e2) {
			e2.printStackTrace();
		}
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 520);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.lblRgmDoAluno = new JLabel("RGM do aluno");
		this.lblRgmDoAluno.setBounds(new Rectangle(0, 0, 200, 0));
		this.lblRgmDoAluno.setMinimumSize(new Dimension(200, 0));
		this.lblRgmDoAluno.setPreferredSize(new Dimension(200, 0));
		this.lblRgmDoAluno.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.lblRgmDoAluno.setBounds(37, 16, 142, 27);
		this.contentPane.add(this.lblRgmDoAluno);
		
		this.lblNomeDoAluno = new JLabel("Nome do aluno");
		this.lblNomeDoAluno.setBounds(new Rectangle(0, 0, 200, 0));
		this.lblNomeDoAluno.setMinimumSize(new Dimension(200, 0));
		this.lblNomeDoAluno.setPreferredSize(new Dimension(200, 0));
		this.lblNomeDoAluno.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.lblNomeDoAluno.setBounds(37, 54, 142, 38);
		this.contentPane.add(this.lblNomeDoAluno);
		
		this.lblEmailDoAluno = new JLabel("Email do aluno");
		this.lblEmailDoAluno.setBounds(new Rectangle(0, 0, 200, 0));
		this.lblEmailDoAluno.setMinimumSize(new Dimension(200, 0));
		this.lblEmailDoAluno.setPreferredSize(new Dimension(200, 0));
		this.lblEmailDoAluno.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.lblEmailDoAluno.setBounds(37, 103, 142, 38);
		this.contentPane.add(this.lblEmailDoAluno);
		
		this.lblDataDeNascimento = new JLabel("Data de nascimento");
		this.lblDataDeNascimento.setBounds(new Rectangle(0, 0, 200, 0));
		this.lblDataDeNascimento.setMinimumSize(new Dimension(200, 0));
		this.lblDataDeNascimento.setPreferredSize(new Dimension(200, 0));
		this.lblDataDeNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.lblDataDeNascimento.setBounds(37, 152, 162, 38);
		this.contentPane.add(this.lblDataDeNascimento);
		
		this.lblEndereco = new JLabel("Endereco");
		this.lblEndereco.setBounds(new Rectangle(0, 0, 200, 0));
		this.lblEndereco.setMinimumSize(new Dimension(200, 0));
		this.lblEndereco.setPreferredSize(new Dimension(200, 0));
		this.lblEndereco.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.lblEndereco.setBounds(37, 201, 142, 38);
		this.contentPane.add(this.lblEndereco);
		
		this.lblIdadeDoAluno = new JLabel("Idade do aluno");
		this.lblIdadeDoAluno.setBounds(new Rectangle(0, 0, 200, 0));
		this.lblIdadeDoAluno.setMinimumSize(new Dimension(200, 0));
		this.lblIdadeDoAluno.setPreferredSize(new Dimension(200, 0));
		this.lblIdadeDoAluno.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.lblIdadeDoAluno.setBounds(37, 250, 142, 38);
		this.contentPane.add(this.lblIdadeDoAluno);
		
		this.txtRgm = new JTextField();
		this.txtRgm.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.txtRgm.setBounds(225, 11, 423, 27);
		this.contentPane.add(this.txtRgm);
		this.txtRgm.setColumns(10);
		
		this.txtNome = new JTextField();
		this.txtNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.txtNome.setColumns(10);
		this.txtNome.setBounds(225, 60, 423, 27);
		this.contentPane.add(this.txtNome);
		
		this.txtEmail = new JTextField();
		this.txtEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.txtEmail.setColumns(10);
		this.txtEmail.setBounds(225, 109, 423, 27);
		this.contentPane.add(this.txtEmail);
		
		this.txtNascimento = new JTextField();
		this.txtNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.txtNascimento.setColumns(10);
		this.txtNascimento.setBounds(225, 158, 423, 27);
		this.contentPane.add(this.txtNascimento);
		
		this.txtEndereco = new JTextField();
		this.txtEndereco.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.txtEndereco.setColumns(10);
		this.txtEndereco.setBounds(225, 207, 423, 27);
		this.contentPane.add(this.txtEndereco);
		
		this.txtIdade = new JTextField();
		this.txtIdade.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		this.txtIdade.setColumns(10);
		this.txtIdade.setBounds(225, 256, 423, 27);
		this.contentPane.add(this.txtIdade);
		
		this.btnNovo = new JButton("Novo");
		this.btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dt.setRowCount(0);
				txtRgm.setText("");
				txtNome.setText("");
				txtEmail.setText("");
				txtNascimento.setText("");
				txtIdade.setText("");
				txtEndereco.setText("");
			}
		});
		this.btnNovo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		this.btnNovo.setBounds(37, 310, 89, 23);
		this.contentPane.add(this.btnNovo);
		
		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		this.btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno al = new Aluno(Integer.parseInt(txtRgm.getText()),
							txtNome.getText(),
							txtEmail.getText(),
							DateHandler.stringToDate(txtNascimento.getText()),
							Integer.parseInt(txtIdade.getText()),
							txtEndereco.getText()
						);
					AlunoDAO alDao = new AlunoDAO(ConnectionFactory
							.getConnection());
					alDao.salvar(al);
				} catch (NumberFormatException | ParseException |
						SQLException e1) {
					JOptionPane.showMessageDialog(null, 
							("Erro ao salvar: " + e1.getLocalizedMessage()), 
							"Erro", 
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		this.btnSalvar.setBounds(136, 310, 89, 23);
		this.contentPane.add(this.btnSalvar);
		
		this.btnConsultar = new JButton("Consultar");
		this.btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dt.setRowCount(0);
				try {
					AlunoDAO alDao = new AlunoDAO(
							ConnectionFactory.getConnection());
					Aluno achado = alDao.procurar(Integer.parseInt(
							txtRgm.getText()));
					
					mostrarDados(achado);
					
				} catch (SQLException | NumberFormatException 
						| NullPointerException e) {
					JOptionPane.showMessageDialog(null, 
							"Erro ao consultar, cheque o RGM: " 
									+ e.getLocalizedMessage(),
							"Erro",
							JOptionPane.ERROR_MESSAGE
							);
					e.printStackTrace();
				}
			}
		});
		this.btnConsultar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		this.btnConsultar.setBounds(229, 310, 101, 23);
		this.contentPane.add(this.btnConsultar);
		
		this.btnAlterar = new JButton("Alterar");
		this.btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AlunoDAO alDao = new AlunoDAO(
							ConnectionFactory.getConnection());
					Aluno al = new Aluno(
								Integer.parseInt(txtRgm.getText()),
								txtNome.getText(),
								txtEmail.getText(),
								DateHandler.stringToDate(
										txtNascimento.getText()),
								Integer.parseInt(txtIdade.getText()),
								txtEndereco.getText()
							);
					alDao.modificar(al);
				} catch (NumberFormatException | ParseException |
						SQLException e1) {
					JOptionPane.showMessageDialog(null, 
							"Erro ao alterar entidade: " 
									+ e1.getLocalizedMessage(),
							"Erro",
							JOptionPane.ERROR_MESSAGE
							);
					e1.printStackTrace();
				}
			}
		});
		this.btnAlterar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		this.btnAlterar.setBounds(335, 310, 89, 23);
		this.contentPane.add(this.btnAlterar);
		
		this.btnApagar = new JButton("Apagar");
		this.btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AlunoDAO alDao = new AlunoDAO(
							ConnectionFactory.getConnection());
					alDao.apagar(new Aluno(Integer.parseInt(
							txtRgm.getText())));
				} catch (SQLException | NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, 
						"Erro ao apagar valor: " 
								+ e1.getLocalizedMessage(),
						"Erro",
						JOptionPane.ERROR_MESSAGE
					);
					e1.printStackTrace();
				}
			}
		});
		this.btnApagar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		this.btnApagar.setBounds(434, 310, 89, 23);
		this.contentPane.add(this.btnApagar);
		
		this.btnListarTodos = new JButton("Listar todos");
		this.btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dt.setRowCount(0);
				try {
					AlunoDAO alDao = new AlunoDAO(
							ConnectionFactory.getConnection());
					List<Aluno> lista = alDao.buscaTodosAlunos();
					
					
					for (Aluno al : lista) {
						dt.addRow(
								new Object[] {
										al.getRgm(),
										al.getNome(),
										al.getEmail(),
										al.getNascimento(),
										al.getIdade(),
										al.getEndereco()
								}
						);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		this.panel = new JPanel();
		this.panel.setBounds(37, 351, 611, 119);
		
		this.table = new JTable();
		this.table.setModel(new DefaultTableModel(new Object[][] {}, 
				new String[] {
					"RGM",
					"Nome",
					"Email",
					"Nascimento",
					"Idade",
					"Endereco"
		}));
		
		this.table.getTableHeader().setReorderingAllowed(true);
		this.dt = (DefaultTableModel) table.getModel();
//		this.dt.setRowCount(0);
//		this.dt.setColumnIdentifiers(new Object[] {
//				"RGM",
//				"Nome",
//				"Email",
//				"Nascimento",
//				"Idade",
//				"Endereco"
//		});
		
		this.sp = new JScrollPane();
		sp.setViewportView(table);
		
//		dt.addColumn("Rgm");
//		dt.addColumn("Nome");
//		dt.addColumn("Email");
//		dt.addColumn("Nascimento");
//		dt.addColumn("Idade");
//		dt.addColumn("Endereco");
		
		this.panel.setLayout(new BorderLayout());
		this.panel.add(sp, BorderLayout.CENTER);
		contentPane.add(this.panel);
		
		this.table.setBounds(37, 351, 611, 119);
		this.table.setPreferredScrollableViewportSize(new Dimension(350, 50));
		this.table.setFillsViewportHeight(true);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
//		contentPane.add(table);
		
//		dt.addRow(new String[] {
//				"Rgm",
//				"Nome",
//				"Email",
//				"Nascimento",
//				"Idade",
//				"Endereco"
//		});
		this.btnListarTodos.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		this.btnListarTodos.setBounds(533, 310, 115, 23);
		this.contentPane.add(this.btnListarTodos);
		
	}
	
	private void mostrarDados(Aluno aluno) {
		dt.addRow(
				new Object[] {
						aluno.getRgm(),
						aluno.getNome(),
						aluno.getEmail(),
						aluno.getNascimento(),
						aluno.getIdade(),
						aluno.getEndereco()
				}
			);
	}
}
