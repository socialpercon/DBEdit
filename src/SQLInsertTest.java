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
			System.out.println("����̹� ���� ����");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
		return con;
	}

	public static void main(String arg[]) {
		addBook();
		
	}

	 
	private static void addBook() {
		System.out.println("����");
		Connection con = makeConnection();
		try {
			Statement stmt = con.createStatement();
			String s = "INSERT INTO memorize(id,Qustion,Anwser,explanation,category,Level) VALUES (9, 'all' but', '���� ~�� ���ϴ� He all but died of his wounds.', '', 'idoms', '0')";
			System.out.println(s);
			int i = stmt.executeUpdate(s);
			if (i == 1)
				System.out.println("���ڵ� �߰� ����");
			else
				System.out.println("���ڵ� �߰� ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}