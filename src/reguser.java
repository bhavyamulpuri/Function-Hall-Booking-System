

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finall.Email;

/**
 * Servlet implementation class reguser
 */
@WebServlet("/reguser")
public class reguser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reguser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		final String fromEmail = "planvenue@gmail.com"; //requires valid gmail id
		final String password = "planit@1234"; // correct password for gmail id
		String oname=request.getParameter("name");
		String email=request.getParameter("email");
		final String toEmail = email; // can be any email id 
		String number=request.getParameter("phonenumber");
		String password1=request.getParameter("password");
		String question=request.getParameter("list1");
		String answer=request.getParameter("answer");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root");
				PreparedStatement pst = con.prepareStatement("insert into userlogin values(?,?,?,?,?,?)");
			      pst.setString(1,oname.toLowerCase().trim());
			      pst.setString(2,email.trim());
			      pst.setString(3,number.trim());
			      pst.setString(4,password1.trim());
			      pst.setString(5,question.toLowerCase().trim());
			      pst.setString(6,answer.toLowerCase().trim());
			      pst.executeUpdate();
			      PreparedStatement pst1 = con.prepareStatement("insert into credentails values(?,?,?,?)");
			      pst1.setString(1,email);
			      pst1.setString(2,password1);
			      pst1.setString(3,"2");
			      pst1.setString(4,"1");
			      pst1.executeUpdate();

		          String subject=" User Registration from PLAN_IT_4_U Venue was successful  ";
		          String Body=" Account details are : Username is  "+ email+ " Password is "+password1 ;
		          System.out.println(Body);
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