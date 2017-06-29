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
import dao.InicioDAO;
import model.Filme;

/**
 * Servlet implementation class ServletInicio
 */
@WebServlet("/index")
public class ServletInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = new Conexao().getConexao();
		
		InicioDAO lpc = new InicioDAO(conexao);
		String idTipoCategoria = request.getParameter("idtipocategoria");
		
		ArrayList<Filme> listaCategorias = lpc.listasGeneros();
		request.setAttribute("listarPorCategoria", listaCategorias);
		
		
		//Dispachar o request
				RequestDispatcher rd = request.getRequestDispatcher("/inicio.jsp");
				rd.forward(request, response);
		
	
	}

}
