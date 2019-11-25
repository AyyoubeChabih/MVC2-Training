package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Publisher;

public interface PublisherDao {
	public boolean insert(Publisher a);
	public void update(Publisher a);
	public Publisher delete(int id);
	public Publisher select(int id);
	public List<Publisher> selectAll();
	public List<Publisher> selectLike(String key,Object value);
	public List<Publisher> selectPublishersByTheme(String theme);
}
