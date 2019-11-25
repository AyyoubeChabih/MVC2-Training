<%@page import="org.mql.biblio.models.Publisher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des editeurs</title>
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
					<th>Company</th>
				</tr>
				<%
				List<Publisher> list = (List<Publisher>)request.getAttribute("publishers");
				for(Publisher p : list) {
				%>
				<tr>
					<td><%= p.getId() %></td>
					<td><%= p.getName() %></td>
					<td><%= p.getCompany() %></td>
				</tr>
				<%		
				}
				%>
			</table>		
		</div>
	</body>
</html>