/**
 * 
 */
package br.edu.unicid.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Gabriel
 *
 */
public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/escola?useTimezone=true&"
				+ "serverTimezone=UTC";
		String user = "root";
		String pass = "";
		
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static void close(Connection conn) throws SQLException {
		conn.close();
	}
	
	public static void close(Connection conn, PreparedStatement ps) 
			throws SQLException 
	{
		close(conn);
		ps.close();
	}
	
	public static void close(Connection conn, PreparedStatement ps, 
			ResultSet rs) throws SQLException
	{
		close(conn, ps);
		rs.close();
	}
}
