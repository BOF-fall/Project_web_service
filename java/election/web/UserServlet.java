package election.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import election.bean.UserBean;
import election.database.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userdao;
	public void init() {
		userdao = new UserDao();	
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String civilite = request.getParameter("civilite");
		String date_naiss = request.getParameter("date_naiss");
		String cni = request.getParameter("cni");
		String adresse = request.getParameter("adresse");
		String dept = request.getParameter("dept");
		String commune = request.getParameter("commune");
		String bureauvote = request.getParameter("bureauvote");
		String password = request.getParameter("password");
		UserBean user = new UserBean();
		user.setPrenom(prenom);
		user.setNom(nom);
		user.setCivilite(civilite);
		user.setDate_naiss(date_naiss);
		user.setCni(cni);
		user.setAdresse(adresse);
		user.setDept(dept);
		user.setCommune(commune);
		user.setBureauvote(bureauvote);
		user.setPassword(password);
		try {
			userdao.registerUser(user);
		}catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		response.sendRedirect("index.jsp");
		
		
	}

}
