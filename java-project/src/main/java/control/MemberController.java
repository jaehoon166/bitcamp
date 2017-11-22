package control;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import domain.Member;
import util.Prompts;

public class MemberController extends GenericController<Member> {

    String dataFilePath;

    public MemberController(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.init();
    }

    public MemberController() {
        this.init();
    }

    @Override
    public void destroy() {

        try (FileWriter out = new FileWriter(this.dataFilePath);) {
            for (Member member : this.list) {
                out.write(member.toCSVString() + "\n");
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
                    list.add(new Member(csv));
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
        case "/member/list":
            this.doList(request, response);
            break;
        case "/member/add":
            this.doAdd(request, response);
            break;
        case "/member/view":
            this.doView(request, response);
            break;
        case "/member/update":
            this.doUpdate(request, response);
            break;
        case "/member/delete":
            this.doDelete(request, response);
            break;
        case "main":
            break;
        default:
            System.out.println("해당 명령이 없습니다.");
        }
    }

    private void doList(Request request, Response respons) {
        PrintWriter out = respons.getWriter();
        System.out.println("[회원 목록]");

        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            out.printf("%-4s, %s\n", member.getName(), member.getEmail());
        }
    }

    private void doAdd(Request request, Response response) {

        Member member = new Member();
        member.setEmail(request.getParameter("name"));
        member.setEmail(request.getParameter("email"));

        if (findByEmail(member.getEmail()) != null) {
            System.out.println("이미 등록된 이메일입니다.");
            return;
        }
        list.add(member);

        // member.setName(Prompts.inputString("이름? "));
        // member.setPassword(Prompts.inputString("암호? "));
        PrintWriter out = response.getWriter();
        out.println("저장");
    }

    private void doView(Request request, Response response) {
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        
        out.println("[회원 상세 정보]");
        
        Member member = findByEmail(email);

        if (member == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
            return;
        }

        out.printf("%-4s, %s, %s\n", member.getName(), member.getEmail(), member.getPassword());
    }

    private void doUpdate(Request request, Response response) {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");

        System.out.println("[회원 변경]");
        
        Member member = findByEmail(email);

        if (member == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
            return;
        }

        member.setName(request.getParameter("name"));
        member.setPassword(request.getParameter("password"));
        out.println("변경완료!");
    }

    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        
        System.out.println("[회원 삭제]");

        Member member = findByEmail(email);

        if (member == null) {
            out.printf("'%s'의 회원 정보가 없습니다.\n", email);
        } else {
            out.println("삭제완료!");
        }
    }

    private Member findByEmail(String email) {
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getEmail().equals(email)) {
                return member;
            }
        }
        return null;
    }
}
