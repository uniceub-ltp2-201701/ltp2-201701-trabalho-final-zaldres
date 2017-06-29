package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Filme;

public class ListarPorCategoriaDAO {
private Connection conexao;
	
	//Metodo construtor
	public ListarPorCategoriaDAO(Connection conexao){
		this.conexao = conexao;
}
	//Metodo retorna a lista de listas por desclista especifica
		public ArrayList<Filme> getListarPorCategoria(String idtipocategoria){
			ArrayList<Filme> ListarPorCategoria = new ArrayList<Filme>();
			//Objetos para obter dados dos funcionarios
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try{
				ps = conexao.prepareStatement("SELECT f.idfilme, f.titulo, c.idcategoriadofilme, t.idtipocategoria,  t.nomecategoria FROM cinema.filme as f, cinema.tipocategoria as t, cinema.categoriadofilme as c where t.idtipocategoria = c.idtipocategoria and f.idfilme = c.idfilme and t.idtipocategoria= ? order by titulo;");
				ps.setString(1, idtipocategoria);
				rs = ps.executeQuery();
				
				while (rs.next()){
					Filme lpc = new Filme(rs.getInt("idfilme"), rs.getString("titulo"), rs.getInt("idcategoriadofilme"), rs.getInt("idtipocategoria"), rs.getString("nomecategoria"));
					ListarPorCategoria.add(lpc);
				}
				rs.close();
				ps.close();
				}catch (Exception e){
				e.printStackTrace();
			}
			return ListarPorCategoria;
		}
}
