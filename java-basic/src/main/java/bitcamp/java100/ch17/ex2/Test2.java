package bitcamp.java100.ch17.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test2 {
    public static void main(String[] args) throws Exception {

        // mysql-connector에 있는 Driver.class 참조
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");

        System.out.println("연결되었습니다!");

        Statement stmt = con.createStatement();

        stmt.executeUpdate("update jdbc_test set title='xxx', conts='xxxx' where no=1");
        System.out.println("변경완료!");

        stmt.close();
        con.close();
    }
}
