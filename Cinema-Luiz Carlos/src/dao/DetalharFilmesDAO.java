package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import model.Filme;

public class DetalharFilmesDAO {
	private Connection conexao;
	
	public DetalharFilmesDAO(Connection conexao){
		this.conexao = conexao;
	}
	//Metodo que retorna funcionario de acordo com id funcionario
	public Filme getFilmePorId(String idFilme){
		Filme f = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps=conexao.prepareStatement("select filme.idfilme, filme.titulo, filme.titulo_ingles, filme.datadeestreia, filme.pontuacao  FROM cinema.filme where idfilme=?;");
			ps.setString(1, idFilme);
			rs=ps.executeQuery();
			while(rs.next()){
				 f = new Filme(rs.getInt("idfilme"),rs.getString("titulo"),rs.getString("titulo_ingles"),rs.getDate("dataDeEstreia"),rs.getFloat("pontuacao"));
			}
		rs.close();
		ps.close();
	} catch(Exception e){
		e.printStackTrace();
	}
	return f;

}
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Metodo que retorna pessoa de acoedo com idpessoa
			public ArrayList<Filme> getElencoFilme(String idFilme){
				ArrayList<Filme> ElencoFilme = new ArrayList<Filme>();
				PreparedStatement ps = null;
				ResultSet rs = null;
				try{
					ps = conexao.prepareStatement("SELECT distinct p.idpessoa, p.nomepessoa, e.tipopessoa, z.titulo,e.personagem ,z.idfilme, e.idelenco FROM cinema.pessoa AS p, cinema.elenco AS e, cinema.filme AS z WHERE p.idpessoa = e.idpessoa and e.idfilme = z.idfilme and z.idfilme = ? ;");
					ps.setString(1, idFilme);
					rs=ps.executeQuery();
					while(rs.next()){
						Filme ef = new Filme(rs.getInt("idfilme"), rs.getString("titulo"), rs.getInt("idpessoa"), rs.getString("nomepessoa"), rs.getInt("tipoPessoa"), rs.getString("personagem"), rs.getInt("idelenco"));
						ElencoFilme.add(ef);
					}rs.close();
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				return ElencoFilme;
			}
		
	}

