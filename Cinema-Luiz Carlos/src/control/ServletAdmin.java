package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Recuperar os parametros
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String mensagem = null;
			
			try {
				//Referenciar o driver JDBC
				Class.forName("com.mysql.jdbc.Driver");
				
				//Criar as strings de conexao
				String url = "jdbc:mysql://localhost/cinema";
				String username = "root"; //nome do usuario no BD
				String password = ""; //senha do usuario no BD
				
				//Realizar a conexao ao BD
				Connection conexao = DriverManager.getConnection(url, username, password);
				
				//Preparar a consulta SQL - Jeito 1
			String sql = "select idlogin from cinema.login where " +
						"usuario = '"+ login + "'and senha = '" + senha + "'";	
				PreparedStatement ps = conexao.prepareStatement(sql);

				
				//Executando a query e recebendo o ResultSet
				ResultSet rs = ps.executeQuery();

				//Verificar se o ResultSet tem resultado
				if (rs.first()) {
					mensagem = "<body><h1>Seja bem vindo Administrador!!</h1>" +
							"<a href='/Cinema-Luiz_Carlos/inicioAdmin'>Logar como Administrador </a>" +
							"</body></html>";
				} else {
					mensagem = "<body><h1>Usu�rio/senha inv�lidos!</h1></body></html>";
				}
				
				//Fechar o ResultSet
				rs.close();
				//Fechar o PreparedStatement
				ps.close();
				//Fechar o Connnection
				conexao.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			//Retornar HTML para o cliente
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Resultado do Login</title></head>");
			out.println(mensagem);
		}
	}


