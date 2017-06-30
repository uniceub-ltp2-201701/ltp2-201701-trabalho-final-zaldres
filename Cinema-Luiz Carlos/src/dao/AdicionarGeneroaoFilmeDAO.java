package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionarGeneroaoFilmeDAO {
	private Connection conexao;
	
	public AdicionarGeneroaoFilmeDAO(Connection conexao) {
	      this.conexao = conexao;
		}
	//Metodo para inserir um FILME
			public boolean AdicionarGeneroaoFilme(String idtipocategoria, String idfilme){
				PreparedStatement ps = null;
				boolean resultado = false;
				
				try {
					ps = conexao.prepareStatement("insert INTO categoriadofilme (idtipocategoria, idfilme) values(?, ?);");
					ps.setInt(1, Integer.parseInt(idtipocategoria));
					ps.setInt(2, Integer.parseInt(idfilme));
					
					ps.executeUpdate();
					ps.close();
					resultado = true;
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return resultado;
		}

}
