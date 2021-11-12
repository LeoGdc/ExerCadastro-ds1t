package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNome;
	private JLabel lblNome;
	private JLabel lblPeriodo;

	private int posicao;

	public FrameCadastroAlunos() {
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(10, 41, 65, 14);
		contentPane.add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(85, 38, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(85, 66, 86, 20);
		contentPane.add(txtNome);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 66, 46, 14);
		contentPane.add(lblNome);

		lblPeriodo = new JLabel("Per\u00EDodo: ");
		lblPeriodo.setBounds(10, 100, 46, 14);
		contentPane.add(lblPeriodo);

		JComboBox comboPeriodo = new JComboBox();
		DefaultComboBoxModel<String> comboModelPeriodo = new DefaultComboBoxModel<String>();
		// Carregar o comboModel com as descrições dos Períodos

		for (Periodo descricao : Periodo.values()) {
			comboModelPeriodo.addElement(descricao.getDescricao());

		}
		;

		comboPeriodo.setModel(comboModelPeriodo);
		comboPeriodo.setBounds(85, 96, 74, 22);
		contentPane.add(comboPeriodo);

		JButton btnSalvar = new JButton("Salvar Aluno");
		btnSalvar.setBounds(59, 151, 128, 45);
		contentPane.add(btnSalvar);

		JLabel lblLista = new JLabel("Lista de alunos: ");
		lblLista.setBounds(266, 41, 107, 14);
		contentPane.add(lblLista);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(262, 66, 149, 184);
		contentPane.add(scrollPane);

		JList listAlunos = new JList();
		scrollPane.setViewportView(listAlunos);

		// Criar o model que vai exibir os alunos na JList

		DefaultListModel<String> modelAlunos = new DefaultListModel<String>();

		// Definir o modelAlunos como sendo o model do nosso JList
		listAlunos.setModel(modelAlunos);

		// Criar uma turma que é um repositório de alunos
		AlunoRepository turma = new AlunoRepository(3);

		// Criar botão
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Aluno aluno = new Aluno();

				aluno.setNome(txtNome.getText());
				aluno.setMatricula(txtMatricula.getText());

				System.out.println(comboPeriodo.getSelectedIndex());
				System.out.println(comboPeriodo.getSelectedItem());

				// definir o horario que o aluno estuda
				aluno.setPeriodo(determinarPeriodo(comboPeriodo.getSelectedIndex()));
				turma.gravar(aluno, posicao);

				posicao++;

				modelAlunos.addElement(aluno.getNome());

				if (posicao == turma.getTamanho()) {
					btnSalvar.setEnabled(false);
					JOptionPane.showMessageDialog(null, "A Turma está completa", "Cheio", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}

	private Periodo determinarPeriodo(int periodoSelecionado) {

		if (periodoSelecionado == 0) {
			return Periodo.MANHA;
		} else if (periodoSelecionado == 1) {
			return Periodo.TARDE;
		} else {
			return Periodo.NOITE;
		}

	}

}