package control;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import domain.Room;

public class RoomController extends ArrayList<Room> implements Controller {
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
        case "/room/list":
            this.doList(request, response);
            break;
        case "/room/add":
            this.doAdd(request, response);
            break;
        case "/room/delete":
            this.doDelete(request, response);
            break;
        default:
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }

    private void doList(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[강의실 목록]");

        Iterator<Room> iterator = this.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            out.printf("%s, %s, %d\n", room.getLocation(), room.getName(), room.getCapacity());
        }
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con.prepareStatement("select loc,name,capacity from ex_room");
                ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                out.printf("%4s, %4s, %4d\n", rs.getString("loc"), rs.getString("name"), rs.getInt("capacity"));
            }

        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doAdd(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[강의실 등록]");


        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con
                        .prepareStatement("insert into ex_room(loc,name,capacity) values(?,?,?)");) {

            pstmt.setString(1, request.getParameter("loc"));
            pstmt.setString(2, request.getParameter("name"));
            pstmt.setInt(3, Integer.parseInt(request.getParameter("capacity")));

            pstmt.executeUpdate();
            out.println("저장하였습니다.");
            
        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[강의실 삭제]");
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con.prepareStatement("delete from ex_room where name=?");) {

            pstmt.setString(1, request.getParameter("name"));

            if (pstmt.executeUpdate() > 0) {
                out.printf("'%s'의 방 정보가 없습니다.\n", request.getParameter("name"));
            }
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
        
    }

    private Room find(String roomName) {
        Iterator<Room> iterator = this.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            if (room.getName().equals(roomName)) {
                return room;
            }
        }
        return null;
    }
}
