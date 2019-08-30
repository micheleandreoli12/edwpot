package s08;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s08/checker2")
public class Checker2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");// dall'utente PARAMETRI
        Set<Character> set = new TreeSet<>();
        if (user != null) {
            for (char c : user.toCharArray()) {
                set.add(Character.toLowerCase(c));
            }
        }
        request.setAttribute("set", set);//dal developer ATTRIBUTI
        String s = "";

        if (set == null || set.isEmpty()) {
            s = ("is empty");
        } else {
            s = ("contains these letters:");

            Iterator<Character> it = set.iterator();
            while (it.hasNext()) {
                s=(s + " " + it.next());
            }
           
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
