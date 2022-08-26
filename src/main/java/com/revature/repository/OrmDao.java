package com.revature.repository;

import com.revature.models.*;


public interface OrmDao {
	
	public boolean tryConnect(DatabaseInfo info);
	
	public Table getTableByName(String tableName);
	
	public boolean tableExists(String tableName);
	
	public boolean typesMatch(String tableName, Row testRow);
	
	public boolean addRow(String tableName, Row newRow);
	
	public boolean containsRow(String tableName, Row toFind);
	
	public boolean removeRow(String tableName, Row toRemove);
	
	public boolean updateRow(String tableName, Row toReplace, Row newRow);
}
