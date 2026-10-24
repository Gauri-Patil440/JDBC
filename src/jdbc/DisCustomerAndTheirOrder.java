/*Assignment 12: Display Customers and Their Orders
Tables: customers, orders
Description: Retrieve customer information along with their order details.
Expected behavior:
Display customer name, email, order ID, order date, total amount, and status.
Use an INNER JOIN.
Accept a customer ID as input to filter the results.
Sort orders by date in descending order.
*/


package jdbc;
import java.util.*;
import java.sql.*;

public class DisCustomerAndTheirOrder {

	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter customer id");
			int id =sc.nextInt();
			
			PreparedStatement stmt =conn.prepareStatement("SELECT c.c_name,c.email,o.o_id,o.o_date,o.total_amount,o.o_status "
					+ "FROM customer c "
					+ "INNER JOIN orders o "
					+ "ON c.c_id =orders.c_id "
					+ "WHERE c.c_id = ? "
					+ "ORDER BY o.o_date DESC");
			
			stmt.setInt(1, id);
			
			ResultSet value =stmt.executeQuery();
			
			while (value.next()) 
	        {
	           
	            System.out.println("customer Name=" + value.getString("c_name"));
	            System.out.println("customer email=" + value.getString("email"));
	            System.out.println("orders id= " + value.getInt("o_id"));
	            System.out.println("orders Date= " + value.getDate("o_date"));
	            System.out.println("orders total amount =" + value.getDouble("total_amount"));
	            System.out.println("orders status=" + value.getString("status"));
	        }
		}
	}

}
