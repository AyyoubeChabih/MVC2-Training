package org.mql.biblio.web.actions;

import java.util.List;

import org.mql.biblio.web.actions.annotations.Url;
import org.mql.biblio.business.BiblioService;
import org.mql.biblio.models.Author;
import org.mql.biblio.models.Publisher;
import org.mql.biblio.models.Title;

public class BiblioAction {
	
	private BiblioService service;
	public BiblioAction() {
		
	}
	public BiblioAction(BiblioService service) {
		this.service = service;
	}
	public void setService(BiblioService service) {
		this.service = service;
	}
	
	@Url(url = "/P02-MVC2/biblio/ListeDesAuteurs")
	public String listDesAuteurs(Context context) {
		List<Author> list = service.authors();
		context.setModel("authors", list);
		context.setModel("title", "liste de touts les auteurs");
		return "ListeDesAuteurs";
	}
	
	@Url(url = "/P02-MVC2/biblio/SearchBook")
	public String bookByID(Context context) {
		List<Title> titles = service.titlesByKey(context.getParameter("key"));
		if(titles != null) {
			context.setModel("title", "Liste des livres dont son titre contenant la mot " + context.getParameter("key"));
			context.setModel("titles", titles);
			return "ListeDesLivres";
		}
		else {
			context.setModel("error", "book not found");
			return "Error";
		}
	}
	
	@Url(url = "/P02-MVC2/biblio/SelectAuthor")
	public String selectAuthor(Context context) {
		List<Author> list = service.authors();
		if(list != null) {
			context.setModel("authors", list);
			context.setModel("title", "Selectioner un auteur");
			return "SelectAuthor";
		}
		else {
			context.setModel("error", "authors not found");
			return "Error";
		}
	}
	
	@Url(url = "/P02-MVC2/biblio/BooksByAuthor")
	public String booksByAuthor(Context context) {
		Author author = service.author(Integer.parseInt(context.getParameter("author")));
		List<Title> list = service.TitleByAuthor(author.getId());
		if(list != null) {
			context.setModel("titles", list);
			context.setModel("title", "Liste de tous les livres écrite par : " + author.getName());
			return "ListeDesLivres";
		}
		else {
			context.setModel("error", "books not found");
			return "Error";
		}
	}
	
	@Url(url = "/P02-MVC2/biblio/SelectPublisher")
	public String selectPublisher(Context context) {
		List<Publisher> list = service.publishers();
		if(list != null) {
			context.setModel("publishers", list);
			context.setModel("title", "Selectioner un éditeur");
			context.setModel("action", "BooksByPublisher");
			return "SelectPublisher";
		}
		else {
			context.setModel("error", "publishers not found");
			return "Error";
		}
	}	
	
	@Url(url = "/P02-MVC2/biblio/BooksByPublisher")
	public String booksByPublisher(Context context) {
		Publisher publisher = service.publisher(Integer.parseInt(context.getParameter("publisher")));
		List<Title> list = service.TitleByPublisher(publisher.getId());
		if(list != null) {
			context.setModel("titles", list);
			context.setModel("title", "Liste de tous les livres publié par : " + publisher.getName());
			return "ListeDesLivres";
		}
		else {
			context.setModel("error", "books not found");
			return "Error";
		}
	}
	
	@Url(url = "/P02-MVC2/biblio/SelectPublisher2")
	public String selectPublisher2(Context context) {
		List<Publisher> list = service.publishers();
		if(list != null) {
			context.setModel("publishers", list);
			context.setModel("title", "Selectioner un éditeur");
			context.setModel("action", "AuthorsByPublisher");
			return "SelectPublisher";
		}
		else {
			context.setModel("error", "publishers not found");
			return "Error";
		}
	}	

	@Url(url = "/P02-MVC2/biblio/AuthorsByPublisher")
	public String authorsByPublisher(Context context) {
		Publisher publisher = service.publisher(Integer.parseInt(context.getParameter("publisher")));
		List<Author> list = service.authorsByPublisher(publisher.getId());
		if(list != null) {
			context.setModel("authors", list);
			context.setModel("title", "Liste des auteurs qui ont écrit des livres publiés par l'éditeur " + publisher.getName());
			return "ListeDesAuteurs";
		}
		else {
			context.setModel("error", "authors not found");
			return "Error";
		}
	}	
	
	@Url(url = "/P02-MVC2/biblio/PublishersByTheme")
	public String publishersByTheme(Context context) {
		List<Publisher> publishers = service.publishersByTheme(context.getParameter("theme"));
		if(publishers != null) {
			context.setModel("title", "Liste des éditeurs ayant publiés des livres qui ont la thematique " + context.getParameter("theme"));
			context.setModel("publishers", publishers);
			return "ListeDesEditeurs";
		}
		else {
			context.setModel("error", "publishers not found");
			return "Error";
		}
	}
	
	// String c'est le chemin de vue ; mauvais solution HttpServletRequest request comme parametre
}
