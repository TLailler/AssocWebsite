package org.servlets.stock;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.ArticlePersistence;
import org.demo.persistence.services.StockPersistence;

/**
 * Login implementation class Login
 */
@WebServlet(
	name="DeleteArticle",
	urlPatterns= {"/Stock/DeleteArticle"}
)
public class DeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteArticle() {
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
		
		if (refStr==null) {
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

		// Load the article service
		StockPersistence stockService = PersistenceServiceProvider.getService(StockPersistence.class);
	
		if (stockService.load(ref) == null) {
			stockService.delete(ref);
		} else {
			// TODO:: input error, unknown ref
			return;
		}
		
		// Load the article service
		ArticlePersistence articleService = PersistenceServiceProvider.getService(ArticlePersistence.class);
		articleService.delete(ref);
		
	}

}
