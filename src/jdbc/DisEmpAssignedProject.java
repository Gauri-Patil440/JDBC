/*Assignment 11: Display Employees Assigned to Projects
Tables: employees, employee_projects, projects
Description: Retrieve the names of employees, the projects they are working on, and the number of hours they have worked on each project.
Expected behavior:
Join all three tables using their related IDs.
Display employee name, project name, hours worked, and assigned date.
Filter records based on a project ID entered by the user.
*/

package jdbc;

import java.sql.*;
import java.util.*;

public class DisEmpAssignedProject  {

	public static void main(String[] args) throws Exception{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
		    
			System.out.println("Enter project ID");
            int pid = sc.nextInt();
            
		        PreparedStatement stmt = conn.prepareStatement("SELECT e.emp_name, "
		        		+ "p.project_name,"
		        		+ "ep.hours_worked,"
		        		+ "ep.assigned_date "
		        		+ "FROM "
		        		+ "employee e INNER JOIN emp_project ep "
		        		+ "ON e.emp_id = ep.emp_id INNER JOIN project p "
		        		+ "ON ep.project_id = p.project_id "
		        		+ "WHERE "
		        		+ "p.project_id = ?");
		        		
		        stmt.setInt(1, pid);
		        
		        ResultSet value = stmt.executeQuery();
		        
		        
		        while (value.next()) 
		        {
		           
		            System.out.println("Employee Name=" + value.getString("emp_name"));
		            System.out.println("Project Name=" + value.getString("project_name"));
		            System.out.println("Hours Worked= " + value.getInt("hours_worked"));
		            System.out.println("Assigned Date= " + value.getDate("assigned_date"));
		           
		        }
		}
	}

}
