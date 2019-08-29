package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;
import pl.coderslab.utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtil.setCharset(request, response);
        HttpSession session = request.getSession();

        String login = request.getParameter("email");
        String password = request.getParameter("password");
        Admin admin = AdminDao.authorizeAdmin(login, password);

        if (admin != null) {
            session.setAttribute("email", login);
            session.setAttribute("id", admin.getId());
            if (admin.getSuperadmin() == 0) {
                getServletContext().getRequestDispatcher("/dashboard.html").forward(request, response);
            } else if (admin.getSuperadmin() == 1) {
                session.setAttribute("superadmin", 1);
                getServletContext().getRequestDispatcher("/super-admin-users.html").forward(request, response);
            }
        }

        response.sendRedirect("/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login.jsp");
    }
}
