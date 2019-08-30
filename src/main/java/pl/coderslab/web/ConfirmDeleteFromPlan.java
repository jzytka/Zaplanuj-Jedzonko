package pl.coderslab.web;

import pl.coderslab.utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/confirmDeleteFromPlan")
public class ConfirmDeleteFromPlan extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtil.setCharset(request, response);
        String id = request.getParameter("id");
        response.getWriter().append("Czy napewno chcesz usunąć przepis z planu?").append("<br><br>")
                .append("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'" +
                        "integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO'" +
                        "          crossorigin='anonymous'>")
                .append("<a href='/delete?id=").append(id).append("&confirm=true'").append("class='btn btn-danger rounded-0 text-light m-1'>Usuń</a>")
                //todo poprawić adres jak będzie istniał servlet kasujący
                .append("<a href='app-details-schedules.jsp' class='btn btn-info rounded-0 text-light m-1'>Anuluj</a>");


    }
}
/*


@WebServlet("/confirmdelete")
public class ConfirmDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

* */