package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Filme;

public class ListarFilmesDAO {
	private Connection conexao;
	
	//Metodo construtor
	public ListarFilmesDAO(Connection conexao){
		this.conexao = conexao;
	}
	//Metodo retorna a lista de listas por desclista especifica
	public ArrayList<Filme> getListarFilmes(){
		ArrayList<Filme> ListarFilmes = new ArrayList<Filme>();
		//Objetos para obter dados dos funcionarios
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, datadeestreia,pontuacao FROM cinema.filme order by titulo;");
			rs = ps.executeQuery();
			
			while (rs.next()){
				Filme f = new Filme(rs.getInt("idfilme"),rs.getString("titulo"),rs.getString("titulo_ingles"),rs.getDate("dataDeEstreia"),rs.getFloat("pontuacao"));
				ListarFilmes.add(f);
			}
			rs.close();
			ps.close();
			}catch (Exception e){
			e.printStackTrace();
		}
		return ListarFilmes;
	}

}
