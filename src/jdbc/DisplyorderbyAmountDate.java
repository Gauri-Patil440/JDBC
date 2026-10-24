/*Assignment 8: Display Orders by Amount and Date
Table: orders
Description: Retrieve orders belonging to a selected status and sort them by total amount from highest to lowest, followed by order date from newest to oldest.
Expected behavior:
Accept an order status as input.
Display order ID, customer ID, order date, amount, and status.
Apply multiple sorting criteria using ORDER BY.
*/

package jdbc;
import java.util.*;
import java.sql.*;

public class DisplyorderbyAmountDate {

	public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			
			 System.out.println("Enter order status");
		        String status = sc.nextLine();

		        PreparedStatement stmt = conn.prepareStatement("SELECT o_id,c_id,o_date,total_amount,o_status FROM orders WHERE o_status = ? " + "ORDER BY total_amount DESC, o_date DESC");
		        
		        stmt.setString(1, status);

		        ResultSet value = stmt.executeQuery();
		        
		            while (value.next()) 
		            {
		            System.out.println("Order Id= " + value.getInt("o_id"));
		            System.out.println("Customer Id= " + value.getInt("c_id"));
		            System.out.println("Order Date= " + value.getDate("o_date"));
		            System.out.println("Total Amount= " + value.getDouble("total_amount"));
		            System.out.println("Order Status= " + value.getString("o_status"));
		}
	}
	}
}
