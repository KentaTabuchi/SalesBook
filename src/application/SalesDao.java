package application;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import command.PathGenerator;

public class SalesDao {
	private final String SQLITE_DRIVER = "org.sqlite.JDBC";
	private static Connection con = null;
	public SalesDao(ISQLExecutable sqlExecutable) throws SQLException, URISyntaxException {
		Path path = PathGenerator.getParentPath(SalesDao.class);
		String PASS_DB_FILE = "jdbc:sqlite:"+path+"/db/test.sqlite";
		System.out.println("path=" + path);
		try{
			Class.forName(SQLITE_DRIVER);
		}catch(ClassNotFoundException e){
			System.out.println("JDBCドライバーが見つかりません。");
			System.exit(0);
		}
		
		try{
			System.out.println("sqlite driver connection start.");
			con = DriverManager.getConnection(PASS_DB_FILE);
			sqlExecutable.executeQuery(con); //delegate to an other Class what inherited ISQLExecutable
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
			con.close();
			System.exit(1);
	}
	}	
}
