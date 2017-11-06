package org.servlets.stock;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.bean.jpa.StockEntity;
import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.StockPersistence;

/**
 * Servlet implementation class Login
 */
@WebServlet(
	name="PutArticle",
	urlPatterns= {"/Stock/PutArticle"}
)
public class PutArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutArticle() {
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
		
		// Load the service
		StockPersistence service = PersistenceServiceProvider.getService(StockPersistence.class);
		
		StockEntity stock = service.load(ref);
		
		if (stock != null) {
			stock.setQte(stock.getQte() + qte);
		} else {
			// TODO:: error page
			return;
		}
		
	}

}
