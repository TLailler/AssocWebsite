package org.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Utils {
    public static void ForwardToJSP(HttpServletRequest request, HttpServletResponse response, String pageTitle, String view) throws ServletException, IOException {
        request.setAttribute("pageTitle", pageTitle);
        request.setAttribute("includeView", view);
        request.getRequestDispatcher("/WEB-INF/jsp/layout.jsp").forward(request, response);
    }
}
