/*Assignment 15: Find Departments with High Average Salaries
Tables: employees, departments
Description: Calculate the average salary for each department and display only departments whose average salary is greater than an amount entered by the user.
Expected behavior:
Accept a minimum average salary as input.
Calculate average salary using AVG().
Group employees by department.
Use HAVING to filter groups based on average salary.
Display department name and average salary.
*/


package jdbc;
import java.util.*;
import java.sql.*;

public class FindDepWithHighAvgSal {

	public static void main(String[] args) throws Exception  {
	 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Minimum Average Salary:");
            double salary = sc.nextDouble();

			PreparedStatement stmt=conn.prepareStatement("SELECT d.dep_name,AVG(e.salary) AS avg_salary FROM department d JOIN employee e ON d.dep_id = e.dep_id GROUP BY d.dep_id,d.dep_name HAVING AVG(e.salary) > ?  ");
					
			 stmt.setDouble(1, salary);

			ResultSet value = stmt.executeQuery();
			
			while(value.next())
			{
				System.out.println("Department Name =" + value.getString("dep_name"));
				System.out.println("Average_salary =" + value.getDouble("avg_salary"));
			}
		}
	}

}
