/*insert data project table*/


package jdbc;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class projectinsert {
	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Patil@123");
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
		
			System.out.println("Enter project id");
			int id =sc.nextInt();
			
			System.out.println("Enter project name");
			String name =sc.nextLine();
			sc.nextLine();
			
			System.out.println("Enter project budget");
			double budget=sc.nextDouble();
			
			 System.out.println("Enter department ID");
	         int depId = sc.nextInt();
            
			 System.out.print("Enter Start Date (YYYY-MM-DD)");
		     String date = sc.next();

		        
			PreparedStatement stmt=conn.prepareStatement("insert into project" + "(project_id,project_name, budget, dep_id, start_date) " + " values(?,?,?,?,?)");
			stmt.setInt(1,id);
			stmt.setString(2, name);
			stmt.setDouble(3,budget);
			stmt.setInt(4, depId);
			stmt.setDate(5, Date.valueOf(date));
			
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
