package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcluirPessoaDAO {
private Connection conexao;
	
	public ExcluirPessoaDAO(Connection conexao) {
	      this.conexao = conexao;
		}
		//Metodo para inserir um FILME
		public boolean excluiPessoa(String idPessoa){
			PreparedStatement ps = null;
			boolean resultado = false;
			
			
			try {
				ps = conexao.prepareStatement("DELETE FROM cinema.pessoa WHERE idpessoa=?;");
				ps.setInt(1, Integer.parseInt(idPessoa));
			
				ps.executeUpdate();
				ps.close();
				resultado = true;
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return resultado;
	}

}
