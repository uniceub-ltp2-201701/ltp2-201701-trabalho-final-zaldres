package model;

public class TipoCategoria {
	private int idtipocategoria;
	private String nomecategoria;
	
	public TipoCategoria(int idtipocategoria, String nomecategoria) {
		this.idtipocategoria = idtipocategoria;
		this.nomecategoria = nomecategoria;
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
