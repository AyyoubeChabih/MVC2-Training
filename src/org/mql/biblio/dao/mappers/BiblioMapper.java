package org.mql.biblio.dao.mappers;

import java.util.List;

import org.mql.biblio.models.Author;
import org.mql.biblio.models.Title;
import org.mql.biblio.models.Publisher;

public class BiblioMapper {

	public static Author getAuthor(String ...row) {
		Author a = new Author();
		a.setName(row[1]);
		try {
			a.setId(Integer.parseInt(row[0]));
			a.setYearBorn(Integer.parseInt(row[2]));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return a;
	}
	
	public static Publisher getPublisher(String...row) {
		Publisher publisher = new Publisher();
		publisher.setId(Integer.parseInt(row[0]));
		publisher.setName(row[1]);
		publisher.setCompany(row[2]);
		return publisher;
	}
	
	public static Title getTitle(Publisher publisher,List<Author> authors,String...row) {
		Title title = new Title(row[0], row[1], Integer.parseInt(row[2]), publisher);
		title.setAuthors(authors);
		return title;
	}
}
