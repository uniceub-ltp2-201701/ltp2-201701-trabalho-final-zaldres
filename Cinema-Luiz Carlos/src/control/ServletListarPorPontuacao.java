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

import dao.ListarPorPontuacaoDAO;
import model.Filme;
import dao.Conexao;

/**
 * Servlet implementation class ServletListarPorPontuacao
 */
@WebServlet("/listarPorPontuacao")
public class ServletListarPorPontuacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarPorPontuacao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = new Conexao().getConexao();
		
		ListarPorPontuacaoDAO lpp = new ListarPorPontuacaoDAO(conexao);
		String pontuacao = request.getParameter("pontuacao");
		
		ArrayList<Filme> ListarPorPontuacao = lpp.getListarPorPontuacao(pontuacao);
		request.setAttribute("listarPorPontuacao", ListarPorPontuacao);
		
		//Dispachar o request
				RequestDispatcher rd = request.getRequestDispatcher("/listarPelaPontuacao.jsp");
				rd.forward(request, response);
	}

}
