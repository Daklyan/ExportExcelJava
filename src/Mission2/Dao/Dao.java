package Mission2.Dao;

import java.util.ArrayList;

public abstract class Dao<T> {
	protected String table;
	
	public Dao(String table) {
		this.table = table;
	}

	public abstract ArrayList<T> recover();
}
