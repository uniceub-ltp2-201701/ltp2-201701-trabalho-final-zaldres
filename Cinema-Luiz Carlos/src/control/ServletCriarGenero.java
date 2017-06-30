package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.CriarGeneroDAO;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * Servlet implementation class ServletCriarGenero
 */
@WebServlet("/criarGenero")
public class ServletCriarGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCriarGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomecategoria = request.getParameter("nomecategoria");
		//Obter uma conexao com o BD
		Connection conexao = new Conexao().getConexao();
		//Criar a DAO
		CriarGeneroDAO cgd = new CriarGeneroDAO(conexao);
		//Inclui o contato
		boolean resultado = cgd.CriarGenero(nomecategoria);
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>Criar Genero</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<form action='/Cinema-Luiz_Carlos/inicioAdmin'><input type='submit' value='Volte ao inicio'></form>");
		if (resultado) {
			out.println("<TABLE border='1'>" +
		                "<TR>" +
					    "<TD><CENTER><FONT size='6'>GENERO CRIADO COM SUCESSO</FONT></CENTER></TD>" +
		                "</TR>" +
					    "</TABLE>");
		} else {
			out.println("<TABLE  border='1'>" +
	                "<TR>" +
				    "<TD><CENTER>ERRO AO CRIAR GENERO</FONT></CENTER></TD>" +
	                "</TR>" +
	                "<TR>" +
				    "<TD><CENTER>OS DADOS FORAM INSERIDOS INCORRETAMENTE... TENTE NOVAMENTE MAIS TARDE</FONT></CENTER></TD>" +
	                "</TR>" +
				    "</TABLE>");
		}
				
		out.println("</BODY></HTML>");
	}
	

}
