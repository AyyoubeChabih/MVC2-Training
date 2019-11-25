package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.mappers.BiblioMapper;
import org.mql.biblio.models.Author;
import org.mql.biblio.models.Title;
import org.mql.biblio.jdbc.Database;

public class AuthorDaojdbc implements AuthorDao{

	private Database db;
	private String tablename = "authors";
	public AuthorDaojdbc() {
		super();
	}
	

	public AuthorDaojdbc(Database db) {
		super();
		this.db = db;
	}


	public boolean insert(Author a) {
		return false;
	}

	public void update(Author a) {
		
	}

	public Author delete(int id) {
		return null;
	}

	public Author select(int id) {
		String data[][] = db.select(tablename, "Au_ID", id);
		return BiblioMapper.getAuthor(data[1]);
	}
	
	public List<Author> selectAll() {
		String data[][] = db.selectAll(tablename);
		Vector<Author> authors = new Vector<Author>();
		for (int i = 1; i < data.length; i++) {
			Author a = BiblioMapper.getAuthor( data[i] );
			authors.add(a);
		}
		return authors;
	}

	public List<Author> selectLike(String key, Object value) {
		return null;
	}

	public Database getDb() {
		return db;
	}

	public void setDb(Database db) {
		this.db = db;
	}


	public List<Author> selectAuthorsByPublisher(int id) {
		String isbns[][] = db.select("titles", "Publisher_ID", id);
		if(isbns.length == 1) return null;
		
		List<Author> authors = new Vector<Author>();
		for (int i = 1; i < isbns.length; i++) {
			String isbn = isbns[i][0];
			String data[][] = db.select("title_author", "ISBN", isbn);
			for (int j = 1; j < data.length; j++) {
				String s = data[j][1];
				System.out.println(s);
				authors.add(select(Integer.parseInt(s)));
			}			
		}
		
		return authors;
	}
}
