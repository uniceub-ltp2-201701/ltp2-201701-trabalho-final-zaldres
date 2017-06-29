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
import dao.ListarPessoasDAO;
import model.Pessoa;

/**
 * Servlet implementation class ServletListarPessoas
 */
@WebServlet("/listarPessoas")
public class ServletListarPessoas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarPessoas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = new Conexao().getConexao();
			
			ListarPessoasDAO lpd = new ListarPessoasDAO(conexao);
			ArrayList<Pessoa> ListarPessoas = lpd.getListarPessoas();
			request.setAttribute("listarPessoas", ListarPessoas);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/listarTodasPessoas.jsp");
			rd.forward(request, response);
	}

}
