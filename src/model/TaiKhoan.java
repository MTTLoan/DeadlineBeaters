package model;

import java.time.LocalDate;

public class TaiKhoan {
    private int MaNV;
    private String TenTK;
    private String MatKhau;
    private String HoTen;
    private String GioiTinh;
    private LocalDate NgaySinh;
    private String ChucVu;
    private int Luong;
    private LocalDate NgayVaoLam;
    private int MaQL;

    public TaiKhoan() {
    }

    public TaiKhoan(int MaNV, String TenTK, String MatKhau, String HoTen, String GioiTinh, LocalDate NgaySinh, String ChucVu, int Luong, LocalDate NgayVaoLam, int MaQL) {
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

    public int getMaNV() {
        return MaNV;
    }
    
    public String getTenTK() {
        return TenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public int getLuong() {
        return Luong;
    }

    public LocalDate getNgayVaoLam() {
        return NgayVaoLam;
    }

    public int getMaQL() {
        return MaQL;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

    public void setNgayVaoLam(LocalDate NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    public void setMaQL(int MaQL) {
        this.MaQL = MaQL;
    }

}