package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriarGeneroDAO {
private Connection conexao;
	
	public CriarGeneroDAO(Connection conexao) {
	      this.conexao = conexao;
		}
		//Metodo para inserir um FILME
		public boolean CriarGenero(String nomecategoria){
			PreparedStatement ps = null;
			boolean resultado = false;
			
			try {
				ps = conexao.prepareStatement("insert INTO tipocategoria (nomecategoria) values(?);");
				ps.setString(1, nomecategoria);
				
				ps.executeUpdate();
				ps.close();
				resultado = true;
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return resultado;
	}
}
