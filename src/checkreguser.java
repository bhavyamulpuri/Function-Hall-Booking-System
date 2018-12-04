import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
		
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkreguser
 */
@WebServlet("/checkreguser")
public class checkreguser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkreguser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root");
			PreparedStatement ps = con.prepareStatement("SELECT username FROM credentails");
        		ps.executeQuery();
	            ResultSet res = ps.getResultSet();
	            String approve="username$";
	            while(res.next())
	            {
	            	approve=approve+";"+res.getString(1)+"$";
	            }
		        out.println(approve);
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