package control;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import domain.Score;
import util.Prompts;

public class ScoreController extends GenericController<Score> {

    String dataFilePath;

    public ScoreController(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.init();
    }

    @Override
    public void destroy() {

        try (FileWriter out = new FileWriter(this.dataFilePath);) {
            for (Score score : this.list) {
                out.write(score.toCSVString() + "\n");
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
                    list.add(new Score(csv));
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
        case "/score/add":
            this.doAdd(request, response);
            break;
        case "/score/list":
            this.doList(request, response);
            break;
        case "/score/view":
            this.doView(request, response);
            break;
        case "/score/update":
            this.doUpdate(request, response);
            break;
        case "/score/delete":
            this.doDelete(request, response);
            break;
        case "main":
            break;
        default:
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }

    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        System.out.println("[성적 삭제]");

        Score score = findByName(name);

        if (score == null) {
            out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            list.remove(score);
            out.println("삭제하였습니다.");
        }
    }

    private void doUpdate(Request request, Response response) {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");

        out.println("[성적 변경]");

        Score score = findByName(name);

        if (score == null) {
            out.printf("'%s'의 성적 정보가 없습니다.\n", name);
            return;
        }
        score.setKor(Integer.parseInt(request.getParameter("kor")));
        score.setEng(Integer.parseInt(request.getParameter("eng")));
        score.setMath(Integer.parseInt(request.getParameter("math")));

        out.println("변경하였습니다!");
    }

    private void doView(Request request, Response response) {
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        Score score = findByName(name);

        out.println("[성적 상세 정보]");

        if (score == null) {
            out.printf("'%s'의 성적 정보가 없습니다.\n", name);
            return;
        }

        out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n", score.getName(), score.getKor(), score.getEng(),
                score.getMath(), score.getSum(), score.getAver());
    }

    private void doList(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[성적 목록]");

        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score score = iterator.next();
            out.printf("%-4s, %4d, %6.1f\n", score.getName(), score.getSum(), score.getAver());
        }
    }

    private void doAdd(Request request, Response response) {

        Score score = new Score();
        score.setName(request.getParameter("name"));
        score.setKor(Integer.parseInt(request.getParameter("kor")));
        score.setEng(Integer.parseInt(request.getParameter("eng")));
        score.setMath(Integer.parseInt(request.getParameter("math")));

        list.add(score);

        PrintWriter out = response.getWriter();
        out.println("저장하였습니다.");
    }

    private Score findByName(String name) {
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score score = iterator.next();
            if (score.getName().equals(name)) {
                return score;
            }
        }
        return null;
    }
}
