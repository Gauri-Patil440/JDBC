/*Assignment 5: Update Order Status
Table: orders
Description: Update an order's status based on its order ID. The user should be able to change the status to Pending, Completed, or Cancelled.
Expected behavior:
Accept order ID and the new status.
Update only the matching order.
Display the number of affected rows.
Validate the status before executing the update.
*/


package jdbc;
import java.sql.*;
import java.util.*;

public class Updateorderstatus {

	public static void main(String[] args) throws Exception{
		
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
        
	    if(conn!=null)
	    {
	    	Scanner sc=new Scanner(System.in);
	    	
	    	System.out.println("Enter order id");
	    	int id=sc.nextInt();
	    	sc.nextLine();
	    	
	    	System.out.println("Enter status(pending,complited,cancelled)");
	    	String status =sc.nextLine();
	    	
	    	PreparedStatement stmt=conn.prepareStatement("UPDATE orders SET o_status=? WHERE o_id=?");
			
			 stmt.setString(1, status);
		     stmt.setInt(2, id);

			int value = stmt.executeUpdate();
			
			if(value > 0)
			{
				 System.out.println("Record update  successfully");
			}
			 else 
			 {
				 System.out.println("Employee in not successfuly");
			 }
	    }
	}
}
