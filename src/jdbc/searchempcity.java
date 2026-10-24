/*Assignment 7: Search Employees by City
Table: employees
Description: Retrieve employees belonging to a city entered by the user and display them in alphabetical order by employee name.
Expected behavior:
Accept a city name as input.
Filter employees using a parameterized condition.
Sort the matching records by employee name.
Display a suitable message when no employees match.
*/


package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class searchempcity {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter city name");
			String name=sc.nextLine();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT emp_id,emp_name,email,salary,dep_id,city FROM employee WHERE city >=? ORDER BY emp_name asc");
			stmt.setString(1, name);
			
			ResultSet value = stmt.executeQuery();
			
			while(value.next())
			{
				System.out.println("Employee Id =" + value.getInt("emp_id"));
				System.out.println("Employee name =" + value.getString("emp_name"));
				System.out.println("Employee salary=" + value.getDouble("salary"));
				System.out.println("Employee email=" + value.getString("email"));
				System.out.println("department id=" + value.getInt("dep_id"));
				System.out.println("City =" + value.getString("city"));
			}
		}
		
	}

}
