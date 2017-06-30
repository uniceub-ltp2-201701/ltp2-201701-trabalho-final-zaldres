package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import model.Filme;
import dao.AssociarPessoaAFilmeDAO;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;


/**
 * Servlet implementation class ServletAssociarPessoaAFilme
 */
@WebServlet("/associarPessoaAFilme")
public class ServletAssociarPessoaAFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAssociarPessoaAFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idfilme = request.getParameter("idfilme");
		String idpessoa = request.getParameter("idpessoa");
		String tipopessoa = request.getParameter("tipopessoa");
		String personagem = request.getParameter("personagem");
		//Obter uma conexao com o BD
		Connection conexao = new Conexao().getConexao();
		//Criar a DAO
		AssociarPessoaAFilmeDAO apaf = new AssociarPessoaAFilmeDAO(conexao);
		String idFilme = request.getParameter("idfilme");
		//
		//
		ArrayList<Filme> AssociarPessoaaoFilme = apaf.getAdicionarPessoaaoFilme(idFilme);
		request.setAttribute("associarPessoaaoFilme", AssociarPessoaaoFilme);
		//Inclui o contato
		boolean adicionar =  apaf.AssociarPessoaAFilme(idfilme, idpessoa, tipopessoa, personagem);
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>Adicionar pessoa a filme</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<form action='/Cinema-Luiz_Carlos/listarPessoasAdmin'><input type='submit' value='Veja a lista de pessoas disponiveis'></form>");
		//_______________________________________________VERIFICAR SE A INCLUSAO FOI BEM SUCEDIDA___________________________________________________________________________
				//_______________________________________________PUXANDO O VALOR ALOCADO NA VARIAVEL "resultado" PRESENTE NA NOSSA CLASSE "IncluiDisciplinaDAO"_____________________
				if (adicionar) {
				
					out.println("<TABLE border='1'>" +
				                "<TR>" +
							    "<TD><CENTER><FONT size='6'>PESSOA ADICIONADA AO FILME COM SUCESSO </FONT></CENTER></TD>" +
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

