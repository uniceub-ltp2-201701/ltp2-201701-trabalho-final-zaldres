<%@page import="dao.Conexao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Filme" %>
<%@page import="dao.InicioDAO"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cinema do Luiz</title>
</head>
<body>

	<% ArrayList<Filme> filmes = new InicioDAO(new Conexao().getConexao()).listasGeneros();%>
	

	<form action="/Cinema-Luiz_Carlos/inicioAdmin"><input type="submit" value="inicio"></form>
	
	<h1>Bem vindo ao Banco de Dados Administrador</h1>
	<a href="/Cinema-Luiz_Carlos/listarFilmesAdmin">Listar Todos os Filmes/Tabela de Excluir Filme</a> <br/>
	<a href="/Cinema-Luiz_Carlos/listarPessoasAdmin">Listar Todas os Atores/Diretores</a> <br />
	<a href="/Cinema-Luiz_Carlos/listarAtoresAdmin">Listar Todas os Atores</a> <br />
	<a href="/Cinema-Luiz_Carlos/listarDiretoresAdmin">Listar Todas os Diretores</a> <br />
	<a href="/Cinema-Luiz_Carlos/adicionarPessoas.jsp">Registrar Pessoas no Banco de Dados</a> <br />
	<a href="/Cinema-Luiz_Carlos/adicionarFilmes.jsp">Registrar Filmes ou criar novas categorias para filmes no Banco de Dados</a> <br />

	<table border=1>
		<tr><td>Lista de Filmes Por Pontuacao</td></tr>
		<%for(Filme filme: filmes){%>
		<form action='/Cinema-Luiz_Carlos/listarPorPontuacao?pontuacao=<%=filme.getPontuacao()%>"' method='GET'><%}%>
			<tr><td>
			<select name='pontuacao'>
			<option  value='1'>1</option>
            <option  value='2'>2</option>
            <option  value='3'>3</option>
            <option  value='4'>4</option>
            <option  value='5'>5</option>
            <option  value='6'>6</option>
            <option  value='7'>7</option>
            <option  value='8'>8</option>
            <option  value='9'>9</option>
            <option  value='10'>10</option>
            </select>
            </td>
            </tr>
		    </table>
	        <INPUT TYPE='SUBMIT' VALUE='buscar'>
	        </form>

	<table border=1>
		<tr><td>Listar Por genero</td></tr>
		<%for(Filme filme: filmes){%>
			<tr><td><a href="/Cinema-Luiz_Carlos/listarPorCategoriaAdmin?idtipocategoria=<%=filme.getIdtipocategoria()%>"><%= filme.getNomecategoria()%></a></td></tr>
		<%}%>
	</table>
	 <hr>
	<form action="/Cinema-Luiz_Carlos/index"><input type="submit" value="Log out"></form>
</body>
</html>