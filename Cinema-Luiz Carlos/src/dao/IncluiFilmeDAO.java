package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class IncluiFilmeDAO {
	private Connection conexao;
	
	public IncluiFilmeDAO(Connection conexao) {
	      this.conexao = conexao;
		}
		//Metodo para inserir um FILME
		public boolean IncluiFilme(String titulo, String titulo_ingles, String dataDeEstreia, String pontuacao){
			PreparedStatement ps = null;
			boolean resultado = false;
			
			try {
				ps = conexao.prepareStatement("insert INTO filme (titulo, titulo_ingles, datadeestreia, pontuacao) values(?, ?, ?, ?);");
				ps.setString(1, titulo);
				ps.setString(2, titulo_ingles);
				ps.setString(3, dataDeEstreia);
				ps.setString(4, pontuacao);
				
				
				ps.executeUpdate();
				ps.close();
				resultado = true;
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return resultado;
	}
}
