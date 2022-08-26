package com.revature.service;

import com.revature.repository.*;

import java.util.Hashtable;
import java.util.LinkedHashSet;

import com.revature.models.*;

public class OrmService {

	private OrmDao dao;
	
	public OrmService() {
		super();
		dao = new OrmDaoImp();
	}
	
	public OrmService(OrmDao newDao) {
		super();
		dao = newDao;
	}
	
	public boolean tryConnect(DatabaseInfo info){
		return dao.tryConnect(info);
	}
	
	public Table getTableByName(String tableName) {
		if(!dao.tableExists(tableName)) {
			return null;
		}else {
			return dao.getTableByName(tableName);
		}
	}
	
	public boolean addToTable(String tableName, LinkedHashSet<Hashtable<String, Object>> newRow) {
		if(dao.tableExists(tableName) && dao.typesMatch(tableName, newRow)) {
			return dao.addRow(tableName, newRow);
		}else {
			return false;
		}
	}
	
	public boolean removeMatchingRow(String tableName, LinkedHashSet<Hashtable<String, Object>> toRemove) {
		if(dao.tableExists(tableName) && dao.typesMatch(tableName,toRemove) && dao.containsRow(tableName, toRemove)) {
			return dao.removeRow(tableName, toRemove);
		}else {
			return false;
		}
	}
	
	public boolean updateRow(String tableName, LinkedHashSet<Hashtable<String, Object>> rowToReplace, LinkedHashSet<Hashtable<String, Object>> newRow) {
		if(dao.tableExists(tableName) && dao.typesMatch(tableName, rowToReplace) && dao.typesMatch(tableName, newRow) && dao.containsRow(tableName, rowToReplace)) {
			return dao.updateRow(tableName, rowToReplace, newRow);
		}else {
			return false;
		}
	}

}
