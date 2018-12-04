

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class blockhalldate
 */
@WebServlet("/blockhalldate")
public class blockhalldate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public blockhalldate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession s=request.getSession(true);
		 String name=(s.getAttribute("uname").toString());
		 String date=request.getParameter("date");

     		try {
     			Class.forName("com.mysql.jdbc.Driver");
     			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root");
     			PreparedStatement pst = con.prepareStatement("insert into dates values(?,?,?,?,?,?,?)");
			      pst.setString(1,name);
			      pst.setString(2,"Manually Blocked");
			      pst.setString(3,date);
			      pst.setString(4,"0");
			      pst.setString(5,"Manually Blocked");
			      pst.setString(6,"Manually Blocked");
			      pst.setString(7,"Manually Blocked");


                  pst.executeUpdate();
			      response.sendRedirect("hallpage.html"); 
			}
			 catch (Exception e)
            {
            System.out.println(e);  
            }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
