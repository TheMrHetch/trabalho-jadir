package br.edu.unicid.bean;

import java.sql.Date;

public class Aluno {
	private Integer rgm;
	private String nome;
	private String email;
	private Date nascimento;
	private Integer idade;
	private String endereco;
	
	public Aluno(Integer rgm, String nome, String email, Date nascimento, 
			Integer idade, String endereco) 
	{
		this.rgm = rgm;
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.idade = idade;
		this.endereco = endereco;
	}

	public Aluno(Integer rgm) {
		super();
		this.rgm = rgm;
	}

	public Integer getRgm() {
		return rgm;
	}

	public void setRgm(Integer rgm) {
		this.rgm = rgm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
