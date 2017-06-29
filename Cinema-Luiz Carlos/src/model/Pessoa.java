package model;

import java.sql.Date;

public class Pessoa {
	private int idpessoa;
	private String nomepessoa;
	private Date dataDeNascimento;
	private int idade;
	private String sexo;
	private String tipoPessoa;
	private String personagem;
	private String titulo;
	private int idfilme;


	public Pessoa(int idpessoa, String nomepessoa, Date dataDeNascimento, int idade, String sexo, int tipoPessoa) {
		this.idpessoa = idpessoa;
		this.nomepessoa = nomepessoa;
		this.dataDeNascimento = dataDeNascimento;
		this.idade = idade;
		this.sexo = sexo;
		switch (tipoPessoa) {
		case 1:
			this.tipoPessoa = "Ator/Atriz";
		
			break;
		case 2:
			this.tipoPessoa = "Diretor(a)";
		
			break;
		case 3:
			this.tipoPessoa = "diretor-ator";
		
			break;	

		default:
			break;	
		}
	}
	public Pessoa(int idpessoa, String nomepessoa, Date dataDeNascimento, int idade, String sexo, int tipoPessoa, String personagem, String titulo, int idfilme) {
		this.idpessoa = idpessoa;
		this.nomepessoa = nomepessoa;
		this.dataDeNascimento = dataDeNascimento;
		this.idade = idade;
		this.sexo = sexo;
		switch (tipoPessoa) {
		case 1:
			this.tipoPessoa = "Ator/Atriz";
		
			break;
		case 2:
			this.tipoPessoa = "Diretor(a)";
		
			break;
		case 3:
			this.tipoPessoa = "diretor-ator";
		
			break;	

		default:
			break;	
		}
		if (personagem.equals("")){
			this.personagem = "Não interpreta Personagem nesse filme";
		}else{
			this.personagem = personagem;
		}
		this.titulo = titulo;
		this.idfilme = idfilme;
	}
	public int getIdpessoa() {
		return idpessoa;
	}
	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}
	public String getNomepessoa() {
		return nomepessoa;
	}
	public void setNomepessoa(String nomepessoa) {
		this.nomepessoa = nomepessoa;
	}
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public String getPersonagem() {
		return personagem;
	}
	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getIdfilme() {
		return idfilme;
	}
	public void setIdfilme(int idfilme) {
		this.idfilme = idfilme;
	}
	
	
}
