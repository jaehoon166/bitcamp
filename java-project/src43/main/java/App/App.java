package App;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import Beans.ApplicationContext;
import control.BoardController;
import control.Controller;
import control.MemberController;
import control.Request;
import control.Response;
import control.RoomController;
import control.ScoreController;
import dao.BoardDao;
import dao.MemberDao;
import dao.RoomDao;
import dao.ScoreDao;
import util.DataSource;

public class App {

    ServerSocket ss;
    Scanner keyScan = new Scanner(System.in);

    void init() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/studydb");
        ds.setUserName("study");
        ds.setPassword("1111");

        ScoreDao scoreDao = new ScoreDao();
        scoreDao.setDataSource(ds);

        MemberDao memberDao = new MemberDao();
        memberDao.setDataSource(ds);

        BoardDao boardDao = new BoardDao();
        boardDao.setDataSource(ds);

        RoomDao roomDao = new RoomDao();
        roomDao.setDataSource(ds);

        ScoreController scoreController = new ScoreController();
        scoreController.setScoreDao(scoreDao);
        scoreController.init();
        ApplicationContext.addBean("/score", scoreController);

        MemberController memberController = new MemberController();
        memberController.setMemberDao(memberDao);
        memberController.init();
        ApplicationContext.addBean("/member", memberController);

        BoardController boardController = new BoardController();
        boardController.setBoardScore(boardDao);
        boardController.init();
        ApplicationContext.addBean("/board", boardController);

        RoomController roomController = new RoomController();
        roomController.setRoomDao(roomDao);
        roomController.init();
        ApplicationContext.addBean("/room", roomController);

    }

    void service() throws Exception {
        ss = new ServerSocket(9999);
        System.out.println("서버 실행!");

        while (true) {
            new HttpAgent(ss.accept()).start();
        }
    }

    private void request(String command, PrintWriter out) {

        String menuName = command;

        int i = command.indexOf("/", 1);
        if (i != -1) {
            menuName = command.substring(0, i);
        }

        Object controller = ApplicationContext.getBean(menuName);

        if (controller == null && controller instanceof Controller) {
            out.println("해당 명령을 지원하지 않습니다.");
            return;
        }

        Request request = new Request(command);

        Response response = new Response();
        response.setWriter(out);

        ((Controller) controller).execute(request, response);
    }

    private void hello(String command, PrintWriter out) {
        out.println("안녕하세요. 성적관리 시스템입니다.");
        out.println("[성적관리 명령들]");
        out.println("목록보기: /score/list");
        out.println("상세보기: /score/view?name=이름");
        out.println("등록: /score/add?name=이름&kor=점수&eng=점수&math=점수");
        out.println("변경: /score/update?name=이름&kor=점수&eng=점수&math=점수");
        out.println("삭제: /score/delete?name=이름");
        out.println("[회원]");
        out.println("[게시판]");
        out.println("[강의실]");

    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.init();
        app.service();
    }

    class HttpAgent extends Thread {
        Socket socket;

        public HttpAgent(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Socket socket = this.socket;
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));) {
                String command = in.readLine().split(" ")[1];

                String header = null;
                while (true) {
                    header = in.readLine();
                    if (header.equals(""))
                        break;
                }

                out.println("HTTP/1.1 200 OK");

                out.println("Content-Type:text/plain;charset=UTF-8");

                out.println();

                if (command.equals("/")) {
                    hello(command, out);
                } else {
                    request(command, out);
                }
                out.println();
                out.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}