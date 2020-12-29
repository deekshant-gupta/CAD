package coe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection dconn=new DatabaseConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(false);
		if(session==null) {
			//session.removeAttribute("username");
		//request.getRequestDispatcher("index.html").forward(request, response);
			response.sendRedirect("index.html");
		}
		String employee_id=request.getParameter("employee_id");
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		String email_id=request.getParameter("email_id");
		long mobile_no=Long.parseLong(request.getParameter("mobile_no"));
		String query="update CAD_EMPLOYEE set first_name='"+first_name+"',last_name='"+last_name+"',email_id='"+email_id+"',mobile_no="+mobile_no+" where employee_id='"+employee_id+"'";
		System.out.println(query);
	
		Connection con=DatabaseConnection.getDatabaseConnection();
		try {
			Statement stmt=con.createStatement();
            
            //step 4 execute query
          ResultSet  rs=stmt.executeQuery(query);
          PrintWriter out=response.getWriter();
          if(rs!=null) {
        	  out.write("<html><script>alert(\"updated profile successfully\")</script></html>");
        	if(session.getAttribute("emps")!=null) {
        		  List<Employee> employees = dconn.getAllEmployees();
             	 
            	  // out.write(emp.getFirst_name()+ " "+emp.getLast_name());
            	   session.setAttribute("emps", employees);
        	  response.sendRedirect("login-admin.jsp");
        	}
        	else if(session.getAttribute("emp")!=null)  {
        		 response.sendRedirect("update.jsp");
        	}
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
