package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

import conn.Connections;

public class DB {
	
	private static Connection getConnection() {
		Connection conn = null;
		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
			try {
				conn = Connections.getProductionConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				conn = Connections.getDevConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}	
}
