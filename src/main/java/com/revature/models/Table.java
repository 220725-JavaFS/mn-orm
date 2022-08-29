package com.revature.models;

import java.util.Hashtable;
import java.util.LinkedHashSet;


public class Table {
	
	public Table() {
		super();
		columnTitles = new LinkedHashSet<String>();
		rows = new LinkedHashSet<Hashtable<String,VariableObject>>();
	}
	
	public Table(LinkedHashSet<String> rowTitles, LinkedHashSet<Hashtable<String,VariableObject>> rows) {
		super();
		this.columnTitles = rowTitles;
		this.rows = rows;
	}
	
	public LinkedHashSet<String> columnTitles;
	public LinkedHashSet<Hashtable<String, VariableObject>> rows;
	
	public void addRow(Hashtable<String,VariableObject> newRow) {
		if(!newRow.keySet().equals(columnTitles)) {
			return;
		}
		
		rows.add(newRow);
		return;
	}
	
	public boolean containsRow(Hashtable<String,VariableObject> toFind) {
		for(Hashtable<String,VariableObject> toCheck : rows) {
			if(rowCompare(toCheck,toFind)) {
				return true;
			}else {
				continue;
			}
		}
		return false;
	}
	
	public static boolean rowCompare(Hashtable<String,VariableObject> a, Hashtable<String,VariableObject> b) {
		for(String key : a.keySet()) {
			if(!b.containsKey(key) || (a.get(key) != b.get(key))) {
				return false;
			}
		}
		return true;
	}
	
	public String toJson() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(Hashtable<String,VariableObject> row : rows) {
			builder.append("{");
			for(String key : row.keySet()) {
				builder.append("\"" + key + "\" : " + row.get(key).toJsonString() + ",");
			}
			builder.delete(builder.length()-1,builder.length());
			builder.append("},");
		}
		if(builder.length() >= 2) {
			builder.delete(builder.length()-1,builder.length());
		}
		builder.append("}");
		return builder.toString();
	}
	

}
