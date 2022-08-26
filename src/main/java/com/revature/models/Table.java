package com.revature.models;

import java.util.Hashtable;
import java.util.LinkedHashSet;


public class Table {
	
	public Table(LinkedHashSet<String> rowTitles, LinkedHashSet<Hashtable<String, Object>> rows) {
		super();
		this.rowTitles = rowTitles;
		this.rows = rows;
	}
	
	public LinkedHashSet<String> rowTitles;
	public LinkedHashSet<Hashtable<String,Object>> rows;
	
	public void addRow(Hashtable<String, Object> newRow) {
		if(!newRow.keySet().equals(rowTitles)) {
			return;
		}
		
		rows.add(newRow);
		return;
	}
	

}
