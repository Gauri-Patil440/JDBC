/*Assignment 1: Insert a New Employee
Table: employees
Description: Develop a JDBC operation to insert a new employee into the database. Accept the employee name, email, salary, department ID, joining date, and city as input values.
Expected behavior:
Accept employee details from the user.
Use a parameterized INSERT statement.
Display a message indicating whether the employee was inserted successfully.
Handle invalid department IDs and duplicate email addresses appropriately.
*/

package jdbc;
import java.sql.*;
import java.util.*;
public class insertemp {

	public static void main(String[] args) throws Exception {
		com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter employee id");
			int id=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter employee name");
			String name =sc.nextLine();
			
			System.out.println("Enter employee email");
			String email=sc.nextLine();
			
			System.out.println("Enter employee salary");
			double salary=sc.nextDouble();
			
			System.out.print("Enter department id ");
            int depId = sc.nextInt();

            System.out.print("Enter Joining Date (YYYY-MM-DD)");
            java.sql.Date joining_date =  java.sql.Date.valueOf(sc.next());

            System.out.print("Enter City");
            String city = sc.next();
            
			PreparedStatement stmt=conn.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			
			stmt.setInt(1,id);
			stmt.setString(2, name);
			stmt.setString(3,email);
			stmt.setDouble(4, salary);
		    stmt.setInt(5, depId);
		    stmt.setDate(6, joining_date);
		    stmt.setString(7, city);

			
			int value = stmt.executeUpdate();

            if (value > 0) {
                System.out.println("Record inserted successfully");
            } else {
                System.out.println("Record not inserted successfully");
            }

		}
		else
		{
			System.out.println("Database is not connected");
		}
	}

}
