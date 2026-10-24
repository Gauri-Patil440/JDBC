/*Assignments 6–8 · Practice filtering, sorting, and retrieving records.
Assignment 6: Display Employees in Salary Order
Table: employees
Description: Retrieve all employees and display their details in descending order of salary.
Expected behavior:
Display employee ID, name, email, salary, and department ID.
Show the highest-paid employee first.
Allow the user to enter a minimum salary to filter the results.
Use ORDER BY to sort the results.
*/


package jdbc;
import java.util.*;
import java.sql.*;
public class displayempsalaryorder {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter minimum salary");
			int min_salary=sc.nextInt();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT emp_id,emp_name,email,salary,dep_id FROM employee WHERE salary >=? ORDER BY salary DESC");
			stmt.setInt(1, min_salary);
			
			ResultSet value = stmt.executeQuery();
			
			while(value.next())
			{
				System.out.println("Employee Id " + value.getInt("emp_id"));
				System.out.println("Employee name " + value.getString("emp_name"));
				System.out.println("Employee salary" + value.getDouble("salary"));
				System.out.println("Employee email" + value.getString("email"));
				System.out.println("department id" + value.getInt("dep_id"));
			}
		}
	}

}
