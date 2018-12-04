

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import finall.Email;
/**
 * Servlet implementation class sendpassword
 */
@WebServlet("/sendpassword")
public class sendpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String fromEmail = "planvenue@gmail.com"; //requires valid gmail id
		final String password = "planit@1234"; // correct password for gmail id
		HttpSession s=request.getSession(true);
		 String st=(s.getAttribute("uname").toString());
		final String toEmail = st; // can be any email id 
	    String userpassword="";
		PrintWriter out=response.getWriter();
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root");
			 PreparedStatement ps = con.prepareStatement("SELECT  password FROM credentails WHERE " +
	                    "username = ?");
	            ps.setString(1,st);
        		ps.executeQuery();
	            ResultSet res = ps.getResultSet();
	             String subject=" Password from PLAN_IT_4_U Venue ";
	            if(res.next())
	            {
	        		userpassword = res.getString(1); // can be any email id 
	            }
	             String Body="Password Retrieved is "+userpassword;
	    		Email.sendEmail(fromEmail, password, toEmail, subject, Body);
	    		response.sendRedirect("HomePage.html");

			}
		catch(Exception e)
		{
			out.print(e);
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
