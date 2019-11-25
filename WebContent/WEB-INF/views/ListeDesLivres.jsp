<%@page import="org.mql.biblio.models.Title"%>
<%@page import="org.mql.biblio.models.Author"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des livres</title>
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
					<th>ISBN</th>
					<th>Titre</th>
					<th>Date de publication</th>
					<th>Nom d'éditeur</th>
					<th>Nom des auteurs</th>
				</tr>
				<%
				List<Title> list = (List<Title>)request.getAttribute("titles");
				for(Title t : list) {
				%>
				<tr>
					<td><%= t.getIsbn() %></td>
					<td><%= t.getTitle() %></td>
					<td><%= t.getYearPublished() %></td>
					<td><%= t.getPublisher().getName() %></td>
					<td>
					<% List<Author> authors = t.getAuthors(); 
						for(Author author:authors){ %>
						<li><%= author.getName() %></li>
					<% } %>				
					</td>
				</tr>
				<%		
				}
				%>
			</table>
		</div>
	</body>
</html>