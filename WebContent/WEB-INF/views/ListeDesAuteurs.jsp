<%@page import="org.mql.biblio.models.Author"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des auteurs</title>
		<link rel="stylesheet" href="../css/index.css" type="text/css" />
		<link rel="stylesheet" href="../css/table.css" type="text/css" />
	</head>
	<body>
		<div class="panel">
			<header>
				<h2><%= request.getAttribute("title") %></h2>
			</header>
			<table border="1" style="width: 100%; border-collapse: collapse;">
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Date de naissance</th>
				</tr>
				<%
				List<Author> list = (List<Author>)request.getAttribute("authors");
				for(Author a : list) {
				%>
				<tr>
					<td><%= a.getId() %></td>
					<td><%= a.getName() %></td>
					<td><%= a.getYearBorn() %></td>
				</tr>
				<%		
				}
				%>
			</table>
		</div>
	</body>
</html>