package com.revature.service;

import com.revature.repository.*;

import java.util.Hashtable;
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
	
	public boolean addToTable(String tableName, Hashtable<String, VariableObject> newRow) {
		if(!dao.tableExists(tableName)) {
			System.out.println("Table missing in add");
			return false;
		}
		if(!dao.typesMatch(tableName, newRow)) {
			System.out.println("type mismatch in add");
			return false;
		}
		if(!dao.addRow(tableName, newRow)) {
			System.out.println("row add fail");
			return false;
		}
		return true;
	}
	
	public boolean removeMatchingRow(String tableName, Hashtable<String, VariableObject> toRemove) {
		if(!dao.tableExists(tableName)) {
			System.out.println("Table missing in remove");
			return false;
		}
		if(!dao.typesMatch(tableName, toRemove)) {
			System.out.println("type mismatch in remove");
			return false;
		}
		if(!dao.removeRow(tableName, toRemove)) {
			System.out.println("row remove fail");
			return false;
		}
		return true;
	}
	
	public boolean updateRow(String tableName, Hashtable<String, VariableObject> rowToReplace, Hashtable<String, VariableObject> newRow) {

		if(!dao.tableExists(tableName)) {
			System.out.println("Table missing in update");
			return false;
		}
		if(!dao.typesMatch(tableName, rowToReplace)) {
			System.out.println("Type mismatch in update old row");
			return false;
		}
		if(!dao.typesMatch(tableName, newRow)) {
			System.out.println("Type mismatch in update new row");
			return false;
		}
		if(!dao.containsRow(tableName, rowToReplace)) {
			System.out.println("Table missing row to replace");
			return false;
		}
		if(!dao.updateRow(tableName, rowToReplace, newRow)) {
			return false;
		}
		return true;
	}

}
