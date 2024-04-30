
package model;

import java.time.LocalDate;

public class TaiKhoan {
    private String MaNV;
    private String TenTK;
    private String MatKhau;
    private String HoTen;
    private String GioiTinh;
    private LocalDate NgaySinh;
    private String ChucVu;
    private long Luong;
    private LocalDate NgayVaoLam;
    private String MaQL;

    public TaiKhoan() {
    }

    public TaiKhoan(String MaNV, String TenTK, String MatKhau, String HoTen, String GioiTinh, LocalDate NgaySinh, String ChucVu, long Luong, LocalDate NgayVaoLam, String MaQL) {
        this.MaNV = MaNV;
        this.TenTK = TenTK;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.ChucVu = ChucVu;
        this.Luong = Luong;
        this.NgayVaoLam = NgayVaoLam;
        this.MaQL = MaQL;
    }
    
    
}
