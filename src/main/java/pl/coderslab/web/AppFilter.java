package pl.coderslab.web;

import pl.coderslab.model.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("*")
public class AppFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        String URL = request.getRequestURL().toString();

        if (URL.matches("(http://localhost:8080/app.*)||(http://localhost:8080/dashboard)||(http://localhost:8080/super-admin-users.html)")) {
            Admin admin = (Admin) session.getAttribute("admin");
            if (admin == null) {
                response.sendRedirect("/login");
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}
