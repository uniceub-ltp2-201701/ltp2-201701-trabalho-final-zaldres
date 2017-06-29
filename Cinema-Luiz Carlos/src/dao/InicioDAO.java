package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Filme;


public class InicioDAO {
	
	private Connection conexao;
	
	//Metodo construtor
	public InicioDAO(Connection conexao){
		this.conexao = conexao;
	}
		
	//Metodo retorna a lista de listas por desclista especifica
	public ArrayList<Filme> listasGeneros(){
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		//Objetos para obter dados dos funcionarios
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			ps = conexao.prepareStatement("SELECT idtipocategoria, nomecategoria FROM cinema.tipocategoria");
			rs = ps.executeQuery();
			while(rs.next()){
				Filme filme = new Filme();
				filme.setIdtipocategoria(rs.getInt("idtipocategoria"));
				filme.setNomecategoria(rs.getString("nomecategoria"));
				filmes.add(filme);
			}
			
			
			rs.close();
			ps.close();
			}catch (Exception e){
			e.printStackTrace();
		}
		return filmes;
	}
}

