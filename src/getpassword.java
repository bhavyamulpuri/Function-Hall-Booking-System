

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
 * Servlet implementation class getpassword
 */
@WebServlet("/getpassword")
public class getpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getpassword() {
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
		String s2=(s.getAttribute("uname").toString());
		String pass="";
     		try {
     			Class.forName("com.mysql.jdbc.Driver");
     			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root");
     			PreparedStatement pst1 = con.prepareStatement("select password from userlogin where username=?");
			      pst1.setString(1,s2);
			      ResultSet res = pst1.executeQuery();
		            if(res.next())
					{
		            pass=res.getString(1);
					}
     			out.println(pass);
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