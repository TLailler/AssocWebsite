package org.servlets.panier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.PanieritemPersistence;
import org.servlets.Utils;

/**
 * Login implementation class Login
 */
@WebServlet(
	name="Clean",
	urlPatterns= {"/Panier/Clean"}
)
public class Clean extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clean() {
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
		
		PanieritemPersistence service = PersistenceServiceProvider.getService(PanieritemPersistence.class);
		service.cleanPanier(userId);
		response.sendRedirect("commands");
		//Utils.ForwardToJSP(request, response, "Récapitulatif des commandes", "/commands");
	}

}
