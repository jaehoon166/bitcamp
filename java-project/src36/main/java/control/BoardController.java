package control;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import domain.Board;
import domain.Score;
import util.Prompts;

public class BoardController extends GenericController<Board> {

    String dataFilePath;

    public BoardController(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.init();
    }

    public BoardController() {
        this.init();
    }

    @Override
    public void destroy() {

        try (FileWriter out = new FileWriter(this.dataFilePath);) {
            for (Board board : this.list) {
                out.write(board.toCSVString() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void init() {

        try (FileReader in = new FileReader(this.dataFilePath); Scanner lineScan = new Scanner(in);) {

            String csv = null;
            while (lineScan.hasNextLine()) {
                csv = lineScan.nextLine();
                try {
                    list.add(new Board(csv));
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
        System.out.println("[게시물 목록]");

        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            out.printf("%d, %s, %s, %d\n", board.getNo(), board.getTitle(), board.getRegDate().toString(),
                    board.getViewCount());
        }
    }

    private void doAdd(Request request, Response response) {
        PrintWriter out = response.getWriter();

        out.println("[게시물 등록]");

        Board board = new Board();
        board.setNo(Integer.parseInt(request.getParameter("no")));

        if (findByNo(board.getNo()) != null) {
            System.out.println("이미 등록된 번호입니다.");
            return;
        }

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setRegDate(new Date(System.currentTimeMillis()));

        list.add(board);
        out.println("저장완료!");
    }

    private void doView(Request request, Response response) {
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));

        out.println("[게시물 상세 정보]");
        Board board = findByNo(no);

        if (board == null) {
            System.out.printf("%d번 게시물이 없습니다.\n", no);
            return;
        }

        out.printf("제목: %s\n", board.getTitle());
        out.printf("내용: %s\n", board.getContent());
        out.printf("등록일: %s\n", board.getRegDate().toString());
        board.setViewCount(board.getViewCount() + 1);
        out.printf("조회수: %d\n", board.getViewCount());
    }

    private void doUpdate(Request request, Response response) {
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));

        System.out.println("[게시물 변경]");

        Board board = findByNo(no);

        if (board == null) {
            out.printf("%d번 게시물이 없습니다.\n", no);
            return;
        }
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setRegDate(new Date(System.currentTimeMillis()));
        out.println("변경완료!");
    }

    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));

        out.println("[게시물 삭제]");

        Board board = findByNo(no);

        if (board == null) {
            System.out.printf("%d번 게시물이 없습니다.\n", no);
            return;
        }
        list.remove(board);
        out.println("삭제하였습니다.");
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
