/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.HDPhat;

/**
 *
 * @author ASUS
 */
public class HDPhatDAO implements DAOInterface<HDPhat>{

    public static HDPhatDAO getInstance() {
        return new HDPhatDAO();
    }
    
    @Override
    public int insert(HDPhat t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            pst.setString(1, t.getTGTao().format(dtf));
            pst.setInt(2, t.getTongTienPhat());
            pst.setString(3, t.getTinhTrang());
            pst.setInt(4, t.getMaHD());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(HDPhat t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            PreparedStatement pst;
            String alterSessionSql = "ALTER SESSION SET nls_date_format = 'DD/MM/YYYY'";
            pst = con.prepareStatement(alterSessionSql);
            pst.execute();
            String sql = "UPDATE HDPHAT SET TGTao=?, TongTienPhat=?, TinhTrang=?, MaHD=? WHERE MaHDP=? ";
            pst = con.prepareStatement(sql);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            pst.setString(1, t.getTGTao().format(dtf));
            pst.setInt(2, t.getTongTienPhat());
            pst.setString(3, t.getTinhTrang());
            pst.setInt(4, t.getMaHD());
            pst.setInt(5, t.getMaHDP());
            
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(HDPhat t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM HDPHAT WHERE MaHDP=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHDP());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<HDPhat> selectAll() {
        ArrayList<HDPhat> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM HDPHAT";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaHDP = rs.getInt("MaHDP");
                LocalDate TGTao = rs.getDate("TGTao").toLocalDate();
                int TongTienPhat = rs.getInt("TongTienPhat");
                String TinhTrang = rs.getString("TinhTrang");
                int MaHD = rs.getInt("MaHD");

                HDPhat hdp = new HDPhat(MaHDP, TGTao, TongTienPhat, TinhTrang, MaHD);
                ketQua.add(hdp);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public HDPhat selectById(String t) {
        HDPhat ketQua = new HDPhat();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM HDPHAT WHERE MaHDP=?";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaHDP = rs.getInt("MaHDP");
                LocalDate TGTao = rs.getDate("TGTao").toLocalDate();
                int TongTienPhat = rs.getInt("TongTienPhat");
                String TinhTrang = rs.getString("TinhTrang");
                int MaHD = rs.getInt("MaHD");

                ketQua = new HDPhat(MaHDP, TGTao, TongTienPhat, TinhTrang, MaHD);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
}
