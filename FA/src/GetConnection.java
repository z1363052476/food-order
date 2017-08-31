import java.sql.*;

/*
 * database operation
 */
public class GetConnection {
	public static void main(String[] args) throws SQLException {
		try {
			// 调用Class.forName()方法加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// System.out.println("成功加载MySQL驱动！");
		} catch (ClassNotFoundException e1) {
			System.out.println("找不到MySQL驱动!");
			e1.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/mysql"; // JDBC的URL
		// 调用DriverManager对象的getConnection()方法，获得一个Connection对象
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(url, "root", "");
			// 创建一个Statement对象
			stmt= conn.createStatement(); // 创建Statement对象
			System.out.print("成功连接到数据库！");

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		stmt.close();
		conn.close();
	}



}
