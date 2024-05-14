package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DanhGia;

public class DanhGiaDAO implements DAOInterface<DanhGia> {

    public static DanhGiaDAO getInstance() {
        return new DanhGiaDAO();
    }

    @Override
    public int insert(DanhGia t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO DanhGia (MaDG, SoDiem, NoiDung, MaHopDong) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaDG());
            pst.setInt(2, t.getSoDiem());
            pst.setString(3, t.getNoiDung());
            pst.setString(4, t.getMaHopDong());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(DanhGia t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE DanhGia SET SoDiem=?, NoiDung=?, MaHopDong=? WHERE MaDG=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getSoDiem());
            pst.setString(2, t.getNoiDung());
            pst.setString(3, t.getMaHopDong());
            pst.setString(4, t.getMaDG());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(DanhGia t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM DanhGia WHERE MaDG=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaDG());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<DanhGia> selectAll() {
        ArrayList<DanhGia> ketQua = new ArrayList<DanhGia>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM DanhGia";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaDG = rs.getString("MaDG");
                int SoDiem = rs.getInt("SoDiem");
                String NoiDung = rs.getString("NoiDung");
                String MaHopDong = rs.getString("MaHopDong");

                DanhGia dg = new DanhGia(MaDG, SoDiem, NoiDung, MaHopDong);
                ketQua.add(dg);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public DanhGia selectById(String t) {
        DanhGia ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM DanhGia WHERE MaDG=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String MaDG = rs.getString("MaDG");
                int SoDiem = rs.getInt("SoDiem");
                String NoiDung = rs.getString("NoiDung");
                String MaHopDong = rs.getString("MaHopDong");

                ketQua = new DanhGia(MaDG, SoDiem, NoiDung, MaHopDong);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
