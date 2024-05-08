package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import database.JDBCUtil;
import model.TaiKhoan;

public class TaiKhoanDAO implements DAOInterface<TaiKhoan> {

    public static TaiKhoanDAO getInstance() {
        return new TaiKhoanDAO();
    }

    @Override
    public int insert(TaiKhoan t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO TaiKhoan (MaNV, TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaNV());
            pst.setString(2, t.getTenTK());
            pst.setString(3, t.getMatKhau());
            pst.setString(4, t.getHoTen());
            pst.setString(5, t.getGioiTinh());
            pst.setDate(6, java.sql.Date.valueOf(t.getNgaySinh()));
            pst.setString(7, t.getChucVu());
            pst.setLong(8, t.getLuong());
            pst.setDate(9, java.sql.Date.valueOf(t.getNgayVaoLam()));
            pst.setString(10, t.getMaQL());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(TaiKhoan t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE TaiKhoan SET MaNV=?, MatKhau=?, HoTen=?, GioiTinh=?, NgaySinh=?, ChucVu=?, Luong=?, NgayVaoLam=?, MaQL=? WHERE TenTK=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaNV());
            pst.setString(2, t.getMatKhau());
            pst.setString(3, t.getHoTen());
            pst.setString(4, t.getGioiTinh());
            pst.setDate(5, java.sql.Date.valueOf(t.getNgaySinh()));
            pst.setString(6, t.getChucVu());
            pst.setLong(7, t.getLuong());
            pst.setDate(8, java.sql.Date.valueOf(t.getNgayVaoLam()));
            pst.setString(9, t.getMaQL());
            pst.setString(10, t.getTenTK());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(TaiKhoan t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM TaiKhoan WHERE TenTK=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenTK());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<TaiKhoan> selectAll() {
        ArrayList<TaiKhoan> ketQua = new ArrayList<TaiKhoan>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM TaiKhoan";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaNV = rs.getString("MaNV");
                String TenTK = rs.getString("TenTK");
                String MatKhau = rs.getString("MatKhau");
                String HoTen = rs.getString("HoTen");
                String GioiTinh = rs.getString("GioiTinh");
                LocalDate NgaySinh = rs.getDate("NgaySinh").toLocalDate();
                String ChucVu = rs.getString("ChucVu");
                long Luong = rs.getLong("Luong");
                LocalDate NgayVaoLam = rs.getDate("NgayVaoLam").toLocalDate();
                String MaQL = rs.getString("MaQL");

                TaiKhoan tk = new TaiKhoan(MaNV, TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL);
                ketQua.add(tk);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public TaiKhoan selectById(String t) {
        TaiKhoan tk = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM TaiKhoan WHERE TenTK=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaNV = rs.getString("MaNV");
                String TenTK = rs.getString("TenTK");
                String MatKhau = rs.getString("MatKhau");
                String HoTen = rs.getString("HoTen");
                String GioiTinh = rs.getString("GioiTinh");
                LocalDate NgaySinh = rs.getDate("NgaySinh").toLocalDate();
                String ChucVu = rs.getString("ChucVu");
                long Luong = rs.getLong("Luong");
                LocalDate NgayVaoLam = rs.getDate("NgayVaoLam").toLocalDate();
                String MaQL = rs.getString("MaQL");

                tk = new TaiKhoan(MaNV, TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tk;
    }
    
    public TaiKhoan kiemTraDangNhap(String tenTaiKhoan, String matKhau) {
        TaiKhoan taiKhoan = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM TaiKhoan WHERE TenTK=? AND MatKhau=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, tenTaiKhoan);
            pst.setString(2, matKhau);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String MaNV = rs.getString("MaNV");
                String TenTK = rs.getString("TenTK");
                String MatKhau = rs.getString("MatKhau");
                String HoTen = rs.getString("HoTen");
                String GioiTinh = rs.getString("GioiTinh");
                LocalDate NgaySinh = rs.getDate("NgaySinh").toLocalDate();
                String ChucVu = rs.getString("ChucVu");
                long Luong = rs.getLong("Luong");
                LocalDate NgayVaoLam = rs.getDate("NgayVaoLam").toLocalDate();
                String MaQL = rs.getString("MaQL");

                taiKhoan = new TaiKhoan(MaNV, TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taiKhoan;
    }
    
public boolean doiMatKhau(String tenTaiKhoan, String matKhauCu, String matKhauMoi) {
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM TaiKhoan WHERE TenTK=? AND MatKhau=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tenTaiKhoan);
        pst.setString(2, matKhauCu);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {

            String updateSql = "UPDATE TaiKhoan SET MatKhau=? WHERE TenTK=?";
            PreparedStatement updatePst = con.prepareStatement(updateSql);
            updatePst.setString(1, matKhauMoi);
            updatePst.setString(2, tenTaiKhoan);
            int rowsAffected = updatePst.executeUpdate();

            if (rowsAffected > 0) {
                JDBCUtil.closeConnection(con);
                return true;
            }
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}
