package org.mql.biblio.dao.mediators;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.AuthorDao;
import org.mql.biblio.dao.PublisherDao;
import org.mql.biblio.dao.TitleDao;
import org.mql.biblio.models.Author;
import org.mql.biblio.models.Publisher;
import org.mql.biblio.models.Title;

public class BiblioMediator {
	private AuthorDao authorDao;
	private PublisherDao publisherDao;
	
	
	public BiblioMediator(AuthorDao authorDao, PublisherDao publisherDao) {
		super();
		this.authorDao = authorDao;
		this.publisherDao = publisherDao;
	}

	public List<Author> getBookAuthors(String[][] authorsIDs){
		List<Author> authors = new Vector<Author>();
		for (int i = 1; i < authorsIDs.length; i++) {
			int id = Integer.parseInt(authorsIDs[i][1]);
			authors.add(authorDao.select(id));
		}
		return authors;
	}
	
	public Publisher getBookPublisher(String publisherID) {
		Publisher publisher = publisherDao.select(Integer.parseInt(publisherID));
		return publisher;
	}
}
