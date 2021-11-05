package br.senai.sp.jandira.model;

public class Aluno {

	private String nome;
	private String matricula;
	private Periodo periodo;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}
