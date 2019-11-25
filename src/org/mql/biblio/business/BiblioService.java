package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.models.Author;
import org.mql.biblio.models.Publisher;
import org.mql.biblio.models.Title;

public interface BiblioService {
	public List<Author> authors();
	public Title title(String id);
	public List<Title> titlesByKey(String key);
	public Author author(int id);
	public List<Title> TitleByAuthor(int id);
	public List<Publisher> publishers();
	public Publisher publisher(int id);
	public List<Title> TitleByPublisher(int id);
	public List<Author> authorsByPublisher(int id);
	public List<Publisher> publishersByTheme(String parameter);
}
