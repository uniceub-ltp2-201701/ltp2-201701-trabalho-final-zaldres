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
import dao.DetalharFilmesDAO;
import dao.ListarPessoasDAO;
import model.Filme;
import model.Pessoa;

/**
 * Servlet implementation class ServletDetalharFilmes
 */
@WebServlet("/detalhaFilme")
public class ServletDetalharFilmes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharFilmes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obter conexao
		Connection conexao = new Conexao().getConexao();
		//Criar Objeto DAO
		DetalharFilmesDAO dfd = new DetalharFilmesDAO(conexao);
		String idFilme = request.getParameter("idfilme");
		//
		Filme f = dfd.getFilmePorId(idFilme);
		request.setAttribute("Filme", f);
		//
		ArrayList<Filme> ElencoFilme = dfd.getElencoFilme(idFilme);
		request.setAttribute("elencoFilme", ElencoFilme);
		//
		ListarPessoasDAO lpd = new ListarPessoasDAO(conexao);
		ArrayList<Pessoa> ListarPessoas = lpd.getListarPessoas();
		request.setAttribute("listarPessoas", ListarPessoas);
		
		//Dispachar o request
		RequestDispatcher rd = request.getRequestDispatcher("/detalharFilme.jsp");
		rd.forward(request, response);
		
	}

}
