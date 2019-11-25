<!-- 1. Tags de directive -->
<!-- definition de configuration du page -->
<!-- importation des package
<%@page import="org.mql.biblio.jdbc.DataSource" %>
<%@page import="org.mql.biblio.jdbc.MySQLDataSource" %> -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <%@include %> include d'autre fragment exterieur -->
<!-- <%@taglib prefix="s" uri="/struts-tags" %> exemple <s:nom></s:nom> etendre la possiblite des balise HTML -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des auteurs</title>
	</head>
	<body>
		<!-- 2. Tags de scripting-->
		<!-- 2.1. Tags de déclaration -->
		<%!
			/*private int p1; // c'est une propriete
			void m1() {
				p1 = 20;
				p2++;
			}*/
		%>
		<!-- 2.2. Tags d'expression : c'est pour afficher, Raccorcie d'affichge html-->
		<%= "JSP" %>
		<%= ((Point)request.getAttribute("nom")).getX() %>
		<!-- 2.2. Scriptlets -->
		<%
			// code Java
			//int x; // variable local de doGet()
			//DataSource ds = new MySQLDataSource("biblio");
			/* je peux pas declare des methodes ici */
			//out.println("<h1>JSP</h1>"); on la faire par les tags d'expression
		%>
		<%!
			//int p2 = 30;
		%>
		<!-- Tag d'action -->
		<!-- <jsp:include page=""></jsp:include> meme chose que include -->
		<!-- Expression EL -->
		<h1 align="${nom.x}""></h1>
		
		<h1>Ceci est une JSP</h1>
	</body>
</html>