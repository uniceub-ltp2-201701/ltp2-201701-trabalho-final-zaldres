package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private Connection conexao = null;
	
	//Metodo para retornar uma conexao ao banco de dados
	public Connection getConexao(){
		if (conexao == null) {
			try {
				//Referenciar o driver JDBC
				Class.forName("com.mysql.jdbc.Driver");
				
				//Criar as strings de conexao
				String url = "jdbc:mysql://localhost/cinema";
				String username = "root"; //nome do usuario no BD
				String password = ""; //senha do usuario no BD
				
				//Realizar a conexao ao BD
				conexao = DriverManager.getConnection(url, username, password);
			}
			catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		//Retornando o atributo estatico conexao
		return conexao;
	}

}
