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
            String sql = "INSERT INTO DanhGia (SoDiem, NoiDung, MaHD) VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getSoDiem());
            pst.setString(2, t.getNoiDung());
            pst.setInt(3, t.getMaHD());

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
            String sql = "UPDATE DANHGIA SET SoDiem=?, NoiDung=?, MaHD=? WHERE MaDG=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getSoDiem());
            pst.setString(2, t.getNoiDung());
            pst.setInt(3, t.getMaHD());
            pst.setInt(4, t.getMaDG());

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
            String sql = "DELETE FROM DANHGIA WHERE MaDG=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaDG());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<DanhGia> selectAll() {
        ArrayList<DanhGia> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM DANHGIA";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaDG = rs.getInt("MaDG");
                int SoDiem = rs.getInt("SoDiem");
                String NoiDung = rs.getString("NoiDung");
                int MaHD = rs.getInt("MaHD");

                DanhGia dg = new DanhGia(MaDG, SoDiem, NoiDung, MaHD);
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
            String sql = "SELECT * FROM DANHGIA WHERE MaDG=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaDG = rs.getInt("MaDG");
                int SoDiem = rs.getInt("SoDiem");
                String NoiDung = rs.getString("NoiDung");
                int MaHD = rs.getInt("MaHD");

                ketQua = new DanhGia(MaDG, SoDiem, NoiDung, MaHD);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public ArrayList<DanhGia> selectByMaHD(String t) {
        ArrayList<DanhGia> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM DANHGIA WHERE MaHD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaDG = rs.getInt("MaDG");
                int SoDiem = rs.getInt("SoDiem");
                String NoiDung = rs.getString("NoiDung");
                int MaHD = rs.getInt("MaHD");

                DanhGia dg = new DanhGia(MaDG, SoDiem, NoiDung, MaHD);
                ketQua.add(dg);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

}
