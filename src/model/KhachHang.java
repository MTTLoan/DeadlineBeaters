
package model;

import java.time.LocalDate;

public class KhachHang {
    private int MaKH;
    private String TenKH;
    private String GioiTinh;
    private LocalDate NgaySinh;
    private String DiaChi;
    private String SDT;
    private int TongDoanhThu;

    public KhachHang() {
    }

    public KhachHang(int MaKH, String TenKH, String GioiTinh, LocalDate NgaySinh, String DiaChi, String SDT, int TongDoanhThu) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.TongDoanhThu = TongDoanhThu;
    }

    public int getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public int getTongDoanhThu() {
        return TongDoanhThu;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setTongDoanhThu(int TongDoanhThu) {
        this.TongDoanhThu = TongDoanhThu;
    }
    
}
