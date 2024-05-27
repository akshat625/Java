package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class JDBC {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/book";
        String user = "root";
        String password = "0105T@@t";


        String query = "SELECT * FROM book_info";

        try (
                Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {


            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                double publication_year = resultSet.getDouble("publication_year");

                System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", publication_year: " + publication_year);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
