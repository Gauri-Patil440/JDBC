/*Assignments 9–13 · Practice INNER JOIN, LEFT JOIN, and multiple-table joins.
Assignment 9: Display Employees with Department Names
Tables: employees, departments
Description: Retrieve employee information along with the department name in which each employee works.
Expected behavior:
Display employee ID, employee name, salary, and department name.
Use an INNER JOIN between employees and departments.
Sort the results by department name and employee name.
*/


package jdbc;

import java.sql.*;
import java.util.*;

public class displayEmpWithDepName {

	public static void main(String[]args) throws Exception{
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
		
		        PreparedStatement stmt = conn.prepareStatement("SELECT e.emp_id, e.emp_name, e.salary, d.dep_name FROM employee e INNER JOIN department d ON e.dep_id = d.dep_id ORDER BY d.dep_name ASC, e.emp_name ASC");

		        ResultSet value = stmt.executeQuery();
		        
        while(value.next())
        {
        	System.out.println("Employee Id = " + value.getInt("emp_id"));
            System.out.println("Employee Name = " + value.getString("emp_name"));
            System.out.println("Salary = " + value.getDouble("salary"));
            System.out.println("Department Name =" + value.getString("dep_name"));
            
            System.out.println(".............");
        
        }
        }
	}

}
