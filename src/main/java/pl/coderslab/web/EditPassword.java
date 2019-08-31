package pl.coderslab.web;

import com.mysql.jdbc.StringUtils;
import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editPassword")
public class EditPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String newPassword = request.getParameter("newPassword");
        String newPasswordRepeat = request.getParameter("newPasswordRepeat");

        if (StringUtils.isNullOrEmpty(newPassword) || StringUtils.isNullOrEmpty(newPasswordRepeat)) {
            Admin admin = (Admin) session.getAttribute("admin");
            request.setAttribute("adminData", admin);
            getServletContext().getRequestDispatcher("/app-edit-password.jsp").forward(request, response);
        } else if (!newPassword.equals(newPasswordRepeat)) {
            Admin admin = (Admin) session.getAttribute("admin");
            request.setAttribute("adminData", admin);
            getServletContext().getRequestDispatcher("/app-edit-password.jsp").forward(request, response);
        } else {
            Admin admin = (Admin) session.getAttribute("admin");
            admin.hashPassword(newPassword);

            AdminDao.update(admin);

            session.setAttribute("admin", admin);
            response.sendRedirect("/dashboard");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Admin admin = (Admin) session.getAttribute("admin");
        request.setAttribute("adminData", admin);

        getServletContext().getRequestDispatcher("/app-edit-password.jsp").forward(request, response);
    }
}
