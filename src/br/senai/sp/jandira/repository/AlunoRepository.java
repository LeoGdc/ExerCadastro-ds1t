package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Aluno;

public class AlunoRepository {

	private Aluno[] turma;

	public AlunoRepository() {
		turma = new Aluno[32];
	}

	public AlunoRepository(int quantidadeAlunos) {
		turma = new Aluno[quantidadeAlunos];
	}

	public void gravar(Aluno aluno, int posicao) {
		turma[posicao] = aluno;
	}

	public Aluno listarAluno(int posicao) {
		return turma[posicao];
	}

	public Aluno[] listarTodos() {
		return turma;
	}
}
