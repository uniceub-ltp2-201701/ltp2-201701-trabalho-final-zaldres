<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Filme" %>
    <%@ page import="dao.ListarPorCategoriaDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista da categoria</title>
</head>
<body>
<% ArrayList<Filme> listarPorCategoria = (ArrayList<Filme>) request.getAttribute("listarPorCategoria"); %>
<% Filme f = (Filme) request.getAttribute("Filme");%>

<form action="/Cinema-Luiz_Carlos/index"><input type="submit" value="inicio"></form>
<h1>Lista de <%= listarPorCategoria.get(0).getNomecategoria() %></h1>
<table border=1>

<tr><td>Filmes Encontrados</td>
<% 	for (int i = 0; i < listarPorCategoria.size(); i++){ 
		 out.println("<tr><td>" + "<a href='/Cinema-Luiz_Carlos/detalhaFilme?idfilme="+ listarPorCategoria.get(i).getIdfilme() +"'>" +listarPorCategoria.get(i).getTitulo() +"</a></td></tr>");}
 %>


</table>
</body>
</html>