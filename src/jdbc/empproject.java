/*insert employee_project in table */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class empproject {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Database connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc",
                "root",
                "Patil@123"
            );

            int empid = readNumber(sc, "Enter employee id:");
            int projectid = readNumber(sc, "Enter project id:");
            int hours = readNumber(sc, "Enter hours worked:");

            System.out.println("Enter Assigned Date (YYYY-MM-DD):");
            String date = sc.nextLine().trim();

            java.sql.Date assignedDate =
                java.sql.Date.valueOf(date);

            String sql =
                "INSERT INTO emp_project " +
                "(emp_id, project_id, hours_worked, assigned_date) " +
                "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, empid);
            ps.setInt(2, projectid);
            ps.setInt(3, hours);
            ps.setDate(4, assignedDate);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Project assigned successfully!");
            }

            ps.close();
            con.close();

        } catch (IllegalArgumentException e) {
            System.out.println(
                "Invalid date! Use YYYY-MM-DD format."
            );
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Read only valid integer input
    public static int readNumber(Scanner sc, String message) {

        while (true) {
            System.out.println(message);
            String input = sc.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input! Please enter numbers only."
                );
            }
        }
    }
}
