package com.revature.controller;

import java.util.Hashtable;
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
	
	public boolean addToTable(String tableName, Hashtable<String, VariableObject> newRow) {
		return service.addToTable(tableName, newRow);
	}
	
	public boolean removeMatchingRow(String tableName, Hashtable<String, VariableObject> toRemove) {
		return service.removeMatchingRow(tableName, toRemove);
	}
	
	public boolean updateRow(String tableName, Hashtable<String, VariableObject> rowToReplace, Hashtable<String, VariableObject> newRow) {
		return service.updateRow(tableName, rowToReplace, newRow);
	}
	
	
}
