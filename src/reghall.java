

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import finall.Email;

/**
 * Servlet implementation class reghall
 */
@WebServlet("/reghall")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class reghall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reghall() {
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
	      InputStream i1 = null; // input stream of the upload file
	      InputStream i2 = null; // input stream of the upload file
	      InputStream i3 = null; // input stream of the upload file

	         
	        // obtains the upload file part in this multipart request
	        Part f1 = request.getPart("i1");
	            i1 = f1.getInputStream();
	        Part f2 = request.getPart("i2");
	            i2= f2.getInputStream(); 
	        Part f3 = request.getPart("i3");
	            i3 = f3.getInputStream();
	         
	        String message = null;  // message will be sent back to client
	        final String fromEmail = "planvenue@gmail.com"; //requires valid gmail id
			final String password = "planit@1234"; // correct password for gmail id
		String oname=request.getParameter("ownername");
		String email=request.getParameter("email");
		final String toEmail = email; // can be any email id 
		String number=request.getParameter("phonenumber");
		String hallname=request.getParameter("functionhallname");
		String location=request.getParameter("list3");
		String password1=request.getParameter("password");
		String description=request.getParameter("description");
		String doorno=request.getParameter("door");
		String landmark=request.getParameter("landmark");
		String town=request.getParameter("town");
		String state=request.getParameter("state");
		String pincode=request.getParameter("pincode");
		String money=request.getParameter("rent");
		String question=request.getParameter("list1");
		String answer=request.getParameter("answer");
		String ac= request.getParameter("a21");
		String wifi= request.getParameter("a22");
		String powerback= request.getParameter("a23");
		String projector= request.getParameter("a24");
		String roof= request.getParameter("a25");
		String cctv= request.getParameter("a26");
		String sound= request.getParameter("a27");
		String catering= request.getParameter("a28");
		String lift= request.getParameter("a29");
		String rooms= request.getParameter("a30");
		String event= request.getParameter("a31");
		String parking= request.getParameter("a32");
		String mdimen= request.getParameter("d1");
		String mdf= request.getParameter("a34");
		String mmin= request.getParameter("m1");
		String mmax= request.getParameter("m2");
		String hdimen= request.getParameter("d2");
		String hdf= request.getParameter("a38");
		String hmin= request.getParameter("m3");
		String hmax=request.getParameter("m4");
		String ac1,wifi1,powerback1,projector1,roof1,cctv1,sound1,catering1,lift1,rooms1,event1;
		String park="null";
		String hdf1= " ",mdf1 =" ";
		if(ac.equals("1"))
		{
			 ac1="Available ";
		}
		else
		{
			 ac1="Not Available";
		}
		if(wifi.equals("1"))
		{
		 wifi1="Available";
		}
		else
		{
			 wifi1="Not Available";
		}
		if(powerback.equals("1"))
		{
			 powerback1="Available";
		}
		else
		{
		 powerback1="Not Available";
		}
		if(projector.equals("1"))
		{
			 projector1="Available";
		}
		else
		{
			 projector1="Not Available";
		}
		if(roof.equals("1"))
		{
			 roof1="Available";
		}
		else
		{
			 roof1="Not Available";
		}
		if(cctv.equals("1"))
		{
			 cctv1="Available";
		}
		else
		{
			 cctv1="Not Available";
		}
		if(sound.equals("1"))
		{
			 sound1="Available";
		}
		else
		{
			 sound1="Not Available";
		}
		if(catering.equals("1"))
		{
			 catering1="Available";
		}
		else
		{
			 catering1="Not Available";
		}
		if(lift.equals("1"))
		{
			 lift1="Available";
		}
		else
		{
			 lift1="Not Available";
		}
		if(rooms.equals("1"))
		{
			 rooms1="Available";
		}
		else
		{
			 rooms1="Not Available";
		}
		if(event.equals("1"))
		{
			 event1="Available";
		}
		else
		{
			 event1="Not Available";
		}
		if(parking.equals("0"))
		{
			 park="Only Four Wheeler Parking Available";
		}
		else if(parking.equals("1"))
		{
			 park="Only Two Wheeler Parking Available";
		}
		else if(parking.equals("2"))
		{
			 park="Two and Four Wheeler Parking Available";
		}
		if(mdf.equals("0"))
		{
			 mdf1="sq.ft";
		}
		else if(mdf.equals("1"))
		{
			 mdf1="sq.m";
		}
		else if(mdf.equals("2"))
		{
			 mdf1="sq.cm";
		}
		if(hdf.equals("0"))
		{
			 hdf1="sq.ft";
		}
		else if(hdf.equals("1"))
		{
			 hdf1="sq.m";
		}
		else if(hdf.equals("2"))
		{
			 hdf1="sq.cm";
		}


			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root");
				PreparedStatement pst = con.prepareStatement("insert into functionhalllogin values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			      pst.setString(1,oname);
			      pst.setString(2,email);
			      pst.setString(3,number);
			      pst.setString(4,password1);
			      pst.setString(5,question);
			      pst.setString(6,answer.toLowerCase().trim());
			      pst.setString(7,hallname);
			      pst.setString(8,location);
			      pst.setString(9,description);
			      pst.setString(10,"0");
			      pst.setString(11,"0");
			      pst.setString(12,ac1);
			      pst.setString(13,wifi1);
			      pst.setString(14,powerback1);
			      pst.setString(15,projector1);
			      pst.setString(16,roof1);
			      pst.setString(17,cctv1);
			      pst.setString(18,sound1);
			      pst.setString(19,catering1);
			      pst.setString(20,lift1);
			      pst.setString(21,rooms1);
			      pst.setString(22,event1);
			      pst.setString(23,park);
			      pst.setString(24,mdimen);
			      pst.setString(25,mdf1);
			      pst.setString(26,mmin);
			      pst.setString(27,mmax);
			      pst.setString(28,hdimen);
			      pst.setString(29,hdf1);
			      pst.setString(30,hmin);
			      pst.setString(31,hmax);
                  pst.setBlob(32, i1);
                  pst.setBlob(33, i2);
                  pst.setBlob(34, i3);
			      pst.setString(35,doorno);
			      pst.setString(36,landmark);
			      pst.setString(37,town);
			      pst.setString(38,state);
			      pst.setString(39,pincode);
			      pst.setString(40,money);
			      pst.executeUpdate();
			      PreparedStatement pst1 = con.prepareStatement("insert into credentails values(?,?,?,?)");
			      pst1.setString(1,email);
			      pst1.setString(2,password1);
			      pst1.setString(3,"1");
			      pst1.setString(4,"1");
			      pst1.executeUpdate();
			      String subject=" Functionhall Registration from PLAN_IT_4_U Venue was successful  ";
		          String Body=" Account details are : Username is  "+ email+ " Password is "+password1 +" Admin had to apporve your functionhall please wait untill you get a mail that the functionhall had been approved " ;
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
