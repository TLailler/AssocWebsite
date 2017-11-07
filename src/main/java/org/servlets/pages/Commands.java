package org.servlets.pages;

import org.demo.bean.jpa.ArticleEntity;
import org.demo.bean.jpa.PanieritemEntity;
import org.demo.bean.jpa.StockEntity;
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
            response.sendRedirect("error");
        }
        else
        {
            // mock
            ArticleEntity article = new ArticleEntity();
            article.setNom("Article #1");
            article.setPrix(10f);
            article.setRef(0);

            PanieritemEntity panier = new PanieritemEntity();
            panier.setQte(10);
            panier.setArticle(article);

            PanieritemEntity[] data = {
                    panier,
                    panier,
                    panier,
                    panier,
                    panier,
                    panier,
                    panier
            };

            request.setAttribute("articleList", data);
            Utils.ForwardToJSP(request, response, "Récapitulatif des commandes", "commands");
        }
    }
}
