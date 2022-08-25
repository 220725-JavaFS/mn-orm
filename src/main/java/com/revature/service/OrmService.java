package com.revature.service;

import com.revature.repository.*;
import com.revature.models.*;

public class OrmService {
	@SuppressWarnings("unused")
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
		return true;
	}
	
	public Table getTableByName(String tableName) {
		return null;
	}
	
	public boolean addToTable(String tableName, Row newRow) {
		return true;
	}
	
	public boolean removeMatchingRow(String tableName, Row toRemove) {
		return true;
	}
	
	public boolean updateRow(String tableName, Row rowToReplace, Row newRow) {
		return true;
	}

}
