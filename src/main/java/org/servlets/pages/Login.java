package org.servlets.pages;

import org.demo.bean.jpa.UtilisateurEntity;
import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.UtilisateurPersistence;
import org.servlets.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "Login",
        urlPatterns = {"/login"}
)
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("login") != null)
        {
            response.sendRedirect("error");
        }
        else
        {
            String login = request.getParameter("login");
            String pwd = request.getParameter("pwd");

            // not attempting to connect
            if (login == null && pwd == null)
            {
                Utils.ForwardToJSP(request, response, "Connexion", "login");
            }
            // attempting to connect
            else
            {
                boolean error = login == null || pwd == null;
                if (!error)
                {
                    UtilisateurPersistence service = PersistenceServiceProvider.getService(UtilisateurPersistence.class);
                    UtilisateurEntity user = service.login(login, pwd);
                    if (user != null)
                    {
                        session.setAttribute("login", login);
                        session.setAttribute("userId", user.getId());
                    }
                    else
                    {
                        error = true;
                    }
                }

                if (error)
                {
                    request.setAttribute("errorMessage", "Oups! La connexion a échoué, veuillez vérifier votre identifiant et votre mot de passe!");
                    Utils.ForwardToJSP(request, response, "Connexion", "login");
                }
                else
                {
                    response.sendRedirect("commands");
                }
            }
        }
    }
}
