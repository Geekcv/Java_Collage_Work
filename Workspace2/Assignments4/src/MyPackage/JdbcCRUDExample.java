//in database 
//create database test2
//create table users
//CREATE TABLE users (
//	    id INT AUTO_INCREMENT PRIMARY KEY,
//	    username VARCHAR(50) NOT NULL,
//	    email VARCHAR(50) NOT NULL,
//	    age INT NOT NULL
//	);



package MyPackage;

import java.sql.*;

public class JdbcCRUDExample {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test2";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1. Establishing a connection to the database
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // 2. Creating a statement object to execute SQL queries
            stmt = conn.createStatement();

            // 3. Performing CRUD operations

            // 3.1. Adding a new record (Create)
            String insertQuery = "INSERT INTO users (username, email, age) VALUES ('abhi', 'abhi@example.com', 21)";
            int rowsInserted = stmt.executeUpdate(insertQuery);
            System.out.println(rowsInserted + " row(s) inserted.");

            // 3.2. Retrieving records (Read)
            String selectQuery = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", Username: " + username + ", Email: " + email + ", Age: " + age);
            }

            // 3.3. Modifying a record (Update)
//            String updateQuery = "UPDATE users SET age = 31 WHERE username = 'JohnDoe'";
//            int rowsUpdated = stmt.executeUpdate(updateQuery);
//            System.out.println(rowsUpdated + " row(s) updated.");

            // 3.4. Deleting a record (Delete)
//            String deleteQuery = "DELETE FROM users WHERE username = 'JohnDoe'";
//            int rowsDeleted = stmt.executeUpdate(deleteQuery);
//            System.out.println(rowsDeleted + " row(s) deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4. Closing resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
