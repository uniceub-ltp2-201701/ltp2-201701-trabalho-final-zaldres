<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Filme" %>
        <%@ page import="model.Pessoa" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalha Filme</title>
</head>
<body>
<form action="/Cinema-Luiz_Carlos/inicioAdmin"><input type="submit" value="inicio"></form>
<% 

Filme f = (Filme) request.getAttribute("Filme");

%>
<h1><%= f.getTitulo() %></h1>
<hr />
<h3>Titulo em ingles:<% out.println(f.getTitulo_ingles()); %></h3>
<h3>Data de estreia:<%out.println(f.getDataDeEstreia()); %></h3>
<h3>Pontuação:<% out.println(f.getPontuacao()); %></h3>
<table border=1>
<tr><td>Elenco do Filme</td><td>Contratado no papel de</td><td>Personagem Interpretado</td><td>Excluir no Elenco</td></tr>
<%

ArrayList<Filme> elencoFilme = (ArrayList<Filme>) request.getAttribute("elencoFilme");
ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) request.getAttribute("listarPessoas");


%>
<% 

for (int i = 0; i < elencoFilme.size(); i++){ 
out.println("<tr><td>" + "<a href='/Cinema-Luiz_Carlos/detalhaPessoaAdmin?idpessoa="+ elencoFilme.get(i).getIdpessoa() +"'>" + 
elencoFilme.get(i).getNomepessoa() +"</a></td><td> "+ elencoFilme.get(i).getTipoPessoa() + "</td><td>" +elencoFilme.get(i).getPersonagem() +"</td><td>" +
"<FORM ACTION='excluiPessoa'>" + "<input type='hidden' name='idelenco' value=" + elencoFilme.get(i).getIdelenco() + ">" +
"<input type='submit' value='Excluir'></form></td></tr>");}

 %>
 
 <tr>
 <%//name='idfilme' value='" + f.getIdfilme() + "'
 out.println("<form action='/Cinema-Luiz_Carlos/associarPessoaAFilme' method='GET'>");
 
 %>
 <td>
<select name="idpessoa">
<%
for (Pessoa p: pessoas) {
out.println("<option value='" + p.getIdpessoa() + "'>" +  p.getNomepessoa() + "</option>");
}
%>
</select>			
</td>
<td>
<select name='tipopessoa'>
<option  value='1'>Ator</option>
<option  value='2'>Diretor</option>
</select>
</td>
<td>
<input type='text' name='personagem'>
</td>
<td>
<%
out.println("<input type='hidden' name='idfilme' value='" + f.getIdfilme() + "'>" +
			"<input type='submit' name='inserindo' value='Inserir'>");
%>
</td>
</form>
</tr>
 
 </table>
 <hr>
 <form action="/Cinema-Luiz_Carlos/index"><input type="submit" value="Log out"></form>
</body>
</html>