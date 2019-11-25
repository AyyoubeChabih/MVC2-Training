package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.mappers.BiblioMapper;
import org.mql.biblio.models.Author;
import org.mql.biblio.models.Publisher;
import org.mql.biblio.jdbc.Database;

public class PublisherDaojdbc implements PublisherDao{
	
	private Database db;
	private String tablename = "publishers";
	
	public PublisherDaojdbc(Database db) {
		this.db = db;
		
	}

	@Override
	public boolean insert(Publisher a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Publisher a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Publisher delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Publisher select(int id) {
		String data[][] = db.select(tablename, "Publisher_ID", id);
		return BiblioMapper.getPublisher(data[1]);
	}

	public List<Publisher> selectAll() {
		String data[][] = db.selectAll(tablename);
		Vector<Publisher> publishers = new Vector<Publisher>();
		for (int i = 1; i < data.length; i++) {
			Publisher p = BiblioMapper.getPublisher(data[i]);
			publishers.add(p);
		}
		return publishers;
	}

	@Override
	public List<Publisher> selectLike(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publisher> selectPublishersByTheme(String theme) {
		String data[][] = db.selectLike("titles", "title", theme);
		Vector<Publisher> publishers = new Vector<Publisher>();
		for (int i = 1; i < data.length; i++) {
			Publisher p = select(Integer.parseInt(data[i][3]));
			publishers.add(p);
		}
		return publishers;
	}

}
