import java.sql.*;
import java.util.Scanner;

public class Database {
    public static void main(String[] args) throws SQLException {
        try {
            //Finder class Driver i den importede mappe (Mysql-connector-java (External Libaries))
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezooneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");


        Statement statement = connection.createStatement();


        //String sql1 = "SELECT * FROM person";
        System.out.print("Write MySQL Query: ");
        String sql = sc.nextLine();

        ResultSet results = statement.executeQuery(sql);

        while (results.next()) {
            for (int i = 0; i < results.getMetaData().getColumnCount(); i++) {
                System.out.printf("%40s", results.getString(i + 1));
            }
            System.out.println();
        }
    }
}
