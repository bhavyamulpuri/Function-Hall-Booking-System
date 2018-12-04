

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

/**
 * Servlet implementation class regemp
 */
@WebServlet("/regemp")
public class regemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regemp() {
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
		String email=request.getParameter("email");
		String password=request.getParameter("password");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root");
				PreparedStatement pst = con.prepareStatement("insert into employees(username,password,attempt,enable) values(?,?,?,?)");
			      pst.setString(1,email.trim());
			      pst.setString(2,password.trim());
			      pst.setString(3,"0");
			      pst.setString(4,"0");

			      pst.executeUpdate();
			      PreparedStatement pst1 = con.prepareStatement("insert into credentails values(?,?,?,?)");
			      pst1.setString(1,email);
			      pst1.setString(2,password);
			      pst1.setString(3,"3");
			      pst1.setString(4,"1");
			      pst1.executeUpdate();
			      response.sendRedirect("employees.html"); 
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
