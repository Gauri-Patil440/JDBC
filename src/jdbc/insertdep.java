/*Assignment 4: Insert a New Department
Table: departments
Description: Create a program that inserts a new department using a department name and location provided by the user.
Expected behavior:
Accept department name and location.
Insert the department into the database.
Display the generated department ID if available.
Handle database errors appropriately.
*/

package jdbc;
import java.sql.*;
import java.util.*;

public class insertdep {

	public static void main(String[] args) throws Exception {
	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		 Scanner sc = new Scanner(System.in);

	        System.out.println("Enter Employee name");
	        String name = sc.nextLine();
	        
	        
	        System.out.println("Enter Employee location");
	        String location = sc.nextLine();
	        
	        PreparedStatement stmt = conn.prepareStatement("INSERT INTO department (dep_name, location) VALUES (?, ?)");
	        
	        stmt.setString(1, name);
	        stmt.setString(2,location);

	        int rows = stmt.executeUpdate();

	        if (rows > 0) 
	        {
	            System.out.println("Employee insert new  Successfully");
	        } else 
	        {
	            System.out.println("Employee Not insert new ");
	        }
	        System.out.println("Affected Rows " + rows);
	}
}
