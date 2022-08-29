package com.revature.repository;

import java.util.Hashtable;
import com.revature.models.DatabaseInfo;
import com.revature.models.Table;
import com.revature.models.*;
import com.revature.utils.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class OrmDaoImp implements OrmDao {
	
	private DatabaseInfo loginInfo = null;
	
	private Table resultToTable(ResultSet result) {
		Table output = new Table();
		try {
			ResultSetMetaData meta = result.getMetaData();
			for(int i = 1; i <= meta.getColumnCount(); i++) {
				output.columnTitles.add(meta.getColumnName(i));
			}
			while(result.next()) {
				Hashtable<String, VariableObject> nextRow = new Hashtable<String,VariableObject>();
				for(String column : output.columnTitles) {
					if(result.getObject(column) instanceof Integer) {
						nextRow.put(column, new VariableObject((Integer)result.getObject(column)));
					}else if(result.getObject(column) instanceof String) {
						nextRow.put(column, new VariableObject((String)result.getObject(column)));
					}
				}
				output.rows.add(nextRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return output;
	}

	@Override
	public boolean tryConnect(DatabaseInfo info) {
		Connection conn = ConnectionUtil.getConnection(info);
		if(conn == null) {
			return false;
		}else {
			loginInfo = info;
			return true;
		}
	}

	@Override
	public Table getTableByName(String tableName) {
		try {
			Connection conn = ConnectionUtil.getConnection(loginInfo);
			String sql = "SELECT * FROM " + tableName + ";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			return resultToTable(result);
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean tableExists(String tableName) {
		Connection conn = ConnectionUtil.getConnection(loginInfo);
		try {
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet searchResult = meta.getTables(null, null, tableName.toLowerCase(), null);
			while(searchResult.next()) {
				if(searchResult.getString("TABLE_NAME").toLowerCase() == tableName.toLowerCase()) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean typesMatch(String tableName, Hashtable<String,VariableObject> testRow) {
		try {
			Connection conn = ConnectionUtil.getConnection(loginInfo);
			String sql = "SELECT * FROM " + tableName + ";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			ResultSetMetaData meta = result.getMetaData();
			
			if(meta.getColumnCount() != testRow.size()) {
				return false;
			}
			
			for(int i = 1; i <= meta.getColumnCount(); i++) {
				if(testRow.get(meta.getColumnName(i)) != null && Class.forName(meta.getColumnClassName(i)) != testRow.get(meta.getColumnName(i)).getClass()) {
					return false;
				}
			}
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addRow(String tableName, Hashtable<String, VariableObject> newRow) {
		try {
			Connection conn = ConnectionUtil.getConnection(loginInfo);
			StringBuilder sqlFront = new StringBuilder();
			StringBuilder sqlBack = new StringBuilder();
			
			sqlFront.append("Insert INTO " + tableName + "(");
			sqlBack.append("Values (");
			for(String key : newRow.keySet()) {
				sqlFront.append(key + ", ");
				sqlBack.append(newRow.get(key).toSqlString() + ", ");
			}
			sqlFront.delete(sqlFront.length()-2, sqlFront.length()-1);
			sqlBack.delete(sqlBack.length()-2, sqlBack.length()-1);
			sqlFront.append(")");
			sqlBack.append(");");
			
			Statement statement = conn.createStatement();
			String sql = sqlFront.toString() + sqlBack.toString();
			statement.executeQuery(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean containsRow(String tableName, Hashtable<String, VariableObject> toFind) {
		Table toSearch;
		try {
			Connection conn = ConnectionUtil.getConnection(loginInfo);
			String sql = "SELECT * FROM " + tableName + ";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			toSearch = resultToTable(result);
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
		return toSearch.containsRow(toFind);
		
	}

	@Override
	public boolean removeRow(String tableName, Hashtable<String, VariableObject> toRemove) {
		try {
			Connection conn = ConnectionUtil.getConnection(loginInfo);
			StringBuilder sqlBuild = new StringBuilder();
			sqlBuild.append("DELETE FROM " + tableName + "WHERE ");
			
			for(String key : toRemove.keySet()) {
				sqlBuild.append(key + " = " + toRemove.get(key).toSqlString() + " AND ");
			}
			
			sqlBuild.delete(sqlBuild.length()-6, sqlBuild.length()-1);
			sqlBuild.append(";");

			
			Statement statement = conn.createStatement();
			String sql = sqlBuild.toString();
			statement.executeQuery(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateRow(String tableName, Hashtable<String, VariableObject> toReplace, Hashtable<String, VariableObject> newRow) {
		try {
			Connection conn = ConnectionUtil.getConnection(loginInfo);
			StringBuilder sqlBuild = new StringBuilder();
			sqlBuild.append("UPDATE " + tableName + "SET ");
			
			for(String key : newRow.keySet()) {
				sqlBuild.append(key + " = " + newRow.get(key).toSqlString() + ", ");
			}
			
			sqlBuild.delete(sqlBuild.length()-2, sqlBuild.length()-1);
			sqlBuild.append(" WHERE ");
			
			for(String key : toReplace.keySet()) {
				sqlBuild.append(key + " = " + toReplace.get(key).toSqlString() + " AND ");
			}
			
			sqlBuild.delete(sqlBuild.length()-6, sqlBuild.length()-1);
			sqlBuild.append(";");
			
			
			Statement statement = conn.createStatement();
			String sql = sqlBuild.toString();
			statement.executeQuery(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	

}
