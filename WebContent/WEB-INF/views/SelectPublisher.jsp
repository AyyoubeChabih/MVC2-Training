<%@page import="org.mql.biblio.models.Publisher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Select editeur</title>
		<link rel="stylesheet" href="../css/index.css" type="text/css" />
		<link rel="stylesheet" href="../css/select.css" type="text/css" />
	</head>
	<body>
		<div class="panel">
			<header>
				<h2><%= request.getAttribute("title") %></h2>
			</header>
			<section>
				<form action='<%= request.getAttribute("action") %>'>
					<select name="publisher">
						<%
							List<Publisher> list = (List<Publisher>)request.getAttribute("publishers");
							for(Publisher p : list) {
						%>
							<option value="<%= p.getId() %>"><%= p.getName() %></option>
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