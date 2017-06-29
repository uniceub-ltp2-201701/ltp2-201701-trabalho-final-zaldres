package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;

	public class ExcluirFilmeDAO {
		private Connection conexao;
		
		public ExcluirFilmeDAO(Connection conexao) {
			this.conexao = conexao;
		}
		
		//Metodo que exclui um contato pelo idcontato
		public boolean excluiFilme(String idFilme){
			PreparedStatement ps = null;
			boolean resultado = false;
			
			try {
				ps = conexao.prepareStatement("DELETE FROM cinema.filme WHERE idfilme=?;");
				ps.setInt(1, Integer.parseInt(idFilme));
				
				ps.executeUpdate();
				ps.close();
				resultado = true;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return resultado;
		}
		


}
