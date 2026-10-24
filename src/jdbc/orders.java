/*Table 6: orders
Stores customer order information.
*/

package jdbc;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class orders {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter order id");
			int id=sc.nextInt();
			
			System.out.println("Enter customer c_id");
			int c_id=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter order date (YYYY-MM-DD)");
			String date=sc.nextLine();
			
			System.out.println("Enter total amount");
			Double amount=sc.nextDouble();
			
			sc.nextLine();
			
			System.out.println("Enter order status");
			String status=sc.nextLine();
			
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO orders (o_id, c_id, o_date, total_amount,o_status) VALUES (?, ?, ?, ?, ?)");
			
	         stmt.setInt(1,id);
	         stmt.setInt(2, c_id);
	         stmt.setDate(3, Date.valueOf(date));
	         stmt.setDouble(4, amount);
	         stmt.setString(5, status);
	         
	         int value = stmt.executeUpdate();

	         if (value > 0) 
	         {
	             System.out.println("Record inserted successfully");
	         } 
	         else 
	         {
	             System.out.println("Record not inserted successfully");
	         }
			}
			else
			{
				System.out.println("Database is not connected");
			}
		}
	}
