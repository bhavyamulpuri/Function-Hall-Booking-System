

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
 * Servlet implementation class changepassword
 */
@WebServlet("/changepassword")
public class changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("password2");
		HttpSession s=request.getSession(true);
	     Enumeration ep =s.getAttributeNames();
	     while(ep.hasMoreElements())
		{
			 String s1=(String)ep.nextElement();
			 String s2=(String)s.getAttribute(s1);
			 System.out.print(s2);
			 String username=s2;

     		try {
     			Class.forName("com.mysql.jdbc.Driver");
     			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root");
     			PreparedStatement pst1 = con.prepareStatement("update userlogin set password =? where username=?");
			      pst1.setString(1,uname);
			      pst1.setString(2,s2);
			      pst1.executeUpdate(); 
			      response.sendRedirect("userpage.html"); 
			}
			 catch (Exception e)
            {
            System.out.println(e);
            }
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
