package java100.app;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java100.app.util.DataSource;

@WebServlet(urlPatterns="/init", name = "AppInitServlet", loadOnStartup = 1)
@Configuration
@ComponentScan("java100.app")
public class AppInitServlet implements Servlet {

    ServletConfig servletConfig;

    public static AnnotationConfigApplicationContext iocContainer;

    @Bean
    DataSource getDataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/studydb");
        ds.setUsername("study");
        ds.setPassword("1111");
        return ds;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        System.out.println("AppInitServlet.init()");

        this.servletConfig = config;

        iocContainer = new AnnotationConfigApplicationContext(AppInitServlet.class);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("AppInitServlet.service()");
    }

    @Override
    public void destroy() {

        System.out.println("AppInitServlet.destroy()");

        DataSource ds = iocContainer.getBean(DataSource.class);
        ds.close();

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public String getServletInfo() {
        return "이 서블릿은 다른 서블릿을 위한 스프링 IoC 컨테이너를 준비한다.";
    }
}
