package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataSource {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("JDBC 드라이버 클래스를 찾을 수 없습니다.");
        }
    }
    static ArrayList<Connection> list = new ArrayList<>();

    synchronized public static Connection getConnection() throws SQLException {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");
    }

    synchronized public static void returnConnection(Connection con) {
        try {
            if (con == null)
                return;
            if (con.isClosed())
                return;
            list.add(con);
        } catch (Exception e) {
        }
    }
}
