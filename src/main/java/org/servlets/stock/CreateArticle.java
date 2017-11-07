package org.servlets.stock;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.bean.jpa.ArticleEntity;
import org.demo.bean.jpa.StockEntity;
import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.ArticlePersistence;
import org.demo.persistence.services.StockPersistence;

/**
 * Login implementation class Login
 */
@WebServlet(
	name="CreateArticle",
	urlPatterns= {"/Stock/CreateArticle"}
)
public class CreateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateArticle() {
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
		String nom = request.getParameter("nom");
		String prixStr = request.getParameter("prixStr");
		
		if (refStr==null||nom==null||prixStr==null) {
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
		
		float prix = 0f;
		try {
			prix = Float.parseFloat(prixStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			// TODO:: error page
			return;
		}
		
		// Create the entity
		ArticleEntity article = new ArticleEntity();
		article.setRef(ref);
		article.setNom(nom);
		article.setPrix(prix);
		
		// Load the article service
		ArticlePersistence articleService = PersistenceServiceProvider.getService(ArticlePersistence.class);
		
		if (articleService.load(ref) == null) {
			articleService.insert(article);
		} else {
			// TODO:: input error, ref already exist
			return;
		}
		
		// Load the article service
		StockPersistence stockService = PersistenceServiceProvider.getService(StockPersistence.class);
		
		StockEntity stock = new StockEntity();
		stock.setArticleref(ref);
		stock.setQte(0);
		
		stockService.insert(stock);
		
	}

}
