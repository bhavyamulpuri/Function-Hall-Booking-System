

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageDemo1
 */
@WebServlet("/ImageDemo1")
public class ImageDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		byte[] s1 = null;

		String i=(request.getParameter("id"));
		System.out.println(i);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root");
			PreparedStatement ps = con.prepareStatement("SELECT i_photo FROM functionhalllogin where username=? ");
		    ps.setString(1,i);
        		ps.executeQuery();
	            ResultSet res = ps.getResultSet();
						if(res.next())
						{
						    s1 = res.getBytes(1);

						}
						 response.setContentType("image/*");
					       OutputStream o = response.getOutputStream();
					       o.write(s1);
					       o.flush();
					       o.close();
					
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

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
