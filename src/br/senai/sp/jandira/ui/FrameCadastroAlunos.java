package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNome;
	private int posicao = 0;

	public FrameCadastroAlunos() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(10, 37, 66, 14);
		contentPane.add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(71, 34, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(71, 83, 128, 20);
		contentPane.add(txtNome);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 86, 47, 14);
		contentPane.add(lblNome);

		JLabel lblPeriodo = new JLabel("Periodo:");
		lblPeriodo.setBounds(10, 126, 47, 14);
		contentPane.add(lblPeriodo);

		JComboBox comboPeriodo = new JComboBox();
		DefaultComboBoxModel<String> modelPeriodo = new DefaultComboBoxModel<String>();

		for (Periodo p : Periodo.values()) {
			modelPeriodo.addElement(p.getDescricao());
		}

		comboPeriodo.setModel(modelPeriodo);
		comboPeriodo.setBounds(71, 122, 89, 22);
		contentPane.add(comboPeriodo);

		JButton btnSalvar = new JButton("Salvar Aluno");
		btnSalvar.setBounds(57, 163, 131, 48);
		contentPane.add(btnSalvar);
		AlunoRepository turma = new AlunoRepository(3);
		JButton btnMostrarAlunos = new JButton("Exibir Alunos");
		btnMostrarAlunos.setBounds(71, 222, 102, 23);
		contentPane.add(btnMostrarAlunos);

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(txtMatricula.getText());
				aluno.setNome(txtNome.getText());

				turma.gravar(aluno, posicao);
				posicao++;

			}
		});

		btnMostrarAlunos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Aluno aluno : turma.listarTodos()) {
					System.out.println(aluno.getMatricula());
					System.out.println(aluno.getNome());
					System.out.println("---------------------------");
				}

			}
		});

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
