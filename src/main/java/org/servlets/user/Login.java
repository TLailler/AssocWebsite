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
	name="UserLogin",
	urlPatterns= {"/User/Login"}
)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		if (login == null || login == null) {
			// TODO:: Error page
			return;
		}

		// Récupération du service Utilisateurs
		UtilisateurPersistence service = PersistenceServiceProvider.getService(UtilisateurPersistence.class);
		
		// Récupération de l'utilisateur si il est en base
		UtilisateurEntity user = service.login(login, pwd);
		
		if (user != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			session.setAttribute("userId", user.getId());
		}
		else {
			// TODO:: inut error, wrong tokens
		}
				
		
	}

}
