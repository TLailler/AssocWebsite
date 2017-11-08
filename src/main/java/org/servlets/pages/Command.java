package org.servlets.pages;

import org.demo.bean.jpa.ArticleEntity;
import org.demo.bean.jpa.StockEntity;
import org.demo.bean.jpa.UtilisateurEntity;
import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.StockPersistence;
import org.demo.persistence.services.UtilisateurPersistence;
import org.demo.persistence.services.jpa.ArticlePersistenceJPA;
import org.servlets.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "Command",
        urlPatterns = {"/command"}
)
public class Command extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("login") == null)
        {
            response.sendRedirect("error");
        }
        else
        {
            StockPersistence service = PersistenceServiceProvider.getService(StockPersistence.class);
            List<StockEntity> tmp = service.loadAll();
            StockEntity[] stocks = new StockEntity[tmp.size()];
            for (int i = 0; i < tmp.size(); i++) stocks[i] = tmp.get(i);
            request.setAttribute("articleList", stocks);
            Utils.ForwardToJSP(request, response, "Effectuer une commande", "command");
        }
    }
}
