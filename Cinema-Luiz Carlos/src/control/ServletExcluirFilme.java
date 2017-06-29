package control;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Conexao;
import dao.ExcluirFilmeDAO;
import java.io.PrintWriter;
import java.sql.Connection;
/**
 * Servlet implementation class ServletExcluiFilme
 */
@WebServlet("/excluiFilme")
public class ServletExcluirFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar parametros
				String idFilme = request.getParameter("idfilme");
				//Obter uma conexao com o BD
				Connection conexao = new Conexao().getConexao();
				//Criar a DAO
				ExcluirFilmeDAO efd = new ExcluirFilmeDAO(conexao);
				//Executar a exclusao
				boolean resultado = efd.excluiFilme(idFilme);
				
				//----- Escrevendo a resposta ao cliente -----
				PrintWriter out = response.getWriter();
				out.println("<HTML><HEAD><TITLE>EXCLUSÃO DE FILME</TITLE></HEAD>");
				out.println("<BODY>");
				out.println("<form action='/Cinema-Luiz_Carlos/listarFilmesAdmin'><input type='submit' value='Veja se o filme foi excluido da lista'></form>");
				
				//Verificar se a exclusao foi bem sucedida
				if (resultado) {
					out.println("<H1>FILME EXCLUIDO COM SUCESSO</H1>");
				} else {
					out.println("<H1>ERRO AO EXCLUIR FILME</H1>");
				}
				
				out.println("</BODY></HTML>");		
			}
	}



