package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.IncluiPessoaDAO;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletIncluiPessoa
 */
@WebServlet("/incluiPessoa")
public class ServletIncluiPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIncluiPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomepessoa = request.getParameter("nomepessoa");
		String datadenascimento = request.getParameter("datadenascimento");
		String idade = request.getParameter("idade");
		String sexo = request.getParameter("sexo");
		//Obter uma conexao com o BD
		Connection conexao = new Conexao().getConexao();
		//Criar a DAO
		IncluiPessoaDAO ipd = new IncluiPessoaDAO(conexao);
		
		boolean resposta = ipd.IncluiPessoa(nomepessoa, datadenascimento, idade, sexo);
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>INCLUSÃO DE Filme</TITLE></HEAD>");
		out.println("<BODY>");
				
		//_______________________________________________VERIFICAR SE A INCLUSAO FOI BEM SUCEDIDA___________________________________________________________________________
		//_______________________________________________PUXANDO O VALOR ALOCADO NA VARIAVEL "resultado" PRESENTE NA NOSSA CLASSE "IncluiDisciplinaDAO"_____________________
		if (resposta) {
			out.println("<TABLE border='1'>" +
		                "<TR>" +
					    "<TD><CENTER><FONT size='6'>PESSOA INCLUIDA COM SUCESSO</FONT></CENTER></TD>" +
		                "</TR>" +
					    "</TABLE>");
		} else {
			out.println("<TABLE  border='1'>" +
	                "<TR>" +
				    "<TD><CENTER>ERRO AO INCLUIR PESSOA</FONT></CENTER></TD>" +
	                "</TR>" +
	                "<TR>" +
				    "<TD><CENTER>OS DADOS FORAM INSERIDOS INCORRETAMENTE... TENTE NOVAMENTE MAIS TARDE</FONT></CENTER></TD>" +
	                "</TR>" +
				    "</TABLE>");
		}
				
		out.println("</BODY></HTML>");
	}


	}



