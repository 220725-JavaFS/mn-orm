package com.revature.repository;

import java.util.Hashtable;

import com.revature.models.DatabaseInfo;
import com.revature.models.Table;
import com.revature.models.*;

public class FakeOrmDao implements OrmDao{

	@Override
	public boolean tryConnect(DatabaseInfo info) {
		if(info.databaseName == "valid") {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Table getTableByName(String tableName) {
		if(tableName == "valid") {
			return new Table();
		}else {
			return null;
		}
	}

	@Override
	public boolean tableExists(String tableName) {
		if(tableName == "valid") {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean typesMatch(String tableName, Hashtable<String, VariableObject> testRow) {
		if(tableName == "valid" && testRow != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean addRow(String tableName, Hashtable<String, VariableObject> newRow) {
		if(tableName == "valid") {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean containsRow(String tableName, Hashtable<String, VariableObject> toFind) {
		if(toFind != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean removeRow(String tableName, Hashtable<String, VariableObject> toRemove) {
		if(toRemove != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateRow(String tableName, Hashtable<String, VariableObject> toReplace, Hashtable<String, VariableObject> newRow) {
		if(toReplace != null) {
			return true;
		}else {
			return false;
		}
	}

}
