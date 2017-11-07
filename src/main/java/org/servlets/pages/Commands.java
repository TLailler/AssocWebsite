package org.servlets.pages;

import org.servlets.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "Commands",
        urlPatterns = {"/commands"}
)
public class Commands extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("login") != null)
        {
            request.setAttribute("errorMessage", "Oups! Une petite erreur est survenue!");
            Utils.ForwardToJSP(request, response, "Erreur", "error");
        }
        else
        {

        }
    }
}
