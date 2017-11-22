package control;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import domain.Room;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class RoomController extends ArrayList<Room> implements Controller {
    private static final long serialVersionUID = 1L;

    Scanner keyScan = new Scanner(System.in);
    private String dataFilePath;

    public RoomController(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.init();
    }

    @Override
    public void destroy() {

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.dataFilePath)))) {
            for (Room room : this) {
                out.println(room.toCSVString());
            }
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void init() {

        try (BufferedReader in = new BufferedReader(new FileReader(this.dataFilePath));) {

            String csv = null;
            while ((csv = in.readLine()) != null) {
                try {
                    this.add(new Room(csv));
                } catch (CSVFormatException e) {
                    System.err.println("CSV 데이터 형식 오류!");
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
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
    }

    private void doAdd(Request request, Response response) {
        PrintWriter out = response.getWriter();

        out.println("[강의실 등록]");

        Room room = new Room();
        room.setName(request.getParameter("name"));

        if (find(room.getName()) != null) {
            out.println("이미 등록된 강의실입니다.");
            return;
        }

        room.setLocation(request.getParameter("location"));
        room.setCapacity(Integer.parseInt(request.getParameter("capacity")));

        this.add(room);
        out.println("등록했습니다.");
    }

    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        String roomName = request.getParameter("name");

        out.println("[강의실 삭제]");

        Room room = find(roomName);

        if (room == null) {
            out.printf("'%s' 강의실 정보가 없습니다.\n", roomName);
            return;
        }

        this.remove(room);
        out.println("삭제하였습니다.");
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
