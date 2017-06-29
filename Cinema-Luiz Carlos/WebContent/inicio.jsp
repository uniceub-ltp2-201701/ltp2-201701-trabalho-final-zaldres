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

	<form action="/Cinema/consultarFilme" method="get">
		Buscar por titulo: <input type="text" name="titulo"><p>
		<input type="submit" value="buscar">
	</form>

	<table border=1>
		<tr><td>Listar Por genero</td></tr>
		<%for(Filme filme: filmes){%>
			<tr><td><a href="/Cinema-Luiz_Carlos/listarPorCategoria?idtipocategoria=<%=filme.getIdtipocategoria()%>"><%= filme.getNomecategoria()%></a></td></tr>
		<%}%>
	</table>
</body>
</html>






