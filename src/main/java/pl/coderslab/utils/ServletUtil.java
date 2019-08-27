package pl.coderslab.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;



    public class ServletUtil {

        public static void setCharset(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
        }

    }


