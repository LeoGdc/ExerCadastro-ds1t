package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import br.senai.sp.jandira.model.Periodo;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNome;

	public FrameCadastroAlunos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(10, 37, 47, 14);
		contentPane.add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(60, 34, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(60, 83, 128, 20);
		contentPane.add(txtNome);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 86, 47, 14);
		contentPane.add(lblNome);

		JLabel lblPeriodo = new JLabel("Periodo:");
		lblPeriodo.setBounds(10, 126, 47, 14);
		contentPane.add(lblPeriodo);

		JComboBox comboPeriodo = new JComboBox();
		comboPeriodo.setModel(new DefaultComboBoxModel(Periodo.values()));
		comboPeriodo.setBounds(57, 122, 89, 22);
		contentPane.add(comboPeriodo);

		JButton btnSalvar = new JButton("Salvar Aluno");
		btnSalvar.setBounds(57, 163, 131, 48);
		contentPane.add(btnSalvar);

		JLabel lblLista = new JLabel("Lista de Aluno:");
		lblLista.setBounds(259, 37, 86, 14);
		contentPane.add(lblLista);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(258, 62, 166, 188);
		contentPane.add(scrollPane);

		JList listAlunos = new JList();
		scrollPane.setViewportView(listAlunos);
	}
}
