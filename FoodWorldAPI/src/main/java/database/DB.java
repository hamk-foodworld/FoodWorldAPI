package database;

import java.sql.Connection;
import java.sql.SQLException;

import com.google.appengine.api.utils.SystemProperty;

import conn.Connections;

public class DB {
	
	public static Connection getConnection() {
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
	
	public static Connection getConnectionCommit() throws SQLException {
		Connection conn = null;
		conn.setAutoCommit(false);
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
