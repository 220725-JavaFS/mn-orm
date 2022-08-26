package com.revature.repository;

import java.util.Hashtable;
import java.util.LinkedHashSet;

import com.revature.models.DatabaseInfo;

import com.revature.models.Table;

public class OrmDaoImp implements OrmDao {

	@Override
	public boolean tryConnect(DatabaseInfo info) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Table getTableByName(String tableName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean tableExists(String tableName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean typesMatch(String tableName, LinkedHashSet<Hashtable<String, Object>> testRow) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRow(String tableName, LinkedHashSet<Hashtable<String, Object>> newRow) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsRow(String tableName, LinkedHashSet<Hashtable<String, Object>> toFind) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeRow(String tableName, LinkedHashSet<Hashtable<String, Object>> toRemove) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRow(String tableName, LinkedHashSet<Hashtable<String, Object>> toReplace,
			LinkedHashSet<Hashtable<String, Object>> newRow) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
