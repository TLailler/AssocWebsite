package org.servlets.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.bean.jpa.UtilisateurEntity;
import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.UtilisateurPersistence;

/**
 * Servlet implementation class Login
 */
@WebServlet(
	name="Signup",
	urlPatterns= {"/User/Signup"}
)
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
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
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String ville = request.getParameter("ville");
		String pays = request.getParameter("pays");
		
		
		int cp = 0;
		try {
			cp = Integer.parseInt(request.getParameter("cp"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			// TODO:: error page
			return;
		}
		
		if (login==null||pwd==null||nom==null||prenom==null||adresse==null
				||ville==null||pays==null)
		{
			// TODO:: error page
			return;
		}
		
		// Création de l'utilisateur
		UtilisateurEntity user = new UtilisateurEntity();
		user.setLogin(login);
		user.setPwd(pwd);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setAdresse(adresse);
		user.setCodepostal(cp);
		user.setVille(ville);
		user.setPays(pays);
		
		// Récupération du service de gestiond des users
		UtilisateurPersistence service = PersistenceServiceProvider.getService(UtilisateurPersistence.class);
		
		if (service.checkLogin(login))
		{
			// Insertion de l'utilisateur dans la base
			service.insert(user);
		}
		else {
			// TODO:: input error, login already used
		}
		
	}

}
