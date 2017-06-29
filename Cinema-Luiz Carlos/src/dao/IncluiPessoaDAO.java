package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class IncluiPessoaDAO {
	private Connection conexao;
	public IncluiPessoaDAO(Connection conexao) {
	      this.conexao = conexao;
		}
	//Metodo para inserir uma pessoa
			public boolean IncluiPessoa(String nomepessoa, String datadenascimento, String idade, String sexo){
				PreparedStatement ps = null;
				boolean resposta = false;
				
				try {
					ps = conexao.prepareStatement("insert INTO pessoa (nomepessoa, datadenascimento, idade, sexo) values(?, ?, ?, ?);");
					ps.setString(1, nomepessoa);
					ps.setString(2, datadenascimento);
					ps.setString(3, idade);
					ps.setString(4, sexo);
					
					
					ps.executeUpdate();
					ps.close();
					resposta = true;
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return resposta;
		}
	}
/*insert INTO pessoa (nomepessoa, datadenascimento, idade, sexo) values(?, ?, ?, ?);

SELECT pessoa.idpessoa FROM pessoa WHERE 

SELECT filme.idfilme, pessoa.idpessoa FROM filme, pessoa WHERE 

AND elenco (idfilme, idpessoa, tipopessoa, personagem) values(?, ?, ?, ?) WHERE pessoa.idpessoa = elenco.idpessoa;*/