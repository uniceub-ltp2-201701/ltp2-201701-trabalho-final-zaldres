<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Filme" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalha Filme</title>
</head>
<body>
<form action="/Cinema-Luiz_Carlos/index"><input type="submit" value="inicio"></form>
<% Filme f = (Filme) request.getAttribute("Filme");%>
<h1><%= f.getTitulo() %></h1>
<hr />
<h3>Titulo em ingles:<% out.println(f.getTitulo_ingles()); %></h3>
<h3>Data de estreia:<%out.println(f.getDataDeEstreia()); %></h3>
<h3>Pontuação:<% out.println(f.getPontuacao()); %></h3>
<table border=1>
<tr><td>Elenco do Filme</td><td>Contratado no papel de</td><td>Personagem Interpretado</td></tr>
<%ArrayList<Filme> elencoFilme = (ArrayList<Filme>) request.getAttribute("elencoFilme"); %>
<% 	for (int i = 0; i < elencoFilme.size(); i++){ 
		out.println("<tr><td>" + "<a href='/Cinema-Luiz_Carlos/detalhaPessoa?idpessoa="+ elencoFilme.get(i).getIdpessoa() +"'>" + elencoFilme.get(i).getNomepessoa() +"</a></td><td> "+ elencoFilme.get(i).getTipoPessoa() + "</td><td>" +elencoFilme.get(i).getPersonagem() +"</td></tr>");}
 %>
 </table>
</body>
</html>