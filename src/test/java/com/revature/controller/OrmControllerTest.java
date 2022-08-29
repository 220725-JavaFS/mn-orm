package com.revature.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Hashtable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import com.revature.service.*;
import com.revature.repository.*;
import com.revature.models.*;


class OrmControllerTest {
	
	static OrmController cont;
	static Hashtable<String,VariableObject> goodHash;

	@BeforeAll
	static void setup() {
		cont = new OrmController(new OrmService(new FakeOrmDao()));
		goodHash = new Hashtable<String,VariableObject>();
	}
	
	@Test
	void testTryConnect() {
		assertTrue(cont.tryConnect(new DatabaseInfo("valid","valid","valid","valid")) == true);
		assertTrue(cont.tryConnect(new DatabaseInfo("","","","")) == false);
	}
	
	@Test
	void testGetTable() {
		assertTrue(cont.getTableByName("valid") != null);
		assertTrue(cont.getTableByName("invalid") == null);
	}
	
	@Test
	void testAddToTable() {
		assertTrue(cont.addToTable("valid", goodHash) == true);
		assertTrue(cont.addToTable("invalid", goodHash) == false);
		assertTrue(cont.addToTable("valid", null) == false);
	}
	
	@Test
	void testRemoveMatchingRow() {
		assertTrue(cont.removeMatchingRow("valid", goodHash) == true);
		assertTrue(cont.removeMatchingRow("valid", null) == false);
		assertTrue(cont.removeMatchingRow("invalid", goodHash) == false);
		assertTrue(cont.removeMatchingRow("invalid", null) == false);
	}
	
	@Test
	void testUpdateRow() {
		assertTrue(cont.updateRow("invalid", null, null) == false);
		assertTrue(cont.updateRow("valid", goodHash, null) == false);
		assertTrue(cont.updateRow("valid", goodHash, goodHash) == true);
	}
	
	

}
