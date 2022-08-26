package com.revature.repository;

import java.util.Hashtable;
import java.util.LinkedHashSet;

import com.revature.models.*;


public interface OrmDao {
	
	public boolean tryConnect(DatabaseInfo info);
	
	public Table getTableByName(String tableName);
	
	public boolean tableExists(String tableName);
	
	public boolean typesMatch(String tableName, LinkedHashSet<Hashtable<String, Object>> testRow);
	
	public boolean addRow(String tableName, LinkedHashSet<Hashtable<String, Object>> newRow);
	
	public boolean containsRow(String tableName, LinkedHashSet<Hashtable<String, Object>> toFind);
	
	public boolean removeRow(String tableName, LinkedHashSet<Hashtable<String, Object>> toRemove);
	
	public boolean updateRow(String tableName, LinkedHashSet<Hashtable<String, Object>> toReplace, LinkedHashSet<Hashtable<String, Object>> newRow);
}
