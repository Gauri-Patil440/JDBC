/*Assignments 14–17 · Practice COUNT, SUM, AVG, MAX, MIN, and HAVING.
Assignment 14: Count Employees in Each Department
Tables: employees, departments
Description: Calculate the number of employees working in each department.
Expected behavior:
Display department name and employee count.
Use GROUP BY to group employees by department.
Include departments with zero employees.
Sort departments by employee count in descending order.
*/


package jdbc;
import java.util.*;
import java.sql.*;
public class CountEmpInEachDep {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			
			PreparedStatement stmt =conn.prepareStatement("SELECT d.dep_name, COUNT(e.emp_id) AS emp_count FROM department d LEFT JOIN employee e ON d.dep_id = e.dep_id GROUP BY d.dep_id ,d.dep_name ORDER BY emp_count DESC");
			
			ResultSet value = stmt.executeQuery();

            while (value.next()) 
            {
                    System.out.println("Department=  " +value.getString("dep_name"));
                    System.out.println("Employee Count= " + value.getInt("emp_count"));
		}
	}
  }
}