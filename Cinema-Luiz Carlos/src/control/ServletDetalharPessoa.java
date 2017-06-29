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

import dao.ListarFilmesDAO;
import model.Filme;
import dao.AssociarPessoaAFilmeDAO;
import dao.Conexao;
import dao.DetalharPessoaDAO;
import model.Pessoa;

/**
 * Servlet implementation class ServletDetalharPessoa
 */
@WebServlet("/detalhaPessoa")
public class ServletDetalharPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharPessoa() {
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
		DetalharPessoaDAO dpd = new DetalharPessoaDAO(conexao);
		String idPessoa = request.getParameter("idpessoa");
		//
		Pessoa p = dpd.getPessoaPorId(idPessoa);
		request.setAttribute("Pessoa", p);
		//
		String idFilme = request.getParameter("idFilme");
		ArrayList<Filme> AssociarPessoaaoFilme = dpd.getAdicionarPessoaaoFilme(idFilme);
		request.setAttribute("associarPessoaaoFilme", AssociarPessoaaoFilme);
		//
		ArrayList<Pessoa> PessoaPersonagem = dpd.getPessoaPersonagem(idPessoa);
		request.setAttribute("pessoaPersonagem", PessoaPersonagem);
		//
		ListarFilmesDAO lfd = new ListarFilmesDAO(conexao);
		ArrayList<Filme> ListarFilmes = lfd.getListarFilmes();
		request.setAttribute("listarFilmes", ListarFilmes);
		
		
		//Dispachar o request
		RequestDispatcher rd = request.getRequestDispatcher("/detalharPessoa.jsp");
		rd.forward(request, response);

	}

}
