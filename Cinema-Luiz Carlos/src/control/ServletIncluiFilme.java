package control;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Conexao;
import dao.IncluiFilmeDAO;
import java.io.PrintWriter;
import java.sql.Connection;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletIncluiFilme
 */
@WebServlet("/incluiFilme")
public class ServletIncluiFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIncluiFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String titulo_ingles = request.getParameter("titulo_ingles");
		String dataDeEstreia = request.getParameter("datadeestreia");
		String pontuacao = request.getParameter("pontuacao");
		//Obter uma conexao com o BD
		Connection conexao = new Conexao().getConexao();
		//Criar a DAO
		IncluiFilmeDAO ifd = new IncluiFilmeDAO(conexao);
		//Inclui o contato
		boolean resultado = ifd.IncluiFilme(titulo, titulo_ingles, dataDeEstreia, pontuacao);
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>INCLUSÃO DE Filme</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<form action='/Cinema-Luiz_Carlos/listarFilmesAdmin'><input type='submit' value='Veja se o filme foi adicionada na lista'></form>");
				
		//_______________________________________________VERIFICAR SE A INCLUSAO FOI BEM SUCEDIDA___________________________________________________________________________
		//_______________________________________________PUXANDO O VALOR ALOCADO NA VARIAVEL "resultado" PRESENTE NA NOSSA CLASSE "IncluiDisciplinaDAO"_____________________
		if (resultado) {
			out.println("<TABLE border='1'>" +
		                "<TR>" +
					    "<TD><CENTER><FONT size='6'>FILME INCLUIDO COM SUCESSO</FONT></CENTER></TD>" +
		                "</TR>" +
					    "</TABLE>");
		} else {
			out.println("<TABLE  border='1'>" +
	                "<TR>" +
				    "<TD><CENTER>ERRO AO INCLUIR FILME</FONT></CENTER></TD>" +
	                "</TR>" +
	                "<TR>" +
				    "<TD><CENTER>OS DADOS FORAM INSERIDOS INCORRETAMENTE... TENTE NOVAMENTE MAIS TARDE</FONT></CENTER></TD>" +
	                "</TR>" +
				    "</TABLE>");
		}
				
		out.println("</BODY></HTML>");
	}

}

		
	

       
