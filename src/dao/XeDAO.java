package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Xe;

public class XeDAO implements DAOInterface<Xe> {

    public static XeDAO getInstance() {
        return new XeDAO();
    }

    @Override
    public int insert(Xe t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO XE ( TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenXe());
            pst.setString(2, t.getBienSo());
            pst.setString(3, t.getTrangThai());
            pst.setInt(4, t.getTGBaoDuong());
            pst.setLong(5, t.getDonGia());
            pst.setString(6, t.getThuongHieu());
            pst.setLong(7, t.getTienCoc());
            pst.setInt(8, t.getMaLX());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Xe t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE XE SET TenXe=?, BienSo=?, TrangThai=?, TGBaoDuong=?, DonGia=?, ThuongHieu=?, TienCoc=?, MaLX=? WHERE MaXe=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenXe());
            pst.setString(2, t.getBienSo());
            pst.setString(3, t.getTrangThai());
            pst.setInt(4, t.getTGBaoDuong());
            pst.setLong(5, t.getDonGia());
            pst.setString(6, t.getThuongHieu());
            pst.setLong(7, t.getTienCoc());
            pst.setInt(8, t.getMaLX());
            pst.setInt(9, t.getMaXe());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(Xe t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM XE WHERE MaXe=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaXe());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Xe> selectAll() {
        ArrayList<Xe> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM XE WHERE TrangThai='Không hư'";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaXe = rs.getInt("MaXe");
                String TenXe = rs.getString("TenXe");
                String BienSo = rs.getString("BienSo");
                String TrangThai = rs.getString("TrangThai");
                int TGBaoDuong = rs.getInt("TGBaoDuong");
                int DonGia = rs.getInt("DonGia");
                String ThuongHieu = rs.getString("ThuongHieu");
                int TienCoc = rs.getInt("TienCoc");
                int MaLX = rs.getInt("MaLX");

                Xe x = new Xe(MaXe, TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX);
                ketQua.add(x);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Xe selectById(String t) {
        Xe ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM XE WHERE MaXe=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaXe = rs.getInt("MaXe");
                String TenXe = rs.getString("TenXe");
                String BienSo = rs.getString("BienSo");
                String TrangThai = rs.getString("TrangThai");
                int TGBaoDuong = rs.getInt("TGBaoDuong");
                int DonGia = rs.getInt("DonGia");
                String ThuongHieu = rs.getString("ThuongHieu");
                int TienCoc = rs.getInt("TienCoc");
                int MaLX = rs.getInt("MaLX");

                ketQua = new Xe(MaXe, TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX);

            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
            
    public ArrayList<Xe> selectAllTG(LocalDate TGNhan, LocalDate TGTra) {
        ArrayList<Xe> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            PreparedStatement pst;
            String alterSessionSql = "ALTER SESSION SET nls_date_format = 'DD/MM/YYYY'";
            pst = con.prepareStatement(alterSessionSql);
            pst.execute();
            String sql= "SELECT * FROM XE WHERE MaXe NOT IN (SELECT CT.MaXe FROM CHITIETHD CT JOIN HOADON HD ON CT.MaHD = HD.MaHD WHERE (HD.TGNhan between ? and ?) or (HD.TGTra between ? and ?))";
            pst = con.prepareStatement(sql);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            pst.setString(1, TGNhan.format(dtf));
            pst.setString(2, TGTra.format(dtf));
            pst.setString(3, TGNhan.format(dtf));
            pst.setString(4, TGTra.format(dtf));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaXe = rs.getInt("MaXe");
                String TenXe = rs.getString("TenXe");
                String BienSo = rs.getString("BienSo");
                String TrangThai = rs.getString("TrangThai");
                int TGBaoDuong = rs.getInt("TGBaoDuong");
                int DonGia = rs.getInt("DonGia");
                String ThuongHieu = rs.getString("ThuongHieu");
                int TienCoc = rs.getInt("TienCoc");
                int MaLX = rs.getInt("MaLX");

                Xe x = new Xe(MaXe, TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX);
                ketQua.add(x);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public ArrayList<Object[]> getTopRentedCars(int month, int year) {
        ArrayList<Object[]> result = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT ROWNUM AS Top, MaXe, SoLanThue " +
                         "FROM (" +
                         "    SELECT cthd.MaXe, COUNT(*) AS SoLanThue " +
                         "    FROM HOADON hd " +
                         "    JOIN CHITIETHD cthd ON hd.MaHD = cthd.MaHD " +
                         "    WHERE EXTRACT(MONTH FROM hd.TGTao) = ? AND EXTRACT(YEAR FROM hd.TGTao) = ? " +
                         "    GROUP BY cthd.MaXe " +
                         "    ORDER BY SoLanThue DESC" +
                         ") " +
                         "WHERE ROWNUM <= 10";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, month);
            pst.setInt(2, year);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result.add(new Object[]{rs.getInt("Top"), rs.getInt("MaXe"), rs.getInt("SoLanThue")});
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    
    
}
