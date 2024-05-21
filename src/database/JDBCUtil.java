package database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection c = null;
        try {
            // Các thông số kết nối
            String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // Địa chỉ và cổng của cơ sở dữ liệu Oracle
            String userName = "qlthuexe"; // Tên đăng nhập vào cơ sở dữ liệu Oracle
            String password = "qlthuexe"; // Mật khẩu đăng nhập vào cơ sở dữ liệu Oracle

            // Tạo kết nối 
            c = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
            // Thông báo lỗi
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
    
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    
    public static void closeStatement(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }
    
    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            } 
        } catch (Exception e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }
}