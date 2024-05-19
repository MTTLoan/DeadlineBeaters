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
import java.util.ArrayList;
import model.ChiTietHD;
import model.HoaDon;

/**
 *
 * @author ASUS
 */
public class ChiTietHDDAO implements DAOInterface<ChiTietHD>{
    public static ChiTietHDDAO getInstance() {
        return new ChiTietHDDAO();
    }

    @Override
    public int insert(ChiTietHD t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO CHITIETHD (MaHD, MaXe, SoNgay, SoTien, MaHopDong) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHD());
            pst.setInt(2, t.getMaXe());
            pst.setInt(3, t.getSoNgay());
            pst.setInt(4, t.getSoTien());
            pst.setInt(5, t.getMaHopDong());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(ChiTietHD t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE HOADON SET MaHD=?, MaXe=?, SoNgay=?, SoTien=?, MaHopDong=? WHERE MaHD=? and MaXe=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHD());
            pst.setInt(2, t.getMaXe());
            pst.setInt(3, t.getSoNgay());
            pst.setInt(4, t.getSoTien());
            pst.setInt(5, t.getMaHopDong());
            pst.setInt(6, t.getMaHD());
            pst.setInt(7, t.getMaXe());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(ChiTietHD t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM CHITIETHD WHERE MaHD=? and MaXe=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHD());
            pst.setInt(2, t.getMaXe());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<ChiTietHD> selectAll() {
        ArrayList<ChiTietHD> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChiTietHD";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaHD = rs.getInt("MaHD");
                int MaXe = rs.getInt("MaXe");
                int SoNgay = rs.getInt("SoNgay");
                int SoTien = rs.getInt("SoTien");
                int MaHopDong = rs.getInt("MaHopDong");

                ChiTietHD tk = new ChiTietHD(MaHD, MaXe, SoNgay, SoTien, MaHopDong);
                ketQua.add(tk);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ChiTietHD selectById(String t) {
        ChiTietHD ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChiTietHD WHERE MaHD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaHD = rs.getInt("MaHD");
                int MaXe = rs.getInt("MaXe");
                int SoNgay = rs.getInt("SoNgay");
                int SoTien = rs.getInt("SoTien");
                int MaHopDong = rs.getInt("MaHopDong");

                ketQua = new ChiTietHD(MaHD, MaXe, SoNgay, SoTien, MaHopDong);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public ArrayList<ChiTietHD> selectByMaHD(String t) {
        ArrayList<ChiTietHD> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChiTietHD WHERE MaHD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaHD = rs.getInt("MaHD");
                int MaXe = rs.getInt("MaXe");
                int SoNgay = rs.getInt("SoNgay");
                int SoTien = rs.getInt("SoTien");
                int MaHopDong = rs.getInt("MaHopDong");

                ChiTietHD tk = new ChiTietHD(MaHD, MaXe, SoNgay, SoTien, MaHopDong);
                ketQua.add(tk);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    
}
