/*Assignment 10: Display All Departments and Their Employees
Tables: departments, employees
Description: Display every department, including departments that do not currently have employees.
Expected behavior:
Display department ID, department name, employee ID, and employee name.
Use a LEFT JOIN.
Show departments with no employees as well.
Sort the results by department name.
*/


package jdbc;

import java.sql.*;
import java.util.*;

public class DisAllDepTheirEmp {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
		
		        PreparedStatement stmt = conn.prepareStatement("SELECT  d.dep_id, d.dep_name ,e.emp_id, e.emp_name FROM department d  LEFT JOIN employee  e ON e.dep_id = d.dep_id ORDER BY d.dep_name ASC, e.emp_name ASC");

		        ResultSet value = stmt.executeQuery();
		        
        while(value.next())
        {
        	System.out.println("Department Id = " + value.getInt("dep_id"));
            System.out.println("Department Name = " + value.getString("dep_name"));
            System.out.println("Employee Id = " + value.getInt("emp_id"));
            System.out.println("Employee Name =" + value.getString("emp_name"));
            
            System.out.println(".............");
        
        }
        }
	}

}
