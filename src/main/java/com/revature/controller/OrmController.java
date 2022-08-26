package com.revature.controller;

import java.util.Hashtable;
import java.util.LinkedHashSet;

import com.revature.models.*;
import com.revature.service.*;

public class OrmController{
	
	private OrmService service;
	
	public OrmController() {
		super();
		service = new OrmService();
	}
	
	public OrmController(OrmService newService) {
		super();
		service = newService;
	}
	
	public boolean tryConnect(DatabaseInfo info) {
		return service.tryConnect(info);
	}
	
	public Table getTableByName(String tableName) {
		return service.getTableByName(tableName);
	}
	
	public boolean addToTable(String tableName, LinkedHashSet<Hashtable<String, Object>> newRow) {
		return service.addToTable(tableName, newRow);
	}
	
	public boolean removeMatchingRow(String tableName, LinkedHashSet<Hashtable<String, Object>> toRemove) {
		return service.removeMatchingRow(tableName, toRemove);
	}
	
	public boolean updateRow(String tableName, LinkedHashSet<Hashtable<String, Object>> rowToReplace, LinkedHashSet<Hashtable<String, Object>> newRow) {
		return service.updateRow(tableName, rowToReplace, newRow);
	}
	
	
}
