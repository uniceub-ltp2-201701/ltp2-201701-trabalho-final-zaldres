package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionarGeneroaoFilmeDAO;
import dao.Conexao;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
/**
 * Servlet implementation class ServletAdicionarGeneroaoFilme
 */
@WebServlet("/adicionarGeneroaoFilme")
public class ServletAdicionarGeneroaoFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdicionarGeneroaoFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idtipocategoria = request.getParameter("idtipocategoria");
		String idfilme = request.getParameter("idfilme");
		//Obter uma conexao com o BD
		Connection conexao = new Conexao().getConexao();
		//Criar a DAO
		AdicionarGeneroaoFilmeDAO agfd = new AdicionarGeneroaoFilmeDAO(conexao);
		
		boolean resultado = agfd.AdicionarGeneroaoFilme(idtipocategoria, idfilme);
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>INCLUSÃO DE Genero de filme</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<form action='/Cinema-Luiz_Carlos/listarFilmesAdmin'><input type='submit' value='Veja se o genero foi adicionado na lista'></form>");
				
		//_______________________________________________VERIFICAR SE A INCLUSAO FOI BEM SUCEDIDA___________________________________________________________________________
		//_______________________________________________PUXANDO O VALOR ALOCADO NA VARIAVEL "resultado" PRESENTE NA NOSSA CLASSE "IncluiDisciplinaDAO"_____________________
		if (resultado) {
			out.println("<TABLE border='1'>" +
		                "<TR>" +
					    "<TD><CENTER><FONT size='6'>GENERO ADICIONADO COM SUCESSO</FONT></CENTER></TD>" +
		                "</TR>" +
					    "</TABLE>");
		} else {
			out.println("<TABLE  border='1'>" +
	                "<TR>" +
				    "<TD><CENTER>ERRO AO ADICIONAR GENERO</FONT></CENTER></TD>" +
	                "</TR>" +
	                "<TR>" +
				    "<TD><CENTER>OS DADOS FORAM INSERIDOS INCORRETAMENTE... TENTE NOVAMENTE MAIS TARDE</FONT></CENTER></TD>" +
	                "</TR>" +
				    "</TABLE>");
		}
				
		out.println("</BODY></HTML>");
	}

		
	}

