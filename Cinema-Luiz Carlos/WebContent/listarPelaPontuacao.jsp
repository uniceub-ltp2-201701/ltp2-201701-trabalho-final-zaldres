<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Filme" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="dao.ListarPorPontuacaoDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Por Pontuacao</title>
</head>
<body>

<% ArrayList<Filme> listarPorPontuacao = (ArrayList<Filme>) request.getAttribute("listarPorPontuacao"); %>
<table border=1>
<tr><td>Lista de filmes por pontuacao</td><td></td></tr>
<%
for (int i = 0; i < listarPorPontuacao.size(); i++){ 
		out.println("<tr><td>" + "<a href='/Cinema-Luiz_Carlos/detalhaFilme?idfilme="+ listarPorPontuacao.get(i).getIdfilme() +"'>" + listarPorPontuacao.get(i).getTitulo() +"</a></td><td>" + listarPorPontuacao.get(i).getPontuacao() + "</td></tr>");}
 %>
</table>
</body>
</html>