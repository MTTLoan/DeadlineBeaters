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
            String sql = "INSERT INTO TaiKhoan ( TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenTK());
            pst.setString(2, t.getMatKhau());
            pst.setString(3, t.getHoTen());
            pst.setString(4, t.getGioiTinh());
            pst.setDate(5, java.sql.Date.valueOf(t.getNgaySinh()));
            pst.setString(6, t.getChucVu());
            pst.setInt(7, t.getLuong());
            pst.setDate(8, java.sql.Date.valueOf(t.getNgayVaoLam()));
            pst.setInt(9, t.getMaQL());
            if(t.getMaQL() != 0){
                pst.setInt(9, t.getMaQL());
            }else{
                pst.setString(9, null);
            }
            
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
            String sql = "UPDATE TaiKhoan SET TenTK=?, MatKhau=?, HoTen=?, GioiTinh=?, NgaySinh=?, ChucVu=?, Luong=?, NgayVaoLam=?, MaQL=? WHERE MaNV=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenTK());
            pst.setString(2, t.getMatKhau());
            pst.setString(3, t.getHoTen());
            pst.setString(4, t.getGioiTinh());
            pst.setDate(5, java.sql.Date.valueOf(t.getNgaySinh()));
            pst.setString(6, t.getChucVu());
            pst.setInt(7, t.getLuong());
            pst.setDate(8, java.sql.Date.valueOf(t.getNgayVaoLam()));
            pst.setInt(9, t.getMaQL());
            pst.setInt(10, t.getMaNV());

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
        ArrayList<TaiKhoan> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM TaiKhoan";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaNV = rs.getInt("MaNV");
                String TenTK = rs.getString("TenTK");
                String MatKhau = rs.getString("MatKhau");
                String HoTen = rs.getString("HoTen");
                String GioiTinh = rs.getString("GioiTinh");
                LocalDate NgaySinh = rs.getDate("NgaySinh").toLocalDate();
                String ChucVu = rs.getString("ChucVu");
                int Luong = rs.getInt("Luong");
                LocalDate NgayVaoLam = rs.getDate("NgayVaoLam").toLocalDate();
                int MaQL = rs.getInt("MaQL");

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
                int MaNV = rs.getInt("MaNV");
                String TenTK = rs.getString("TenTK");
                String MatKhau = rs.getString("MatKhau");
                String HoTen = rs.getString("HoTen");
                String GioiTinh = rs.getString("GioiTinh");
                LocalDate NgaySinh = rs.getDate("NgaySinh").toLocalDate();
                String ChucVu = rs.getString("ChucVu");
                int Luong = rs.getInt("Luong");
                LocalDate NgayVaoLam = rs.getDate("NgayVaoLam").toLocalDate();
                int MaQL = rs.getInt("MaQL");

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
                int MaNV = rs.getInt("MaNV");
                String TenTK = rs.getString("TenTK");
                String MatKhau = rs.getString("MatKhau");
                String HoTen = rs.getString("HoTen");
                String GioiTinh = rs.getString("GioiTinh");
                LocalDate NgaySinh = rs.getDate("NgaySinh").toLocalDate();
                String ChucVu = rs.getString("ChucVu");
                int Luong = rs.getInt("Luong");
                LocalDate NgayVaoLam = rs.getDate("NgayVaoLam").toLocalDate();
                int MaQL = rs.getInt("MaQL");

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
