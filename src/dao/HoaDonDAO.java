
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
            String sql = "INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            pst.setString(1, t.getTGTao().format(dtf));
            pst.setInt(2, t.getTongTienThue());
            pst.setString(3, t.getTGNhan().format(dtf));
            pst.setString(4, t.getTGTra().format(dtf));
            pst.setInt(5, t.getTongTienCoc());
            pst.setString(6, t.getTGCapNhat().format(dtf));
            pst.setString(7, t.getTinhTrang());
            pst.setString(8, t.getChuThich());
            pst.setInt(9, t.getMaKH());
            pst.setInt(10, t.getMaNV());

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
            PreparedStatement pst;
            String alterSessionSql = "ALTER SESSION SET nls_date_format = 'DD/MM/YYYY'";
            pst = con.prepareStatement(alterSessionSql);
            pst.execute();
            String sql = "UPDATE HOADON SET TGTao=?, TongTienThue=?, TGNhan=?, TGTra=?, TongTienCoc=?, TGCapNhat=?, TinhTrang=?, ChuThich=?, MaKH=?, MaNV=? WHERE MaHD=? ";
            pst = con.prepareStatement(sql);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            pst.setString(1, t.getTGTao().format(dtf));
            pst.setInt(2, t.getTongTienThue());
            pst.setString(3, t.getTGNhan().format(dtf));
            pst.setString(4, t.getTGTra().format(dtf));
            pst.setInt(5, t.getTongTienCoc());
            pst.setString(6, LocalDate.now().format(dtf));
            pst.setString(7, t.getTinhTrang());
            pst.setString(8, t.getChuThich());
            pst.setInt(9, t.getMaKH());
            pst.setInt(10, t.getMaNV());
            pst.setInt(11, t.getMaHD());
            
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
            String sql = "DELETE FROM HOADON WHERE MaHD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHD());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<HoaDon> selectAll() {
        ArrayList<HoaDon> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM HOADON";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaHD = rs.getInt("MaHD");
                LocalDate TGTao = rs.getDate("TGTao").toLocalDate();
                int TongTienThue = rs.getInt("TongTienThue");
                LocalDate TGNhan = rs.getDate("TGNhan").toLocalDate();
                LocalDate TGTra = rs.getDate("TGTra").toLocalDate();
                int TongTienCoc = rs.getInt("TongTienCoc");
                LocalDate TGCapNhat = rs.getDate("TGCapNhat").toLocalDate();
                String TinhTrang = rs.getString("TinhTrang");
                String ChuThich = rs.getString("ChuThich");
                int MaKH = rs.getInt("MaKH");
                int MaNV = rs.getInt("MaNV");

                HoaDon tk = new HoaDon(MaHD, TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV);
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
            String sql = "SELECT * FROM HOADON WHERE MaHD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaHD = rs.getInt("MaHD");
                LocalDate TGTao = rs.getDate("TGTao").toLocalDate();
                int TongTienThue = rs.getInt("TongTienThue");
                LocalDate TGNhan = rs.getDate("TGNhan").toLocalDate();
                LocalDate TGTra = rs.getDate("TGTra").toLocalDate();
                int TongTienCoc = rs.getInt("TongTienCoc");
                LocalDate TGCapNhat = rs.getDate("TGCapNhat").toLocalDate();
                String TinhTrang = rs.getString("TinhTrang");
                String ChuThich = rs.getString("ChuThich");
                int MaKH = rs.getInt("MaKH");
                int MaNV = rs.getInt("MaNV");

                ketQua = new HoaDon(MaHD, TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public int getTotalInvoiceCount(int month, int year) {
        int totalInvoiceCount = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT COUNT(*) AS TotalInvoiceCount FROM (" +
                         "    SELECT hd.MaHD " +
                         "    FROM HOADON hd " +
                         "    WHERE EXTRACT(MONTH FROM hd.TGTao) = ? AND EXTRACT(YEAR FROM hd.TGTao) = ? " +
                         "    UNION ALL " +
                         "    SELECT phd.MaPhat AS MaHD " +
                         "    FROM PHATHOADON phd " +
                         "    WHERE EXTRACT(MONTH FROM phd.TGPhat) = ? AND EXTRACT(YEAR FROM phd.TGPhat) = ? " +
                         ")";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, month);
            pst.setInt(2, year);
            pst.setInt(3, month);
            pst.setInt(4, year);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                totalInvoiceCount = rs.getInt("TotalInvoiceCount");
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalInvoiceCount;
    }
    
    public ArrayList<Object[]> getRevenueData(int month, int year) {
        ArrayList<Object[]> revenueData = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT MaXe, SUM(TongTien) AS DoanhThu " +
                         "FROM CHITIETHD " +
                         "WHERE EXTRACT(MONTH FROM TGTao) = ? AND EXTRACT(YEAR FROM TGTao) = ? " +
                         "GROUP BY MaXe";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, month);
            pst.setInt(2, year);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                revenueData.add(new Object[]{rs.getInt("MaXe"), rs.getDouble("DoanhThu")});
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revenueData;
    }
}