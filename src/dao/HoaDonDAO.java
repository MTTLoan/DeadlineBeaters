
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.HoaDon;

public class HoaDonDAO implements DAOInterface<HoaDon>{

    public static HoaDonDAO getInstance() {
        return new HoaDonDAO();
    }
    
    @Override
    public int insert(HoaDon t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO HOADON (MaHD, TGTao, TongTien, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-YYYY HH24:MI");
            pst.setString(1, t.getMaHD());
            pst.setString(2, t.getTGTao().format(dtf));
            pst.setLong(3, t.getTongTien());
            pst.setString(4, t.getTGNhan().format(dtf));
            pst.setString(5, t.getTGTra().format(dtf));
            pst.setLong(6, t.getTongTienCoc());
            pst.setString(7, t.getTGCapNhat().format(dtf));
            pst.setString(8, t.getTinhTrang());
            pst.setString(9, t.getChuThich());
            pst.setString(10, t.getMaKH());
            pst.setString(11, t.getMaNV());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(HoaDon t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE HOADON SET TGTao=?, TongTien=?, TGNhan=?, TGTra=?, TongTienCoc=?, TGCapNhat=?, TinhTrang=?, ChuThich=?, MaKH=?, MaNV=? WHERE MaHD=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-YYYY HH24:MI");
            pst.setString(1, t.getTGTao().format(dtf));
            pst.setLong(2, t.getTongTien());
            pst.setString(3, t.getTGNhan().format(dtf));
            pst.setString(4, t.getTGTra().format(dtf));
            pst.setLong(5, t.getTongTienCoc());
            pst.setString(6, t.getTGCapNhat().format(dtf));
            pst.setString(7, t.getTinhTrang());
            pst.setString(8, t.getChuThich());
            pst.setString(9, t.getMaKH());
            pst.setString(10, t.getMaNV());
            pst.setString(11, t.getMaHD());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(HoaDon t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM TaiKhoan WHERE MaHD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaHD());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<HoaDon> selectAll() {
        ArrayList<HoaDon> ketQua = new ArrayList<HoaDon>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM HoaDon";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaHD = rs.getString("MaHD");
                LocalDateTime TGTao = rs.getTimestamp("TGTao").toLocalDateTime();
                long TongTien = rs.getLong("TongTien");
                LocalDateTime TGNhan = rs.getTimestamp("TGNhan").toLocalDateTime();
                LocalDateTime TGTra = rs.getTimestamp("TGTra").toLocalDateTime();
                long TongTienCoc = rs.getLong("TongTienCoc");
                LocalDateTime TGCapNhat = rs.getTimestamp("TGCapNhat").toLocalDateTime();
                String TinhTrang = rs.getString("TinhTrang");
                String ChuThich = rs.getString("ChuThich");
                String MaKH = rs.getString("MaKH");
                String MaNV = rs.getString("MaNV");

                HoaDon tk = new HoaDon(MaHD, TGTao, TongTien, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV);
                ketQua.add(tk);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public HoaDon selectById(String t) {
        HoaDon ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM HoaDon WHERE MaHD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaHD = rs.getString("MaHD");
                LocalDateTime TGTao = rs.getTimestamp("TGTao").toLocalDateTime();
                long TongTien = rs.getLong("TongTien");
                LocalDateTime TGNhan = rs.getTimestamp("TGNhan").toLocalDateTime();
                LocalDateTime TGTra = rs.getTimestamp("TGTra").toLocalDateTime();
                long TongTienCoc = rs.getLong("TongTienCoc");
                LocalDateTime TGCapNhat = rs.getTimestamp("TGCapNhat").toLocalDateTime();
                String TinhTrang = rs.getString("TinhTrang");
                String ChuThich = rs.getString("ChuThich");
                String MaKH = rs.getString("MaKH");
                String MaNV = rs.getString("MaNV");

                ketQua = new HoaDon(MaHD, TGTao, TongTien, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
}
