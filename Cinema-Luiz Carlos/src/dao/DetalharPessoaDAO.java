package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.Filme;
import model.Pessoa;

public class DetalharPessoaDAO {
	private Connection conexao;
	
	public DetalharPessoaDAO(Connection conexao){
		this.conexao = conexao;
	}
	//Metodo que retorna pessoa de acoedo com idpessoa
	public Pessoa getPessoaPorId (String idPessoa){
		Pessoa p = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conexao.prepareStatement("SELECT distinct p.idpessoa, p.nomepessoa, p.datadenascimento, p.idade, p.sexo, e.tipopessoa FROM cinema.pessoa AS p, cinema.elenco AS e  WHERE p.idpessoa = e.idpessoa and p.idpessoa = ?;");
			ps.setString(1, idPessoa);
			rs=ps.executeQuery();
			while(rs.next()){
				 p = new Pessoa(rs.getInt("idPessoa"), rs.getString("nomepessoa"), rs.getDate("dataDeNascimento"), rs.getInt("idade"), rs.getString("sexo"), rs.getInt("tipoPessoa"));
			}rs.close();
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodo que retorna pessoa de acoedo com idpessoa
		public ArrayList<Pessoa> getPessoaPersonagem(String idPessoa){
			ArrayList<Pessoa> PessoaPersonagem = new ArrayList<Pessoa>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try{
				ps = conexao.prepareStatement("SELECT distinct p.idpessoa, p.nomepessoa, p.datadenascimento, p.idade, p.sexo, e.tipopessoa, z.titulo, e.personagem ,z.idfilme FROM cinema.pessoa AS p, cinema.elenco AS e, cinema.filme AS z WHERE p.idpessoa = e.idpessoa and e.idfilme = z.idfilme and p.idpessoa = ? ;");
				ps.setString(1, idPessoa);
				rs=ps.executeQuery();
				while(rs.next()){
					Pessoa per = new Pessoa(rs.getInt("idPessoa"), rs.getString("nomepessoa"), rs.getDate("dataDeNascimento"), rs.getInt("idade"), rs.getString("sexo"), rs.getInt("tipoPessoa"), rs.getString("personagem"), rs.getString("titulo"), rs.getInt("idfilme"));
				    PessoaPersonagem.add(per);
				}rs.close();
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return PessoaPersonagem;
		}
		//-----------------------------------------------------------------------------------------------------------------------------------------------------
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
