package java100.app.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.AppInitServlet;
import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@WebServlet(urlPatterns = "/member/*")
public class MemberServlet implements Servlet {
    ServletConfig servletConfig;

    MemberDao memberDao;

    @Override
    public void destroy() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        memberDao = AppInitServlet.iocContainer.getBean(MemberDao.class);
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public String getServletInfo() {
        return "회원관리 서블릿";
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setContentType("text/plain;charset=UTF-8");
        switch (httpRequest.getPathInfo()) {
        case "/list":
            this.doList(httpRequest, httpResponse);
            break;
        case "/add":
            this.doAdd(httpRequest, httpResponse);
            break;
        case "/view":
            this.doView(httpRequest, httpResponse);
            break;
        case "/update":
            this.doUpdate(httpRequest, httpResponse);
            break;
        case "/delete":
            this.doDelete(httpRequest, httpResponse);
            break;
        default:
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("[회원 목록]");

        try {

            List<Member> list = memberDao.selectList();

            for (Member member : list) {
                out.printf("%d, %s, %s, %s\n", member.getNo(), member.getName(), member.getEmail(),
                        member.getCreateDate());
            }

        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("[회원 등록]");

        try {

            Member member = new Member();
            member.setName(request.getParameter("name"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));

            memberDao.insert(member);

            out.println("저장하였습니다.");

        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("[회원 상세 정보]");

        try {

            int no = Integer.parseInt(request.getParameter("no"));
            Member member = memberDao.selectOne(no);

            if (member != null) {
                out.printf("번호: %d\n", member.getNo());
                out.printf("이름: %s\n", member.getName());
                out.printf("이메일: %s\n", member.getEmail());
                out.printf("등록일: %s\n", member.getCreateDate());
            } else {
                out.printf("'%d'번의 회원 정보가 없습니다.\n", no);
            }

        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("[회원 변경]");

        try {
            Member member = new Member();
            member.setNo(Integer.parseInt(request.getParameter("no")));
            member.setName(request.getParameter("name"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));

            if (memberDao.update(member) > 0) {
                out.println("변경하였습니다.");
            } else {
                out.printf("'%d'번 회원의 정보가 없습니다.\n", member.getNo());
            }

        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("[회원 삭제]");

        try {

            int no = Integer.parseInt(request.getParameter("no"));

            if (memberDao.delete(no) > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%d'번의 회원 정보가 없습니다.\n", no);
            }

        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
}