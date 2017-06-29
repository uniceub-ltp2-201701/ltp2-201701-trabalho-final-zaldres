package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ListarFilmesDAO;
import model.Filme;

/**
 * Servlet implementation class ServletListarFilmesAdmin
 */
@WebServlet("/listarFilmesAdmin")
public class ServletListarFilmesAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarFilmesAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexao = new Conexao().getConexao();
		
		ListarFilmesDAO lfd = new ListarFilmesDAO(conexao);
		ArrayList<Filme> ListarFilmes = lfd.getListarFilmes();
		request.setAttribute("listarFilmes", ListarFilmes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listarTodosFilmesAdmin.jsp");
		rd.forward(request, response);
	
	}

}
