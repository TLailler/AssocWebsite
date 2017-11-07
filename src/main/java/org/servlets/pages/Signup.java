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
        name = "Signup",
        urlPatterns = {"/signup"}
)
public class Signup extends HttpServlet {
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
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String adresse = request.getParameter("adresse");
            String ville = request.getParameter("ville");
            String pays = request.getParameter("pays");
            Integer cp = null;
            try
            {
                cp = Integer.parseInt(request.getParameter("cp"));
            }
            catch (NumberFormatException ignored) {}

            if (login==null || pwd==null || nom==null || prenom==null || adresse==null || ville==null || pays==null || cp == null)
            {
                if (!(login==null && pwd==null && nom==null && prenom==null && adresse==null && ville==null && pays==null))
                {
                    request.setAttribute("errorMessage", "Oups! Veuillez remplir tous les champs pour vous inscrire!");
                }
                Utils.ForwardToJSP(request, response, "Inscription", "register");
                return;
            }

            // Création de l'utilisateur
            UtilisateurEntity user = new UtilisateurEntity();
            user.setLogin(login);
            user.setPwd(pwd);
            user.setNom(nom);
            user.setPrenom(prenom);
            user.setAdresse(adresse);
            user.setCodepostal(cp);
            user.setVille(ville);
            user.setPays(pays);

            // Récupération du service de gestion des users
            UtilisateurPersistence service = PersistenceServiceProvider.getService(UtilisateurPersistence.class);
            if (!service.checkLogin(login))
            {
                // Insertion de l'utilisateur dans la base
                service.insert(user);
                request.setAttribute("message", "Félicitation, votre inscription a bien été prise en compte!");
                Utils.ForwardToJSP(request, response, "Inscription réussie", "message");
            }
            else {
                request.setAttribute("errorMessage", "Oups! L'identifiant que vous souhaitez n'est pas valide (il est surement déjà prit!)...");
                Utils.ForwardToJSP(request, response, "Inscription", "register");
            }
        }
    }
}
