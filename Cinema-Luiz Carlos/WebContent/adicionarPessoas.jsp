<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicione Pessoas no Banco de dados</title>
</head>
<body>
<form action="/Cinema-Luiz_Carlos/inicioAdmin"><input type="submit" value="inicio"></form>
		<P><BR><HR>
		<H2>Incluir Nova Pessoa</H2>
		<FORM ACTION='incluiPessoa'>
		Nome da Pessoa: <INPUT TYPE='TEXT' NAME='nomepessoa'><BR>
		Data de nascimento: <INPUT TYPE='TEXT' NAME='datadenascimento'><BR>
		Idade : <INPUT TYPE='TEXT' NAME='idade'><BR>
		Sexo: <INPUT TYPE='TEXT' NAME='sexo'><BR>
		<INPUT TYPE='SUBMIT' VALUE='Incluir'>
		</FORM>
		
		
		<hr>
		<form action="/Cinema-Luiz_Carlos/index"><input type="submit" value="Log out"></form>
</body>
</html>