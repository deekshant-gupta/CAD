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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/welcome.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection dconn=new DatabaseConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Hello in serv");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		out.write("<html>");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		String query;
		Connection con=DatabaseConnection.getDatabaseConnection();
		try {
			Statement stmt=con.createStatement();
			System.out.println(role);
			if(role.equals("admin")) {
				query="select * from CAD_EMPLOYEE natural join user_role where EMPLOYEE_ID='"+username+"' and pwd='"+password+"'";
             
			}
			else {
				query="select * from CAD_EMPLOYEE  where EMPLOYEE_ID='"+username+"' and pwd='"+password+"'";
			
			}
			
            //step 4 execute query
            ResultSet rs=stmt.executeQuery(query);
            
            Employee emp;
           if(rs.next()) {
        	   HttpSession session=request.getSession();
        	   if(role.equals("employee")) {
        	   emp=new Employee(rs.getString("employee_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email_id"), rs.getString("pwd"), rs.getString("mobile_no"));
        	  // out.write(emp.getFirst_name()+ " "+emp.getLast_name());
        	   session.setAttribute("emp", emp);
        	   request.getRequestDispatcher("update.jsp").forward(request, response);
           }
        	   else {
        		  
        		   List<Employee> employees = dconn.getAllEmployees();
            	 
            	  // out.write(emp.getFirst_name()+ " "+emp.getLast_name());
            	   session.setAttribute("emps", employees);
            	   request.getRequestDispatcher("login-admin.jsp").forward(request, response);
        	   }
           }
   		else {
   			out.write("invalid username or password");
   			RequestDispatcher rd= request.getRequestDispatcher("index.html");
   			rd.include(request, response);
   			
   		}
           //step 5 connection close
          
           con.close();
		}
		 catch (SQLException ex) {
	            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
	            
	        }
	
	
		out.write("</html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

}
}
