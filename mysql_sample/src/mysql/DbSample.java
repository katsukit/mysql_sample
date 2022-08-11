package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbSample {

  public static void main(String[] args) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
    	
      con = DriverManager.getConnection(
    	 "jdbc:mysql://localhost:3306/test_db?serverTimezone=JST", "root", "password"
      );// "password"の部分は，各自の環境に合わせて変更してください。

      pstmt = con.prepareStatement("select * from user");

      rs = pstmt.executeQuery();

      while (rs.next()) {
        System.out.println(rs.getString("username"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (con != null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}