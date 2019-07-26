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
	public SalesDao(ISQLExecutable sqlExecutable) {
		Path path =null;
		try {
			path = PathGenerator.getParentPath(SalesDao.class);
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String PASS_DB_FILE = "jdbc:sqlite:"+path+"/db/sales_note.sqlite";
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
			
		}catch(SQLException e){
			e.printStackTrace();
			System.exit(1);
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
	}
}
