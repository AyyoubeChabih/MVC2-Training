package org.mql.biblio.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mql.biblio.business.BiblioService;
import org.mql.biblio.business.BiblioServiceDefault;
import org.mql.biblio.dao.AuthorDao;
import org.mql.biblio.dao.TitleDao;
import org.mql.biblio.dao.PublisherDao;
import org.mql.biblio.dao.AuthorDaojdbc;
import org.mql.biblio.dao.TitleDaojdbc;
import org.mql.biblio.dao.PublisherDaojdbc;
import org.mql.biblio.jdbc.DataSource;
import org.mql.biblio.jdbc.Database;
import org.mql.biblio.jdbc.MySQLDataSource;
import org.mql.biblio.web.actions.BiblioAction;
import org.mql.biblio.web.actions.WebContext;
import org.mql.biblio.web.actions.annotations.Url;

@WebServlet({ "/BiblioServlet", "/biblio/*", "*.biblio" })
public class BiblioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String prefix = "/WEB-INF/views/";
	private String suffix = ".jsp";
	private BiblioAction action;
	
	public void init() throws ServletException {
		// Wiring : DI c'est le cablage , pour le framework spring autoWiring
		DataSource ds = new MySQLDataSource("biblio");
		Database db = new Database(ds);
		AuthorDao authorDao = new AuthorDaojdbc(db);
		TitleDao docDao = new TitleDaojdbc(db);
		PublisherDao pubDao = new PublisherDaojdbc(db);
		BiblioService service = new BiblioServiceDefault(authorDao, pubDao, docDao);
		action = new BiblioAction(service);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String keyword = request.getParameter("keyword");
		
		 * Mauvaise solution :
		 
		String[][] data = db.selectLike("titles", "title", keyword);
		StringBuffer s = new StringBuffer("<table style='width:100%;'>\n");
		for (int i = 0; i < data.length; i++) {
			s.append("<tr>");
			for (int j = 0; j < data[i].length; j++) {
				s.append("<td>" + data[i][j] + "</td>");
			}
			s.append("</tr>");
		}
		s.append("</table>");
		
		response.getWriter().println(s);
		*/
		
		String url = request.getRequestURI();
		String view = "Error";
		
		Method methodes[] = action.getClass().getDeclaredMethods();
		for (Method method : methodes) {
			if(method.isAnnotationPresent(Url.class))
				if(url.equals(method.getDeclaredAnnotation(Url.class).url()))
				{
					try {
						view = (String)method.invoke(action,new WebContext(request));
					} catch (Exception e) {
						System.out.println("METHOD ERROR : " + e.getMessage());
					}
				}
		}

		request.getRequestDispatcher(prefix + view + suffix).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
