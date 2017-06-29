<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Pessoa" %>
    <%@ page import="model.Filme" %>
    <%@ page import="dao.DetalharPessoaDAO" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhar Pessoa</title>
</head>
<body>
<form action="/Cinema-Luiz_Carlos/inicioAdmin"><input type="submit" value="inicio"></form>
<% Pessoa p = (Pessoa) request.getAttribute("Pessoa");%>
<h1><%= p.getNomepessoa() %></h1>
<hr />
<h3>Ocupação:<%out.println(p.getTipoPessoa()); %></h3>
<h3>Data de nascimento:<% out.println(p.getDataDeNascimento()); %></h3>
<h3>Idade:<%out.println(p.getIdade()); %></h3>
<h3>Sexo:<%out.println(p.getSexo()); %></h3>
<table border=1>
<tr><td>Filmes Estrelados/Dirigidos</td><td>Contratado no papel de</td><td>Personagem Interpretado</td></tr>
<%ArrayList<Pessoa> pessoaPersonagem = (ArrayList<Pessoa>) request.getAttribute("pessoaPersonagem"); %>
<% 	for (int i = 0; i < pessoaPersonagem.size(); i++){ 
		out.println("<tr><td>" + "<a href='/Cinema-Luiz_Carlos/detalhaFilmeAdmin?idfilme="+ pessoaPersonagem.get(i).getIdfilme() +"'>" + pessoaPersonagem.get(i).getTitulo() +"</a></td><td> "+ pessoaPersonagem.get(i).getTipoPessoa() + "</td><td>" +pessoaPersonagem.get(i).getPersonagem() +"</td></tr>");}
 %>
</table>
 <hr>
 <form action="/Cinema-Luiz_Carlos/index"><input type="submit" value="Log out"></form>
</body>
</html>