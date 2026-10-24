/*Table 5: customers
Stores customer details for sales-related assignments.
*/

package jdbc;

import java.sql.*;
import java.util.*;
public class customer {
	
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		
		if(conn!=null)
		{
			System.out.println("Database is connected");
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter customer id");
			int id =sc.nextInt();
			
			System.out.println("Enter customer name");
			String name=sc.next();
			
			System.out.println("Enter email");
			String email=sc.next();
			
			System.out.println("Enter city");
			String city=sc.next();
			
			
         PreparedStatement stmt=conn.prepareStatement("insert into customer" + "(c_id,c_name, email,city) " + " values(?,?,?,?)");
         stmt.setInt(1,id);
         stmt.setString(2, name);
         stmt.setString(3,email);
         stmt.setString(4, city);
         
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
