/*insert department table data*/

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class depinsert {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter department id");
			int id=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter department name");
			String name =sc.nextLine();
			
			System.out.println("Enter department location");
			String location=sc.nextLine();
            
			PreparedStatement stmt=conn.prepareStatement("insert into department values(?,?,?)");
			
			stmt.setInt(1,id);
			stmt.setString(2, name);
			stmt.setString(3,location);
			
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
