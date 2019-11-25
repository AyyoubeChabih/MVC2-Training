package org.mql.biblio.web.actions;

public interface Context {
	public String getParameter(String name);
	public void setModel(String key, Object model);
	public Object getModel(String key);
}
