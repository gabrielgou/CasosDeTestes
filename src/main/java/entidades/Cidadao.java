package main.java.entidades;

import java.util.Date;

public class Cidadao {
	
	private String nome;
	private String cpf;
	private String cep;
	private String endereco;
	private Integer nCasa;
	private String bairro;
	private String email;
	private Date dataNascimento;
	private String senha;
	
	
	
	public Cidadao(String nome, String cpf, String cep, String endereco, Integer nCasa, String bairro,
			String email, Date dataNascimento, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.endereco = endereco;
		this.nCasa = nCasa;
		this.bairro = bairro;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
	}
	
	public Cidadao() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getnCasa() {
		return nCasa;
	}
	public void setnCasa(Integer nCasa) {
		this.nCasa = nCasa;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
