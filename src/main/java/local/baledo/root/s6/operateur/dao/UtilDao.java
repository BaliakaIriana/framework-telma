package local.baledo.root.s6.operateur.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilDao {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection connection;
		Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql:framework-telma","baliaka","blk");
        connection.setAutoCommit(false);
		return connection;
	}
	
}
