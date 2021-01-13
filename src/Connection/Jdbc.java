package Connection;

import java.sql.*;

import javax.swing.JOptionPane;

public class Jdbc {

  final static private String userName = "root";
  final static private String password = "123456";
  final static private String url = "jdbc:mysql://localhost:3306/?user=root";
  final static private String Driver = "com.mysql.cj.jdbc.Driver";

  private static String query;
  private static Connection con = null;
  private static Statement statement = null;

  public Jdbc() throws SQLException {
    this.connect();
  }

  public static void connect() throws SQLException {
    try {
      Class.forName(Driver);
    } catch (ClassNotFoundException e) {
      JOptionPane.showMessageDialog(null, "Error: unable to load driver class!");
    }

    con = DriverManager.getConnection(url, userName, password);
    statement = con.createStatement();

  }

  public static ResultSet executeQuery(String query) throws SQLException {
    return statement.executeQuery(query);
  }

  public static void executeUpdate(String update) throws SQLException {
    statement.executeUpdate(update);
  }

}
