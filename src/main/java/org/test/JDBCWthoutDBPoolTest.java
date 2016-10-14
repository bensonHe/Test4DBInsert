package org.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class JDBCWthoutDBPoolTest extends BaseURL {
	public static Long queryTest() throws SQLException {
		Connection con = null;
		Long aid = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passWord);
			PreparedStatement prepare = (PreparedStatement) con
					.prepareStatement("select * from tbl_account_info where account_id = ?");
			prepare.setLong(1, 1001203);
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				aid = (result.getLong("aid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return aid;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(queryTest());
	}
}
