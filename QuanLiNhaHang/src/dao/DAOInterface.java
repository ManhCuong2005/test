package dao;

import java.util.ArrayList;

public interface DAOInterface<T> {
	
	public int insert();
	
	public int update ();
	
	public int delete ();
	
	public void selectAll();
	
	public T selectByID(T t);
	
	public ArrayList<T> selectByCondition (String condition);
}
