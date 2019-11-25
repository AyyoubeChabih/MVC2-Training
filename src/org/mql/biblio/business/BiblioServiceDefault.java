package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.dao.AuthorDao;
import org.mql.biblio.dao.PublisherDao;
import org.mql.biblio.dao.TitleDao;
import org.mql.biblio.models.Author;
import org.mql.biblio.models.Publisher;
import org.mql.biblio.models.Title;

public class BiblioServiceDefault implements BiblioService{
	private AuthorDao authorDao;
	private PublisherDao publisherDao;
	private TitleDao titleDao;
	
	public BiblioServiceDefault() {
	}
	
	public BiblioServiceDefault(AuthorDao authorDao, PublisherDao publisherDao, TitleDao titleDao) {
		super();
		this.authorDao = authorDao;
		this.publisherDao = publisherDao;
		this.titleDao = titleDao;
	}

	public List<Author> authors() {
		return authorDao.selectAll();
	}
	
	public Title title(String id) {
		return titleDao.select(id);
	}

	public List<Title> titlesByKey(String key) {
		return titleDao.selectLike(key);
	}
	
	public AuthorDao getAuthorDao() {
		return authorDao;
	}


	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}


	public PublisherDao getPublisherDao() {
		return publisherDao;
	}


	public void setPublisherDao(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}


	public TitleDao getTitleDao() {
		return titleDao;
	}


	public void setTitleDao(TitleDao titleDao) {
		this.titleDao = titleDao;
	}


	public Author author(int id) {
		return authorDao.select(id);
	}

	public List<Title> TitleByAuthor(int id) {
		return titleDao.selectTitlesByAuthor(id);
	}

	public List<Publisher> publishers() {
		return publisherDao.selectAll();
	}

	public Publisher publisher(int id) {
		return publisherDao.select(id);
	}

	@Override
	public List<Title> TitleByPublisher(int id) {
		return titleDao.selectTitlesByPublisher(id);
	}

	public List<Author> authorsByPublisher(int id) {
		return authorDao.selectAuthorsByPublisher(id);
	}

	public List<Publisher> publishersByTheme(String theme) {
		return publisherDao.selectPublishersByTheme(theme);
	}
}
