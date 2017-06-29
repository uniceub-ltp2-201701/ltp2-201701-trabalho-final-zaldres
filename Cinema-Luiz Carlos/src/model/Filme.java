package model;

import java.sql.Date;

public class Filme {
	
	private int idfilme;
	private String titulo;
	private String titulo_ingles;
	private Date dataDeEstreia;
	private float pontuacao;
	private int idpessoa;
	private String nomepessoa;
	private String tipoPessoa;
	private String personagem;
	private int idcategoriadofilme;
	private int idtipocategoria;
	private String nomecategoria;
	
	public Filme(int idfilme, String titulo, String titulo_ingles, Date dataDeEstreia, float pontuacao) {

		this.idfilme = idfilme;
		this.titulo = titulo;
		this.titulo_ingles = titulo_ingles;
		this.dataDeEstreia = dataDeEstreia;
		this.pontuacao = pontuacao;
	}
	
	
	public Filme(int idfilme, String titulo,int idpessoa,String nomepessoa, int tipoPessoa, String personagem) {
		this.idfilme = idfilme;
		this.titulo = titulo;
		this.idpessoa = idpessoa;
		this.nomepessoa = nomepessoa;
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
	}
	public Filme(int idfilme, String titulo, int idcategoriadofilme, int idtipocategoria, String nomecategoria){
		this.idfilme = idfilme;
		this.titulo = titulo;
		this.idcategoriadofilme = idcategoriadofilme;
		this.idtipocategoria = idtipocategoria;
		this.nomecategoria = nomecategoria;
	}


	public Filme(int idfilme, String titulo, int idpessoa, String nomepessoa, String tipoPessoa, String personagem) {
		this.idfilme = idfilme;
		this.titulo = titulo;
		this.idpessoa = idpessoa;
		this.nomepessoa = nomepessoa;
		this.tipoPessoa = tipoPessoa;
		this.personagem = personagem;
	}



	public Filme() {
		// TODO Auto-generated constructor stub
	}

	public int getIdfilme() {
		return idfilme;
	}
	public void setIdfilme(int idfilme) {
		this.idfilme = idfilme;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTitulo_ingles() {
		return titulo_ingles;
	}
	public void setTitulo_ingles(String titulo_ingles) {
		this.titulo_ingles = titulo_ingles;
	}
	public Date getDataDeEstreia() {
		return dataDeEstreia;
	}
	public void setDataDeEstreia(Date dataDeEstreia) {
		this.dataDeEstreia = dataDeEstreia;
	}
	public float getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(float pontuacao) {
		this.pontuacao = pontuacao;
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


	public int getIdcategoriadofilme() {
		return idcategoriadofilme;
	}


	public void setIdcategoriadofilme(int idcategoriadofilme) {
		this.idcategoriadofilme = idcategoriadofilme;
	}


	public int getIdtipocategoria() {
		return idtipocategoria;
	}


	public void setIdtipocategoria(int idtipocategoria) {
		this.idtipocategoria = idtipocategoria;
	}


	public String getNomecategoria() {
		return nomecategoria;
	}


	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria;
	}
	
	
	

}
