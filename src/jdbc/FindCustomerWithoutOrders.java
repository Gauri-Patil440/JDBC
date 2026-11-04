/*Assignment 13: Find Customers Without Orders
Tables: customers, orders
Description: Identify customers who have never placed an order.
Expected behavior:
Use a LEFT JOIN between customers and orders.
Filter for customers without matching orders.
Display customer ID, name, email, and city.
*/


package jdbc;
//import java.util.*;
import java.sql.*;
public class FindCustomerWithoutOrders {

	public static void main(String[] args) throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			PreparedStatement stmt=conn.prepareStatement("SELECT c.c_id,c.c_name,c.email,c.city "
					+ "FROM Customer c "
					+ "LEFT JOIN orders o ON  c.c_id = o.c_id  "
					+ "WHERE o.c_id IS NULL");
			
           ResultSet value =stmt.executeQuery();
			
			while (value.next()) 
	        {
				System.out.println("Customer ID=" + value.getInt("c_id"));
	            System.out.println("Customer Name=" + value.getString("c_name"));
	            System.out.println("Customer Email=" + value.getString("email"));
	            System.out.println("Customer City =" + value.getString("city"));
	        }
			
		}
	}

}
