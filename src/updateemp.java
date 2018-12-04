

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class updateemp
 */
@WebServlet("/updateemp")
public class updateemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateemp() {
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
		String oname=request.getParameter("name");
		String number=request.getParameter("phonenumber");
		String hn1=request.getParameter("hn1");
		String hn2=request.getParameter("hn2");
		String hn4=request.getParameter("hn4");
		String hn5=request.getParameter("hn5");
		String hn6=request.getParameter("hn6");
		String hn7=request.getParameter("hn7");
		String hn=hn1+","+hn2+","+hn4+","+hn6+","+hn7;
		String hn8=request.getParameter("hn8");
		 HttpSession s=request.getSession(true);
	     Enumeration ep =s.getAttributeNames();
	     String s2=(s.getAttribute("uname").toString());
		

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root");
				PreparedStatement pst = con.prepareStatement("update employees set name=? , phonenumber=?, Address=?,location=?,proof=?,attempt=? where username=?");
			      pst.setString(1,oname);
			      pst.setString(2,number.trim());
			      pst.setString(3,hn);
			      pst.setString(4,hn5);
			      pst.setString(5,hn8);
			      pst.setString(6,"1");
			      pst.setString(7,s2);
			      
		            int res = pst.executeUpdate();
		            System.out.println(res);
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
