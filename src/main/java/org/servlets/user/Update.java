package org.servlets.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.demo.bean.jpa.UtilisateurEntity;
import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.UtilisateurPersistence;

/**
 * Login implementation class Login
 */
@WebServlet(
	name="UserUpdate",
	urlPatterns= {"/User/Update"}
)
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
			return;
		} else {
			userId = (int)session.getAttribute("userId");
		}
		
		String pwd = request.getParameter("pwd");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String cpStr = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String pays = request.getParameter("pays");
		
		// Récupération du service de gestiond des users
		UtilisateurPersistence service = PersistenceServiceProvider.getService(UtilisateurPersistence.class);
		
		// Récupération de l'utilisateur
		UtilisateurEntity user = service.load(userId);
		
		if (user == null) {
			// TODO:: error page
			return;
		}
		
		// On update le user avec les paramètres passés
		if (pwd != null) user.setPwd(pwd);
		if (nom != null) user.setNom(nom);
		if (prenom != null) user.setPrenom(prenom);
		if (adresse != null) user.setAdresse(adresse);
		if (ville != null) user.setVille(ville);
		if (pays != null) user.setPays(pays);
		
		if (cpStr != null) {
			try {
				int cp = Integer.parseInt(cpStr);
				user.setCodepostal(cp);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				// TODO:: error page
			}
		}
		
		// Insertion
		service.save(user);
	}

}
