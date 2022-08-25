package com.revature.controller;

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
	
	public boolean addToTable(String tableName, Row newRow) {
		return service.addToTable(tableName, newRow);
	}
	
	public boolean removeMatchingRow(String tableName, Row toRemove) {
		return service.removeMatchingRow(tableName, toRemove);
	}
	
	public boolean updateRow(String tableName, Row rowToReplace, Row newRow) {
		return service.updateRow(tableName, rowToReplace, newRow);
	}
	
	
}
