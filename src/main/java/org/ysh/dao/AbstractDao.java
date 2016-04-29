package org.ysh.dao;

import java.util.List;

public interface AbstractDao<T> {
	
	public void create(T t);
	
	public void update(T t);
	
	public List<T> reverse(T t,boolean fuzzy);
	
	public T query(T t);
	
	public void delete(T t);
}
