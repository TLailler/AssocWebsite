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
        if (session.getAttribute("login") == null)
        {
            response.sendRedirect("error");
        }
        else
        {
            PanieritemPersistence service = PersistenceServiceProvider.getService(PanieritemPersistence.class);
            List<PanieritemEntity> tmp = service.getPanierFromUser((int)session.getAttribute("userId"));
            PanieritemEntity[] panier = new PanieritemEntity[tmp.size()];
            for (int i = 0; i < tmp.size(); i++) panier[i] = tmp.get(i);
            request.setAttribute("articleList", panier);
            Utils.ForwardToJSP(request, response, "Mes Commandes", "commands");
        }
    }
}
