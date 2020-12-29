package coe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;




public class DatabaseConnection {
	
	public static Connection getDatabaseConnection() {
	//adding comment
		Connection con=null;
		try {
            // TODO code application logic here
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            //step 2 create the connection object
             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:kite","SYSTEM","123");
            
		}
		catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
		return con;
	}
	public List<Employee> getAllEmployees() {
		Connection con=DatabaseConnection.getDatabaseConnection();
		 List<Employee> employees=new ArrayList<Employee>() ;
		try {
			Statement stmt=con.createStatement();
			String query="select * from CAD_EMPLOYEE";
			 ResultSet rs=stmt.executeQuery(query);
			
			 Employee emp=null;
				while (rs.next()) {
					 emp=new Employee(rs.getString("employee_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email_id"), rs.getString("pwd"), rs.getString("mobile_no"));
					employees.add(emp);
				}

				con.close();
	}
	 catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
		
		return employees;
	}
	public Employee getEmployee(String id) {
		Connection con=DatabaseConnection.getDatabaseConnection();
		Employee  emp=null;
		try {
			Statement stmt=con.createStatement();
			String query="select * from CAD_EMPLOYEE where employee_id='"+id+"'";
			 ResultSet rs=stmt.executeQuery(query);
			 if(rs.next()) {
	        	   
	          emp=new Employee(rs.getString("employee_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email_id"), rs.getString("pwd"), rs.getString("mobile_no"));
	        	 
	           }
			 con.close();
				}

	 catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
	 return emp;
	}
	
	public void deleteEmployee(String id) {
		Connection con=DatabaseConnection.getDatabaseConnection();
		try {
			Statement stmt=con.createStatement();
			String query="delete from CAD_EMPLOYEE where employee_id='"+id+"'";
			 ResultSet rs=stmt.executeQuery(query);
			 con.close();
				}

	 catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
	 
	}
}
