package org.servlets.panier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.demo.bean.jpa.PanieritemEntity;
import org.demo.bean.jpa.StockEntity;
import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.PanieritemPersistence;
import org.demo.persistence.services.StockPersistence;

/**
 * Login implementation class Login
 */
@WebServlet(
	name="DecreaseArticle",
	urlPatterns= {"/Panier/DecreaseArticle"}
)
public class DecreaseArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecreaseArticle() {
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
			// TODO:: error page
			return;
		}
		
		int ref = 0;
		try {
			ref = Integer.parseInt(refStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			// TODO:: error page
			return;
		}
		
		int qte = 0;
		try {
			qte = Integer.parseInt(qteStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			// TODO:: error page
			return;
		}
		
		// Load the panier service
		PanieritemPersistence panierService = PersistenceServiceProvider.getService(PanieritemPersistence.class);
		
		PanieritemEntity panierItem = panierService.searchItemInPanier(userId, ref);
		if (panierItem != null)
		{
			panierItem.setQte(panierItem.getQte() - qte);
		}
		else
		{
			// TODO:: error page
			return;
		}
		
		// Load the stock service
		StockPersistence stockService = PersistenceServiceProvider.getService(StockPersistence.class);
		StockEntity stock = stockService.load(ref);
		
		if (stock != null)
		{
			stock.setQte(stock.getQte() + qte);
		}
		else {
			// TODO:: error page
			return;
		}

	}

}
