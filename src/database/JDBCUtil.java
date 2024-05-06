/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class JDBCUtil {
    public static Connection  getConnect (String sId,String strUser,String strPwd) {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Registered!");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/"+sId, strUser,strPwd);
        } catch (Exception e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return connection;
    }

}
