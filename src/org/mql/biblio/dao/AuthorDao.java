package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Author;

public interface AuthorDao {
	public boolean insert(Author a);
	public void update(Author a);
	public Author delete(int id);
	public Author select(int id);
	public List<Author> selectAll();
	public List<Author> selectLike(String key,Object value);
	public List<Author> selectAuthorsByPublisher(int id);
}
