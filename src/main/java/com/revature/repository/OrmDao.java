package com.revature.repository;

import java.util.Hashtable;
import com.revature.models.*;


public interface OrmDao {
	
	public boolean tryConnect(DatabaseInfo info);
	
	public Table getTableByName(String tableName);
	
	public boolean tableExists(String tableName);
	
	public boolean typesMatch(String tableName, Hashtable<String, VariableObject> testRow);
	
	public boolean addRow(String tableName, Hashtable<String, VariableObject> newRow);
	
	public boolean containsRow(String tableName, Hashtable<String, VariableObject> toFind);
	
	public boolean removeRow(String tableName, Hashtable<String, VariableObject> toRemove);
	
	public boolean updateRow(String tableName, Hashtable<String, VariableObject> toReplace, Hashtable<String, VariableObject> newRow);
	
	public static <T> T safeCastTo(Object obj, Class<T> to) {
		if (obj != null) {
            Class<?> c = obj.getClass();
            if (to.isAssignableFrom(c)) {
                return to.cast(obj);
            }
        }
        return null;
	}
}
