package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.mappers.BiblioMapper;
import org.mql.biblio.dao.mediators.BiblioMediator;
import org.mql.biblio.models.Author;
import org.mql.biblio.models.Title;
import org.mql.biblio.models.Publisher;
import org.mql.biblio.jdbc.Database;

public class TitleDaojdbc implements TitleDao{
	
	private Database db;
	private String tablename = "titles";
	private String relationtable = "title_author";
	private BiblioMediator biblioMediator;
	
	public TitleDaojdbc(Database db) {
		this.db = db;
		biblioMediator = new BiblioMediator(new AuthorDaojdbc(db), new PublisherDaojdbc(db));
	}

	@Override
	public boolean insert(Author a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Author a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Title delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Title select(String isbn) {
		
		String data[][] = db.select(tablename, "ISBN", isbn);
		if(data.length == 1) return null;
		String authorsIDs[][] = db.select(relationtable, "ISBN", isbn);
		
		List<Author> authors = biblioMediator.getBookAuthors(authorsIDs);
		Publisher publisher = biblioMediator.getBookPublisher(data[1][3]);
		
		return BiblioMapper.getTitle(publisher, authors, data[1]);
	}

	public List<Title> selectTitlesByAuthor(int id) {
		String isbns[][] = db.select(relationtable, "Au_ID", id);
		
		if(isbns.length == 1) return null;
		
		List<Title> titles = new Vector<Title>();
		for (int i = 1; i < isbns.length; i++) {
			String isbn = isbns[i][0];
			titles.add(select(isbn));
		}
		
		return titles;
	}

	public List<Title> selectLike(String key) {
		String data[][] = db.selectLike(tablename, "title", key);
		
		if(data.length == 1) return null;
		
		List<Title> titles = new Vector<Title>();
		for (int i = 1; i < data.length; i++) {
			String isbn = data[i][0];
			titles.add(select(isbn));
		}
		
		return titles;
	}

	public List<Title> selectTitlesByPublisher(int id) {
		String data[][] = db.select(tablename, "Publisher_ID", id);
		if(data.length == 1) return null;
		
		List<Title> titles = new Vector<Title>();
		for (int i = 1; i < data.length; i++) {
			String isbn = data[i][0];
			titles.add(select(isbn));
		}
		
		return titles;
	}
}
