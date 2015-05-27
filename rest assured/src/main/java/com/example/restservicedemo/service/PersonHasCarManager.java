package com.example.restservicedemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonHasCarManager {
	private Connection connection;

	private static final String URL = "jdbc:hsqldb:hsql://localhost/workdb";
	private static final String CREATE_TABLE_PERSON_HAS_CAR = "CREATE TABLE Person_Has_Car(id bigint GENERATED BY DEFAULT AS IDENTITY, personid integer, carid integer)";
	private Statement statement;
	private PreparedStatement addCarToPersonStmt;
	
	public PersonHasCarManager() {
		try {
			connection = DriverManager.getConnection(URL);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Person_Has_Car".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(CREATE_TABLE_PERSON_HAS_CAR);

			addCarToPersonStmt = connection
					.prepareStatement("INSERT INTO Person_Has_Car (personid, carid) VALUES (?, ?)");
//			deleteAllPersonsStmt = connection
//					.prepareStatement("DELETE FROM Person");
//			getAllPersonsStmt = connection
//					.prepareStatement("SELECT id, name, yob FROM Person");
//			getPersonByIdStmt = connection
//					.prepareStatement("SELECT id, name, yob FROM Person where id = ?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	Connection getConnection() {
		return connection;
	}
	
	public void addCarToPerson(int personId, int carId) {
		try {
			addCarToPersonStmt.setInt(1, personId);
			addCarToPersonStmt.setInt(2, carId);
			addCarToPersonStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}