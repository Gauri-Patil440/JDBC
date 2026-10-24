/*Assignment 3: Delete an Employee
Table: employees
Description: Delete an employee using their employee ID.
Expected behavior:
Accept an employee ID as input.
Delete the corresponding employee using PreparedStatement.
Display whether a record was deleted.
Consider foreign key relationships with employee_projects before deleting an employee.
*/


package jdbc;
import java.sql.*;
import java.util.*;
public class delete {

	public static void main(String[] args) throws Exception {

		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		  Scanner sc = new Scanner(System.in);

	        System.out.println("Enter Employee ID");
	        int id = sc.nextInt();

	        PreparedStatement stmt = conn.prepareStatement("DELETE FROM employee WHERE emp_id = ?");
	        stmt.setInt(1, id);

	        int rows = stmt.executeUpdate();

	        if (rows > 0) 
	        {
	            System.out.println("Employee Deleted Successfully");
	        } else 
	        {
	            System.out.println("Employee ID Not Found");
	        }
	        System.out.println("Affected Rows " + rows);
	}

}
