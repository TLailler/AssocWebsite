package org.servlets.pages;

import org.demo.bean.jpa.ArticleEntity;
import org.demo.bean.jpa.PanieritemEntity;
import org.demo.bean.jpa.StockEntity;
import org.demo.bean.jpa.UtilisateurEntity;
import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.ArticlePersistence;
import org.demo.persistence.services.PanieritemPersistence;
import org.demo.persistence.services.StockPersistence;
import org.demo.persistence.services.UtilisateurPersistence;
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
            String refStr = request.getParameter("ref");
            String qteStr = request.getParameter("qte");
            if (refStr != null)
            {
                int qte = 0;
                int ref = 0;
                try {
                    qte = Integer.parseInt(qteStr);
                    ref = Integer.parseInt(refStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    request.setAttribute("errorMessage", "nombre non reconnu");
                    Utils.ForwardToJSP(request, response, "Effectuer une commande", "/command");
                    return;
                }

                // STOCK
                StockPersistence stockService = PersistenceServiceProvider.getService(StockPersistence.class);
                StockEntity stock = stockService.load(ref);
                if (stock != null)
                {
                    if (stock.getQte() >= qte)
                    {
                        stock.setQte(stock.getQte() - qte);
                        stockService.save(stock);
                    }
                    else {
                        request.setAttribute("errorMessage", "Pas assez d'articles en stock");
                        Utils.ForwardToJSP(request, response, "Effectuer une commande", "/command");
                        return;
                    }
                }
                else {
                    response.sendRedirect("error");
                    return;
                }

                UtilisateurPersistence userService = PersistenceServiceProvider.getService(UtilisateurPersistence.class);
                UtilisateurEntity user = userService.load((int)session.getAttribute("userId"));

                // Load the panier service
                PanieritemPersistence panierService = PersistenceServiceProvider.getService(PanieritemPersistence.class);
                PanieritemEntity panierItem = panierService.searchItemInPanier(user.getId(), ref);
                if (panierItem == null)
                {
                    panierItem = new PanieritemEntity();
                    panierItem.setUtilisateur(user);
                    ArticleEntity article = PersistenceServiceProvider.getService(ArticlePersistence.class).load(ref);
                    panierItem.setArticle(article);
                    panierItem.setQte(qte);
                }
                else
                {
                    panierItem.setQte(panierItem.getQte() + qte);
                }
                panierService.save(panierItem);
                response.sendRedirect("commands");
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
}
