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
import model.AdicionarGeneroNoFilme;
import model.Filme;;

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
		String idFilme = request.getParameter("idfilme");
		//
		ArrayList<Filme> AdicionarGeneroaoFilme = new agfd.
		
	}

}
