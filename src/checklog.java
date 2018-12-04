
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

/**
 * Servlet implementation class checklog
 */
@WebServlet("/checklog")
public class checklog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checklog() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/final", "root", "root");
			PreparedStatement ps = con.prepareStatement("SELECT username,password,role,status FROM credentails");
			ps.executeQuery();
			ResultSet res = ps.getResultSet();
			while (res.next()) {
				String s1 = res.getString(1);
				String s2 = res.getString(2);
				String s3 = res.getString(3);
				String s4 = res.getString(4);
				System.out.println(uname);
				System.out.println(password);
				System.out.println(s1);
				System.out.println(s2);
				if (s1.equals(uname) && s2.equals(password)) {
					HttpSession s = request.getSession(true);
					s.setAttribute("uname", new String(uname));
					System.out.println("entered");
					if (s3.equals("0")) {
						i = 10;
					} else if (s3.equals("1")) {
						PreparedStatement ps1 = con
								.prepareStatement("SELECT approve FROM functionhalllogin where username=?");
						ps1.setString(1, s1);
						String s5 = "Null";
						ps1.executeQuery();
						ResultSet res1 = ps1.getResultSet();
						if (res1.next()) {
							s5 = res1.getString(1);
						}
						if (s5.equals("0")) {
							i = 11;
						} else {
							i = 12;
						}
					} else if (s3.equals("2")) {
						i = 13;
					} else if (s3.equals("3")) {
						PreparedStatement ps2 = con
								.prepareStatement("SELECT attempt,enable FROM employees where username=?");
						ps2.setString(1, s1);
						String s5 = "Null";
						String s6 = "Null";
						ps2.executeQuery();
						ResultSet res2 = ps2.getResultSet();
						if (res2.next()) {
							s5 = res2.getString(1);
							s6 = res2.getString(2);
						}
						if (s5.equals("1")) {
							i = 14;
						} else {
							i = 16;
						}
						if (s5.equals("1") && s6.equals("1")) {
							i = 15;
						}
					}
					System.out.println(i);
				}
			}
			System.out.println(i);
			out.println(i);
		} catch (Exception e) {
			out.print(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}