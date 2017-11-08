package org.servlets.pages;

import org.demo.bean.jpa.PanieritemEntity;
import org.demo.bean.jpa.StockEntity;
import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.PanieritemPersistence;
import org.demo.persistence.services.StockPersistence;
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
        name = "CleanCommands",
        urlPatterns = "/cleancart"
)
public class CleanCommands extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = 0;
        if (session == null) {
            response.sendRedirect("error");
            return;
        } else {
            userId = (int)session.getAttribute("userId");
        }

        StockPersistence stockService = PersistenceServiceProvider.getService(StockPersistence.class);
        PanieritemPersistence panierService = PersistenceServiceProvider.getService(PanieritemPersistence.class);
        List<PanieritemEntity> panier = panierService.getPanierFromUser(userId);

        for (PanieritemEntity item : panier)
        {
            StockEntity stock = stockService.load(item.getArticle().getRef());
            stock.setQte(stock.getQte() + item.getQte());
            stockService.save(stock);
        }
        panierService.cleanPanier(userId);
        response.sendRedirect("commands");
    }
}
