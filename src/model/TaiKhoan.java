package model;

import java.time.LocalDate;
import java.util.Objects;

public class TaiKhoan {
    private Integer MaNV;
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

    public TaiKhoan(Integer MaNV, String TenTK, String MatKhau, String HoTen, String GioiTinh, LocalDate NgaySinh, String ChucVu, long Luong, LocalDate NgayVaoLam, String MaQL) {
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

    public TaiKhoan(int parseInt, String TenTK, String MatKhau, String HoTen, String GioiTinh, String NgaySinh, String ChucVu, String Luong, String NgayVaoLam, String MaQL) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getter và Setter cho các trường dữ liệu
    public Integer getMaNV() {
        return MaNV;
    }

    public void setMaNV(Integer MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public long getLuong() {
        return Luong;
    }

    public void setLuong(long Luong) {
        this.Luong = Luong;
    }

    public LocalDate getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(LocalDate NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    public String getMaQL() {
        return MaQL;
    }

    public void setMaQL(String MaQL) {
        this.MaQL = MaQL;
    }
        @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.MaNV);
        hash = 71 * hash + Objects.hashCode(this.TenTK);
        hash = 71 * hash + Objects.hashCode(this.MatKhau);
        hash = 71 * hash + Objects.hashCode(this.HoTen);
        hash = 71 * hash + Objects.hashCode(this.GioiTinh);
        hash = 71 * hash + Objects.hashCode(this.NgaySinh);
        hash = 71 * hash + Objects.hashCode(this.ChucVu);
        hash = 71 * hash + (int) (this.Luong ^ (this.Luong >>> 32));
        hash = 71 * hash + Objects.hashCode(this.NgayVaoLam);
        hash = 71 * hash + Objects.hashCode(this.MaQL);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TaiKhoan taiKhoan = (TaiKhoan) obj;
        return Luong == taiKhoan.Luong &&
                Objects.equals(MaNV, taiKhoan.MaNV) &&
                Objects.equals(TenTK, taiKhoan.TenTK) &&
                Objects.equals(MatKhau, taiKhoan.MatKhau) &&
                Objects.equals(HoTen, taiKhoan.HoTen) &&
                Objects.equals(GioiTinh, taiKhoan.GioiTinh) &&
                Objects.equals(NgaySinh, taiKhoan.NgaySinh) &&
                Objects.equals(ChucVu, taiKhoan.ChucVu) &&
                Objects.equals(NgayVaoLam, taiKhoan.NgayVaoLam) &&
                Objects.equals(MaQL, taiKhoan.MaQL);
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "MaNV='" + MaNV + '\'' +
                ", TenTK='" + TenTK + '\'' +
                ", MatKhau='" + MatKhau + '\'' +
                ", HoTen='" + HoTen + '\'' +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", NgaySinh=" + NgaySinh +
                ", ChucVu='" + ChucVu + '\'' +
                ", Luong=" + Luong +
                ", NgayVaoLam=" + NgayVaoLam +
                ", MaQL='" + MaQL + '\'' +
                '}';
    }

}