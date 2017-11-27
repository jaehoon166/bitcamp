package control;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import domain.Board;

public class BoardController extends GenericController<Board> {

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("JDBC 드라이버 클래스를 찾을 수 없습니다.");
        }
    }

    @Override
    public void execute(Request request, Response response) {

        switch (request.getMenuPath()) {
        case "/board/list":
            this.doList(request, response);
            break;
        case "/board/add":
            this.doAdd(request, response);
            break;
        case "/board/view":
            this.doView(request, response);
            break;
        case "/board/update":
            this.doUpdate(request, response);
            break;
        case "/board/delete":
            this.doDelete(request, response);
            break;
        case "main":
            break;
        default:
            response.getWriter().println("해당 명령이 없습니다!");
        }
    }

    private void doList(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[게시물 목록]");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con.prepareStatement("select no,title,conts,regdt,vwcnt from ex_board");
                ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                out.printf("%4d, %4s, %4s, %4s, %4d\n", rs.getInt("no"), rs.getString("title"), rs.getString("conts"),
                        rs.getDate("regdt"), rs.getInt("vwcnt"));
            }

        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doAdd(Request request, Response response) {
        PrintWriter out = response.getWriter();

        out.println("[게시물 등록]");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con
                        .prepareStatement("insert into ex_board(title,conts,regdt) values(?,?,now())");) {

            pstmt.setString(1, request.getParameter("title"));
            pstmt.setString(2, request.getParameter("conts"));

            pstmt.executeUpdate();
            out.println("저장하였습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

    private void doView(Request request, Response response) {
        PrintWriter out = response.getWriter();

        out.println("[게시물 상세 정보]");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con
                        .prepareStatement("select title,conts,regdt,vwcnt from ex_board where no=?");) {

            pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                out.printf("제목: %s\n", rs.getString("title"));
                out.printf("내용: %s\n", rs.getString("conts"));
                out.printf("등록일: %s\n", rs.getDate("regdt"));
                out.printf("조회수: %d\n", rs.getInt("vwcnt"));
            } else {
                out.printf("'%s'의 게시물 정보가 없습니다.\n", request.getParameter("no"));
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doUpdate(Request request, Response response) {
        PrintWriter out = response.getWriter();
        System.out.println("[게시물 변경]");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con
                        .prepareStatement("update ex_board set title=?,conts=?,regdt=now() where no=?");) {

            pstmt.setString(1, request.getParameter("title"));
            pstmt.setString(2, request.getParameter("conts"));
            pstmt.setString(3, request.getParameter("no"));

            if (pstmt.executeUpdate() > 0) {
                out.println("변경하였습니다.");
            } else {
                out.printf("'%s'의 게시물 정보가 없습니다.\n", request.getParameter("no"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[게시물 삭제]");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con.prepareStatement("delete from ex_board where no=?");) {

            pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));

            if (pstmt.executeUpdate() > 0) {
                out.printf("삭제완료!");
            } else {
                out.printf("'%s'게시물 정보가 없습니다.\n", request.getParameter("no"));
            }
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private Board findByNo(int no) {
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            if (board.getNo() == no) {
                return board;
            }
        }
        return null;
    }
}
