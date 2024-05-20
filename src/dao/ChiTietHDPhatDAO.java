
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.ChiTietHDPhat;
import model.HDPhat;
import java.sql.Blob;

public class ChiTietHDPhatDAO implements DAOInterface<ChiTietHDPhat>{

    public static ChiTietHDPhatDAO getInstance() {
        return new ChiTietHDPhatDAO();
    }
    
    @Override
    public int insert(ChiTietHDPhat t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "BEGIN insert_cthdphat_details(?,?,?,?,?) END";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHDP());
            pst.setInt(2, t.getMaXe());
            pst.setString(3, t.getLoaiPhat());
            pst.setInt(4, t.getSoTien());
            pst.setBlob(5, t.getHinhAnh());
            pst.setString(6, t.getChuThich());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
        
    }

    @Override
    public int update(ChiTietHDPhat t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE HDPHAT SET LoaiPhat=?, SoTien=?, HinhAnh=?, ChuThich=? WHERE MaHDP=? and MaXe=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getLoaiPhat());
            pst.setInt(2, t.getSoTien());
            pst.setBlob(3, t.getHinhAnh());
            pst.setString(4, t.getChuThich());
            pst.setInt(5, t.getMaHDP());
            pst.setInt(6, t.getMaXe());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(ChiTietHDPhat t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM CHITIETHDPHAT WHERE MaHDP=? and MaXe=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHDP());
            pst.setInt(1, t.getMaXe());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<ChiTietHDPhat> selectAll() {
        ArrayList<ChiTietHDPhat> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM CHITIETHDPHAT";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaHDP = rs.getInt("MaHDP");
                int MaXe = rs.getInt("MaXe");
                String LoaiPhat = rs.getString("LoaiPhat");
                int SoTien = rs.getInt("SoTien");
                Blob HinhAnh = rs.getBlob("HinhAnh");
                String ChuThich = rs.getString("ChuThich");

                ChiTietHDPhat cthdp = new ChiTietHDPhat(MaHDP, MaXe, LoaiPhat, SoTien, HinhAnh, ChuThich);
                ketQua.add(cthdp);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ChiTietHDPhat selectById(String t) {
        ChiTietHDPhat ketQua = new ChiTietHDPhat();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM CHITIETHDPHAT WHERE MaHDP=? and MaXe=?";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaHDP = rs.getInt("MaHDP");
                int MaXe = rs.getInt("MaXe");
                String LoaiPhat = rs.getString("LoaiPhat");
                int SoTien = rs.getInt("SoTien");
                Blob HinhAnh = rs.getBlob("HinhAnh");
                String ChuThich = rs.getString("ChuThich");

                ketQua = new ChiTietHDPhat(MaHDP, MaXe, LoaiPhat, SoTien, HinhAnh, ChuThich);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
}
