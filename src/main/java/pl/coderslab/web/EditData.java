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
import java.util.Iterator;
import java.util.List;

@WebServlet("/editData")
public class EditData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Admin admin = (Admin) session.getAttribute("admin");

        if (StringUtils.isNullOrEmpty(firstName) || StringUtils.isNullOrEmpty(lastName) || StringUtils.isNullOrEmpty(email)) {
            request.setAttribute("adminData", admin);
            getServletContext().getRequestDispatcher("/app-edit-user.jsp").forward(request, response);
        } else {
            if (!admin.getEmail().equals(email)) {
                List<Admin> list = AdminDao.findAll();
                for (Admin a : list) {
                    if (email.equals(a.getEmail())) {
                        request.setAttribute("adminData", admin);
                        getServletContext().getRequestDispatcher("/app-edit-user.jsp").forward(request, response);
                    }
                }
            } else {

                admin.setFirstName(firstName);
                admin.setLastName(lastName);
                admin.setEmail(email);

                AdminDao.update(admin);

                session.setAttribute("admin", admin);
                response.sendRedirect("/dashboard");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Admin admin = (Admin) session.getAttribute("admin");
        request.setAttribute("adminData", admin);

        getServletContext().getRequestDispatcher("/app-edit-user.jsp").forward(request, response);
    }
}
