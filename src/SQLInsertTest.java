import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.logging.Logger;





public class SQLInsertTest {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/l1jdb?useUnicode=true&characterEncoding=euckr";
		String id = "root";
		String password = "root";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		return con;
	}

	public static void main(String arg[]) {
		addBook();
		
	}

	 
	private static void addBook() {
		System.out.println("들어옴");
		Connection con = makeConnection();
		try {
			Statement stmt = con.createStatement();
			String s = "INSERT INTO memorize(id,Qustion,Anwser,explanation,category,Level) VALUES (9, 'all' but', '거의 ~할 뻔하다 He all but died of his wounds.', '', 'idoms', '0')";
			System.out.println(s);
			int i = stmt.executeUpdate(s);
			if (i == 1)
				System.out.println("레코드 추가 성공");
			else
				System.out.println("레코드 추가 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}
