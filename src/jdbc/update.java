/*Assignment 2: Update Employee Salary
Table: employees
Description: Increase or change the salary of an employee based on the employee ID entered by the user.
Expected behavior:
Accept employee ID and new salary.
Update only the employee matching the specified ID.
Display the number of affected rows.
Handle the case where the employee ID does not exist.
*/

package jdbc;
import java.sql.*;
import java.util.*;
public class update {

	public static void main(String[]srgs) throws Exception
	{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		Scanner sc=new Scanner(System.in);
		
			System.out.println("Enter employee id");
			int id=sc.nextInt();
			
	        System.out.print("Enter New Salary ");
	        double salary = sc.nextDouble();
			
			PreparedStatement stmt=conn.prepareStatement("UPDATE employee SET salary=? WHERE emp_id=?");
			
			 stmt.setDouble(1, salary);
		     stmt.setInt(2, id);

			int value = stmt.executeUpdate();
			
			if(value > 0)
			{
				 System.out.println("Record update  successfully");
			}
			 else 
			 {
				 System.out.println("Employee in not found");
			 }
	}
}
