<%@page import="org.mql.biblio.models.Author"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Select Auteur</title>
		<link rel="stylesheet" href="../css/index.css" type="text/css" />
		<link rel="stylesheet" href="../css/select.css" type="text/css" />
	</head>
	<body>
		<div class="panel">
			<header>
				<h2><%= request.getAttribute("title") %></h2>
			</header>
			<section>
				<form action="BooksByAuthor"> 
					<select name="author">
						<%
							List<Author> list = (List<Author>)request.getAttribute("authors");
							for(Author a : list) {
						%>
							<option value="<%= a.getId() %>"><%= a.getName() %></option>
							<%		
							}
						%>
					</select>
					<input type="submit" value="rechercher" class="btn"/>
				</form>
			</section>
		</div>
	</body>
</html>