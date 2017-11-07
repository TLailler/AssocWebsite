package org.servlets.panier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.demo.bean.jpa.ArticleEntity;
import org.demo.bean.jpa.PanieritemEntity;
import org.demo.bean.jpa.StockEntity;
import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.ArticlePersistence;
import org.demo.persistence.services.PanieritemPersistence;
import org.demo.persistence.services.StockPersistence;
import org.servlets.Utils;

/**
 * Login implementation class Login
 */
@WebServlet(
	name="AddArticle",
	urlPatterns= {"/Panier/AddArticle"}
)
public class AddArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticle() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int userId = 0;
		if (session == null) {
			response.sendRedirect("error");
			return;
		} else {
			userId = (int)session.getAttribute("userId");
		}
		
		String refStr = request.getParameter("ref");
		String qteStr = request.getParameter("qte");
		
		if (refStr==null||qteStr==null) {
			response.sendRedirect("error");
			return;
		}

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

		// Load the stock service
		StockPersistence stockService = PersistenceServiceProvider.getService(StockPersistence.class);
		StockEntity stock = stockService.load(ref);
		
		if (stock != null)
		{
			if (stock.getQte() >= qte)
			{
				stock.setQte(stock.getQte() + qte);
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
		
		// Load the panier service
		PanieritemPersistence panierService = PersistenceServiceProvider.getService(PanieritemPersistence.class);
		
		PanieritemEntity panierItem = panierService.searchItemInPanier(userId, ref);
		if (panierItem == null)
		{
			panierItem = new PanieritemEntity();
			ArticleEntity article =
					PersistenceServiceProvider.getService(ArticlePersistence.class).load(ref);
			panierItem.setArticle(article);
			panierItem.setQte(qte);
		}
		else
		{
			panierItem.setQte(panierItem.getQte() + qte);
		}
		Utils.ForwardToJSP(request, response, "Effectuer une commande", "/command");
	}

}
