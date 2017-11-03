package org.servlets.session;

import java.io.IOException;

import javax.persistence.PersistenceContexts;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.demo.persistence.PersistenceServiceProvider;
import org.demo.persistence.services.UtilisateurPersistence;
import org.demo.persistence.services.jpa.UtilisateurPersistenceJPA;

/**
 * Servlet implementation class Login
 */
@WebServlet(
	name="Login",
	urlPatterns= {"/Session/Login"}
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

		// TODO:: check si les tokens sont corrects et si l'utilisateur existe
		
		int userId = 0;
		
		HttpSession session = request.getSession();
		session.setAttribute("login", login);
		session.setAttribute("userId", String.valueOf(userId));
	}

}
