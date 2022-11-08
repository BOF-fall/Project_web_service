package election.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import election.bean.VoterBean;
import election.database.VoterDao;

/**
 * Servlet implementation class VoterServlet
 */
@WebServlet("/VoterServlet")
public class VoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDao voterdao;
	public void init() {
        voterdao = new VoterDao();
    }
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoterServlet() {
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
		String numero = request.getParameter("numero");
		String candidat = request.getParameter("candidat");
		VoterBean voterbean = new VoterBean();
		voterbean.setNumero(numero);
		voterbean.setCandidat(candidat);
		try {
			voterdao.RegisterVoter(voterbean);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect("voteenregister.jsp");
		
		
	}

}
