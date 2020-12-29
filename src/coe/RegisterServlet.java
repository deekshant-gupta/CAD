package coe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String employee_id=request.getParameter("employee_id");
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		String email_id=request.getParameter("email_id");
		String pwd=request.getParameter("pwd");
		long mobile_no=Long.parseLong(request.getParameter("mobile_no"));
		String query="insert into CAD_EMPLOYEE VALUES('"+employee_id+"','"+first_name+"','"+last_name+"','"+email_id+"','"+pwd+"',"+mobile_no+")";
		System.out.println(query);
		Connection con=DatabaseConnection.getDatabaseConnection();
		try {
			Statement stmt=con.createStatement();
            
            //step 4 execute query
          ResultSet  rs=stmt.executeQuery(query);
          PrintWriter out=response.getWriter();
          if(rs!=null) {
        	  out.write("<html>registered successfully<br><a href=\"index.html\">Click here for Login</a></html>");
          }
           //step 5 connection close
           con.close();
           //response.sendRedirect("index.html");
		}
		 catch (SQLException ex) {
	            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
	            
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
