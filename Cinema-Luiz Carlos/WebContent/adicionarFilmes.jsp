<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/Cinema-Luiz_Carlos/inicioAdmin"><input type="submit" value="inicio"></form>

		<P><BR><HR>
		<H2>Incluir Novo Filme</H2>
		<FORM ACTION='incluiFilme'>
		Titulo: <INPUT TYPE='TEXT' NAME='titulo'><BR>
		Titulo Ingles: <INPUT TYPE='TEXT' NAME='titulo_ingles'><BR>
		Data de Estreia : <INPUT TYPE='TEXT' NAME='datadeestreia'><BR>
	    Pontuação: <INPUT TYPE='TEXT' NAME='pontuacao'><BR>
	    <INPUT TYPE='SUBMIT' VALUE='Incluir'>
		</FORM>
		
		<hr>
		<H2>Criar Nova Categoria de Filme</H2>
		<FORM ACTION='criarGenero'>
		Nome da categoria: <INPUT TYPE='TEXT' NAME='nomecategoria'><BR>
		<INPUT TYPE='SUBMIT' VALUE='Criar'>
		</FORM>
		<hr>
		<form action="/Cinema-Luiz_Carlos/index"><input type="submit" value="Log out"></form>

</body>
</html>