package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Pessoa;

public class ListarPessoasDAO {
	private Connection conexao;
	
	public ListarPessoasDAO(Connection conexao){
		this.conexao = conexao;
	}
	//Metodo retorna a lista de listas por desclista especifica
		public ArrayList<Pessoa> getListarPessoas(){
			 ArrayList<Pessoa> ListarPessoas = new ArrayList<Pessoa>();
			//Objetos para obter dados dos funcionarios
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try{
				ps = conexao.prepareStatement("SELECT distinct p.idpessoa, p.nomepessoa, p.datadenascimento, p.idade, p.sexo, e.tipopessoa FROM cinema.pessoa AS p, cinema.elenco AS e WHERE p.idpessoa = e.idpessoa order by nomepessoa;");
				rs = ps.executeQuery();
				
				
				while (rs.next()){
					Pessoa p = new Pessoa(rs.getInt("idpessoa"), rs.getString("nomepessoa"), rs.getDate("dataDeNascimento"), rs.getInt("idade"), rs.getString("sexo"), rs.getInt("tipoPessoa"));
					ListarPessoas.add(p);
				}
				rs.close();
				ps.close();
				}catch (Exception e){
				e.printStackTrace();
			
			}
			return ListarPessoas;
		}
		
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		public ArrayList<Pessoa> getListarAtores(){
			 ArrayList<Pessoa> ListarAtores = new ArrayList<Pessoa>();
			//Objetos para obter dados dos funcionarios
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try{
				ps = conexao.prepareStatement("SELECT distinct p.idpessoa, p.nomepessoa, p.datadenascimento, p.idade, p.sexo, e.tipopessoa FROM cinema.pessoa AS p, cinema.elenco AS e WHERE p.idpessoa = e.idpessoa and e.tipopessoa = 1;");
				rs = ps.executeQuery();
				
				
				while (rs.next()){
					Pessoa p = new Pessoa(rs.getInt("idpessoa"), rs.getString("nomepessoa"), rs.getDate("dataDeNascimento"), rs.getInt("idade"), rs.getString("sexo"), rs.getInt("tipoPessoa"));
					ListarAtores.add(p);
				}
				rs.close();
				ps.close();
				}catch (Exception e){
				e.printStackTrace();
			
			}
			return ListarAtores;
		}
		
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		public ArrayList<Pessoa> getListarDiretores(){
			 ArrayList<Pessoa> ListarDiretores = new ArrayList<Pessoa>();
			//Objetos para obter dados dos funcionarios
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try{
				ps = conexao.prepareStatement("SELECT distinct p.idpessoa, p.nomepessoa, p.datadenascimento, p.idade, p.sexo, e.tipopessoa FROM cinema.pessoa AS p, cinema.elenco AS e WHERE p.idpessoa = e.idpessoa and e.tipopessoa = 2;");
				rs = ps.executeQuery();
				
				
				while (rs.next()){
					Pessoa p = new Pessoa(rs.getInt("idpessoa"), rs.getString("nomepessoa"), rs.getDate("dataDeNascimento"), rs.getInt("idade"), rs.getString("sexo"), rs.getInt("tipoPessoa"));
					ListarDiretores.add(p);
				}
				rs.close();
				ps.close();
				}catch (Exception e){
				e.printStackTrace();
			
			}
			return ListarDiretores;
		}

}
