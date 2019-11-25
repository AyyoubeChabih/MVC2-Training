package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Author;
import org.mql.biblio.models.Title;

public interface TitleDao {
	public boolean insert(Author a);
	public void update(Author a);
	public Title delete(int id);
	public Title select(String id);
	public List<Title> selectLike(String key);
	public List<Title> selectTitlesByAuthor(int id);
	public List<Title> selectTitlesByPublisher(int id);
}
