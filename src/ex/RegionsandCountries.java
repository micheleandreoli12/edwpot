package ex;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import s21.DaoRegion;

/**
 * Servlet implementation class RegionsandCountries
 */
@WebServlet("/ex/RegionsandCountries")
public class RegionsandCountries extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

    @Resource(name = "jdbc/hr")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoCountry dao = new DaoCountry(ds);
        String s= "select country_id, country_name from regions r natural join countries c where region_id= '";
        String p= "1";
        if (request.getParameter("fav").equals("1") ){
        	s= s + request.getParameter("fav")+"'";
        	request.setAttribute("region", "Europe");
        }
        if (request.getParameter("fav").equals("2")) {
        	s= s + request.getParameter("fav")+"'";
        	request.setAttribute("region", "Americas");
        }
        if (request.getParameter("fav").equals("3")) {
        	s= s + request.getParameter("fav")+"'";
        	request.setAttribute("region", "Asia");
        }
        if (request.getParameter("fav").contentEquals("4")) {
        	s= s + request.getParameter("fav")+"'";
        	request.setAttribute("region", "Middle East and Africa");
        }
        request.setAttribute("countries", dao.getCountries(s));
        request.getRequestDispatcher("/ex/CountriesTable.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionsandCountries() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
