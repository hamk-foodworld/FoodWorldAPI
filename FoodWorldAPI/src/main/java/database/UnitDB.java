package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import java.util.ArrayList;

import data.Unit;

public class UnitDB {
	public static ArrayList<Unit> GetUnit() {
		ArrayList<Unit> UnitList = new ArrayList<>();
		Connection conn = DB.getConnection();
		
		try {
			if (conn != null) {
				// get Unit from database				
				Statement stmt = conn.createStatement();
				ResultSet RS = stmt.executeQuery("select * from Unit");
				System.out.println("Connection Succeed");
				while (RS.next()) {
					Unit u = new Unit();
					u.setiID(RS.getInt("id"));
					u.setsName(RS.getString("uname"));

					UnitList.add(u);
				}
				conn.close();
			} else {
				System.out.println("No connection to database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UnitList;
	}
}
