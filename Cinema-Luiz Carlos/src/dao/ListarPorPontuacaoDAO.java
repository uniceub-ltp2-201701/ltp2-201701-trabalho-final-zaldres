package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Filme;

public class ListarPorPontuacaoDAO {
private Connection conexao;
	
	//Metodo construtor
	public ListarPorPontuacaoDAO(Connection conexao){
		this.conexao = conexao;
}
	//Metodo retorna a lista de listas por desclista especifica
			public ArrayList<Filme> getListarPorPontuacao(String pontuacao){
				ArrayList<Filme> ListarPorPontuacao = new ArrayList<Filme>();
				//Objetos para obter dados dos funcionarios
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				try{
					ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, datadeestreia, pontuacao FROM cinema.filme where pontuacao >= ? and pontuacao <= (? + 1) order by pontuacao DESC;");
					ps.setString(1, pontuacao);
					ps.setString(2, pontuacao);
					rs = ps.executeQuery();
					
					while (rs.next()){
						Filme lpp = new Filme(rs.getInt("idfilme"), rs.getString("titulo"), rs.getInt("idcategoriadofilme"), rs.getInt("idtipocategoria"), rs.getString("nomecategoria"));
						ListarPorPontuacao.add(lpp);
					}
					rs.close();
					ps.close();
					}catch (Exception e){
					e.printStackTrace();
				}
				return ListarPorPontuacao;
			}
}