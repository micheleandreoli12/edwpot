package ex;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Band
 */
@WebServlet("/ex/Band")
public class Band extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 LocalTime start = (LocalTime) session.getAttribute("start");
		 
		 if (start == null) {
	            session.setAttribute("start", LocalTime.now());
//	            session.setAttribute("01", 0);
//	            session.setAttribute("02", 0);
//	            session.setAttribute("03", 0);
//	            session.setAttribute("04", 0);
//	            session.setAttribute("05", 0);
	            
	            for (int i=1; i<6; i++) {
	            	
	            	String s= "name0"+i;
	            	if (request.getParameter(s) != null) {
	            		session.setAttribute("0"+i, Integer.parseInt(request.getParameter(s)));
	            	} else {
	            		session.setAttribute("0"+i, 0);
	            	}
	            	
	            }
	        } else {
	        	
	        	int vprev1= (int) session.getAttribute("01");
	        	if (request.getParameter("name01") != null) {
	        	int vact1 = Integer.parseInt(request.getParameter("name01"));
	        	session.setAttribute("01", vprev1+ vact1 );
	        	}
	        	else {
	        		session.setAttribute("01", vprev1+ 0 );
	        	}
	        	
	        	int vprev2= (int) session.getAttribute("02");
	        	if (request.getParameter("name02") != null) {
	        	int vact2 = Integer.parseInt(request.getParameter("name02"));
	        	session.setAttribute("02", vprev2+ vact2 );
	        	} else {	        		
	        		session.setAttribute("02", vprev2+ 0 );
	        	}
	        	
	        	int vprev3= (int) session.getAttribute("03");
	        	if (request.getParameter("name03") != null) {
	        	int vact3 = Integer.parseInt(request.getParameter("name03"));
	        	session.setAttribute("03", vprev3+ vact3 );
	        	} else {	        		
	        		session.setAttribute("03", vprev3+ 0 );
	        	}
	        	
	        	int vprev4= (int) session.getAttribute("04");
	        	if (request.getParameter("name04") != null) {
	        	int vact4 = Integer.parseInt(request.getParameter("name04"));
	        	session.setAttribute("04", vprev4+ vact4 );
	        	} else {	        		
	        		session.setAttribute("04", vprev4+ 0 );
	        	}
	        	
	        	int vprev5= (int) session.getAttribute("05");
	        	if (request.getParameter("name05") != null) {
	        	int vact5 = Integer.parseInt(request.getParameter("name05"));
	        	session.setAttribute("05", vprev5+ vact5 );
	        	} else {	        		
	        		session.setAttribute("05", vprev5+ 0 );
	        	}
	        }
		// TODO Auto-generated method stub
		
		
		 response.setContentType("text/html");
         response.setCharacterEncoding("utf-8");
         try (PrintWriter writer = response.getWriter()) {
        	 for (int i=1; i<6; i++) {
	            	
	            	String s= "name0"+i;
	            	if (request.getParameter(s) != null) {
	            		writer.println("You have ordered " + Integer.parseInt(request.getParameter(s)) + " copies of the album " +i);
	            	}
         }
         }
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Band() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
