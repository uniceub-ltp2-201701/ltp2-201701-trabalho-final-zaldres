package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;

public class AssociarPessoaAFilmeDAO {
	private Connection conexao;
	
	public AssociarPessoaAFilmeDAO(Connection conexao) {
	      this.conexao = conexao;
		}
	//Metodo para inserir um FILME
			public boolean AssociarPessoaAFilme(String idfilme, String idpessoa, String tipopessoa, String personagem){
				PreparedStatement ps = null;
				boolean adicionar = false;
				
				try {
					ps = conexao.prepareStatement("insert INTO elenco (idfilme, idpessoa, tipopessoa, personagem) values( ?, ?, ?, ?);");
					ps.setInt(1, Integer.parseInt(idfilme));
					ps.setInt(2, Integer.parseInt(idpessoa));
					ps.setInt(3, Integer.parseInt(tipopessoa));
					ps.setString(4, personagem);
					
					
					ps.executeUpdate();
					ps.close();
					adicionar = true;
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return adicionar;
		}
			//-------------------------------------------------------------------------------------------------------------------
			
			//Metodo que retorna pessoa de acoedo com idpessoa
			public ArrayList<Filme> getAdicionarPessoaaoFilme(String idFilme){
				ArrayList<Filme> AdicionarPessoaaoFilme = new ArrayList<Filme>();
				PreparedStatement ps = null;
				ResultSet rs = null;
				try{
					ps = conexao.prepareStatement("SELECT distinct p.idpessoa, p.nomepessoa, e.tipopessoa, z.titulo,e.personagem ,z.idfilme FROM cinema.pessoa AS p, cinema.elenco AS e, cinema.filme AS z WHERE p.idpessoa = e.idpessoa and e.idfilme = z.idfilme and z.idfilme = ? ;");
					ps.setString(1, idFilme);
					rs=ps.executeQuery();
					while(rs.next()){
						Filme apf = new Filme(rs.getInt("idfilme"), rs.getString("titulo"), rs.getInt("idpessoa"), rs.getString("nomepessoa"), rs.getString("tipoPessoa"), rs.getString("personagem"));
						AdicionarPessoaaoFilme.add(apf);
					}rs.close();
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				return AdicionarPessoaaoFilme;
			}
	}

