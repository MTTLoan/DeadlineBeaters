
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
    
    
}
