<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList" %>
     <%@ page import="model.Pessoa" %>
     <%@page import="dao.ListarPessoasDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atores Registrados</title>
</head>
<body>
<form action="/Cinema-Luiz_Carlos/inicioAdmin"><input type="submit" value="inicio"></form>
<h1>Lista de todos os Atores Registrados</h1>
<table border=1>
<tr><td>Todas as Atores</td></tr>
<% ArrayList<Pessoa> listarPessoas = (ArrayList<Pessoa>) request.getAttribute("listarAtores"); %>

<% 	for (int i = 0; i < listarPessoas.size(); i++){ 
		out.println("<tr><td>" + "<a href='/Cinema-Luiz_Carlos/detalhaPessoaAdmin?idpessoa=" + listarPessoas.get(i).getIdpessoa() +"'>" +listarPessoas.get(i).getNomepessoa() +"</a></tr>");}
 %>
 </table>
 <hr>
<form action="/Cinema-Luiz_Carlos/index"><input type="submit" value="Log out"></form>
</body>
</html>