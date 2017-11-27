package bitcamp.java100.ch17.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test4 {
    public static void main(String[] args) throws Exception {

        // mysql-connector에 있는 Driver.class 참조
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");

        System.out.println("연결되었습니다!");

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("select * from jdbc_test");

        while (rs.next()) {
            System.out.printf("%d, %s, %s, %s, %d\n", rs.getInt("no"), rs.getString("title"), rs.getString(3),
                    rs.getDate("regdt"), rs.getInt("vwcnt"));
        }

        System.out.println("출력완료!");

        rs.close();
        stmt.close();
        con.close();
    }
}
