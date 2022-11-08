package election.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import election.bean.LoginBean;
import election.database.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	public void init() {
        loginDao = new LoginDao();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String username = request.getParameter("username");
	      String password = request.getParameter("password");
	        LoginBean loginbean = new LoginBean();
	        loginbean.setUsername(username);
	        loginbean.setPassword(password);
	        try {
	            if (loginDao.validate(loginbean)) {
	               HttpSession session = request.getSession();
	                session.setAttribute("username",username);
	                response.sendRedirect("index.html");
	            } else {
	                //HttpSession session = request.getSession();
	                //session.setAttribute("user", username);
	                response.sendRedirect("Connexion.jsp");
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}


