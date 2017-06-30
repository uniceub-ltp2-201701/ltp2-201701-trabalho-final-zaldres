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
	

	<form action="/Cinema-Luiz_Carlos/index"><input type="submit" value="inicio"></form>
	
	<h1>Bem vindo ao Banco de Dados Cinema</h1>
	<a href="/Cinema-Luiz_Carlos/listarFilmes">Listar Todos os Filmes</a> <br/>
	<a href="/Cinema-Luiz_Carlos/listarPessoas">Listar Todas os Atores/Diretores</a> <br />
	<a href="/Cinema-Luiz_Carlos/listarAtores">Listar Todas os Atores</a> <br />
	<a href="/Cinema-Luiz_Carlos/listarDiretores">Listar Todas os Diretores</a> <br />
	<a href="/Cinema-Luiz_Carlos/login.html">Logar como Administrador</a> <br />

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
			<tr><td><a href="/Cinema-Luiz_Carlos/listarPorCategoria?idtipocategoria=<%=filme.getIdtipocategoria()%>"><%= filme.getNomecategoria()%></a></td></tr>
		<%}%>
	</table>
</body>
</html>






