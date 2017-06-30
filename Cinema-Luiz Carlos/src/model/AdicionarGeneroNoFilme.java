package model;

public class AdicionarGeneroNoFilme {
	
	private int idCategoriadoFilme;
	private int tipoCategoria;
	private int idFilme;
	
	
	public AdicionarGeneroNoFilme(int idCategoriadoFilme, int tipoCategoria, int idFilme) {
		this.idCategoriadoFilme = idCategoriadoFilme;
		this.tipoCategoria = tipoCategoria;
		this.idFilme = idFilme;
	}
	
	public int getIdCategoriadoFilme() {
		return idCategoriadoFilme;
	}
	public void setIdCategoriadoFilme(int idCategoriadoFilme) {
		this.idCategoriadoFilme = idCategoriadoFilme;
	}
	public int getTipoCategoria() {
		return tipoCategoria;
	}
	public void setTipoCategoria(int tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}
	public int getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	
	

}
