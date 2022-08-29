package com.revature.models;

public class VariableObject {
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof VariableObject) {
			if(((VariableObject) obj).currentType == currentType) {
				return ((VariableObject)obj).toString().equals(this.toString());
			}
		}
		return false;
	}

	private Class<?> currentType = null;
	private Integer intValue = null;
	private String stringValue = null;
	
	public VariableObject() {
		
	}
	
	public VariableObject(Integer newValue) {
		intValue = newValue;
		currentType = newValue.getClass();
	}
	
	public VariableObject(String newValue) {
		stringValue = newValue;
		currentType = newValue.getClass();
	}
	
	public Class<?> getCurrentClass(){
		return currentType;
	}
	
	public Object getAsObject() {
		if(intValue != null) {
			return (Object)intValue;
		}else if(stringValue != null) {
			return (Object)stringValue;
		}else{
			return null;
		}
	}
	
	public String toSqlString() {
		if(intValue != null) {
			return intValue.toString();
		}else if(stringValue != null) {
			return "'" + stringValue + "'";
		}else {
			return "";
		}
	}
	
	public void setValue(Integer newValue) {
		stringValue = null;
		intValue = newValue;
		currentType = newValue.getClass();
	}
	
	public void setValue(String newValue) {
		intValue = null;
		stringValue = newValue;
		currentType = newValue.getClass();
	}
	
	public String toJsonString() {
		if(intValue != null) {
			return intValue.toString();
		}else if(stringValue != null) {
			return "\"" + stringValue + "\"";
		}else {
			return "";
		}
	}
	
	public String toString() {
		if(intValue != null) {
			return intValue.toString();
		}else if(stringValue != null) {
			return stringValue;
		}else {
			return "";
		}
	}
	
	

}
