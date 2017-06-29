<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList" %>
     <%@ page import="model.Filme" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Todos os Filmes</title>
</head>
<body>
<form action="/Cinema-Luiz_Carlos/inicioAdmin"><input type="submit" value="inicio"></form>
<h1>Lista de Todos os Filmes</h1>
<table border=1>
<tr><td>Filmes do site</td></tr>
 <% ArrayList<Filme> listarFilmes = (ArrayList<Filme>) request.getAttribute("listarFilmes"); %>

<% 	for (int i = 0; i < listarFilmes.size(); i++){ 
		out.println("<tr><td>" + "<a href='/Cinema-Luiz_Carlos/detalhaFilmeAdmin?idfilme="+ listarFilmes.get(i).getIdfilme() +
				"'>"  +listarFilmes.get(i).getTitulo() +"</a></td><TD>" +	
				"<FORM ACTION='excluiFilme'>" + "<INPUT TYPE='HIDDEN' NAME='idfilme' VALUE=" +
						listarFilmes.get(i).getIdfilme() + ">" +"<INPUT TYPE='SUBMIT' VALUE='Excluir'>" +		
				"</FORM></TD></TR>");}
 %>

</table>
 <hr>
<form action="/Cinema-Luiz_Carlos/index"><input type="submit" value="Log out"></form>
</body>
</html>