
package model;

import java.time.LocalDate;

public class KhachHang {
    private String MaKH;
    private String TenKH;
    private String GioiTinh;
    private LocalDate NgaySinh;
    private String DiaChi;
    private String SDT;
    private int TongDoanhThu;

    public KhachHang() {
    }

    public KhachHang(String MaKH, String TenKH, String GioiTinh, LocalDate NgaySinh, String DiaChi, String SDT, int TongDoanhThu) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.TongDoanhThu = TongDoanhThu;
    }
    
      // Getter and Setter for MaKH
    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    // Getter and Setter for TenKH
    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    // Getter and Setter for GioiTinh
    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    // Getter and Setter for NgaySinh
    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    // Getter and Setter for DiaChi
    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    // Getter and Setter for SDT
    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    // Getter and Setter for TongDoanhThu
    public int getTongDoanhThu() {
        return TongDoanhThu;
    }

    public void setTongDoanhThu(int TongDoanhThu) {
        this.TongDoanhThu = TongDoanhThu;
    }
}
